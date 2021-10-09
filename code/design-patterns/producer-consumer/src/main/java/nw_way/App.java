package nw_way;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    /**
     * Program entry point.
     * 基于简单的notify/wait机制实现
     * @param args command line args
     */
    public static void main(String[] args) {
        /**
         * 新建一个水桶，存放所有的水，刚开始水桶是空的，容量为5L
         */
        List<Water> waterList = new ArrayList<>(5);

        ExecutorService executors = Executors.newFixedThreadPool(10);

        WaterProvider provider = new WaterProvider(waterList);
        WaterConsumer consumer = new WaterConsumer(waterList);

        executors.execute(provider);
        executors.execute(consumer);
    }
}
