package creational.factory.method;

/**
 * Created by bear on 2020/9/17
 */
public class JpgReaderFactory implements ReaderFactory {

    @Override
    public Reader getReader() {
        return new JpgReader();
    }
}
