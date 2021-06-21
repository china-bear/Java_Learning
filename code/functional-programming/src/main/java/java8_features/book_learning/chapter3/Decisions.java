package java8_features.book_learning.chapter3;

import java8_features.book_learning.chapter1.Album;
import java8_features.book_learning.chapter1.Artist;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class Decisions {

    public static class Imperative {
        // BEGIN origins_of_bands_meth_imp
        public Set<String> originsOfBands(Album album) {
            Set<String> nationalities = new HashSet<>();
            for (Artist artist : album.getMusicianList()) {
                if (artist.getName().startsWith("The")) {
                    String nationality = artist.getNationality();
                    nationalities.add(nationality);
                }
            }
            return nationalities;
        }
        // END origins_of_bands_meth_imp
    }

    /**
     * 例 3-25 符合 Stream 的例子
     *
     * @param album
     * @return
     */
    public Set<String> originsOfBands(Album album) {
        // BEGIN origins_of_bands
        Set<String> origins = album.getMusicians()
                .filter(artist -> artist.getName().startsWith("The"))
                .map(artist -> artist.getNationality())
                .collect(toSet());
        // END origins_of_bands
        return origins;
    }

    /**
     * 例 3-24 误用 Stream 的例子
     *
     * @param album
     * @return
     */
    public Set<String> originsOfBandsMisuse(Album album) {
        // BEGIN misuse
        List<Artist> musicians = album.getMusicians()
                .collect(toList());

        List<Artist> bands = musicians.stream()
                .filter(artist -> artist.getName().startsWith("The"))
                .collect(toList());

        Set<String> origins = bands.stream()
                .map(artist -> artist.getNationality())
                .collect(toSet());
        // END misuse
        return origins;
    }

}
