/*
 * The MIT License
 * Copyright © 2014-2021 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package doublebuffer;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.tuple.MutablePair;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Double buffering is a term used to describe a device that has two buffers. The usage of multiple
 * buffers increases the overall throughput of a device and helps prevents bottlenecks. This example
 * shows using double buffer pattern on graphics. It is used to show one image or frame while a
 * separate frame is being buffered to be shown next. This method makes animations and games look
 * more realistic than the same done in a single buffer mode.
 */

public class App {

  /**
   * Program main entry point.
   *
   * @param args runtime arguments
   */
  private static final Logger LOGGER = getLogger(App.class);

  public static void main(String[] args) {
    final Scene scene = new Scene();
    // 在Java 9之前,您需要使用Arrays.asList()而不是List.of(), ArrayList<String> friends =  new ArrayList<>(List.of("Peter", "Paul"));
    ArrayList drawPixels1 = new ArrayList<>(Arrays.asList(
        new MutablePair<>(1, 1),
        new MutablePair<>(5, 6),
        new MutablePair<>(3, 2)
    ));
    scene.draw(drawPixels1);
    Buffer buffer1 = scene.getBuffer();
    printBlackPixelCoordinate(buffer1);

    // 在Java 9之前,您需要使用Arrays.asList()而不是List.of(), ArrayList<String> friends =  new ArrayList<>(List.of("Peter", "Paul"));
    ArrayList drawPixels2 = new ArrayList<>(Arrays.asList(
        new MutablePair<>(3, 7),
        new MutablePair<>(6, 1)
    ));
    scene.draw(drawPixels2);
    Buffer buffer2 = scene.getBuffer();
    printBlackPixelCoordinate(buffer2);
  }

  private static void printBlackPixelCoordinate(Buffer buffer) {
    StringBuilder log = new StringBuilder("Black Pixels: ");
    Pixel[] pixels = buffer.getPixels();
    for (int i = 0; i < pixels.length; ++i) {
      if (pixels[i] == Pixel.BLACK) {
        int y = i / FrameBuffer.WIDTH;
        int x = i % FrameBuffer.WIDTH;
        log.append(" (").append(x).append(", ").append(y).append(")");
      }
    }
    LOGGER.info(log.toString());
  }
}
