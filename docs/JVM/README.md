# Java 虚拟机

> 【Java 虚拟机】总结、整理了个人对于 JVM 的学习、应用心得.

## 📖 内容

###  内存屏障 (Memory Barrier)

1. 重排序: 同步的目的是保证不同执行流对共享数据并发操作的一致性

2. 编译器屏障: 阻止编译器重排, 保证编译程序时在优化屏障之前的指令不会在优化屏障之后执行

3. CPU屏障:  1.防止指令之间的重排序  2.保证数据的可见性

### 内存模型 (Memory Model)

1. Acquire与Release语义: 对于Acquire来说, 保证Acquire后的读写操作不会发生在Acquire动作之前; 对于Release来说, 保证Release前的读写操作不会发生在Release动作之后

2. happens-before规则: happens-before规则定义指令执行顺序与变量的可见性, 类似偏序关系, 具有可传递性, 因此可以运用于并行逻辑分析

3. 内存一致性模型 Memory Model: 内存一致性模型从程序员视角, 由内存序Memory Ordering和写操作原子性Store Atomicity来定义, 针对不同线程中原子操作的全局顺序

4. Linux查看机器缓存行大小 (CPU操作缓存的单位是"缓存行", 也就是说如果CPU要读一个变量x, 那么其实是读变量x所在的整个缓存行)
// L1D Cache  一级指令缓存
cat /sys/devices/system/cpu/cpu0/cache/index0/coherency_line_size  或  getconf LEVEL1_DCACHE_LINESIZE

// L1I Cache  一级数据缓存
cat /sys/devices/system/cpu/cpu0/cache/index1/coherency_line_size 或  getconf LEVEL1_ICACHE_LINESIZE

// L2 Cache  二级缓存
cat /sys/devices/system/cpu/cpu0/cache/index2/coherency_line_size 或  getconf LEVEL2_CACHE_LINESIZE

// L3 Cache 三级缓存
cat /sys/devices/system/cpu/cpu0/cache/index3/coherency_line_size 或  getconf LEVEL3_CACHE_LINESIZE

### CPU 缓存一致性协议 MESI
并发场景下（比如多线程）操作相同变量, 如何保证每个核中缓存的变量是正确的值, 这涉及到一些"缓存一致性"的协议, 应用最广的就是MESI协议（当然这不是唯一的缓存一致性协议）
缓存行的元信息中有一个Flag字段, 它会表示4种状态, 分为对应如下所说的M、E、S、I状态
状态	            描述
M（Modified）	代表该缓存行中的内容被修改了, 并且该缓存行只被缓存在该CPU中. 这个状态的缓存行中的数据和内存中的不一样, 在未来的某个时刻它会被写入到内存中（当其他CPU要读取该缓存行的内容时. 或者其他CPU要修改该缓存对应的内存中的内容时
E（Exclusive）	代表该缓存行对应内存中的内容只被该CPU缓存, 其他CPU没有缓存该缓存对应内存行中的内容. 这个状态的缓存行中的内容和内存中的内容一致. 该缓存可以在任何其他CPU读取该缓存对应内存中的内容时变成S状态. 或者本地处理器写该缓存就会变成M状态
S（Shared）	    该状态意味着数据不止存在本地CPU缓存中, 还存在别的CPU的缓存中. 这个状态的数据和内存中的数据是一致的. 当其他CPU修改该缓存行对应的内存的内容时会使该缓存行变成 I 状态
I（Invalid）  	代表该缓存行中的内容是无效的

### [TLAB(Thread Local Allocation Buffer) 线程本地分配缓存区] (https://zhuanlan.zhihu.com/p/113551358)
> TLAB占用的是Eden区并且基本上大小只是Eden的1%, 所以如果太大的对象分配是无法使用TLAB的, 可以通过选项-XX:TLABWasteTargetPercent设置TLAB空间所占用Eden空间的百分比大小.

--  为什么会有TLAB
> 通常情况下对象是分配在堆上的, 因为堆是线程共享的, 所以同一时间可能会有很多线程申请空间分配, 在这种情况下要加锁处理, 如此一来就会造成分配效率下降. 而TLAB是每个线程独有的, 它可以避免这种开销, 直接分配空间, 效率几乎等同于C. 

-- TLAB中内存不足时是如何处理的
> TLAB其实时很小的一块, 那肯定就会面临TLAB中剩余内存比申请对象小的问题. JVM当TLAB中空间小于比例值的时候, 会放弃当前的TLAB重建一个新的来分配, 该值默认情况下是1/64.
> 也就是说内存分配基本上是：分配请求过来, 看看TLAB中是否有足够空间, 有则分配, 没有则判断剩余内存是否小于它的1/64, 是则重新创建TLAB来分配内存, 否的话就直接在堆上分配. 

### [JDK 命令行工具](jvm-cli-tools.md)

-- 查看JVM 的配置
> java -XX:+PrintFlagsFinal -version | grep -iE 'HeapSize|PermSize|ThreadStackSize'
> 观察内存大小变化（jmap -heap pid 或者 visualGC） 

-- 栈内存大小相关设置
 -Xss1024k  意义： 设置线程栈占用内存大小,  默认值：不同的操作系统平台, 其默认值不同, 具体看官网说明

-- 堆内存大小相关设置
> -Xms512m  意义： 设置堆内存初始值大小,  默认值：如果未设置，初始值将是老年代和年轻代分配制内存之和。
> -Xmx1024m 意义： 设置堆内存最大值,  默认值：default value is chosen at runtime based on system configuration,具体请查看官网或者查看讨论How is the default Java heap size determined?。

-- 年轻代内存大小相关设置
> -Xmn512m  意义： 设置新生代的初始值及最大值, 默认值：堆内存的1/4（这里要记住不是最大堆内存，还是已经分配的堆内存的1/4）
>  -XX:NewSize=512m 意义：设置新生代的初始值,  -XX:MaxNewSize=512m  意义：设置新生代的最大值
 
-- 比率方式设置
> -XX:NewRatio=8 意义：设置老年代和年轻代的比例, 比如：-XX:NewRatio=8 表示老年代内存:年轻代内存=8:1 => 老年代占堆内存的8/9;年轻代占堆内存的1/9,  默认值：2 
> -XX:SurvivorRatio=32 意义：设置新生代和存活区的比例（这里需要注意的是存活区指的是其中一个）。比如：-XX:SurvivorRatio=8 表示存活区：新生代=1：8 =》新生代占年轻代的8/10,每个存活区各占年轻代的1/10, 默认值：8 
> -XX:MinHeapFreeRatio=40 意义：GC后，如果发现空闲堆内存占到整个预估上限值的40%，则增大上限值。 默认值：40 。
 -XX:MaxHeapFreeRatio=70 意义：GC后，如果发现空闲堆内存占到整个预估上限值的70%，则收缩预估上限值。 默认值：70。
 
-- Meta大小相关设置 
>-XX:MetaspaceSize=128m 意义：初始元空间大小，达到该值就会触发垃圾收集进行类型卸载，同时GC会对该值进行调整：如果释放了大量的空间，就适当降低该值；如果释放了很少的空间，那么在不超过MaxMetaspaceSize时，适当提高该值。 默认值：依赖平台。
 -XX:MaxMetaspaceSize=256m 意义：设置元空间的最大值，默认是没有上限的，也就是说你的系统内存上限是多少它就是多少。 默认值：默认没有上限，在技术上，Metaspace的尺寸可以增长到交换空间。

### [JDK GUI 工具](jvm-gui-tools.md)

### [TroubleShooting](trouble-shooting.md)

### 对象引用类型

引用类型	    引用对象被垃圾回收的时间	    用途	                            是否可以转为强引用   	对应的类
强引用	    从来不会	            一般用途, 保持对象不被回收	                    可以	              默认
软引用	    内存不足时	        缓存, 保持对象在内存足够时不被回收	            可以	              SoftReference
弱引用	    垃圾回收时	        缓存, 仅仅在对象仍被使用时保持其不被回收	        可以	              WeakReference WeakHashMap
虚引用	    进行垃圾回收时	        跟踪GC过程, 在对象被回收前进行一些清理工	        可以	              PhantomReference

## 📚 资料
- [JVM系统学习之路系列  JVM演示代码不错](https://github.com/mtcarpenter/JavaTutorial)  
- [《Java 核心技术面试精讲》](https://time.geekbang.org/column/intro/82)
- [《Java 性能调优实战》](https://time.geekbang.org/column/intro/100028001)
- [《Java 业务开发常见错误 100 例》](https://time.geekbang.org/column/intro/100047701)


## 🚪 传送

◾ 🏠 [JAVACORE 首页](https://github.com/dunwu/javacore) ◾ 🎯 [我的博客](https://github.com/dunwu/blog) ◾
