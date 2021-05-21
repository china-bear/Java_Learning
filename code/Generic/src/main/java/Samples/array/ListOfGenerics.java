package Samples.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Java_Learning
 * @description: 泛型数组
 * 不能直接创建泛型数组,一种方案是使用 ArrayLis
 * @author: Mr.Bear
 * @create: 2020-09-13 16:10
 **/

public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<T>();
    public void add(T item) { array.add(item); }
    public T get(int index) { return array.get(index); }

    public static void main(String[] args) {

    }
}
