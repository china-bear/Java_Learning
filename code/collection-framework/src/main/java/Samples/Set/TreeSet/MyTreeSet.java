package Samples.Set.TreeSet;

import java.util.TreeSet;

/**
 * 特点：存取无序，元素唯一，可以进行排序（排序是在添加的时候进行排序）。
 * TreeSet是基于二叉树的数据结构，二叉树的一个节点下不能大于两个节点。
 * Created by bear on 2020/9/1
 */
public class MyTreeSet {

    public static void main(String[] args) {

        TreeSet<String> treeSet = new TreeSet<String>();
        treeSet.add("abc");
        treeSet.add("zbc");
        treeSet.add("cbc");
        treeSet.add("xbc");

        // 遍历  结果：取出来的结果是经过排序的
        for (String str : treeSet){
            System.out.println(str);
        }
    }
}
