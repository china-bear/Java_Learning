package java8_features.book_learning.chapter5;

import java8_features.book_learning.chapter1.Album;
import java8_features.book_learning.chapter1.Artist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.nio.charset.Charset.defaultCharset;
import static java.util.Comparator.comparing;
import static java.util.Map.Entry;
import static java.util.stream.Collectors.*;

public class CollectorExamples {

    public void toCollectionTreeset() {
        Stream<Integer> stream = Stream.of(1, 2, 3);
        // BEGIN TO_COLLECTION_TREESET
        stream.collect(toCollection(TreeSet::new));
        // END TO_COLLECTION_TREESET
    }

    /**
     * 例 5-6 找出成员最多的乐队
     *
     * @param artists
     * @return
     */
    // BEGIN BIGGEST_GROUP
    public Optional<Artist> biggestGroup(Stream<Artist> artists) {
        Function<Artist, Long> getCount = artist -> artist.getMembers().count();
        return artists.collect(maxBy(comparing(getCount)));
    }
    // END BIGGEST_GROUP

    /**
     * 例 5-8 将艺术家组成的流分成乐队和独唱歌手两部分
     *
     * @param artists
     * @return
     */
    // BEGIN BANDS_AND_SOLO
    public Map<Boolean, List<Artist>> bandsAndSolo(Stream<Artist> artists) {
        return artists.collect(partitioningBy(artist -> artist.isSolo()));
    }
    // END BANDS_AND_SOLO

    /**
     * 例 5-9 使用方法引用将艺术家组成的 Stream 分成乐队和独唱歌手两部分
     *
     * @param artists
     * @return
     */
    // BEGIN BANDS_AND_SOLO_REF
    public Map<Boolean, List<Artist>> bandsAndSoloRef(Stream<Artist> artists) {
        return artists.collect(partitioningBy(Artist::isSolo));
    }
    // END BANDS_AND_SOLO_REF

    /**
     * 例 5-10 使用主唱对专辑分组
     *
     * @param albums
     * @return
     */
    // BEGIN ALBUMS_BY_ARTIST
    public Map<Artist, List<Album>> albumsByArtist(Stream<Album> albums) {
        return albums.collect(groupingBy(album -> album.getMainMusician()));
    }
    // END ALBUMS_BY_ARTIST

    /**
     * 例 5-13 计算每个艺术家专辑数的简单方式
     *
     * @param albums
     * @return
     */
    public Map<Artist, Integer> numberOfAlbumsDumb(Stream<Album> albums) {
        // BEGIN NUMBER_OF_ALBUMS_DUMB
        Map<Artist, List<Album>> albumsByArtist
                = albums.collect(groupingBy(album -> album.getMainMusician()));

        Map<Artist, Integer> numberOfAlbums = new HashMap<>();
        for (Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            numberOfAlbums.put(entry.getKey(), entry.getValue().size());
        }
        // END NUMBER_OF_ALBUMS_DUMB
        return numberOfAlbums;
    }

    /**
     * 例 5-14 使用收集器计算每个艺术家的专辑数
     *
     * @param albums
     * @return
     */
    // BEGIN NUMBER_OF_ALBUMS
    public Map<Artist, Long> numberOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(album -> album.getMainMusician(),
                counting()));
    }
    // END NUMBER_OF_ALBUMS

    /**
     * 例 5-15 使用简单方式求每个艺术家的专辑名
     *
     * @param albums
     * @return
     */
    // BEGIN NAME_OF_ALBUMS_DUMB
    public Map<Artist, List<String>> nameOfAlbumsDumb(Stream<Album> albums) {
        Map<Artist, List<Album>> albumsByArtist =
                albums.collect(groupingBy(album -> album.getMainMusician()));

        Map<Artist, List<String>> nameOfAlbums = new HashMap<>();
        for (Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
            nameOfAlbums.put(entry.getKey(), entry.getValue()
                    .stream()
                    .map(Album::getName)
                    .collect(toList()));
        }
        return nameOfAlbums;
    }
    // END NAME_OF_ALBUMS_DUMB

    /**
     * 例 5-16 使用收集器求每个艺术家的专辑名
     *
     * @param albums
     * @return
     */
    // BEGIN NAME_OF_ALBUMS
    public Map<Artist, List<String>> nameOfAlbums(Stream<Album> albums) {
        return albums.collect(groupingBy(Album::getMainMusician,
                mapping(Album::getName, toList())));
    }
    // END NAME_OF_ALBUMS

    public static Map<String, Long> countWords(Stream<String> words) {
        return words.collect(groupingBy(word -> word, counting()));
    }

    private static final Pattern SPACES = Pattern.compile("\\w+");

    public static Map<String, Long> countWordsIn(Path path) throws IOException {
        Stream<String> words = Files.readAllLines(path, defaultCharset())
                .stream()
                .flatMap(line -> SPACES.splitAsStream(line));

        return countWords(words);
    }

    /**
     * 例 5-7 找出一组专辑上曲目的平均数
     *
     * @param albums
     * @return
     */
    // BEGIN averagingTracks
    public double averageNumberOfTracks(List<Album> albums) {
        return albums.stream()
                .collect(averagingInt(album -> album.getTrackList().size()));
    }
    // END averagingTracks

}

