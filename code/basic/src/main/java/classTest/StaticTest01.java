package classTest;

/** 类的初始化顺序依次是
 * 加载父类的静态字段 -> 父类的静态代码块 -> 子类静态字段 -> 子类静态代码块 -> 父类成员变量（非静态字段）-> 父类非静态代码块 -> 父类构造器 -> 子类成员变量 -> 子类成员变量 -> 子类非静态代码块 -> 子类构造器
 * static 修饰的变量存储在方法区中???   static 变量的生命周期与类的生命周期相同，随类的加载而创建，随类的销毁而销毁???
 * 声明为 static 和 transient 类型的变量不能被序列化，因为 static 修饰的变量保存在方法区中
 * 对于每个 StaticTest 的实例化对象都会拥有一个 LOGGER,通常会将 Logger 对象声明为 static 变量，能够减少对内存资源的占用。
 **/
public class StaticTest01 {

    public StaticTest01() {
        System.out.print("默认构造方法！-->");
    }

    //非静态代码块
    {
        System.out.print("非静态代码块 -->");
    }

    //静态代码块  具有最高的优先级, 类加载的时候就被执行了
    static {
        System.out.print("静态代码块 -->");
    }



    private static void test1() {
        System.out.print("静态方法test1中的内容 第一行开始 -->");
        {
            System.out.print("静态方法test1中的代码块 -->");
        }
        System.out.print("静态方法test1中的内容 最后一行结束 -->");
    }

    private  void test2() {
        System.out.print("方法test2中的内容 第一行开始! -->");
        {
            System.out.print("方法test2中的代码块！-->");
        }
        System.out.print("方法test2中的内容 最后一行结束! -->");
    }

    public static void main(String[] args) {
        // 类方法 直接调用
        test1();  //静态代码块！-->静态方法test1中的内容1! -->静态方法test1中的代码块！-->静态方法test1中的内容2! -->

        System.out.println();System.out.println("================================================================");

        StaticTest01 staticTest = new StaticTest01();  // 非静态代码块！-->默认构造方法！-->

        System.out.println();System.out.println("================================================================");

        staticTest.test1();//静态方法test1中的内容1! -->静态方法test1中的代码块！-->静态方法test1中的内容2! -->

        System.out.println();System.out.println("================================================================");

        staticTest.test2();//方法test2中的内容1! -->方法test2中的代码块！-->方法test2中的内容2! -->
    }
}
