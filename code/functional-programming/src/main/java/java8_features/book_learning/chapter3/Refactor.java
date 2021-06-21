package java8_features.book_learning.chapter3;

import java8_features.book_learning.chapter1.Album;
import java8_features.book_learning.chapter1.Track;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

/**
 * 3.4 重构遗留代码
 */
public class Refactor {

    public interface LongTrackFinder {
        Set<String> findLongTracks(List<Album> albums);
    }

    /**
     * 例 3-19 遗留代码：找出长度大于 1 分钟的曲目
     */
    public static class Step0 implements LongTrackFinder {
        // BEGIN findLongTracks_0
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            for (Album album : albums) {
                for (Track track : album.getTrackList()) {
                    if (track.getLength() > 60) {
                        String name = track.getName();
                        trackNames.add(name);
                    }
                }
            }
            return trackNames;
        }
        // END findLongTracks_0
    }

    /**
     * 例 3-20 重构的第一步：找出长度大于 1 分钟的曲目
     */
    public static class Step1 implements LongTrackFinder {
        // BEGIN findLongTracks_1
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream()
                    .forEach(album -> {
                        album.getTracks()
                                .forEach(track -> {
                                    if (track.getLength() > 60) {
                                        String name = track.getName();
                                        trackNames.add(name);
                                    }
                                });
                    });
            return trackNames;
        }
        // END findLongTracks_1
    }

    /**
     * 例 3-21 重构的第二步：找出长度大于 1 分钟的曲目
     */
    public static class Step2 implements LongTrackFinder {
        // BEGIN findLongTracks_2
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();
            albums.stream()
                    .forEach(album -> {
                        album.getTracks()
                                .filter(track -> track.getLength() > 60)
                                .map(track -> track.getName())
                                .forEach(name -> trackNames.add(name));
                    });
            return trackNames;
        }
        // END findLongTracks_2
    }

    /**
     * 例 3-22 重构的第三步：找出长度大于 1 分钟的曲目
     */
    public static class Step3 implements LongTrackFinder {
        // BEGIN findLongTracks_3
        public Set<String> findLongTracks(List<Album> albums) {
            Set<String> trackNames = new HashSet<>();

            albums.stream()
                    .flatMap(album -> album.getTracks())
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .forEach(name -> trackNames.add(name));

            return trackNames;
        }
        // END findLongTracks_3
    }

    /**
     * 例 3-23 重构的第四步：找出长度大于 1 分钟的曲目
     */
    public static class Step4 implements LongTrackFinder {
        // BEGIN findLongTracks_4
        public Set<String> findLongTracks(List<Album> albums) {
            return albums.stream()
                    .flatMap(album -> album.getTracks())
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .collect(toSet());
        }
        // END findLongTracks_4
    }

}
