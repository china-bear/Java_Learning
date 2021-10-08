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
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;
import java.time.Month;

import databus.AbstractDataType;
import databus.DataBus;
import databus.Member;
import databus.data.MessageData;
import databus.data.StartingData;
import databus.data.StoppingData;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link StatusMember}.
 *
 * @author Paul Campbell (pcampbell@kemitix.net)
 */
class StatusMemberTest {

  @Test
  void statusRecordsTheStartTime() {
    //given
    final LocalDateTime startTime = LocalDateTime.of(2017, Month.APRIL, 1, 19, 9);
    final StartingData startingData = new StartingData(startTime);
    final StatusMember statusMember = new StatusMember(1);
    //when
    statusMember.accept(startingData);
    //then
    assertEquals(startTime, statusMember.getStarted());
  }

  @Test
  void statusRecordsTheStopTime() {
    //given
    final LocalDateTime stop = LocalDateTime.of(2017, Month.APRIL, 1, 19, 12);
    final AbstractDataType stoppingData = new StoppingData(stop);
    stoppingData.setDataBus(DataBus.getInstance());
    final StatusMember statusMember = new StatusMember(1);
    //when
    statusMember.accept(stoppingData);
    //then
    assertEquals(stop, statusMember.getStopped());
  }

  @Test
  void statusIgnoresMessageData() {
    //given
    final AbstractDataType messageData = new MessageData("message");
    final StatusMember statusMember = new StatusMember(1);
    //when
    statusMember.accept(messageData);
    //then
    assertNull(statusMember.getStarted());
    assertNull(statusMember.getStopped());
  }

}
