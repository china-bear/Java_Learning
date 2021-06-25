# Java 虚拟机

> 【Java 虚拟机】总结、整理了个人对于 JVM 的学习、应用心得。

## 📖 内容

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
