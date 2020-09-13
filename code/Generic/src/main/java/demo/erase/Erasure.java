package demo.erase;

/**
 * @program: Java_Learning
 * @description: 无限制类型擦除
 * @author: Mr.Bear
 * @create: 2020-09-13 11:14
 **/
public class Erasure<T> {

    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}
