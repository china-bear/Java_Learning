package demo.wildcard;

/**
 * @program: Java_Learning
 * @description: 类型通配符上限
 * @author: Mr.Bear
 * @create: 2020-09-13 10:04
 **/
public class WildcardTest02 {

    public static void main(String[] args) {
        Box<Number> box1 = new Box<>();
        box1.setSize(100);
        showBox(box1);

        Box<Integer> box2 = new Box<>();
        box2.setSize(200);
        showBox(box2);

    }


    public static void showBox(Box<? extends Number> box) {
        Number size = box.getSize();
        System.out.println(size);
    }

}

