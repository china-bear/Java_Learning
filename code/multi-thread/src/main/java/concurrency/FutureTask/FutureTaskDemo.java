package concurrency.FutureTask;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by bear on 2020/9/3
 */
public class FutureTaskDemo {

    public static void main(String[] args) {

        //第一种方式
        // 创建一个ExecutorService对象
        ExecutorService executor = Executors.newCachedThreadPool();
        //  new 一个Callable实例
        MyFutureTask task = new MyFutureTask();
        // a
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);

        // // 提交futureTask对象进入线程池
        executor.submit(futureTask);
        //关闭线程池
        executor.shutdown();

        //第二种方式，注意这种方式和第一种方式效果是类似的，只不过一个使用的是ExecutorService，一个使用的是Thread
        /*
        MyFutureTask task = new MyFutureTask();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();*/

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            //  获取futuretask结果
            System.out.println("task运行结果: "+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}



