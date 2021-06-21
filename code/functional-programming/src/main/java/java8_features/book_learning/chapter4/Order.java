package java8_features.book_learning.chapter4;


import java8_features.book_learning.chapter1.Album;
import java8_features.book_learning.chapter1.Artist;


import java.util.List;

public abstract class Order {

    protected final List<Album> albums;

    public Order(List<Album> albums) {
        this.albums = albums;
    }

    public abstract long countRunningTime();

    public abstract long countMusicians();

    public abstract long countTracks();

}
