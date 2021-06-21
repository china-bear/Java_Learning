package java8_features.book_learning.chapter4;

// BEGIN body
public interface Parent {

    void message(String body);

    default void welcome() {
        message("Parent: Hi!");
    }

    String getLastMessage();

}
// END body
