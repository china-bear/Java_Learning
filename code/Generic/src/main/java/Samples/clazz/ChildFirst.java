package Samples.clazz;

/**
 * @program: Java_Learning
 * @description: 第一个子类
 * 泛型类派生子类，子类也是泛型类，那么子类的泛型标识要和父类一致
 * @author: Mr.Bear
 * @create: 2020-09-06 11:37
 * @param <T>
 **/
public class ChildFirst<T> extends Parent<T> {
    @Override
    public T getValue() {
        return super.getValue();
    }

    public static void main(String[] args) {
        ChildFirst<String> stringChildFirst = new ChildFirst<>();
        stringChildFirst.setValue("abc");
        System.out.println(stringChildFirst.getValue());
    }
}
