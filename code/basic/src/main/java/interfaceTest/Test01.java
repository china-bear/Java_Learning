package interfaceTest;

/**
 * @program: Java_Learning
 * @description: 接口功能测试
 * 为什么使用接口
 * 1. 解决多继承的问题
 * 2. 更好的使用多态
 *
 * 面向接口编程:
 * 1. 程序设计时关心实现类有何能力，而不关心实现细节
 * 2. 面向接口的约定而不考虑接口的具体实现
 * 3. 接口理解为一种约定（体现在接口名称和注释上）/对希望符合这个接口的类的一种需求。
 *
 * 接口特性：
 * 1. 接口不可以实类化，常作为类型使用, 但可以用于声明引用变量类型
 * 2. 实现类必须实现接口的所有方法
 * 3. 实现类可以实现多个接口，java中的多继承
 * 4. 接口中的变量都是静态常量, 没有使用static final也是这个表示
 * 5. 接口中所有方法和常量都是public
 * 6. 接口中没有方法实现 所有方法修饰访问默认都是都是public abstract（可以不写）
 * 7. 用default修饰的为默认方法可以带方法体, 可以不用重写, 子类用 (接口名.super.方法名() ???) 来使用
 * 8. 用static修饰的为默认方法可以带方法体， 不可以重写, 子类用 (接口名.方法名()) 来使用
 *
 *接口的使用：
 * 1、接口代表一种能力, 接口中可以定义 N个方法, 子类在实现的时候必须要实现这些方法，意味着具体了方法的能力
 * 2、接口不能创建实例，但是可以用于声明引用变量类型
 * 3、接口支持多 "继承", 当多个接口中有同名的方法时，子类中必须写一个同名的方法, 如果父类中也有同名方法，那么调用时直接调用父类方法。
 * 4、同时使用时 extends必须在implements之前
 * 5、可以用接口指向实现类来是使不同类型用该接口的具体表现方法，用接口来描述不同的类型具有相似的行为特征
 *
 * 接口相关规则：
 * 1.可以定义一个新接口，用extends去继承一个已有的接口
 * 2、可以定义一个类，用implements去实现一个接口中所有的方法
 * 3、可以定义一个抽象类，用implements去实现一个接口中部分方法
 *
 * @author: Mr.Bear
 * @create: 2021-03-06 11:03
 **/



// 抽象类：门
abstract class Door {
    public abstract void open();
    public abstract void close();
}

// 接口：锁
interface Lock {
    int i = 1;    //都是静态常量
    public void lock();  // 都是抽象方法
    public void unlock();

    default void test() {
        System.out.println("default修饰测试");
    }
}

// 接口：照相机
interface Camera {
    void takePhotos();  //不是默认权限，而是public

    static void test() {
        System.out.println("static修饰测试");
    }

}

//防盗门：实现多个接口继承
class FDoor extends Door implements Lock, Camera{

    @Override
    public void open() {
        System.out.println("开门");
    }

    @Override
    public void close() {
        System.out.println("关门");
    }

    @Override
    public void lock() {
        System.out.println("上锁");
    }

    @Override
    public void unlock() {
        System.out.println("开锁");
    }

    @Override
    public void takePhotos() {
        System.out.println("拍照存档");
    }
}

public class Test01 {
    public static void main(String[] args) {
        FDoor fd = new FDoor();
        fd.close();
        fd.lock();
        fd.takePhotos();
        fd.unlock();
        fd.open();

        // 接口作为类型使用
        Lock fd1 = new FDoor();
        fd1.lock();
        fd1.unlock();
        fd1.test();

        Camera fd2 = new FDoor();
        fd2.takePhotos();

        Camera.test();


        // 父类作为类型使用
        Door fd3 = new FDoor();
        fd3.close();
        fd3.open();

    }
}
