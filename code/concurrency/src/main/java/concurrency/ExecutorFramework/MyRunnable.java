package concurrency.ExecutorFramework;

import java.util.Date;

/**
 * 这是一个简单的Runnable类，需要大约5秒钟来执行其任务。
 * java中Runnable和Callable的区别   https://juejin.cn/post/6844904086832152590
 *
 * 1. java的多线程开发中Runnable一直以来都是多线程的核心，而Callable是java1.5添加进来的一个增强版本
 * 2. Runnable需要实现run（）方法，Callable需要实现call（）方法
 * 3. Runnable是不返还值的，而Callable可以返回值
 * 4. Callable接口的call()方法允许抛出异常；Runnable的run()方法异常只能在内部中自行处理，不能往上继续抛
 * 5. Callalble接口支持返回执行结果，需要调用FutureTask.get()得到，此方法会阻塞主进程的继续往下执行，如果不调用不会阻塞
 *
 */
public class MyRunnable implements Runnable {

    private String command;

    public MyRunnable(String s) {
        this.command = s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Start. Time = " + new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName() + " End. Time = " + new Date());
    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return this.command;
    }
}
