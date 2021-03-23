package classTest;

import java.lang.reflect.InvocationTargetException;

/**
 * @program: Java_Learning
 * @description: 封装测试
 * @author: Mr.Bear
 * @create: 2021-03-07 11:16
 **/

class Rectangle{
    private double height;                          //私有化实例字段
    private double width;

    public Rectangle() {
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public void setHeight(double height) {          //定义更改器方法
        if (height<0) {
            this.height =0;
        }
        else {
            this.height = height;
        }
    }
    public void setWidth(double width) {
        if (width<0) {
            this.width =0;
        }
        else {
            this.width = width;
        }
    }
    public double getHeight() {                     //定义访问器方法
        return height;
    }
    public double getWidth() {
        return width;
    }
    public void calcuArea() {
        System.out.println("面积为："+height*width);
    }
}

public class EncapsulationTest01 {

/*    https://segmentfault.com/a/1190000009174512
      new: 相对高效,能调用任何public构造;
      Class.newInstance()只能反射无参的构造器;
      Constructor.newInstance()可以反任何构造器;
      Class.newInstance()需要构造器可见(visible);
      Constructor.newInstance()可以反私有构造器;
      Class.newInstance()对于捕获或者未捕获的异常均由构造器抛出;
      Constructor.newInstance()通常会把抛出的异常封装成InvocationTargetException
*/

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        Rectangle rec=new Rectangle();
        rec.setHeight(-1);                         //设定高
        rec.setWidth(2);                           //设定宽
        //读取高和宽
        System.out.println("高为："+rec.getHeight()+" 宽为："+rec.getWidth());
        rec.calcuArea();

        Rectangle rec1 = Rectangle.class.newInstance();
        rec1.setHeight(10);                         //设定高
        rec1.setWidth(20);                           //设定宽
        //读取高和宽
        System.out.println("高为："+rec1.getHeight()+" 宽为："+rec1.getWidth());
        rec1.calcuArea();

/*        Rectangle rec2 = (Rectangle) Class.forName("Rectangle").newInstance();
        rec2.setHeight(100);                         //设定高
        rec2.setWidth(200);                           //设定宽
        rec2.calcuArea();
        //读取高和宽
        System.out.println("高为："+rec2.getHeight()+" 宽为："+rec2.getWidth());*/

        Rectangle rec3 = Rectangle.class.getConstructor().newInstance();
        rec3.setHeight(18);                         //设定高
        rec3.setWidth(25);                           //设定宽
        System.out.println("高为："+rec3.getHeight()+" 宽为："+rec3.getWidth());
        rec3.calcuArea();
    }
}
