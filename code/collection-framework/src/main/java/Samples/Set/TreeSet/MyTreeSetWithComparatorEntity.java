package Samples.Set.TreeSet;

import java.util.Comparator;
import java.util.TreeSet;
import Samples.Set.HashSet.Person;

/**
 * TreeSet保证元素的唯一性是有两种方式：
 * 1、自定义对象实现Comparable接口，重写comparaTo方法，该方法返回0表示相等，小于0表示准备存入的元素比被比较的元素小，否则大于0；
 * 2、在创建TreeSet的时候向构造器中传入比较器Comparator接口实现类对象，实现Comparator接口重写compara方法。
 * 如果向TreeSet存入自定义对象时，自定义类没有实现Comparable接口，或者没有传入Comparator比较器时，会出现ClassCastException异常
 * Created by bear on 2020/9/1
 */
public class MyTreeSetWithComparatorEntity {

    public static void main(String[] args) {

        // 利用TreeSet来存储自定义类Person对象
        TreeSet<Person> treeSet = new TreeSet<Person>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1 == o2){
                    return 0;
                }
                int result = o1.getAge() - o2.getAge();
                if (result == 0){
                    return o1.getName().compareTo(o2.getName());
                }
                return result;
            }

        });

        // Person类实现了Comparable接口，并且重写comparaTo方法
        // 比较规则是先按照 年龄排序，年龄相等的情况按照年龄排序
        treeSet.add(new Person("张山1", 20));
        treeSet.add(new Person("张山2", 16));
        treeSet.add(new Person("张山3", 13));
        treeSet.add(new Person("张山4", 17));
        treeSet.add(new Person("张山5", 20));

        for (Person p : treeSet){
            System.out.println(p);
        }

    }
}
