package java8_features.book_learning.chapter5.mutable_custom;

import java8_features.book_learning.chapter1.Album;
import java8_features.book_learning.chapter1.Artist;


public final class AlbumSale {

    private final Album album;
    private final Customer customer;
    private final long price;

    public AlbumSale(Album album, Customer customer, long price) {
        this.album = album;
        this.customer = customer;
        this.price = price;
    }

    public Album getAlbum() {
        return album;
    }

    public Customer getCustomer() {
        return customer;
    }

    public long getPrice() {
        return price;
    }
}
