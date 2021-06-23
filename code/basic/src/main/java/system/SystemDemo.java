package system;

public class SystemDemo {

    public static void main(String[] args) {
        System.out.println("系统版本：" + System.getProperty("os.name") + System.getProperty("os.version") + " " + System.getProperty("os.arch"));
        System.out.println("系统用户：" + System.getProperty("user.name"));
        System.out.println("当前用户目录：" + System.getProperty("user.home"));
        System.out.println("当前用户工作目录：" + System.getProperty("user.dir"));

        Runtime run = Runtime.getRuntime(); // 通过Runtime类的静态方法进行实例化操作
        System.out.println("JVM最大内存量：" + run.maxMemory()); // 观察最大的内存，根据机器的不同，环境也会有所不同
        System.out.println("JVM空闲内存量：" + run.freeMemory()); // 取得程序运行的空闲内存

        Process p = null; // 定义进程变量
        try {
            p = run.exec("notepad.exe"); // 调用本机程序，此方法需要异常处理
        } catch (Exception e) {
            e.printStackTrace(); // 打印异常信息
            // System.out.println(e) ;
        }
        try {
            Thread.sleep(5000); // 让此线程存活5秒
        } catch (Exception e) {
        }
        p.destroy(); // 结束此进程
    }

}
