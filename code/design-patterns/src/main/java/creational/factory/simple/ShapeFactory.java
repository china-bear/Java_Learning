package creational.factory.simple;

/**
 * 简单工厂类
 * 这个工厂类中通过传入不同的type可以new不同的形状，返回结果为Shape 类型，这个就是简单工厂核心的地方
 */
public class ShapeFactory {

    public static final String TAG = "ShapeFactory";
    public static Shape getShape(String type) {
        Shape shape = null;
        if (type.equalsIgnoreCase("circle")) {
            shape = new CircleShape();
        } else if (type.equalsIgnoreCase("rect")) {
            shape = new RectShape();
        } else if (type.equalsIgnoreCase("triangle")) {
            shape = new TriangleShape();
        }
        return shape;
    }
}
