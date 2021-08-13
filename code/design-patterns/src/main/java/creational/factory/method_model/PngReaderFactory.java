package creational.factory.method_model;

/**
 * Created by bear on 2020/9/17
 */
public class PngReaderFactory implements ReaderFactory {

    @Override
    public Reader getReader() {
        return new PngReader();
    }
}
