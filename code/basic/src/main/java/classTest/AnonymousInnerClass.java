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
                System.out.println("匿名内部类");
            }
        };

        f2.speed();  // f2实例不能直接调用 owner方法

        new traffic() {
            @Override
            public void speed() {
                System.out.println("火车: 300KM /H");
            }

            public void owner() {
                System.out.println("匿名内部类");
            }
        }.owner();   // owner能直接调用

    }
}
