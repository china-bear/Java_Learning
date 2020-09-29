package SORT;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 排序算法测试
 */
public class TestSort {

    public static void main(String[] args) throws Exception {
        int n = 10000;
        // basic
        //选择排序
        testSort(n,"demo.sort.SelectionSort", "selectionSort");
        //插入排序
        testSort(n,"demo.sort.InsertionSort", "insertionSort");
        //插入排序优化版
        testSort(n,"demo.sort.InsertionSort", "insertionSortOptimization");
        //冒泡排序
        testSort(n,"demo.sort.BubbleSort", "bubbleSort");
        // advance
        //归并排序自底向上
        testSort(n,"demo.sort.MergeSortBU", "mergeSort");
        //归并排序自顶向下
        testSort(n,"demo.sort.MergeSortUB", "mergeSort");
        //快速排序
        testSort(n,"demo.sort.QuickSort", "quickSort");
        //三路快速排序
        testSort(n,"demo.sort.QuickSort3Ways", "quickSort3Ways");

    }


    /**
     * 测试排序算法性能
     *
     * @param n
     * @param className
     * @param methodName
     * @return double
     */
    public static double testSort(int n, String className, String methodName) throws Exception {
        long startTime = System.nanoTime();
        Object clazz = Class.forName(className).newInstance();
        Method[] obj = clazz.getClass().getMethods();
        for (Method method : obj) {
            if (methodName != null && methodName.equals(method.getName())) {
                //如果是private修饰符的，则把可访问性设置为true
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                List<Object> listValue = new ArrayList<Object>();
                listValue.add(generateArrays(n, 1, 10000));
                Comparable[] sortedArray = (Comparable[])method.invoke(clazz, listValue.toArray());
                //System.out.println(Arrays.toString(sortedArray));
                if(!isSorted(sortedArray)){
                    throw new RuntimeException("Error");
                }
            }
        }
        long endTime = System.nanoTime();
        double totalTime = (endTime - startTime) / 1e9;
        System.out.println(className + "." + methodName + ": " + totalTime + " s");
        return totalTime;
    }

    /**
     * 随机生成指定长度数组
     *
     * @param n
     * @param rangeL
     * @param rangeR
     * @return java.lang.Integer[]
     */
    public static Integer[] generateArrays(int n, int rangeL, int rangeR) {
        assert (rangeL <= rangeR);
        Integer[] result = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            result[i] = Math.abs(random.nextInt()) % (rangeR - rangeL + 1) + rangeL;
        }
        return result;
    }

    /**
     * 判断数组是否有序
     *
     * @param array
     * @return boolean

     */
    public static boolean isSorted(Comparable[] array){
        for (int i = 1; i < array.length; i++) {
            if(array[i].compareTo(array[i-1]) < 0){
                return false;
            }
        }
        return true;
    }
}
