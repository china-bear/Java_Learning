package creational.factory.abstract_model;

/**
 * 工厂抽象模式
 */
public class HighEndProtectiveSuit implements IProtectiveSuit{
    @Override
    public void showSuit() {
        System.out.println("我是高端防护服");
    }
}
