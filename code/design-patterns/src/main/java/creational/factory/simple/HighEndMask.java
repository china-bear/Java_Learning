package creational.factory.simple;

/**
 * 简单工厂模式
 */
public class HighEndMask implements IMask{

    @Override
    public void show() {
        System.out.println("我是高端口罩");
    }
}
