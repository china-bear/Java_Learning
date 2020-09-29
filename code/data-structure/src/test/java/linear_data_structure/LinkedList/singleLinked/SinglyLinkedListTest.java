/**
 * Data-Structures-In-Java
 * SinglyLinkedListTest.java
 */
package linear_data_structure.LinkedList.singleLinked;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for Singly Linked List
 * 
 * @author Deepak
 */
public class SinglyLinkedListTest {

	/**
	 * Test case for insertion at head of linked list
	 */
	@Test
	public void testInsertionAtHead() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertAtHead(4);
		assertEquals("4", String.valueOf(list.searchByIndex(0).item));
		list.insertAtHead(5);
		assertEquals("5", String.valueOf(list.searchByIndex(0).item));
		list.insertAtHead(9);
		assertEquals("9", String.valueOf(list.searchByIndex(0).item));
		list.insertAtHead(13);
		assertEquals("13", String.valueOf(list.searchByIndex(0).item));
	}

	/**
	 * Test case for insertion at tail of linked list
	 */
	@Test
	public void testInsertionAtTail() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
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
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
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
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertTrue(list.size() == 0);
		list.insertAtHead(3);
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
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		assertTrue(list.isEmpty());
		list.insertAtHead(3);
		assertFalse(list.isEmpty());
	}

	/**
	 * Test case for searching a element by index
	 */
	@Test
	public void testSearchByIndex() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
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
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertAtHead(4);
		list.insertAtHead(7);
		list.insertAtHead(13);
		list.insertAtHead(19);
		list.insertAtHead(21);
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
	public void testDeleteFromHead() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertAtTail(4);
		list.insertAtTail(7);
		list.insertAtTail(13);
		list.insertAtTail(19);
		list.insertAtTail(21);
		assertEquals("4", String.valueOf(list.searchByIndex(0).item));
		list.deleteFromHead();
		assertEquals("7", String.valueOf(list.searchByIndex(0).item));
		list.deleteFromHead();
		assertEquals("13", String.valueOf(list.searchByIndex(0).item));
		assertTrue(list.size() == 3);
	}

	/**
	 * Test case to delete element from tail
	 */
	@Test
	public void testDeleteFromTail() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertAtTail(4);
		list.insertAtTail(7);
		list.insertAtTail(13);
		list.insertAtTail(19);
		list.insertAtTail(21);
		assertEquals("21", String.valueOf(list.searchByIndex(4).item));
		assertTrue(list.size() == 5);
		list.deleteFromTail();
		assertEquals("19", String.valueOf(list.searchByIndex(3).item));
		assertTrue(list.size() == 4);
	}

	/**
	 * Test case to delete element from middle
	 */
	@Test
	public void testDeleteFromMiddle() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
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

	/**
	 * Test case to convert the linked list to Array
	 */
	@Test
	public void testConvertToArray() {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.insertAtTail(4);
		list.insertAtTail(7);
		list.insertAtTail(13);
		list.insertAtTail(19);
		list.insertAtTail(21);
		Object[] array = list.toArray();
		assertTrue(list.size() == 5);
		assertTrue(array.length == 5);
		Integer[] integerArray = Arrays.copyOf(array, array.length, Integer[].class);
		assertTrue(integerArray[0] == 4);
		assertTrue(integerArray[1] == 7);
		assertTrue(integerArray[2] == 13);
		assertTrue(integerArray[3] == 19);
		assertTrue(integerArray[4] == 21);
	}

}
