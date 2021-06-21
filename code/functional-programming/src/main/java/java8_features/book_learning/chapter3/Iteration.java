package java8_features.book_learning.chapter3;

import java8_features.book_learning.chapter1.Album;
import java8_features.book_learning.chapter1.Artist;


import java.util.Iterator;
import java.util.List;

/**
 * 3.1 从外部迭代到内部迭代
 * 3.2 实现机制
 */
public class Iteration {

    /**
     * 例 3-1 使用 for 循环计算来自伦敦的艺术家人数
     *
     * @param allArtists
     * @return
     */
    public int externalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN external_count_londoners
        int count = 0;
        for (Artist artist : allArtists) {
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners
        return count;
    }

    /**
     * 例 3-2 使用迭代器计算来自伦敦的艺术家人数
     *
     * @param allArtists
     * @return
     */
    public int externalCountArtistsFromLondonExpanded(List<Artist> allArtists) {
        // BEGIN external_count_londoners_expanded
        int count = 0;
        Iterator<Artist> iterator = allArtists.iterator();
        while (iterator.hasNext()) {
            Artist artist = iterator.next();
            if (artist.isFrom("London")) {
                count++;
            }
        }
        // END external_count_londoners_expanded
        return count;
    }

    /**
     * 例 3-3 使用内部迭代计算来自伦敦的艺术家人数
     *
     * @param allArtists
     * @return
     */
    public long internalCountArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN internal_count_londoners
        long count = allArtists.stream()
                .filter(artist -> artist.isFrom("London"))
                .count();
        // END internal_count_londoners
        return count;
    }

    /**
     * 例 3-4 只过滤，不计数（惰性求值）
     *
     * @param allArtists
     */
    public void filterArtistsFromLondon(List<Artist> allArtists) {
        // BEGIN filter_londoners
        allArtists.stream()
                .filter(artist -> artist.isFrom("London"));
        // END filter_londoners
    }

    /**
     * 例 3-5 由于使用了惰性求值，没有输出艺术家的名字
     *
     * @param allArtists
     */
    public void filterArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN filter_londoners_printed
        allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                });
        // END filter_londoners_printed
    }

    /**
     * 例 3-6 输出艺术家的名字
     *
     * @param allArtists
     * @return
     */
    public long internalCountArtistsFromLondonPrinted(List<Artist> allArtists) {
        // BEGIN internal_count_londoners_printed
        long count = allArtists.stream()
                .filter(artist -> {
                    System.out.println(artist.getName());
                    return artist.isFrom("London");
                })
                .count();
        // END internal_count_londoners_printed
        return count;
    }

}
