/**
 * Data-Structures-In-Java
 * QueueBasedStackTest.java
 */
package demo.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for queue based stack
 * 
 * @author Deepak
 */
public class QueueBasedStackTest {

	/**
	 * Test case for push feature
	 */
	@Test
	public void testPush() {
		QueueBasedStack<Integer> stack = new QueueBasedStack<>();
		assertTrue(stack.isEmpty());
		assertTrue(stack.size() == 0);
		stack.push(3);
		assertFalse(stack.isEmpty());
		assertTrue(stack.size() == 1);
		stack.push(7);
		stack.push(31);
		assertTrue(stack.size() == 3);
	}

	/**
	 * Test case for pop feature
	 */
	@Test
	public void testPop() {
		QueueBasedStack<Integer> stack = new QueueBasedStack<>();
		assertTrue(stack.isEmpty());
		assertTrue(stack.size() == 0);
		stack.push(3);
		stack.push(17);
		stack.push(35);
		stack.push(13);
		assertTrue(stack.size() == 4);
		assertTrue(stack.pop() == 13);
		assertTrue(stack.pop() == 35);
		assertTrue(stack.pop() == 17);
		assertTrue(stack.size() == 1);
	}

	/**
	 * Test case for peek feature
	 */
	@Test
	public void testPeek() {
		QueueBasedStack<Integer> stack = new QueueBasedStack<>();
		assertTrue(stack.isEmpty());
		assertTrue(stack.size() == 0);
		stack.push(3);
		stack.push(17);
		stack.push(35);
		stack.push(13);
		assertTrue(stack.size() == 4);
		assertTrue(stack.peek() == 13);
		assertTrue(stack.size() == 4);
		stack.pop();
		assertTrue(stack.size() == 3);
		assertTrue(stack.peek() == 35);
	}

}
