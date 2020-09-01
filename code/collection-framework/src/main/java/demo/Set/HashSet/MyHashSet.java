package demo.Set.HashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Set集合的特点：元素不重复，存取无序，无下标
 * Created by bear on 2020/9/1
 */
public class MyHashSet {

    public static void main(String[] args) {

        // 利用HashSet来存取自定义对象 Person
        Set<Person> set = new HashSet<Person>();

        set.add(new Person("张三", 12));
        set.add(new Person("李四", 13));
        set.add(new Person("王五", 22));
        set.add(new Person("张三", 12));

        // 遍历  集合中存储两个张三对象，但是集合中就成功存储了一个
        for (Person p : set) {
            System.out.println(p);
        }
    }
}
