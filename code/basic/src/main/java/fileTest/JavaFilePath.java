package fileTest;
import java.io.File;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaFilePath {
    public static void main(String[] args) throws IOException, URISyntaxException {
            File file = new File("/Users/pankaj/test.txt");
            printPaths(file);
            // relative path
            file = new File("test.xsd");
            printPaths(file);
            // complex relative paths
            file = new File("/Users/pankaj/../pankaj/test.txt");
            printPaths(file);
            // URI paths
            file = new File(new URI("file:///Users/pankaj/test.txt"));
            printPaths(file);

            //https://zq99299.github.io/java-tutorial/essential/io/objectstreams.html
            // Microsoft Windows syntax
            //Path path = Paths.get("C:\\home\\joe\\foo");

            // Solaris syntax  不支持带协议的路径 hdfs://namenode.safe.lycc.qihoo.net:9000/home/hdp-ads-dw/  报错：java.nio.file.FileSystemNotFoundException: Provider "hdfs" not installed
            Path path = Paths.get("/home/hdp-ads-dw/hive/warehouse/hdp_ads_dw.db/ods/ods_mediav_base_adspace_pdb_ext/dt=2020-06-17");

            System.out.format("toString: %s%n", path.toString());
            System.out.format("getFileName: %s%n", path.getFileName());
            System.out.format("getName(0): %s%n", path.getName(0));
            System.out.format("getNameCount: %d%n", path.getNameCount());
            System.out.format("subpath(0,2): %s%n", path.subpath(0, 2));
            System.out.format("getParent: %s%n", path.getParent());
            System.out.format("getRoot: %s%n", path.getRoot());
            String str = "hdfs://namenode.safe.lycc.qihoo.net:9000/home/hdp-ads-dw/hive";

            System.out.println(getPathParent(str, 47));
            System.out.println(getFileName(str, 47));

            // java获取classpath文件路径空格转变成了转义字符%20的问题
            JavaFilePath classPath = new JavaFilePath();
            classPath.printClassPath();

    }
    // java获取classpath文件路径空格转变成了转义字符%20的问题  https://www.shuzhiduo.com/A/A7zgjjrod4/
    private  void printClassPath() throws URISyntaxException, UnsupportedEncodingException {
        String classPath;

        // 如果当前路径中包含了空格，则返回的路径字符串空格则被转义为(%20)
        classPath = getClass().getResource("/").getPath();
        System.out.println(classPath);
        // 如果当前路径中包含了空格，则返回的路径字符串空格则被转义为(%20)
        classPath = getClass().getClassLoader().getResource("").getPath();
        System.out.println(classPath);

        // 解决空格转变成了转义字符%20 3种办法

        System.out.println(java.net.URLDecoder.decode(classPath,"UTF-8"));

        classPath= getClass().getResource("/").toURI().getPath();  // getResource方法返回的是一个URL对象,toURI()是将RUL对象转换为URI对象.
        System.out.println(classPath);

        classPath= getClass().getClassLoader().getResource("").toURI().getPath();
        System.out.println(classPath);
    }

    private static void printPaths(File file) throws IOException {
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Canonical Path: " + file.getCanonicalPath());
        System.out.println("Path: " + file.getPath());

        System.out.println("=========================================");
    }

    public static String getFileName(String pathStr, int delim) {
        int pos = pathStr.lastIndexOf(delim);
        int len = pathStr.length();
        System.out.println(pos);
        System.out.println(len);
        if (pos >= 0 && pos < len) {
            return pos == pathStr.length() - 1 ? pathStr: pathStr.substring(pos+1, len);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static String getPathParent(String pathStr, int delim) {
        int pos = pathStr.lastIndexOf(delim);
        return  pos < 0 ?  null : pathStr.substring(0, pos);
    }

}
