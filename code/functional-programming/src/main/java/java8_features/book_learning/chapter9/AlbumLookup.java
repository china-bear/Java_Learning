package java8_features.book_learning.chapter9;

import java8_features.book_learning.chapter1.Album;
import java8_features.book_learning.chapter1.Artist;

public interface AlbumLookup {
    Album lookupByName(String albumName);
}
