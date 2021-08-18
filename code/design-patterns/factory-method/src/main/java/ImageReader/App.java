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

package ImageReader;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 工厂方法模式
 *   定义： https://juejin.im/entry/6844903474639929357
 *      定义一个用于创建对象的接口，让子类决定将哪一个类实例化。工厂方法模式让一个类的实例化延迟到其子类。
 *      简单工厂只有一个统一的工厂类，而工厂方法是针对每个要创建的对象都会提供一个工厂类，这些工厂类都实现了一个工厂基类
 *
 *   适用场景：
 * 　　（1）客户端不需要知道它所创建的对象的类。例子中我们不知道每个图片加载器具体叫什么名，只知道创建它的工厂名就完成了床架过程。
 * 　　（2）客户端可以通过子类来指定创建对应的对象。
 * 以上场景使用于采用工厂方法模式。
 */


public class App {

  /**
   * Program entry point.
   *
   * @param args command line args
   */
  public static final Logger LOGGER = getLogger(App.class);

  public static void main(String[] args) {
    // 读取Jpg
    ReaderFactory factory1 = new JpgReaderFactory();
    Reader reader1 = factory1.getReader();
    reader1.read();

    // 读取Png
    ReaderFactory factory2 = new PngReaderFactory();
    Reader reader2 = factory2.getReader();
    reader2.read();

    // 读取Gif
    ReaderFactory factory3 = new GifReaderFactory();
    Reader reader3 = factory3.getReader();
    reader3.read();

  }
}
