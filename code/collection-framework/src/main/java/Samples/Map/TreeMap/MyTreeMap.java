package linear_data_structure.Map.TreeMap;

import linear_data_structure.Map.HashMap.Person;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 底层基于二叉树实现的，其中存放进去的所有数据都需要排序，要排序就要求对象具备比较功能,对象所属的类需要实现Comparable接口,或者给TreeMap集合传递一个Comparator接口对象
 * Created by bear on 2020/9/1
 */
public class MyTreeMap {

    public static void main(String[] args) {

        // 利用TreeMap存储，自定义对象Person作为键
        // 自定义对象实现Comparable接口或者传入Comparator比较器
        TreeMap<Person,String> map = new TreeMap<Person,String>(new Comparator<Person>() {
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

        map.put(new Person("张三", 12), "JAVA");
        map.put(new Person("李四", 50), "IOS");
        map.put(new Person("小花", 32), "JS");
        map.put(new Person("小黑", 32), "PHP");
        map.put(new Person("张三", 12), "C++");

        // foreach遍历 结果：TreeMap 取出来的顺序是经过Comparator方法排序的，添加了两个张三，如果Map中键相同的时候，当后面的值会覆盖掉前面的值
        for (Map.Entry<Person,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+"==="+entry.getValue());
        }

    }
}
