package creational.factory.abstract_model;


/**
 * 工厂抽象模式
 */
public class HighEndMask implements IMask {

    @Override
    public void showMask() {
        System.out.println("我是高端口罩");
    }
}
