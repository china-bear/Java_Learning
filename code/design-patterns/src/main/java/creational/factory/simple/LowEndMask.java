package creational.factory.simple;

/**
 * 简单工厂模式
 */
public class LowEndMask implements IMask {

    @Override
    public void show() {
        System.out.println("我是低端口罩");
    }
}
