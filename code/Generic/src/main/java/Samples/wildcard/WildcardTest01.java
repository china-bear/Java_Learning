package Samples.wildcard;

/**
 * @program: Java_Learning
 * @description: 类型通配符
 * @author: Mr.Bear
 * @create: 2020-09-13 10:04
 **/
public class WildcardTest01 {

    public static void main(String[] args) {
        Box<Number> box1 = new Box<>();
        box1.setSize(100);
        showBox(box1);

        Box<Integer> box2 = new Box<>();
        box2.setSize(200);
        showBox(box2);

    }

    // Box Number泛型类型 不能理解成多态 和 方法重载（泛型类型实际同一类型所有不能重载），只能通过类型通配符实现
/*    public static void showBox(Box<Number> box) {
        Number size = box.getSize();
        System.out.println(size);
    }

    public static void showBox(Box<Integer> box) {
        Number size = box.getSize();
        System.out.println(size);
    }*/

    public static void showBox(Box<?> box) {
        Object size = box.getSize();
        System.out.println(size);
    }

}

