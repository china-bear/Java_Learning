package creational.factory.abstract_model;

/**
 * 工厂抽象模式
 */
public class LowEndProtectiveSuit implements IProtectiveSuit{
    @Override
    public void showSuit() {
        System.out.println("我是低端防护服");
    }
}
