/**
 * Data-Structures-In-Java
 * StackBasedQueueTest.java
 */
package linear_data_structure.Queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for stack based queue
 * 
 * @author Deepak
 */
public class StackBasedQueueTest {

	/**
	 * Test case for enqueue feature
	 */
	@Test
	public void testEnqueue() {
		StackBasedQueue<Integer> queue = new StackBasedQueue<>();
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
		StackBasedQueue<Integer> queue = new StackBasedQueue<>();
		assertTrue(queue.isEmpty());
		assertTrue(queue.size() == 0);
		queue.enqueue(3);
		queue.enqueue(17);
		queue.enqueue(35);
		queue.enqueue(13);
		assertTrue(queue.size() == 4);
		assertTrue(queue.dequeue() == 3);
		assertTrue(queue.dequeue() == 17);
		assertTrue(queue.dequeue() == 35);
		assertTrue(queue.size() == 1);
	}

	/**
	 * Test case for peek feature
	 */
	@Test
	public void testPeek() {
		StackBasedQueue<Integer> queue = new StackBasedQueue<>();
		assertTrue(queue.isEmpty());
		assertTrue(queue.size() == 0);
		queue.enqueue(3);
		queue.enqueue(17);
		queue.enqueue(35);
		queue.enqueue(13);
		assertTrue(queue.size() == 4);
		assertTrue(queue.peek() == 3);
		assertTrue(queue.size() == 4);
		queue.dequeue();
		assertTrue(queue.size() == 3);
		assertTrue(queue.peek() == 17);
	}

}
