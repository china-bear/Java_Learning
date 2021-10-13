package Samples.List.ArrayList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** CopyOnWriteArrayList 写的时候不对原集合进行修改，而是重新复制一份，修改完之后，再移动指针
 * CopyOnWriteArrayList优缺点
 * 缺点：
 * 1、耗内存（集合复制）
 * 2、实时性不高

 * 优点：
 * 1、数据一致性完整，为什么？因为加锁了，并发数据不会乱
 * 2、解决了像ArrayList、Vector这种集合多线程遍历迭代问题，记住，Vector虽然线程安全，只不过是加了synchronized关键字，迭代问题完全没有解决！

 * CopyOnWriteArrayList使用场景
 * 1、读多写少（白名单，黑名单，商品类目的访问和更新场景），为什么？因为写的时候会复制新集合
 * 2、集合不大，为什么？因为写的时候会复制新集合
 * 3、实时性要求不高，为什么，因为有可能会读取到旧的集合数据
 */

public class CopyOnWriteArrayListTest {

    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {

        list.add("1");
        list.add("2");
        list.add("3");

        Iterator<String> iter = list.iterator();

        // 存放10个线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        // 执行10个任务(我当前正在迭代集合（这里模拟并发中读取某一list的场景）)
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    while (iter.hasNext()) {
                        System.err.println(iter.next());
                    }
                }
            });
            service.execute(new Runnable() {
                @Override
                public void run() {
                    list.add("121");// 添加数据
                }
            });
        }

        // 执行10个任务
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    list.add("121");// 添加数据
                }
            });
            service.execute(new Runnable() {
                @Override
                public void run() {
                    while (iter.hasNext()) {
                        System.err.println(iter.next());
                    }
                }
            });
        }

        System.err.println(Arrays.toString(list.toArray()));

        service.awaitTermination(3, TimeUnit.SECONDS);
        service.shutdownNow();
    }
}
