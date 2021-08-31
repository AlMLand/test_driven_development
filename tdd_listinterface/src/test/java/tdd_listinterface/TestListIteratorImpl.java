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
	
	// hasPrevios()
	@Test
	public void shouldReturnFalseWhenNoPreviousElementExists() {
		Object[] objects = {1};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		assertFalse(listIterator.hasPrevious());
	}
	
	@Test
	public void shouldReturnTrueWhenPreviousElementExist() {
		Object[] objects = {1, 2};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		assertTrue(listIterator.hasPrevious());
	}
	
	// previous()
	@Test(expected = NoSuchElementException.class)
	public void shouldReturnNoSuchElementExceptionWhenNoPreviousElementExist() {
		Object[] objects = {};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.previous();
	}
	
	@Test
	public void shouldReturnExpectedElementWhenPreviousElementExist() {
		Object[] objects = {1, 2};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		assertEquals(Integer.valueOf(1), listIterator.previous());
	}
	
	// next() and previous()
	@Test
	public void shouldReturnTrueWhenFirstCallIsMethodNextAndSecondCallIsMethodPrevious() {
		Object[] objects = {98, 99};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		assertEquals(listIterator.next(), listIterator.previous());
	}
	
	// nextIndex()
	@Test
	public void shouldReturnTrueWhenCursorValueIsEqualsArrayLenght() {
		Object[] objects = {1, 2};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		listIterator.next();
		assertEquals(objects.length, listIterator.nextIndex());
	}

	@Test
	public void shouldReturnTrueWhenIndexForNextElementIsCorrect() {
		Object[] objects = {98, 99};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		assertEquals(1, listIterator.nextIndex());
	}
	
	// previousIndex()
	@Test
	public void shouldReturnTrueWhenListiteratorCursorHasStartPosition() {
		Object[] objects = {1, 2};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		assertEquals(-1, listIterator.previousIndex());
	}
	
	@Test
	public void shouldreturnTrueWhenReturnedPreviousIndexIsCorrect() {
		Object[] objects = {98, 99};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		assertEquals(1, listIterator.previousIndex());
	}
	
	// remove()
	@Test
	public void shouldReturnTrueWhenFirstElementRemovedByNextCall() {
		Object[] objects = {1, 2};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		listIterator.remove();
		assertEquals(null, listIterator.previous());
	}
	
	@Test
	public void shouldReturnTrueWhenFirstElementRemovedByPreviousCall() {
		Object[] objects = {1, 2};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		listIterator.previous();
		listIterator.remove();
		assertEquals(null, listIterator.next());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnIllegalArgumentExceptionWhenMethodsNextOrPreviousAreNotCalled() {
		Object[] objects = {1, 2};
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.remove();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnIllegalArgumentExceptionWhenAfterMethodNextAreMethodAddCalled() {
		Object[] objects = {1, 2};
		ListIterator<Object> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		listIterator.next();
		listIterator.previous();
		listIterator.add(3);
		listIterator.remove();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldReturnIllegalArgumentExceptionWhenAfterMethodPreviousAreMethodAddCalled() {
		Object[] objects = {1, 2};
		ListIterator<Object> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		listIterator.add(3);
		listIterator.remove();
	}
	
	// add()
	@Test
	public void shouldReturnTrueWhenReturnedElementIsEqualsToTheAddedElement() {
		Object[] objects = {};
		ListIterator<Object> listIterator = new ListIteratorImpl<>(objects);
		listIterator.add(Integer.valueOf(1));
		assertEquals(Integer.valueOf(1), listIterator.previous());
	}
	
	@Test(expected = ClassCastException.class)
	public void shouldReturnClassCastExceptionWhenAddedElementTypeIsNotCompatibel() {
		Object[] integers = {1};
		ListIterator<Object> listIterator = new ListIteratorImpl<>(integers);
		listIterator.add("a");
	}
	
	@Test
	public void shouldReturnTrueWhenPreviousElementIsEqualsWithNewAddedElement() {
		Object[] objects = {1, 2};
		ListIterator<Object> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		listIterator.add(3);
		assertEquals(3, listIterator.previous());
	}
	
	@Test
	public void shouldReturnTrueWhenElementOfPosition3IsExist() {
		Object[] objects = {1, 2};
		ListIterator<Object> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		listIterator.add(3);
		assertEquals(2, listIterator.next());
	}
	
}
