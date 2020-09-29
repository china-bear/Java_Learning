package Samples.Utils;

import Samples.Set.TreeSet.Person;

import java.util.Arrays;

/**
 * https://zhuanlan.zhihu.com/p/65220978
 * java.util.Arrays类，包含了常用的数组操作(排序、查找、填充、打印等)。
 * Created by bear on 2020/9/1
 */
public class TestArrays {

    public static void main(String[] args) {

        // 1、Arrays.toString()打印数组
        int [] arr={1,7,45,504};
        System.out.println(arr); // 打印数组引用的值；
        System.out.println(Arrays.toString(arr)); // 打印数组元素的值

        // 2、Arrays.equals(int[] a, int[] a2)比较两个数组是否相同
        int [] arrA={23,34,345,234};
        int [] arrB={23,34,345,234};
        //两个数组以相同的顺序包含相同的元素
        System.out.println(Arrays.equals(arrA, arrB));//true
        //(2)Arrays.equals(...)与Object中的equals方法有什么不同？
        System.out.println(arrA.equals(arrB));//false

        //3、Arrays.copyOf(int[] original, int newLength)复制指定的数组---效率低，会重新开辟新的数组空间original - 要复制的数组;newLength - 要返回的副本的长度
        int [] arrSrc={23,34,345,234};
        int [] arrDst=new int[5];//默认值0
        System.out.println("拷贝前：" + arrDst);
        arrDst=Arrays.copyOf(arrSrc, 5);  //重新开辟空间
        System.out.println("拷贝后：" + arrDst);
        System.out.println(Arrays.toString(arrDst));

        // 4、Arrays.fill(int[] a, int val)/Arrays.fill(int[] a, int fromIndex, int toIndex, int val)填充数组
        int[] a= {1,2,323,23,543,12,59};
        System.out.println(Arrays.toString(a));
        Arrays.fill(a, 2, 4, 100);  //将2到4索引的元素替换为100;前闭后开
        System.out.println(Arrays.toString(a));
        Arrays.fill(a, 55);
        System.out.println(Arrays.toString(a));

        // 5、Arrays.sort(int[] a);对数组进行升序排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 6. 数组元素是引用类型的排序(Comparable接口的应用)
        Person[] student = {new Person("王二", 17), new Person("马三", 15),new Person("李四", 22)};
        Arrays.sort(student);
        System.out.println(Arrays.toString(student));

        // 7、Arrays.binarySearch(int[] a, int key)二分法查找
        System.out.println(Arrays.toString(a));
        Arrays.sort(a);   //使用二分法查找，必须先对数组进行排序;
        System.out.println(Arrays.toString(a));
        //返回排序后新的索引位置,若未找到返回负数。
        System.out.println("该元素的索引："+Arrays.binarySearch(a, 12));
    }
}
