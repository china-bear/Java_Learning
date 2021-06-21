package java8_features.book_learning.chapter4;

// BEGIN body
public interface Carriage {

    default String rock() {
        return "... from side to side";
    }

}
// END body
