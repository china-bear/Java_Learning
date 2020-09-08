## 基本原则：注解不能直接干扰程序代码的运行，无论增加或删除注解，代码都能够正常运行。
注解（也被成为元数据）为我们在代码中添加信息提供了一种形式化的方法，使我们可以在稍后某个时刻非常方便地使用这些数据。 ———摘自《Thinking in Java》

##注解简介
注解（Annontation），Java5引入的新特性，位于java.lang.annotation包中。提供了一种安全的类似注释的机制，用来将任何的信息或元数据（metadata）与程序元素（类、方法、成员变量等）进行关联。
是一种说明、配置、描述性的信息，与具体业务无关，也不会影响正常的业务逻辑。但我们可以用反射机制来进行校验、赋值等操作。

常见的注解：@Override，@author，@param，@Deprecated,@SuppressWarnings。


##注解的常见用途：
- 生成文档的注解，如@author，@param。
- 跟踪代码依赖性，实现替代配置文件功能，如spring mvc的注解。
- 编译时进行格式检查，如@override。
- 编译时进行代码生成补全，如lombok插件的@Data。
- 编译时动态处理，如动态生成代码
- 运行时动态处理，作为额外信息的载体，如得到注解信息
- 让编程变得更加简洁

##注解基础知识
###注解的定义
注解的定义通过@interface表示，所有的注解会自动继承java.lang.Annotation接口,且不能再继承别的类或是接口。
注解的成员参数只能用public或默认(default) 访问权修饰来进行修饰。
成员参数只能使用八种基本类型（byte、short、char、int、long、float、double、boolean）和String、Enum、Class、annotations等数据类型，及其数组。
获取类方法和字段的注解信息，只能通过Java的反射技术来获取 Annotation 对象。
注解可以没有定义成员，只做标识。
###元注解
元注解是专门用来注解其他注解的注解，听起来有些绕口，实际上就是专门为自定义注解提供的注解。java.lang.annotation提供了四种元注解：
- @Documented – 注解是否将包含在JavaDoc中
- @Retention – 什么时候使用该注解
- @Target – 注解用于什么地方
- @Inherited – 是否允许子类继承该注解
- @Repeatable - 是否可重复注解，jdk1.8引入

###注解的生命周期
通过@Retention定义注解的生命周期，格式如下：

@Retention(RetentionPolicy.SOURCE)
其中RetentionPolicy的不同策略对应的生命周期如下：

- RetentionPolicy.SOURCE : 仅存在于源代码中，编译阶段会被丢弃，不会包含于class字节码文件中。@Override, @SuppressWarnings都属于这类注解。
- RetentionPolicy.CLASS : 默认策略，在class字节码文件中存在，在类加载的时被丢弃，运行时无法获取到。
- RetentionPolicy.RUNTIME : 始终不会丢弃，可以使用反射获得该注解的信息。自定义的注解最常用的使用方式。
###注解的作用目标
通过@Target定义注解作用的目标，比如作用于类、属性、或方法等，默认可用于任何地方。格式如下：

@Target(ElementType.TYPE)
对应ElementType参数值适用范围如下：

- ElementType.TYPE: 类、接口、注解、enum
- ElementType.CONSTRUCTOR: 构造函数
- ElementType.FIELD: 成员变量、对象、属性、枚举的常量
- ElementType.LOCAL_VARIABLE: 局部变量
- ElementType.METHOD: 方法
- ElementType.PACKAGE: 包
- ElementType.PARAMETER: 参数
- ElementType.ANNOTATION_TYPE): 注解
- ElementType.TYPE_PARAMETER：类型参数，表示这个注解可以用在 Type的声明式前,jdk1.8引入。
- ElementType.TYPE_USE：类型的注解，表示这个注解可以用在所有使用Type的地方（如：泛型，类型转换等），jdk1.8引入。

@Documented，表示是否将此注解的相关信息添加到javadoc文档中。

@Inherited，定义该注解和子类的关系，使用此注解声明出来的自定义注解，在使用在类上面时，子类会自动继承此注解，否则，子类不会继承此注解。注意，使用Inherited声明出来的注解，只有在类上使用时才会有效，对方法，属性等其他无效。

###注意
- 对局部变量的注解只能在源码级别上进行处理，class文件并不描述局部变量。因此，所有的局部变量注解在编译完一个类的时候就会被遗弃掉。同样的，对包的注解不能在源码级别之外存在。
- 一条没有@Target限制的注解可以应用于任何项上。
- @Inherited元注解只能应用于对类的注解


##
** 参考资料 **

- [Java自定义注解详解](https://www.jianshu.com/p/7a02ddfb0e13)
- [JAVA 注解的基本原理](https://juejin.im/post/6844903636733001741)
- [彻底搞懂Java注解Annotation](http://www.akathink.com/2016/08/11/%E5%BD%BB%E5%BA%95%E6%90%9E%E6%87%82Java%E6%B3%A8%E8%A7%A3Annotation)
- [全面掌握Java自定义注解](https://zhuanlan.zhihu.com/p/60730622)