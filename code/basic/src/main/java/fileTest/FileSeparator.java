package fileTest;

import java.io.File;
import java.util.StringTokenizer;

public class FileSeparator {

    public static void main(String[] args) {
        System.out.println("File.separator = "+ File.separator);
        System.out.println("File.separatorChar = "+File.separatorChar);
        System.out.println("File.pathSeparator = "+File.pathSeparator);
        System.out.println("File.pathSeparatorChar = "+File.pathSeparatorChar);

        //no platform independence, good for Unix systems
        File fileUnsafe = new File("tmp/abc.txt");
        //platform independent and safe to use across Unix and Windows
        File fileSafe = new File("tmp"+File.separator+"abc.txt");
        // windows OS
        String PATH = "C:\\Program Files (x86)\\Common Files\\Oracle\\Java\\javapath;C:\\WINDOWS\\system32;C:\\WINDOWS;";
        String[] filePaths = PATH.split(File.pathSeparator);

        for (String filePath : filePaths) {
            StringTokenizer tokens  = new StringTokenizer(filePath, File.separator);
            System.out.println(filePath  +  "   Length: "  + (tokens.countTokens() -1 ));
            //System.out.println(filePath  +  "   Length: "  + filePath.split("\\\\").length);
        }

/*        StringTokenizer 构造方法：

        1. StringTokenizer(String str) ：构造一个用来解析 str 的 StringTokenizer 对象。java 默认的分隔符是空格("")、制表符(\t)、换行符(\n)、回车符(\r)。
        2. StringTokenizer(String str, String delim) ：构造一个用来解析 str 的 StringTokenizer 对象，并提供一个指定的分隔符。
        3. StringTokenizer(String str, String delim, boolean returnDelims) ：构造一个用来解析 str 的 StringTokenizer 对象，并提供一个指定的分隔符，同时，指定是否返回分隔符。
        StringTokenizer 常用方法：

        1. int countTokens()：返回nextToken方法被调用的次数。
        2. boolean hasMoreTokens()：返回是否还有分隔符。
        3. boolean hasMoreElements()：判断枚举 （Enumeration） 对象中是否还有数据。
        4. String nextToken()：返回从当前位置到下一个分隔符的字符串。
        5. Object nextElement()：返回枚举 （Enumeration） 对象的下一个元素。
        6. String nextToken(String delim)：与 4 类似，以指定的分隔符返回结果。*/
        // linux os
        String hdfs_path = "/home/hdp-ads-dw/hive/warehouse/hdp_ads_dw.db/dwt/dwt_search_amazing/dt=2020-12-25/";
        StringTokenizer st  = new StringTokenizer(hdfs_path, "//");
        System.out.println(st.countTokens());
        while(st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }

        //printFile(new File("C:\\WINDOWS\\system32") ,0);
    }

    /**
     * 打印文件信息
     * @param file 文件名称
     * @param level 层次数(实际就是：第几次递归调用)
     */
    static void printFile(File file, int level) {
        //输出层次数
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        //输出文件名
        System.out.println(file.getName());
        //如果file是目录，则获取子文件列表，并对每个子文件进行相同的操作
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File temp : files) {
                //递归调用该方法：注意等+1
                printFile(temp, level + 1);
            }
        }
    }
}
