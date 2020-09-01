package demo.List.Vector;

import java.util.Enumeration;
import java.util.Vector;

/**
 * Vector:因为已经过时，被ArrayList取代了；迭代器通过vector.elements()获取
 * Created by bear on 2020/9/1
 */
public class MyVector {

    public static void main(String[] args) {
        Vector<String> vector = new Vector<String>();

        vector.add("搜索");
        vector.add("vector");
        vector.add("list");

        Enumeration<String> elements = vector.elements();
        while (elements.hasMoreElements()){
            String nextElement = elements.nextElement();
            System.out.println(nextElement);
        }
    }
}
