package creational.factory.simple;

/**
 * 简单工厂模式又称为静态工厂方法
 * 定义一个工厂类，根据传入的参数不同返回不同的实例，被创建的实例具有共同的父类或接口
 * 适用场景：
 * 　　（1）需要创建的对象较少。
 * 　　（2）客户端不关心对象的创建过程。
 */
public class MaskFactory {

    public IMask createMask(String type) {
        IMask mask = null;
        if("高端口罩".equals(type)){
            mask = new HighEndMask();
            // .....
            // HighEndMask的100行初始化代码
        }else if("低端口罩".equals(type)){
            mask =  new LowEndMask();
            // .....
            // LowEndMask的100行初始化代码
        }
        return mask;
    }
}
