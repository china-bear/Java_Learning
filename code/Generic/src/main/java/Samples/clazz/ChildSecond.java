package Samples.clazz;

/**
 * @program: Java_Learning
 * @description: 第二个子类
 * 泛型类派生子类，如果子类不是泛型类，那么父类要明确泛型类型
 * @author: Mr.Bear
 * @create: 2020-09-06 11:42
 *
 **/
public class ChildSecond extends Parent<Integer> {

    @Override
    public Integer getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Integer value) {
        super.setValue(value);
    }

    public static void main(String[] args) {
        ChildSecond childSecond = new ChildSecond();
        childSecond.setValue(100);
        System.out.println(childSecond.getValue());
    }
}
