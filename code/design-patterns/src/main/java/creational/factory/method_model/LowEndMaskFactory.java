package creational.factory.method_model;


/**
 * 工厂方法模式
 */
public class LowEndMaskFactory implements IMaskFactory {

    @Override
    public IMask createMask() {
        IMask mask =  new LowEndMask();
        // .....
        //  LowEndMask的100行初始化代码
        return mask;
    }
}
