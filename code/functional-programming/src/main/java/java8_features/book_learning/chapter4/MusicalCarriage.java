package java8_features.book_learning.chapter4;

// BEGIN body
public class MusicalCarriage
        implements Carriage, Jukebox {

    @Override
    public String rock() {
        return Carriage.super.rock();
    }

}
// END body
