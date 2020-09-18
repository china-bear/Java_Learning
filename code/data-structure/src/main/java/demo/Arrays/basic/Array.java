package demo.Arrays.basic;

/**
 * 数组在内存中是连续的，插入或者删除需要移动数组中其他数据
 */
public class Array {

    public static void main(String[] args) {

        int[] arr = new int[10];
        System.out.println(arr.length);
        System.out.println("------------------------------");
        for(int i = 0 ; i < arr.length ; i ++)
            arr[i] = i;
        System.out.println("------------------------------");
        int[] scores = new int[]{100, 99, 66};
        for(int i = 0 ; i < scores.length ; i ++)
            System.out.print(scores[i] + "\t");
            System.out.println();

        for(int score: scores)
            System.out.print(score + "\t");
            System.out.println();

        scores[0] = 96;
        System.out.println("------------------------------");
        for(int i = 0 ; i < scores.length ; i ++)
            System.out.print(scores[i] + "\t");
    }
}
