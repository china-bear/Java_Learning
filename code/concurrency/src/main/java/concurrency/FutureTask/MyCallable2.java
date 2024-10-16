package concurrency.FutureTask;

import java.util.concurrent.Callable;

public class MyCallable2 implements Callable<String> {
    private long waitTime;
    public MyCallable2(int timeInMillis){
        this.waitTime=timeInMillis;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        //return the thread name executing this callable task
        return Thread.currentThread().getName();
    }

}
