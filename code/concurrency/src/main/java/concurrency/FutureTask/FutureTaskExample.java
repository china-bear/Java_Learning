package concurrency.FutureTask;

import java.util.concurrent.*;

// https://juejin.cn/post/6844903774985650183
// https://zhuanlan.zhihu.com/p/88933756
public class FutureTaskExample {
    public static void main(String[] args) {
        MyCallable2 callable1 = new MyCallable2(1000);                       // 要执行的任务
        MyCallable2 callable2 = new MyCallable2(2000);

/*      在Future接口中声明了5个方法，下面依次解释每个方法的作用
        cancel方法用来取消任务，如果取消任务成功则返回true，如果取消任务失败则返回false。参数mayInterruptIfRunning表示是否允许取消正在执行却没有执行完毕的任务，如果设置true，则表示可以取消正在执行过程中的任务。如果任务已经完成，则无论mayInterruptIfRunning为true还是false，此方法肯定返回false，即如果取消已经完成的任务会返回false；如果任务正在执行，若mayInterruptIfRunning设置为true，则返回true，若mayInterruptIfRunning设置为false，则返回false；如果任务还没有执行，则无论mayInterruptIfRunning为true还是false，肯定返回true。
        isCancelled方法表示任务是否被取消成功，如果在任务正常完成前被取消成功，则返回 true。
        isDone方法表示任务是否已经完成，若任务完成，则返回true；
        get()方法用来获取执行结果，这个方法会产生阻塞，会一直等到任务执行完毕才返回；
        get(long timeout, TimeUnit unit)用来获取执行结果，如果在指定时间内，还没获取到结果，就直接返回null。
        Future提供了三种功能：
        判断任务是否完成；
        能够中断任务；
        能够获取任务执行结果。
        因为Future只是一个接口，所以是无法直接用来创建对象使用的，因此就有了下面的FutureTask*/

        FutureTask<String> futureTask1 = new FutureTask<String>(callable1);// 将Callable写的任务封装到一个由执行者调度的FutureTask对象
        FutureTask<String> futureTask2 = new FutureTask<String>(callable2);

        ExecutorService executor = Executors.newFixedThreadPool(2);        // 创建线程池并返回ExecutorService实例
        executor.execute(futureTask1);  // 执行任务
        executor.execute(futureTask2);

        while (true) {
            try {
                if(futureTask1.isDone() && futureTask2.isDone()){//  两个任务都完成
                    System.out.println("Done");
                    executor.shutdown();                          // 关闭线程池和服务
                    return;
                }

                if(!futureTask1.isDone()){ // 任务1没有完成，会等待，直到任务完成
                    System.out.println("FutureTask1 output="+futureTask1.get());
                }

                System.out.println("Waiting for FutureTask2 to complete");
                String s = futureTask2.get(200L, TimeUnit.MILLISECONDS);
                if(s !=null){
                    System.out.println("FutureTask2 output="+s);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }catch(TimeoutException e){
                //do nothing
            }
        }
    }
}
