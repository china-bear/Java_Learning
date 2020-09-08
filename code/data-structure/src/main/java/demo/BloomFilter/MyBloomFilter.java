package demo.BloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.util.BitSet;

/**
 * 手动实现布隆过滤器
 * Created by bear on 2020/9/7
 */
public class MyBloomFilter {

    /**
     * 位数组的大小
     */
    private static final int DEFAULT_SIZE = 2 << 24;
    /**
     * 通过这个数组可以创建 6 个不同的哈希函数
     */
    private static final int[] SEEDS = new int[]{3, 13, 46, 71, 91, 134};

    /**
     * 位数组。数组中的元素只能是 0 或者 1
     */
    private BitSet bits = new BitSet(DEFAULT_SIZE);

    /**
     * 存放包含 hash 函数的类的数组
     */
    private SimpleHash[] func = new SimpleHash[SEEDS.length];

    /**
     * 初始化多个包含 hash 函数的类的数组，每个类中的 hash 函数都不一样
     */
    public MyBloomFilter() {
        // 初始化多个不同的 Hash 函数
        for (int i = 0; i < SEEDS.length; i++) {
            func[i] = new SimpleHash(DEFAULT_SIZE, SEEDS[i]);
        }
    }

    /**
     * 添加元素到位数组
     */
    public void add(Object value) {
        for (SimpleHash f : func) {
            bits.set(f.hash(value), true);
        }
    }

    /**
     * 判断指定元素是否存在于位数组
     */
    public boolean contains(Object value) {
        boolean ret = true;
        for (SimpleHash f : func) {
            ret = ret && bits.get(f.hash(value));
        }
        return ret;
    }

    /**
     * 静态内部类。用于 hash 操作！
     */
    public static class SimpleHash {

        private int cap;
        private int seed;

        public SimpleHash(int cap, int seed) {
            this.cap = cap;
            this.seed = seed;
        }

        /**
         * 计算 hash 值
         */
        public int hash(Object value) {
            int h;
            return (value == null) ? 0 : Math.abs(seed * (cap - 1) & ((h = value.hashCode()) ^ (h >>> 16)));
        }

    }

    public static void main(String[] args) {

        // 方式一: 手动实现布隆过滤器
        MyBloomFilter filter = new MyBloomFilter();

        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        System.out.println("---------------------------------");
        Integer value3 = 13423;
        Integer value4 = 22131;
        System.out.println(filter.contains(value3));
        System.out.println(filter.contains(value4));
        filter.add(value3);
        filter.add(value4);
        System.out.println(filter.contains(value3));
        System.out.println(filter.contains(value4));

        // 方式二： 利用Google开源的 Guava中自带的布隆过滤器, 有一个重大的缺陷就是只能单机使用,另外容量扩展也不容易
        // 创建最多存放1500个整数的布隆过滤器实例，以容忍误判的概率为百分之（0.01
        BloomFilter<Integer> gg_filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01);

        // 判断指定元素是否存在
        System.out.println(gg_filter.mightContain(1));
        System.out.println(gg_filter.mightContain(2));
        // 将元素添加进布隆过滤器
        gg_filter.put(1);
        gg_filter.put(2);
        System.out.println(gg_filter.mightContain(1));
        System.out.println(gg_filter.mightContain(2));


       // 方式三： Redis 中的布隆过滤器

    }

}
