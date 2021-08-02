# Java 虚拟机

> 【Java 虚拟机】总结、整理了个人对于 JVM 的学习、应用心得.

## 📖 内容

###  内存屏障 (Memory Barrier)

1. 重排序: 同步的目的是保证不同执行流对共享数据并发操作的一致性

2. 编译器屏障: 阻止编译器重排，保证编译程序时在优化屏障之前的指令不会在优化屏障之后执行

3. CPU屏障:  1.防止指令之间的重排序  2.保证数据的可见性

### 内存模型 (Memory Model)

1. Acquire与Release语义: 对于Acquire来说，保证Acquire后的读写操作不会发生在Acquire动作之前; 对于Release来说，保证Release前的读写操作不会发生在Release动作之后

2. happens-before规则: happens-before规则定义指令执行顺序与变量的可见性，类似偏序关系，具有可传递性，因此可以运用于并行逻辑分析

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
并发场景下（比如多线程）操作相同变量，如何保证每个核中缓存的变量是正确的值, 这涉及到一些"缓存一致性"的协议, 应用最广的就是MESI协议（当然这不是唯一的缓存一致性协议）
缓存行的元信息中有一个Flag字段，它会表示4种状态，分为对应如下所说的M、E、S、I状态
状态	            描述
M（Modified）	代表该缓存行中的内容被修改了，并且该缓存行只被缓存在该CPU中。这个状态的缓存行中的数据和内存中的不一样，在未来的某个时刻它会被写入到内存中（当其他CPU要读取该缓存行的内容时。或者其他CPU要修改该缓存对应的内存中的内容时
E（Exclusive）	代表该缓存行对应内存中的内容只被该CPU缓存，其他CPU没有缓存该缓存对应内存行中的内容。这个状态的缓存行中的内容和内存中的内容一致。该缓存可以在任何其他CPU读取该缓存对应内存中的内容时变成S状态。或者本地处理器写该缓存就会变成M状态
S（Shared）	    该状态意味着数据不止存在本地CPU缓存中，还存在别的CPU的缓存中。这个状态的数据和内存中的数据是一致的。当其他CPU修改该缓存行对应的内存的内容时会使该缓存行变成 I 状态
I（Invalid）  	代表该缓存行中的内容是无效的

### [什么是TLAB(Thread Local Allocation Buffer)] (https://zhuanlan.zhihu.com/p/113551358)

### [JDK 命令行工具](jvm-cli-tools.md)

### [JDK GUI 工具](jvm-gui-tools.md)

### [TroubleShooting](trouble-shooting.md)

### 对象引用类型

引用类型	    引用对象被垃圾回收的时间	    用途	                            是否可以转为强引用   	对应的类
强引用	    从来不会	            一般用途，保持对象不被回收	                    可以	              默认
软引用	    内存不足时	        缓存，保持对象在内存足够时不被回收	            可以	              SoftReference
弱引用	    垃圾回收时	        缓存，仅仅在对象仍被使用时保持其不被回收	        可以	              WeakReference WeakHashMap
虚引用	    进行垃圾回收时	        跟踪GC过程，在对象被回收前进行一些清理工	        可以	              PhantomReference

## 📚 资料
- [JVM系统学习之路系列  JVM演示代码不错](https://github.com/mtcarpenter/JavaTutorial)  
- [《Java 核心技术面试精讲》](https://time.geekbang.org/column/intro/82)
- [《Java 性能调优实战》](https://time.geekbang.org/column/intro/100028001)
- [《Java 业务开发常见错误 100 例》](https://time.geekbang.org/column/intro/100047701)


## 🚪 传送

◾ 🏠 [JAVACORE 首页](https://github.com/dunwu/javacore) ◾ 🎯 [我的博客](https://github.com/dunwu/blog) ◾
