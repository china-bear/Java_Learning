package nw_way;

import java.util.List;

public class WaterConsumer implements Runnable {

    private List<Water> waterList;

    public WaterConsumer(List<Water> waterList) {
        this.waterList = waterList;
    }

    @Override
    public void run() {
        /**
         * 循环任务，也就是这个任务会执行多次，没有明确的break语句或者异常，该任务不会终止
         */
        while (true) {
            /**
             * 获得锁
             */
            synchronized (waterList) {
                /**
                 * 证明没有水可以消费
                 */
                while (waterList.isEmpty()) {
                    try {
                        /**
                         * 释放锁
                         */
                        waterList.wait();
                    } catch (InterruptedException e) {}
                }
                /**
                 * 每次我都移动第一个元素
                 */
                waterList.remove(0);
                System.err.println("消费了1L水，现在水桶有：" + waterList.size() + "L水");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                /**
                 * 通知生产者生产
                 */
                waterList.notifyAll();
            }
        }
    }
}

