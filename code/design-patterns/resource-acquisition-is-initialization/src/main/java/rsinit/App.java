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

package rsinit;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Resource Acquisition Is Initialization pattern was developed for exception safe resource
 * management by C++ creator Bjarne Stroustrup.
 *
 * <p>In RAII resource is tied to object lifetime: resource allocation is done during object
 * creation while resource deallocation is done during object destruction.
 *
 * <p>In Java RAII is achieved with try-with-resources statement and interfaces {@link
 * java.io.Closeable} and {@link AutoCloseable}. The try-with-resources statement ensures that each
 * resource is closed at the end of the statement. Any object that implements {@link
 * AutoCloseable}, which includes all objects which implement {@link java.io.Closeable},
 * can be used as a resource.
 *
 * <p>In this example, {@link SlidingDoor} implements {@link AutoCloseable} and {@link
 * TreasureChest} implements {@link java.io.Closeable}. Running the example, we can observe that
 * both resources are automatically closed.
 *
 * <p>http://docs.oracle.com/javase/7/docs/technotes/guides/language/try-with-resources.html
 */

public class App {
  public static final Logger LOGGER = getLogger(App.class);
  /**
   * Program entry point.
   */
  public static void main(String[] args) throws Exception {

    /**
     *  try-with-resources是一种语法糖, 是在JVM虚拟机层面新加指令进行的支持
     * {try}-with-resources关键点
     * 1. 由带资源的try语句管理的资源必须是实现了AutoCloseable接口的类的对象
     * 2. 在try代码中声明的资源被隐式声明为final
     * 3. 通过使用分号分隔每个声明可以管理多个资源
     */

    try (SlidingDoor ignored = new SlidingDoor()) {
      LOGGER.info("Walking in.");
    }

    try (TreasureChest ignored = new TreasureChest()) {
      LOGGER.info("Looting contents.");
    }
  }
}
