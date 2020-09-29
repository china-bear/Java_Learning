package Samples.clazz;

/**
 * @program: Java_Learning
 * @description: 泛型类的定义
 * @author: Mr.Bear
 * @create: 2020-09-06 10:43
 * @param <T> 泛型表识--类型形参
 *           T 创建对象的时候里指定具体的数据类型
 **/
public class ClassGeneric<T> {

    //  T 是由外部使用类的时候来指定。
    private  T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public ClassGeneric(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ClassGeneric{" +
                "key=" + key +
                '}';
    }

    public static void main(String[] args) {
        // 泛型类在创建对象的时候，来指定操作的具体数据类型。
        ClassGeneric<String> strGeneric = new ClassGeneric<>("abc");
        String key1 = strGeneric.getKey();
        System.out.println("key1: " + key1);

        System.out.println("--------------------------------");

        ClassGeneric<Integer> intGeneric = new ClassGeneric<>(100);
        Integer key2 = intGeneric.getKey();
        System.out.println("key2: " + key2);

        System.out.println("--------------------------------");

        // 泛型类在创建对象的时候，没有指定类型， 将按照Object 类型操作。
        ClassGeneric generic = new ClassGeneric("hello");
        Object key3 = generic.getKey();
        System.out.println("key3: " + key3);

        // 泛型类 不支持基本数据类型，只能是类类型
        //ClassGeneric<int> generic1 = new ClassGeneric<int>(100);

        System.out.println("--------------------------------");

        // 同一泛型类型，根据不同的数据类型创建的对象，本质是同一类型
        System.out.println(intGeneric.getClass());
        System.out.println(strGeneric.getClass());
        System.out.println(intGeneric.getClass() == strGeneric.getClass());

    }
}
