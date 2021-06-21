package java8_features.book_learning.chapter4;

// BEGIN body
public interface Child extends Parent {

    @Override
    default void welcome() {
        message("Child: Hi!");
    }

}
// END body
