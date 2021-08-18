package shape;

/**
 *  简单工厂模式又称为静态工厂方法
 *  定义一个工厂类，根据传入的参数不同返回不同的实例，被创建的实例具有共同的父类或接口
 *  适用场景：
 * 　　（1）需要创建的对象较少。
 * 　　（2）客户端不关心对象的创建过程。
 * https://juejin.im/entry/6844903474639929357
 * https://mp.weixin.qq.com/s?__biz=Mzg5MDEzMjEwNw==&mid=2247485640&idx=1&sn=02a8d28e9436c45f74eddfe97cde5388&chksm=cfe00b2cf897823a5afa514dc85e3a17edceb54c46861a3646757c766229f3407233656366d0&scene=0&xtrack=1&key=8688481eb7cee6e2325404225d18ca105307c42750d68038dd750fc7ce7120fbfaeef6cc382cb948d9b0f4a1c4be68e603e69f3e77c4b4c2249ccf9197aafe03e7ec12191125dcebe7f1fdb6106d4c54d5253d8117751b6b440f7934d4dd2dcbb34924b01561f889a98bd87b1b435ba8e98ef306d0aaa3a6544363c5f530e7d2&ascene=1&uin=MTE5MDA2NzUyMA%3D%3D&devicetype=Windows+10&version=62070158&lang=zh_CN&exportkey=AWiiDXT1EHmAlopsl9CGRTE%3D&pass_ticket=HNgWdifTxlc80f6%2BPdXe8EL46TP2ww29exuxQHiN%2FD31AthrBI87T35iswdbWV8K&wx_header=0
 */
public class MainClass {

    public static void main(String[] args) {

        // 画圆形
        Shape shape1= ShapeFactory.getShape("circle");
        shape1.draw();
        // 画正反形
        Shape shape2= ShapeFactory.getShape("rect");
        shape2.draw();
        // 画三角形
        Shape shape3= ShapeFactory.getShape("triangle");
        shape3.draw();
    }
}
