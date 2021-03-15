package interfaceTest;

/**
 * @program: Java_Learning
 * @description: 接口功能测试
 * 为什么使用接口
 * 1. 解决多继承的问题
 * 2. 更好的使用多态
 * 接口特性：
 * 1. 接口不可以实类化，常作为类型使用
 * 2. 实现类必须实现接口的所有方法
 * 3. 实现类可以实现多个接口，java中的多继承
 * 4. 接口中的变量都是静态常量
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
}

// 接口：照相机
interface Camera {
    void takePhotos();  //不是默认权限，而是public
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

        Camera fd2 = new FDoor();
        fd2.takePhotos();

        // 父类作为类型使用
        Door fd3 = new FDoor();
        fd3.close();
        fd3.open();

    }
}
