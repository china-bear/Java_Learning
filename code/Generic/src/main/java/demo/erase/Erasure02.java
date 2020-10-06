package demo.erase;

import java.util.List;

/**
 * @program: Java_Learning
 * @description: 有限制类型擦除
 * @author: Mr.Bear
 * @create: 2020-09-13 11:14
 **/
public class Erasure02<T extends Number> {

    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    /**
     * 泛型方法
     * @param t
     * @param <T>
     * @return
     */
    public <T extends List> T show(T t){
        return t;
    }
}
