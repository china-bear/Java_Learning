package exception;

import java.io.*;

/**
 * https://juejin.cn/post/6844903446185951240
 */
public class TryWithResource02 {

    // 处理资源关闭的代码通常写在finally块中
    public static void try_with_finally() {
        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        try {
            bin = new BufferedInputStream(new FileInputStream(new File("test.txt")));
            bout = new BufferedOutputStream(new FileOutputStream(new File("out.txt")));
            int b;
            while ((b = bin.read()) != -1) {
                bout.write(b);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bin != null) {
                try {
                    bin.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    if (bout != null) {
                        try {
                            bout.close();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    // 用Java 1.7中新增的try-with-resource语法糖来打开资源，无需码农写关闭代码,编译器自动生成了finally块。
    public static void try_with_resource() {
        try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File("test.txt")));
             BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("out.txt")))) {
            int b;
            while ((b = bin.read()) != -1) {
                bout.write(b);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try_with_resource();
        try_with_finally();
    }
}
