package Samples.interfaces;

/**
 * @program: Java_Learning
 * @description: 泛型接口实现类
 * 泛型接口的实现类是一个泛型类，那么要保证实现接口的泛型类的泛型标识包含泛型接口的泛型标识
 * @author: Mr.Bear
 * @param <T>
 * @param <E>
 * @create: 2020-09-06 12:01
 **/
public class InterfaceGenericImpl2<T,E> implements InterfaceGeneric<T> {

    private T key;
    private E value;

    public InterfaceGenericImpl2(T key, E value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public static void main(String[] args) {

        InterfaceGenericImpl2<String, Integer> integerInterfaceGenericImpl2 = new InterfaceGenericImpl2<>("count", 100);
        String key = integerInterfaceGenericImpl2.getKey();
        Integer value = integerInterfaceGenericImpl2.getValue();

        System.out.println(key + "=" + value);

    }
}
