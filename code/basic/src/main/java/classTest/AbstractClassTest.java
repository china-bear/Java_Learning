package classTest;

/**
 * @program: Java_Learning
 * @description: 抽象类测试
 * @author: Mr.Bear
 * @create: 2021-02-28 20:27
 **/

// 抽象类不能直接 new 实类
abstract class A {
    // 抽象方法没有方法体
    // 抽象方法必须在抽象类中
    // 抽象方法必须在子类中被实现，除非继承的子类也是抽象类
    // 非抽象类继承抽象类，必须实现父类全部抽象方法Pol
    public abstract void run();
}


class TA extends A {
    public void run() {
        System.out.println("测试A");
    }
}

// 通常在继承关系中，父类为了规范代码，而且本身父类new实类没有意义，我们就用抽象来修饰父类，父类的方法也可以设置抽象方法
public class AbstractClassTest {
    public static void main(String[] args) {
        TA ta = new TA();
        ta.run();
    }
}