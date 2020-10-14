package LinearStructure.Arrays.basic;

/**
 * 数组在内存中是连续的，插入或者删除需要移动数组中其他数据
 * 顺序存储结构中，一组数据要占据一段连续的存储，这就要求存储中有这么一段没有存放数据的、连续的存储空间。并且存放数据时候，数据的顺序与物理位置顺序一致。
 * 即在存储中，逻辑上相邻的结点他们的物理位置也相邻。
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
