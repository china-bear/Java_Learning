package java8_features.book_learning.chapter4;

public class ParentImpl implements Parent {

    private String body;

    @Override
    public void message(String body) {
        this.body = body;
    }

    @Override
    public String getLastMessage() {
        return body;
    }

}
