package concurrency.FutureTask;

import java.util.concurrent.Callable;

/**
 * Created by bear on 2020/9/3
 */
public class MyFutureTask implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++){
            sum += i;
        }
        return sum;
    }
}
