package java8_features.book_learning.chapter5;

import java8_features.book_learning.chapter1.Album;
import java8_features.book_learning.chapter1.Artist;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 5.4 一些细节
 */
public class Niceties {

    abstract class ArtistService {

        protected Map<String, Artist> artistCache = new HashMap<>();

        public abstract Artist getArtist(String name);

        protected Artist readArtistFromDB(String name) {
            return new Artist(name, "UK");
        }
    }

    /**
     * 例 5-31 使用显示判断空值的方式缓存
     */
    class OldArtistService extends ArtistService {
        // BEGIN ARTIST_CACHE_OLD
        public Artist getArtist(String name) {
            Artist artist = artistCache.get(name);
            if (artist == null) {
                artist = readArtistFromDB(name);
                artistCache.put(name, artist);
            }
            return artist;
        }
        // END ARTIST_CACHE_OLD
    }

    /**
     * 例 5-32 使用 computeIfAbsent 缓存
     */
    class Java8ArtistService extends ArtistService {
        // BEGIN ARTIST_CACHE_COMPUTE
        public Artist getArtist(String name) {
            return artistCache.computeIfAbsent(name, this::readArtistFromDB);
        }
        // END ARTIST_CACHE_COMPUTE
    }


    /**
     * 例 5-33 一种丑陋的迭代 Map 的方式
     */
    class ImperativeCount {

        public Map<Artist, Integer> countAlbums(Map<Artist, List<Album>> albumsByArtist) {
            // BEGIN COUNT_ALBUMS_VALUES_UGLY
            Map<Artist, Integer> countOfAlbums = new HashMap<>();
            for (Map.Entry<Artist, List<Album>> entry : albumsByArtist.entrySet()) {
                Artist artist = entry.getKey();
                List<Album> albums = entry.getValue();
                countOfAlbums.put(artist, albums.size());
            }
            // END COUNT_ALBUMS_VALUES_UGLY
            return countOfAlbums;
        }
    }

    /**
     * 例 5-34 使用内部迭代遍历 Map 里的值
     */
    class Java8Count {
        public Map<Artist, Integer> countAlbums(Map<Artist, List<Album>> albumsByArtist) {
            // BEGIN COUNT_ALBUMS_VALUES_FOREACH
            Map<Artist, Integer> countOfAlbums = new HashMap<>();
            albumsByArtist.forEach((artist, albums) -> {
                countOfAlbums.put(artist, albums.size());
            });
            // END COUNT_ALBUMS_VALUES_FOREACH
            return countOfAlbums;
        }
    }


}
