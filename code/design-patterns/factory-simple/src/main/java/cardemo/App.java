/*
 * The MIT License
 * Copyright © 2014-2019 Ilkka Seppälä
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

package cardemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory is an object for creating other objects, it providing Providing a static method to 
 * create and return objects of varying classes, in order to hide the implementation logic 
 * and makes client code focus on usage rather then objects initialization and management.
 * 
 * <p>In this example the CarFactory is the factory class and it provides a static method to 
 * create different cars.
 */

public class App {
  
  private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
  
  /**
   * Program main entry point.
   */
  public static void main(String[] args) {
    Car car1 = CarsFactory.getCar(CarType.FORD);
    Car car2 = CarsFactory.getCar(CarType.FERRARI);
    LOGGER.info(car1.getDescription());
    LOGGER.info(car2.getDescription());

    LOGGER.info("The alchemist begins his work.");
    Coin coin1 = CoinFactory.getCoin(CoinType.COPPER);
    Coin coin2 = CoinFactory.getCoin(CoinType.GOLD);
    LOGGER.info(coin1.getDescription());
    LOGGER.info(coin2.getDescription());
  }
}
