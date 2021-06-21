package java8_features.book_learning.chapter4;

// BEGIN body
public class OverridingParent extends ParentImpl {

    @Override
    public void welcome() {
        message("Class Parent: Hi!");
    }

}
// END body
