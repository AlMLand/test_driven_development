package tdd_listinterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class TestListIteratorImpl {
	
	// hasNext()
	@Test
	public void shouldReturnTrueWHenNextElementExists() {
		Object[] objects = {1};
		ListIteratorImpl<?> listIterator = new ListIteratorImpl<>(objects);
		assertTrue(listIterator.hasNext());
	}
	
	@Test
	public void shouldReturnFalseWhenNextElementNotExists() {
		Object[] objects = {};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		assertFalse(listIterator.hasNext());
	}
	
	// next()
	@Test
	public void shouldReturnTrueWhenReturnedTheExpectedElement() {
		Object[] objects = {1, 2, 3};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		assertEquals(Integer.valueOf(1), listIterator.next());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void shouldReturnNoSuchElementExceptionWhenNoElementsAvailable() {
		Object[] objects = {};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
	}
	
	// hasNext() and next()
	@Test
	public void shouldReturnTrueWhenAllElementsAreEquals() {
		Object[] objects = {1, 2, 3};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		assertTrue(listIterator.hasNext());
		assertEquals(Integer.valueOf(1), listIterator.next());
		assertTrue(listIterator.hasNext());
		assertEquals(Integer.valueOf(2), listIterator.next());
		assertTrue(listIterator.hasNext());
		assertEquals(Integer.valueOf(3), listIterator.next());
	}

}
