package demo.wildcard;

/**
 * @program: Java_Learning
 * @description: 类型通配符
 * @author: Mr.Bear
 * @create: 2020-09-13 10:00
 **/
public class Box <E> {

    private E size;

    public void setSize(E size) {
        this.size = size;
    }

    public E getSize() {
        return size;
    }
}
