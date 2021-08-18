package ImageReader;

/**
 * Created by bear on 2020/9/17
 */
public class GifReaderFactory implements ReaderFactory {

    @Override
    public Reader getReader() {
        return new GifReader();
    }
}
