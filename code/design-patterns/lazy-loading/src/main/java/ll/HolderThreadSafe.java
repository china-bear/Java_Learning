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

package ll;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Same as HolderNaive but with added synchronization. This implementation is thread safe, but each
 * {@link #getHeavy()} call costs additional synchronization overhead.
 */
public class HolderThreadSafe {

  public static final Logger LOGGER = getLogger(Java8Holder.class);

  private Heavy heavy;

  /**
   * Constructor.
   */
  public HolderThreadSafe() {
    LOGGER.info("HolderThreadSafe created");
  }

  /**
   * Get heavy object.
   */
  public synchronized Heavy getHeavy() {
    if (heavy == null) {
      heavy = new Heavy();
    }
    return heavy;
  }
}
