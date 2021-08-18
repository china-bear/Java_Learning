package shape;

/**
 * 工厂方法模式
 *   定义： https://juejin.im/entry/6844903474639929357
 *      定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。
 *      简单工厂只有一个统一的工厂类，而工厂方法是针对每个要创建的对象都会提供一个工厂类，这些工厂类都实现了一个工厂基类
 *
 *   适用场景：
 * 　　（1）客户端不需要知道它所创建的对象的类。例子中我们不知道每个图片加载器具体叫什么名，只知道创建它的工厂名就完成了床架过程。
 * 　　（2）客户端可以通过子类来指定创建对应的对象。
 * 以上场景使用于采用工厂方法模式。
 */
public class App {

    public static void main(String[] args) {
        IMaskFactory factoryA = new LowEndMaskFactory();
        IMaskFactory factoryB = new HighEndMaskFactory();
        IMask maskA = factoryA.createMask();
        IMask maskB = factoryB.createMask();
        maskA.show();
        maskB.show();
    }
}
