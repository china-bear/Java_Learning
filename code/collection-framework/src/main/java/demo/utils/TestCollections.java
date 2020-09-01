package demo.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 1、java.util.Collection 是一个集合接口（集合类的一个顶级接口）。它提供了对集合对象进行基本操作的通用接口方法。
 * 2、java.util.Collections 是一个包装类（工具类/帮助类）。它包含有各种有关集合操作的静态多态方法。此类不能实例化，就像一个工具类，
 *    用于对集合中元素进行排序、搜索以及线程安全等各种操作，服务于Java的Collection框架。
 * Created by bear on 2020/9/1
 */
public class TestCollections {

    public static void main(String[] args) {
        //注意List是实现Collection接口的
        List list = new ArrayList();
        double array[] = { 112, 111, 23, 69, 5,1,77 };

        for (int i = 0; i < array.length; i++) {
            list.add(new Double(array[i]));
        }

        //反转reverse
        Collections.reverse(list);
        System.out.println("反转数组list1:"+list);

        //旋转
        Collections.rotate(list,2);
        System.out.println("旋转数组list1:"+list);

        //随机排序
        Collections.shuffle(list);
        System.out.println("随机排序："+list);

        //自定义排序
        Collections.sort(list, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("自定义排序："+list);

        //交换两个索引位置的元素
        Collections.swap(list,2,5);
        System.out.println("交换2、5两个索引后："+list);

        /**
         * int binarySearch(List list, Object key)//对List进行二分查找，返回索引，注意List必须是有序的,key为要查找的元素
         * int max(Collection coll)//根据元素的自然顺序，返回最大的元素。 类比int min(Collection coll)
         * int max(Collection coll, Comparator c)//根据定制排序，返回最大元素，排序规则由Comparatator类控制。类比int min(Collection coll, Comparator c)
         * void fill(List list, Object obj)//用指定的元素代替指定list中的所有元素。
         * int frequency(Collection c, Object o)//统计元素出现次数
         * int indexOfSubList(List list, List target)//统计target在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target).
         * boolean replaceAll(List list, Object oldVal, Object newVal), 用新元素替换旧元素
         */

        Collections.sort(list);
        int pos = Collections.binarySearch(list, 5);
        System.out.println("二分查找7的索引：" + pos);

        Double max = (Double) Collections.max(list);
        Double min = (Double) Collections.min(list);
        System.out.println("最大值："+max+" 最小值："+min);

        int frequency = Collections.frequency(list, 5);
        System.out.println("5出现的次数："+frequency);

        Collections.replaceAll(list,1,5);
        System.out.println(list);


        // 自然排序
        Collections.sort(list);
        for (int i = 0; i < array.length; i++) {
            System.out.println(list.get(i));
        }
    }
}
