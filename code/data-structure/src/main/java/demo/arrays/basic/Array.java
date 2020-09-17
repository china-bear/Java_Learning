package demo.arrays.basic;

/**
 * Created by bear on 2020/9/15
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
