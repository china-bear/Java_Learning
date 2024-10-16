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

package bq_way;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Class responsible for consume the {@link Item} produced by {@link Producer}.
 */
public class Consumer {

  public static final Logger LOGGER = getLogger(Consumer.class);

  private final ItemQueue queue;

  private final String name;

  public Consumer(String name, ItemQueue queue) {
    this.name = name;
    this.queue = queue;
  }

  /**
   * Consume item from the queue.
   */
  public void consume() throws InterruptedException {
    Item item = queue.take();
    LOGGER.info("Consumer [{}] consume item [{}] produced by [{}]", name,
        item.getId(), item.getProducer());

  }
}
