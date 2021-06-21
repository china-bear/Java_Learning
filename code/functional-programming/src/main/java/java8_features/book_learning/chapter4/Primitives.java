package java8_features.book_learning.chapter4;

import java8_features.book_learning.chapter1.Album;
import java8_features.book_learning.chapter1.Artist;


import java.util.IntSummaryStatistics;

public class Primitives {

    /**
     * 例 4-4 使用 summaryStatistics 方法统计曲目长度
     * <p>
     * summaryStatistics 方法能计算出各种各样的统计值，
     * 如 IntStream 对象内所有元素中的最小值、最大值、平均值以及数值总和
     *
     * @param album
     */
    // BEGIN printTrackLengthStatistics
    public static void printTrackLengthStatistics(Album album) {
        IntSummaryStatistics trackLengthStats
                = album.getTracks()
                .mapToInt(track -> track.getLength())
                .summaryStatistics();

        System.out.printf("Max: %d, Min: %d, Ave: %f, Sum: %d",
                trackLengthStats.getMax(),
                trackLengthStats.getMin(),
                trackLengthStats.getAverage(),
                trackLengthStats.getSum());
    }
    // END printTrackLengthStatistics

}
