package classTest;

/**
 * @program: Java_Learning
 * @description: 封装测试
 * @author: Mr.Bear
 * @create: 2021-03-07 11:16
 **/

class Rectangle{
    private double height;                          //私有化实例字段
    private double width;

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

    public static void main(String[] args) {
        Rectangle rec=new Rectangle();
        rec.setHeight(-1);                         //设定高
        rec.setWidth(2);                           //设定宽
        rec.calcuArea();
        //读取高和宽
        System.out.println("高为："+rec.getHeight()+" 宽为："+rec.getWidth());
}
}
