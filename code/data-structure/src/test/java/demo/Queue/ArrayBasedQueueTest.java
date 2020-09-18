/**
 * Data-Structures-In-Java
 * ArrayBasedQueueTest.java
 */
package demo.Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for array based queue
 * 
 * @author Deepak
 */
public class ArrayBasedQueueTest {

	/**
	 * Test case for enqueue feature
	 */
	@Test
	public void testEnqueue() {
		ArrayBasedQueue queue = new ArrayBasedQueue(10);
		assertTrue(queue.isEmpty());
		assertTrue(queue.size() == 0);
		queue.enqueue(3);
		assertFalse(queue.isEmpty());
		assertTrue(queue.size() == 1);
		queue.enqueue(7);
		queue.enqueue(31);
		assertTrue(queue.size() == 3);
	}

	/**
	 * Test case for dequeue feature
	 */
	@Test
	public void testDequeue() {
		ArrayBasedQueue queue = new ArrayBasedQueue(10);
		assertTrue(queue.isEmpty());
		assertTrue(queue.size() == 0);
		queue.enqueue(3);
		queue.enqueue(17);
		queue.enqueue(35);
		queue.enqueue(13);
		assertTrue(queue.size() == 4);
		assertEquals(queue.dequeue(), 3);
		assertEquals(queue.dequeue(), 17);
		assertEquals(queue.dequeue(), 35);
		assertTrue(queue.size() == 1);
	}

	/**
	 * Test case for peek feature
	 */
	@Test
	public void testPeek() {
		ArrayBasedQueue queue = new ArrayBasedQueue(10);
		assertTrue(queue.isEmpty());
		assertTrue(queue.size() == 0);
		queue.enqueue(3);
		queue.enqueue(17);
		queue.enqueue(35);
		queue.enqueue(13);
		assertTrue(queue.size() == 4);
		assertEquals(queue.peek(), 3);
		assertTrue(queue.size() == 4);
		queue.dequeue();
		assertTrue(queue.size() == 3);
		assertEquals(queue.peek(), 17);
	}

}
