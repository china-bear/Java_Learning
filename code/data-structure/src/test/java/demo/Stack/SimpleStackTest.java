/**
 * Data-Structures-In-Java
 * SimpleStackTest.java
 */
package demo.Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for simple stack
 * 
 * @author Deepak
 */
public class SimpleStackTest {

	/**
	 * Test case for push feature
	 */
	@Test
	public void testPush() {
		SimpleStackFromList stack = new SimpleStackFromList();
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
		SimpleStackFromList stack = new SimpleStackFromList();
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
		SimpleStackFromList stack = new SimpleStackFromList();
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
