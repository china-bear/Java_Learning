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

package wizard;

import java.util.Deque;
import java.util.LinkedList;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Wizard is the invoker of the commands.
 */

public class Wizard {

  private static final Logger LOGGER = getLogger(Target.class);
  private final Deque<Runnable> undoStack = new LinkedList<>();
  private final Deque<Runnable> redoStack = new LinkedList<>();

  public Wizard() {
  }

  /**
   * Cast spell.
   */
  public void castSpell(Runnable runnable) {
    runnable.run();
    undoStack.offerLast(runnable);
  }

  /**
   * Undo last spell.
   */
  public void undoLastSpell() {
    if (!undoStack.isEmpty()) {
      Runnable previousSpell = undoStack.pollLast();
      redoStack.offerLast(previousSpell);
      previousSpell.run();
    }
  }

  /**
   * Redo last spell.
   */
  public void redoLastSpell() {
    if (!redoStack.isEmpty()) {
      Runnable previousSpell = redoStack.pollLast();
      undoStack.offerLast(previousSpell);
      previousSpell.run();
    }
  }

  @Override
  public String toString() {
    return "Wizard";
  }
}
