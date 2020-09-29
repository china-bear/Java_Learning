package linear_data_structure.Arrays.sparse;

import java.io.*;


/**
 * Created by bear on 2020/9/16
 */
public class SparseArrayToFile {
    /**
     * 将原始数组转化成稀疏数组，并将稀疏数组存入文件，以便读取
     * @param chessArray
     */
    private static  void toSparse(int[][] chessArray) {
        System.out.println("原始的二维数组");
        for(int i = 0; i<chessArray.length;i++){
            for(int j = 0; j<chessArray[0].length; j++){
                //System.out.println("i= " + i + ",j=" + j);
                System.out.printf("%d\t",chessArray[i][j]);
            }
            System.out.println();
        }
        //数组有多少个非零值
        int sum = 0;
        for(int i = 0; i<chessArray.length;i++){
            for(int j = 0; j<chessArray[0].length; j++){
                if(chessArray[i][j]!=0){
                    sum++;
                }
            }
        }
        System.out.println("非零值："+sum);

        //创建稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = chessArray.length;
        sparseArray[0][1] = chessArray[0].length;
        sparseArray[0][2] = sum;

        //给稀疏数组赋值
        int count = 0;
        int i = 0;
        while (i < chessArray.length) {
            for (int j = 0; j < chessArray[0].length; j++) {
                if(chessArray[i][j]!=0){
                    count++;
                    //横坐标值
                    sparseArray[count][0] = i;
                    //纵坐标值
                    sparseArray[count][1] = j;
                    //该坐标下的值
                    sparseArray[count][2]=chessArray[i][j];
                }
            }
            i++;
        }

        //将稀疏数组存入文件中
        try{
            FileOutputStream out = new FileOutputStream("E:"+ File.separator+"app" +File.separator+"data.txt");
            byte[] arr;
            StringBuilder str = new StringBuilder();
            //遍历稀疏数组
            System.out.println("row\tcol\tvalue");
            for (int[] aSparseArray : sparseArray) {
                //将数字转换成字符串
                Integer val1 = aSparseArray[0];
                str.append(val1.toString()).append(",");
                Integer val2 = aSparseArray[1];
                str.append(val2.toString()).append(",");
                Integer val3 = aSparseArray[2];
                str.append(val3.toString()).append(",");
                System.out.println("字符串: " + str);
            }
            //将字符串放入缓冲区
            arr = str.toString().getBytes();
            //将byte数组写入文件
            out.write(arr);
            System.out.println("写入成功！！！");
            //释放资源
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 读取文件，将稀疏数组转换为原始数组
     * @return
     */
    private static int[][] toSimpleArray() {

        int[][] chessArray = null;
        try{
            //读取文件
            FileInputStream in = new FileInputStream("E:"+ File.separator+"app" +File.separator+"data.txt");
            //创建缓冲区
            byte[] by = new byte[1024*8];
            //将文件数据写入缓冲区
            in.read(by);
            //将byte数组转换为字符串
            String str = new String(by);
            //使用，分割
            String[] str2 = str.split(",");
            //创建二维数组
            chessArray = new int[Integer.parseInt(str2[0])][Integer.parseInt(str2[1])];

            for (int i = 3; i < str2.length-1; i++) {
                //获取下标
                if(i%3==0){
                    int x = Integer.parseInt(str2[i]);
                    int y = Integer.parseInt(str2[i+1]);
                    int value = Integer.parseInt((str2[i+2]));
                    System.out.println("横坐标：" + x + "，纵坐标：" + y +"，值：" + value);
                    chessArray[x][y] = value;
                }
            }
            System.out.println("读取到的字符串:" + str);
            //释放资源
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return chessArray;
    }

    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0:表示没有棋子，1：表示黑子，2：表示蓝子
        int[][] chessArray = new int[6][7];
        chessArray[0][3]=22;
        chessArray[0][6]=15;
        chessArray[1][1]=11;
        chessArray[1][5]=17;
        chessArray[2][3]=-6;
        chessArray[3][5]=39;
        chessArray[4][0]=91;
        chessArray[5][2]=28;
        //调用toSparse()方法 将数组写入文件
        SparseArrayToFile.toSparse(chessArray);
        //调用toSimpleArray()方法 将数据还原成二维数组
        int[][] array = SparseArrayToFile.toSimpleArray();
        System.out.println("恢复后的原始的二维数组");
        for(int i = 0; i<array.length;i++){
            for(int j = 0; j<array[0].length; j++){
                System.out.printf("%d\t",array[i][j]);
            }
            System.out.println();
        }
    }
}
