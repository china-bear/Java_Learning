package exception;

/**
 * https://juejin.cn/post/6844903446185951240
 * https://zhuanlan.zhihu.com/p/143282333
 * {try}-with-resources关键点
 * 1. 由带资源的try语句管理的资源必须是实现了AutoCloseable接口的类的对象
 * 2. 在try代码中声明的资源被隐式声明为final
 * 3. 通过使用分号分隔每个声明可以管理多个资源
 */
public class TryWithResource {

    public static void main(String[] args) {

        try (Connection conn = new Connection()) {
            conn.sendData();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}

/** 配合try-with-resource，资源必须实现AutoClosable接口。该接口的实现类需要重写close方法
 * Closeable 和 AutoCloseable
 * AutoCloseable 是 Java 7 新增的接口，Closeable 早就有了. 二者的关系是 Closeable extends AutoCloseable, 二者都仅包含一个 close() 方法, 那么为什么 Java 7 还要新增 AutoCloseable 接口呢?
 * Closeable 在 java.io 包下, 主要用于 IO 相关的资源的关闭, 其 close() 方法定义了抛出 IOException 异常, 其实现类实现 close() 方法时, 不允许抛出除 IOException、 RuntimeException 外其他类型的异常.
 * AutoCloseable 位于 java.lang 包下, 使用更广泛, 其 close() 方法定义是 void close() throws Exception, 就是它的实现类的 close() 方法对异常抛出是没有限制的。
 */

class Connection implements AutoCloseable {

    /**
     * 由于一次只能抛出一个异常，所以在最上层看到的是最后一个抛出的异常——也就是close方法抛出的MyException，而sendData抛出的Exception被忽略了。这就是所谓的异常屏蔽。
     * 由于异常信息的丢失，异常屏蔽可能会导致某些bug变得极其难以发现，从Java 1.7开始，Throwable类新增了 addSuppressed 方法，支持将一个异常附加到另一个异常身上，从而避免异常屏蔽。
     */

    public void sendData() throws Exception {
        System.out.println("正在发送数据");
        throw new Exception("doSomething exception");
    }

    @Override
    public void close() throws Exception {
        System.out.println("正在关闭连接");
        throw new Exception("close exception");
    }
}

