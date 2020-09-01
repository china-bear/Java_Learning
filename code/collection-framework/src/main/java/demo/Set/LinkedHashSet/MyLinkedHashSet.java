package demo.Set.LinkedHashSet;

import demo.Set.HashSet.Person;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet基于链表和哈希表共同实现的，所以具有存取有序，元素唯一
 * Created by bear on 2020/9/1
 */
public class MyLinkedHashSet {

    public static void main(String[] args) {
        // 利用LinkedHashSet来存取自定义对象 Person
        LinkedHashSet<Person> set = new LinkedHashSet<Person>();

        set.add(new Person("张三", 12));
        set.add(new Person("李四", 13));
        set.add(new Person("王五", 22));
        set.add(new Person("张三", 12));

        // 遍历  结果：向集合中存储两个张三对象，但是集合中就成功存储了一个,并且存进的顺序和取出来的顺序是一致的
        for (Person p : set) {
            System.out.println(p);
        }

    }
}
