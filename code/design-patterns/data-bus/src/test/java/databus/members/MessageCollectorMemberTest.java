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

package databus.members;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import databus.AbstractDataType;
import databus.Member;
import databus.data.MessageData;
import databus.data.StartingData;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link MessageCollectorMember}.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
class MessageCollectorMemberTest {

  @Test
  void collectMessageFromMessageData() {
    //given
    final String message = "message";
    final AbstractDataType messageData = new MessageData(message);
    final MessageCollectorMember collector = new MessageCollectorMember("collector");
    //when
    collector.accept(messageData);
    //then
    assertTrue(collector.getMessages().contains(message));
  }

  @Test
  void collectIgnoresMessageFromOtherDataTypes() {
    //given
    final AbstractDataType startingData = new StartingData(LocalDateTime.now());
    final MessageCollectorMember collector = new MessageCollectorMember("collector");
    //when
    collector.accept(startingData);
    //then
    assertEquals(0, collector.getMessages().size());
  }

}
