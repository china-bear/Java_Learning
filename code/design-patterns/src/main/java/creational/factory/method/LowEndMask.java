package creational.factory.method;

/**
 * 工厂方法模式
 */
public class LowEndMask implements IMask {

    @Override
    public void show() {
        System.out.println("我是低端口罩");
    }
}
