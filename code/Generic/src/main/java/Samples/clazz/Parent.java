package Samples.clazz;

/**
 * @program: Java_Learning
 * @description: 泛型父类
 * @author: Mr.Bear
 * @create: 2020-09-06 11:35
 **/
public class Parent <E>{

    private E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
