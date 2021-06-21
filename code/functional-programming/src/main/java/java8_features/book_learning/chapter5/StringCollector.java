package java8_features.book_learning.chapter5;

import java.util.Collections;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * 例 5-25 定义字符串收集器
 */
// BEGIN class_def
public class StringCollector implements Collector<String, StringCombiner, String> {
// END class_def

    private static final Set<Characteristics> characteristics = Collections.emptySet();

    private final String delim;
    private final String prefix;
    private final String suffix;

    public StringCollector(String delim, String prefix, String suffix) {
        this.delim = delim;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    /**
     * 例 5-26 Supplier 是创建容器的工厂
     *
     * @return
     */
    @Override
    // BEGIN supplier
    public Supplier<StringCombiner> supplier() {
        return () -> new StringCombiner(delim, prefix, suffix);
    }
    // END supplier

    /**
     * 例 5-27 accumulator 是一个函数，它将当前元素叠加到收集器
     *
     * @return
     */
    @Override
    // BEGIN accumulator
    public BiConsumer<StringCombiner, String> accumulator() {
        return StringCombiner::add;
    }
    // END accumulator

    /**
     * 例 5-28 combiner 合并两个容器
     *
     * @return
     */
    @Override
    // BEGIN combiner
    public BinaryOperator<StringCombiner> combiner() {
        return StringCombiner::merge;
    }
    // END combiner

    /**
     * 例 5-29 finisher 方法返回手机操作的最终结果
     *
     * @return
     */
    @Override
    // BEGIN finisher
    public Function<StringCombiner, String> finisher() {
        return StringCombiner::toString;
    }
    // END finisher

    @Override
    public Set<Characteristics> characteristics() {
        return characteristics;
    }

}
