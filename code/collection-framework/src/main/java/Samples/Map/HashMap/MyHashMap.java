package linear_data_structure.Map.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 基于哈希表结构实现的，所以存储自定义对象作为键时，必须重写hasCode和equals方法,存取无序的
 * Created by bear on 2020/9/1
 */
public class MyHashMap {

    public static void main(String[] args) {

        // 利用HashMap存储，自定义对象Person作为键
        // 为了保证键的唯一性，必须重写hashCode和equals方法
        HashMap<Person,String> map = new HashMap<Person,String>();

        map.put(new Person("张三", 12), "JAVA");
        map.put(new Person("李四", 13), "IOS");
        map.put(new Person("小花", 22), "JS");
        map.put(new Person("小黑", 32), "PHP");
        map.put(new Person("张三", 12), "C++");

        Set<Entry<Person, String>> entrySet = map.entrySet();
        Iterator<Entry<Person, String>> it = entrySet.iterator();

        // 结果：存入的时候添加了两个张三，如果Map中键相同的时候，当后面的值会覆盖掉前面的值
        while (it.hasNext()){
            Entry<Person, String> entry = it.next();
            System.out.println(entry.getKey() + "---" + entry.getValue());
        }

        }
}
