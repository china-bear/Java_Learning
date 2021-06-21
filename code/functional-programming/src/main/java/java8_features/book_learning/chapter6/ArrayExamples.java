package java8_features.book_learning.chapter6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArrayExamples {

    /**
     * 例 6-9 计算简单滑动平均数
     * @param values
     * @param n
     * @return
     */
    // BEGIN simpleMovingAverage
    public static double[] simpleMovingAverage(double[] values, int n) {
        double[] sums = Arrays.copyOf(values, values.length); // <1>
        Arrays.parallelPrefix(sums, Double::sum); // <2>
        int start = n - 1;
        return IntStream.range(start, sums.length) // <3>
                .mapToDouble(i -> {
                    double prefix = i == start ? 0 : sums[i - n];
                    return (sums[i] - prefix) / n; // <4>
                })
                .toArray(); // <5>
    }
    // END simpleMovingAverage

    /**
     * 例 6-8 使用并行化数组操作初始化数组
     * @param size
     * @return
     */
    // BEGIN parallelInitialize
    public static double[] parallelInitialize(int size) {
        double[] values = new double[size];
        Arrays.parallelSetAll(values, i -> i);
        return values;
    }
    // END parallelInitialize

    /**
     * 例 6-7 使用 for 循环初始化数组
     * @param size
     * @return
     */
    // BEGIN imperativeInitilize
    public static double[] imperativeInitilize(int size) {
        double[] values = new double[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = i;
        }
        return values;
    }
    // END imperativeInitilize

}
