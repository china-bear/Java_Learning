package classTest;

/**
 * https://juejin.cn/post/6844903991558537230
 * 匿名内部类的格式：    new 父类或接口() { 重写的方法; }
 * 匿名内部类不能有构造器（构造方法）
 * 必须继承一个父类或实现一个接口
 * 每次使用均创建新的匿名内部类对象
 *
 */

abstract class traffic {
    public abstract void speed();
}

class Car extends traffic {

    @Override
    public void speed() {
        System.out.println("丰田: 100KM /H");
    }
}

public class AnonymousInnerClass {

    // 观察Lambda表达式和匿名内部类对：方法局部变量，类变量，实例变量，final常量的读取有何不同  https://olegpt.top/post/l/
    String str1 = "common Sring ";
    static String str2 = "static String ";
    final String str3 = "final String ";

/** Lambda表达式： 没有名称的方法（匿名函数） Lambda 表达式无法实例化
 * 方法局部变量：作为构造和lambda方法的参数传递
 * 类变量：getstatic指令从类中读取
 * 实例变量,final常量：通过对当前实例例的引用(this)读取
 *
 */

    public  void fun1() {
        String str = str1;
        ((Runnable) () -> {
            System.out.println("fun1: "+ str + str1 + str2 + str3);
        }).run();
    }

/** 对于匿名内部类： 没有名字的类  可以实例化匿名内部类
 * 方法局部变量：直接作为构造方法的参数被传递进匿名内部类
 * 类变量：getstatic指令从类中读取
 * 实例变量,final常量：通过对外部实例的引用(this$0)读取，此处是编译器做了优化，final常量直接被存储到常量池中了
 *
 */
    public void fun2() {
        String str = str1;
        new Runnable(){
            @Override
            public void run() {
                System.out.println("fun2: " + str + str1 + str2 + str3);
            }
        }.run();
    }

    public static void main(String[] args) {
        // 不使用匿名内部类
        traffic f1 = new Car();
        f1.speed();

        // 使用匿名内部类, 不需要再创建具体实现类(代码例子 实现类 Car)
        traffic f2 = new traffic() {
            @Override
            public void speed() {
                System.out.println("飞机: 800KM /H");
            }

            public void owner() {
                System.out.println("匿名内部类 增加主人方法");
            }
        };

        f2.speed();  // f2实例不能直接调用 owner方法

        new traffic() {
            @Override
            public void speed() {
                System.out.println("火车: 300KM /H");
            }

            public void owner() {
                System.out.println("匿名内部类 增加主人方法");
            }
        }.owner();   // owner能直接调用


        // 观察Lambda表达式和匿名内部类对：方法局部变量，类变量，实例变量，final常量的读取有何不同
        AnonymousInnerClass anonymousInnerClass = new AnonymousInnerClass();
        anonymousInnerClass.fun1();
        anonymousInnerClass.fun2();

    }
}
