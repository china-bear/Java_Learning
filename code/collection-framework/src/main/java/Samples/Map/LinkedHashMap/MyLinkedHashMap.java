package linear_data_structure.Map.LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Map;

import linear_data_structure.Map.HashMap.Person;

/**
 * 基于链表和哈希表结构的所以具有存取有序，键不重复的特性
 * Created by bear on 2020/9/1
 */
public class MyLinkedHashMap {

    public static void main(String[] args) {

        // 利用LinkedHashMap存储，自定义对象Person作为键
        // 为了保证键的唯一性，必须重写hashCode和equals方法
        LinkedHashMap<Person,String> map = new LinkedHashMap<Person,String>();

        map.put(new Person("张三", 12), "JAVA");
        map.put(new Person("李四", 13), "IOS");
        map.put(new Person("小花", 22), "JS");
        map.put(new Person("小黑", 32), "PHP");
        map.put(new Person("张三", 12), "C++");

        // foreach遍历  结果：取出来的顺序就是和存入的顺序保持一致,存入的时候添加了两个张三，如果Map中键相同的时候，当后面的值会覆盖掉前面的值
        for (Map.Entry<Person,String> entry : map.entrySet()){
            System.out.println(entry.getKey()+"==="+entry.getValue());
        }
    }
}
