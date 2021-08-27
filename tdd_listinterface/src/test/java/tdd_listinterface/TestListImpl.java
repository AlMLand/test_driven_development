package tdd_listinterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class TestListImpl {

	// size()
	@Test
	public void shouldReturn0IfNoObjectsAdded() {
		List<Object> list = new ListImpl<>();
		assertEquals(0, list.size());
	}

	@Test
	public void shouldReturn2IfTwoObjectsAreAdded() {
		List<Object> list = new ListImpl<>();
		list.add(null);
		list.add(null);
		assertEquals(2, list.size());
	}

	// isEmpty
	@Test
	public void shouldRerurnTrueIfListIsEmpty() {
		List<Object> list = new ListImpl<>();
		assertTrue(list.isEmpty());
	}

	@Test
	public void shouldReturnFalseIfListIsNotEmpty() {
		List<Object> list = new ListImpl<>();
		list.add(null);
		assertFalse(list.isEmpty());
	}

	// contains()
	@Test
	public void shouldReturnTrueIfObjectContainsInList() {
		List<Integer> list = new ListImpl<>();
		final int expected = 1;
		list.add(expected);
		assertTrue(list.contains(expected));
	}

	@Test
	public void shouldReturnFalseIfObjectNotContainsInList() {
		List<Integer> list = new ListImpl<>();
		final int addedInteger = 1;
		final int expectedInteger = 2;
		list.add(addedInteger);
		assertFalse(list.contains(expectedInteger));
	}

	@Test
	public void shouldReturnFalseIfListIsEmpty() {
		List<Object> list = new ListImpl<>();
		final int expected = 1;
		assertFalse(list.contains(expected));
	}

	// iterator()
	@Test
	public void shouldReturnTrueIfIteratorisNotNull() {
		List<Object> list = new ListImpl<>();
		Iterator<Object> iterator = list.iterator();
		assertNotNull(iterator);
	}

	// toArray()
	@Test
	public void shouldShouldReturnObjectArrayWithSameLenght() {
		List<Integer> listIntegers = new ListImpl<>();
		listIntegers.add(1);
		Object[] returnedObjectArray = listIntegers.toArray();
		assertEquals(1, returnedObjectArray.length);
	}

	@Test
	public void shouldShouldReturnObjectArrayWithSameElement() {
		List<Integer> listIntegers = new ListImpl<>();
		listIntegers.add(1);
		listIntegers.add(2);
		Object[] returnedObjectArray = listIntegers.toArray();
		assertEquals(1, returnedObjectArray[0]);
		assertEquals(2, returnedObjectArray[1]);
	}

	// toArray(T[] t)
	@Test
	public void shouldReturnArrayWithElementIndex2NullAndElementIndex3NullWhenInputArrayLenghtIs4() {
		List<Integer> list = new ListImpl<>();
		list.add(1);
		list.add(2);
		Integer[] integers = new Integer[4];
		Object[] returnedArray = list.toArray(integers);
		assertNull(returnedArray[2]);
		assertNull(returnedArray[3]);
	}

	@Test
	public void shouldReturnArrayWithLenght2WhenInputArrayLenghtis1() {
		List<Integer> list = new ListImpl<>();
		list.add(1);
		list.add(2);
		Integer[] integers = new Integer[1];
		Object[] returnedArray = list.toArray(integers);
		assertEquals(2, returnedArray.length);
	}

	@Test
	public void shouldReturnArrayWithSameValuesWhenArrayLenghtIsSame() {
		List<String> list = new ListImpl<>();
		list.add("a");
		list.add("b");
		Object[] objects = new Object[2];
		Object[] returnedArray = list.toArray(objects);
		assertEquals("a", returnedArray[0]);
		assertEquals("b", returnedArray[1]);
	}

	// add()
	@Test
	public void shouldReturnTrueIfObjectIsSuccessfullyAdded() {
		List<Object> list = new ListImpl<>();
		assertTrue(list.add(null));
	}

	@Test
	public void shouldReturnTwoSameValue() {
		List<Object> list = new ListImpl<>();
		list.add(1);
		list.add(2);
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
	}

	// remove
	@Test
	public void shouldReturnFalseWhenArgumentIsNull() {
		List<Object> list = new ListImpl<>();
		assertFalse(list.remove(null));
	}

	@Test
	public void shouldReturnFalseWhenElementNotFound() {
		List<Integer> list = new ListImpl<>();
		list.add(1);
		assertFalse(list.remove(Integer.valueOf("2")));
	}

	@Test
	public void shouldReturnTrueWhenElementSuccessfullyRemoved() {
		List<Integer> list = new ListImpl<>();
		list.add(1);
		list.add(2);
		list.add(3);
		assertTrue(list.remove(Integer.valueOf("2")));
	}

	@Test
	public void shouldReturnTrueWhenElementRemovedAndCallSize() {
		List<Integer> list = new ListImpl<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(Integer.valueOf("2"));
		assertEquals(2, list.size());
	}

	@Test
	public void shouldReturnTrueWhenRemainingElementsAreEquals() {
		List<Integer> list = new ListImpl<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.remove(Integer.valueOf("1"));
		assertEquals(Integer.valueOf(2), list.get(0));
		assertEquals(Integer.valueOf(3), list.get(1));
	}

	@Test
	public void shouldReturnTrueWhenSizeIsSame_ElementToRemoveIsNotFound() {
		List<Integer> list = new ListImpl<>();
		list.add(1);
		list.add(2);
		list.remove(Integer.valueOf("3"));
		assertEquals(2, list.size());
	}

	// get()
	@Test
	public void shouldReturnSameValue() {
		List<String> list = new ListImpl<>();
		String testValue = "Test";
		list.add(testValue);
		assertEquals(testValue, list.get(0));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void shouldReturnArrayindexoutofboundsexceptionWhenIndexNotExists() {
		List<Object> list = new ListImpl<>();
		Object testObject = new Object();
		list.add(testObject);
		list.get(1);
	}

	// removeAll()
	@SuppressWarnings("unlikely-arg-type")
	@Test(expected = ClassCastException.class)
	public void shouldReturnClassCastExceptionWhenElementsOfInputCollectionAreNotIncopatibel() {
		List<Integer> source = new ListImpl<>();
		source.add(1);
		List<String> input = new ListImpl<>();
		input.add("a");
		source.removeAll(input);
	}

	@Test
	public void shouldReturnFalseWhenInputCollectionIsEmpty() {
		List<Object> source = new ListImpl<>();
		source.add(null);
		List<Object> input = new ListImpl<>();
		assertFalse(source.removeAll(input));
	}

	@Test
	public void shouldReturnFalseWhenSoourceCollectionIsEmpty() {
		List<Object> source = new ListImpl<>();
		List<Object> input = new ListImpl<>();
		input.add(null);
		assertFalse(source.removeAll(input));
	}

	@Test
	public void shouldReturnTrueWhenTwoElementsRemovedFromSourceList() {
		List<Integer> source = new ListImpl<>();
		source.add(1);
		source.add(2);
		source.add(3);
		List<Integer> input = new ListImpl<>();
		input.add(1);
		input.add(3);
		source.removeAll(input);
		assertEquals(1, source.size());
	}

	@Test
	public void shouldReturnFalseWhenInputElementsNotFoundInSourceList() {
		List<Integer> source = new ListImpl<>();
		source.add(1);
		source.add(2);
		List<Integer> input = new ListImpl<>();
		input.add(3);
		assertFalse(source.removeAll(input));
	}

	@Test
	public void shouldReturnTrueWhenNoElementsRemoved() {
		List<Integer> source = new ListImpl<>();
		source.add(1);
		source.add(2);
		List<Integer> input = new ListImpl<>();
		input.add(3);
		source.removeAll(input);
		assertEquals(2, source.size());
	}

}