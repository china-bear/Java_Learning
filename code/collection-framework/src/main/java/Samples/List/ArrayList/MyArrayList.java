package linear_data_structure.List.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List的特点：存取有序，有索引，可以根据索引来进行取值，元素可以重复
 * Created by bear on 2020/9/1
 */
public class MyArrayList {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();

        list1.add("接口1");
        list1.add("接口2");
        list1.add("接口3");

        // 第一种遍历方式,使用迭代器
        Iterator<String> it = list1.iterator();
        while(it.hasNext()){
            String next = it.next();
            System.out.println(next);
        }
        System.out.println("-------------------");

        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Monday");
        list2.add("Tuesday");
        list2.add("Wensday");
        // 第二种遍历方式，使用增强for迭代，简化了迭代容器时的写法
        for (String weekday  : list2){
            System.err.println(weekday.toUpperCase());
        }


        System.out.println("-------------------");
        //第三种遍历方式,使用List下标
        for(int i = 0; i<list1.size(); i++){
            System.out.println(list1.get(i));
        }
    }
}