package nw_way;

import java.util.List;

public class WaterProvider implements Runnable {

    /**
     * 这是我们的水桶（10L）
     */
    private List<Water> waterList = null;

    /**
     * 初始化水桶，也就是缓冲区
     */
    public WaterProvider(List<Water> waterList) {
        this.waterList = waterList;
    }

    @Override
    public void run() {
        /**
         * 循环任务，也就是这个任务会执行多次，没有明确的break语句或者异常，该任务不会终止
         */
        while (true) {
            /**
             * 这里获得waterList的锁，之前说过notify、wait的使用必须先获得锁
             */
            synchronized (waterList) {
                /**
                 * 判断是不是满了，满了就不生产了
                 */
                while (waterList.size() == 5) {
                    try {
                        /**
                         * 这里将所释放掉waterList的锁
                         */
                        waterList.wait();
                    } catch (InterruptedException e) {}
                }
                /**
                 * 如果还没有满，那么就加1L水进去，加进去之前
                 */
                waterList.add(new Water());
                System.err.println("生产了1L水，现在水桶有：" + waterList.size() + "L水");
                try {
                    /**
                     * sleep方法是不会释放锁的
                     */
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                /**
                 * 我通知所有的消费者来消费
                 */
                waterList.notifyAll();
            }
        }
    }
}
