/**
 * Data-Structures-In-Java
 * LinkedListBasedStackTest.java
 */
package linear_data_structure.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for Linked list based stack
 * 
 * @author Deepak
 */
public class LinkedListBasedStackTest {

	/**
	 * Test case for push feature
	 */
	@Test
	public void testPush() {
		LinkedListBasedStack stack = new LinkedListBasedStack();
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
		LinkedListBasedStack stack = new LinkedListBasedStack();
		assertTrue(stack.isEmpty());
		assertTrue(stack.size() == 0);
		stack.push(3);
		stack.push(17);
		stack.push(35);
		stack.push(13);
		assertTrue(stack.size() == 4);
		assertEquals(stack.pop(), 13);
		assertEquals(stack.pop(), 35);
		assertEquals(stack.pop(), 17);
		assertTrue(stack.size() == 1);
	}

	/**
	 * Test case for peek feature
	 */
	@Test
	public void testPeek() {
		LinkedListBasedStack stack = new LinkedListBasedStack();
		assertTrue(stack.isEmpty());
		assertTrue(stack.size() == 0);
		stack.push(3);
		stack.push(17);
		stack.push(35);
		stack.push(13);
		assertTrue(stack.size() == 4);
		assertEquals(stack.peek(), 13);
		assertTrue(stack.size() == 4);
		stack.pop();
		assertTrue(stack.size() == 3);
		assertEquals(stack.peek(), 35);
	}

}
