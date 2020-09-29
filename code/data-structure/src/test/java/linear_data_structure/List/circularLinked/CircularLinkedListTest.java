/**
 * Data-Structures-In-Java
 * CircularLinkedListTest.java
 */
package linear_data_structure.List.circularLinked;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for circular linked list
 * 
 * @author Deepak
 */
public class CircularLinkedListTest {

	/**
	 * Test case for insertion at head of linked list
	 */
	@Test
	public void testInsertionAtHead() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtBeginning(4);
		assertEquals("4", String.valueOf(list.searchByIndex(0).item));
		list.insertAtBeginning(5);
		assertEquals("5", String.valueOf(list.searchByIndex(0).item));
		list.insertAtBeginning(9);
		assertEquals("9", String.valueOf(list.searchByIndex(0).item));
		list.insertAtBeginning(13);
		assertEquals("13", String.valueOf(list.searchByIndex(0).item));
	}

	/**
	 * Test case for insertion at tail of linked list
	 */
	@Test
	public void testInsertionAtTail() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtTail(4);
		assertEquals("4", String.valueOf(list.searchByIndex(0).item));
		list.insertAtTail(5);
		assertEquals("5", String.valueOf(list.searchByIndex(1).item));
		list.insertAtTail(9);
		assertEquals("9", String.valueOf(list.searchByIndex(2).item));
		list.insertAtTail(13);
		assertEquals("13", String.valueOf(list.searchByIndex(3).item));
	}

	/**
	 * Test case for insertion at middle of linked list
	 */
	@Test
	public void testInsertionAtMiddle() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtTail(4);
		assertEquals("4", String.valueOf(list.searchByIndex(0).item));
		list.insertAtTail(5);
		assertEquals("5", String.valueOf(list.searchByIndex(1).item));
		list.insertAtTail(9);
		assertEquals("9", String.valueOf(list.searchByIndex(2).item));
		list.insertAtPosition(13, 1);
		assertEquals("13", String.valueOf(list.searchByIndex(1).item));
		assertEquals("5", String.valueOf(list.searchByIndex(2).item));
		assertEquals("9", String.valueOf(list.searchByIndex(3).item));
	}

	/**
	 * Test case for checking the size of linked list
	 */
	@Test
	public void testSize() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		assertTrue(list.size() == 0);
		list.insertAtBeginning(3);
		assertTrue(list.size() != 0);
		assertTrue(list.size() == 1);
		list.insertAtTail(4);
		assertTrue(list.size() != 0);
		assertTrue(list.size() == 2);
	}

	/**
	 * Test case for checking if liked list is empty
	 */
	@Test
	public void testIsEmpty() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		assertTrue(list.isEmpty());
		list.insertAtBeginning(3);
		assertFalse(list.isEmpty());
	}

	/**
	 * Test case for searching a element by index
	 */
	@Test
	public void testSearchByIndex() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtTail(4);
		list.insertAtTail(7);
		list.insertAtTail(13);
		list.insertAtTail(19);
		list.insertAtTail(21);
		assertEquals("4", String.valueOf(list.searchByIndex(0).item));
		assertEquals("7", String.valueOf(list.searchByIndex(1).item));
		assertEquals("13", String.valueOf(list.searchByIndex(2).item));
		assertEquals("19", String.valueOf(list.searchByIndex(3).item));
		assertEquals("21", String.valueOf(list.searchByIndex(4).item));
	}

	/**
	 * Test case for searching a element by value
	 */
	@Test
	public void testSearchByValue() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtBeginning(4);
		list.insertAtBeginning(7);
		list.insertAtBeginning(13);
		list.insertAtBeginning(19);
		list.insertAtBeginning(21);
		assertEquals("4", String.valueOf(list.searchByValue(4).item));
		assertEquals("7", String.valueOf(list.searchByValue(7).item));
		assertEquals("13", String.valueOf(list.searchByValue(13).item));
		assertEquals("19", String.valueOf(list.searchByValue(19).item));
		assertEquals("21", String.valueOf(list.searchByValue(21).item));
	}

	/**
	 * Test case to delete element from head
	 */
	@Test
	@Ignore
	public void testDeleteFromHead() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtBeginning(4);
		list.insertAtBeginning(7);
		list.insertAtBeginning(13);
		list.insertAtBeginning(19);
		list.insertAtBeginning(21);
		assertEquals("21", String.valueOf(list.searchByIndex(0).item));
		list.deleteFromBeginning();
		assertEquals("7", String.valueOf(list.searchByIndex(0).item));
		list.deleteFromBeginning();
		assertEquals("13", String.valueOf(list.searchByIndex(0).item));
		assertTrue(list.size() == 3);
	}

	/**
	 * Test case to delete element from tail
	 */
	public void testDeleteFromTail() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtTail(4);
		list.insertAtTail(7);
		list.insertAtTail(13);
		list.insertAtTail(19);
		list.insertAtTail(21);
		assertEquals("21", String.valueOf(list.searchByIndex(4).item));
		assertTrue(list.size() == 5);
		list.deleteFromBeginning();
		assertEquals("21", String.valueOf(list.searchByIndex(3).item));
		assertTrue(list.size() == 4);
	}

	/**
	 * Test case to delete element from middle
	 */
	public void testDeleteFromMiddle() {
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.insertAtTail(4);
		list.insertAtTail(7);
		list.insertAtTail(13);
		list.insertAtTail(19);
		list.insertAtTail(21);
		assertEquals("13", String.valueOf(list.searchByIndex(2).item));
		list.deleteFromPosition(2);
		assertEquals("19", String.valueOf(list.searchByIndex(2).item));
		list.deleteFromPosition(2);
		assertEquals("21", String.valueOf(list.searchByIndex(2).item));
	}

}
