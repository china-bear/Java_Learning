package java8_features.book_learning.chapter8.strategy;

import java.io.IOException;
import java.io.OutputStream;

// BEGIN CompressionStrategy
public interface CompressionStrategy {

    public OutputStream compress(OutputStream data) throws IOException;

}
// END CompressionStrategy
