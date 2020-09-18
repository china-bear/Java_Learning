/**
 * Data-Structures-In-Java
 * DoublyLinkedListTest.java
 */
package demo.List.doubleLinked;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test cases for Doubly linked list
 * 
 * @author Deepak
 */
public class DoublyLinkedListTest {

	/**
	 * Test case to check insertion at head of linked list
	 */
	@Test
	public void testInsertionAtHead() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		assertTrue(doublyList.isEmpty());
		assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		assertFalse(doublyList.isEmpty());
		assertTrue(doublyList.size() == 1);
		assertEquals(doublyList.searchByIndex(0).item, "Tom");
		doublyList.insertAtHead("Alex");
		assertTrue(doublyList.size() == 2);
		assertEquals(doublyList.searchByIndex(0).item, "Alex");
	}

	/**
	 * Test case to check insertion at tail of linked list
	 */
	@Test
	public void testInsertionAtTail() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		assertTrue(doublyList.isEmpty());
		assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		assertFalse(doublyList.isEmpty());
		assertTrue(doublyList.size() == 1);
		assertEquals(doublyList.searchByIndex(0).item, "Tom");
		doublyList.insertAtTail("Alex");
		assertTrue(doublyList.size() == 2);
		assertEquals(doublyList.searchByIndex(0).item, "Tom");
		assertEquals(doublyList.searchByIndex(1).item, "Alex"); 
	}

	/**
	 * Test case to check insertion at a given position of linked list
	 */
	@Test
	public void testInsertionAtPosition() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		assertTrue(doublyList.isEmpty());
		assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		doublyList.insertAtHead("Alex");
		doublyList.insertAtHead("Maria");
		assertFalse(doublyList.isEmpty());
		assertTrue(doublyList.size() == 3);
		assertEquals(doublyList.searchByIndex(0).item, "Maria");
		assertEquals(doublyList.searchByValue("Maria").item, "Maria");
		doublyList.insertAtPosition("Steve", 2);
		assertTrue(doublyList.size() == 4);
		assertEquals(doublyList.searchByIndex(1).item, "Alex");
		assertEquals(doublyList.searchByIndex(2).item, "Tom");
		assertEquals(doublyList.searchByIndex(3).item, "Steve");
	}

	/**
	 * Test case to check deletion from head
	 */
	@Test
	public void testDeleteFromHead() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		assertTrue(doublyList.isEmpty());
		assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		doublyList.insertAtHead("Alex");
		doublyList.insertAtHead("Maria");
		assertFalse(doublyList.isEmpty());
		assertTrue(doublyList.size() == 3);
		assertEquals(doublyList.searchByIndex(0).item, "Maria");
		doublyList.deleteFromHead();
		assertTrue(doublyList.size() == 2);
		assertEquals(doublyList.searchByIndex(0).item, "Alex");
	}

	/**
	 * Test case to check deletion from tail
	 */
	@Test
	public void testDeleteFromTail() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		assertTrue(doublyList.isEmpty());
		assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		doublyList.insertAtHead("Alex");
		doublyList.insertAtHead("Maria");
		assertFalse(doublyList.isEmpty());
		assertTrue(doublyList.size() == 3);
		assertEquals(doublyList.searchByIndex(2).item, "Tom");
		doublyList.deleteFromTail();
		assertTrue(doublyList.size() == 2);
		assertEquals(doublyList.searchByIndex(0).item, "Maria");
		assertEquals(doublyList.searchByIndex(1).item, "Alex");
	}

	/**
	 * Test case to check deletion from position
	 */
	@Test
	public void testDeleteFromPosition() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		assertTrue(doublyList.isEmpty());
		assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		doublyList.insertAtHead("Alex");
		doublyList.insertAtHead("Maria");
		assertFalse(doublyList.isEmpty());
		assertTrue(doublyList.size() == 3);
		assertEquals(doublyList.searchByIndex(2).item, "Tom");
		doublyList.deleteFromPosition(1);
		assertTrue(doublyList.size() == 2);
		assertEquals(doublyList.searchByIndex(1).item, "Tom");
	}

	/**
	 * Test case to convert a linked list to Array
	 */
	@Test
	public void testConvertToArray() {
		DoublyLinkedList<String> doublyList = new DoublyLinkedList<>();
		assertTrue(doublyList.isEmpty());
		assertTrue(doublyList.size() == 0);
		doublyList.insertAtHead("Tom");
		doublyList.insertAtHead("Alex");
		doublyList.insertAtHead("Maria");
		assertTrue(doublyList.size() == 3);
		Object[] array = doublyList.toArray();
		assertTrue(array.length == 3);
		assertEquals(array[0], "Maria");
		assertEquals(array[1], "Alex");
		assertEquals(array[2], "Tom");
	}

}
