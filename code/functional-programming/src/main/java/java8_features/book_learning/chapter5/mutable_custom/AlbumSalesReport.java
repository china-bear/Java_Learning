package java8_features.book_learning.chapter5.mutable_custom;

public class AlbumSalesReport {

    public AlbumSalesReport() {

    }

    public AlbumSalesReport(AlbumSale album) {
        this();
        acknowledgeSale(album);
    }

    public void acknowledgeSale(AlbumSale album) {

    }

    public AlbumSalesReport merge(AlbumSalesReport right) {
        return null;
    }

}
