package creational.factory.method_model;

/**
 * 工厂方法模式
 */
public class HighEndMaskFactory implements IMaskFactory {

    @Override
    public IMask createMask() {
        IMask mask = new HighEndMask();
        // .....
        // HighEndMask的100行初始化代码
        return mask;
    }
}
