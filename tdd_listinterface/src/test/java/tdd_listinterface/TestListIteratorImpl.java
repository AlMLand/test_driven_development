package tdd_listinterface;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TestListIteratorImpl {

	// hasNext()
	@Test
	public void shouldReturnTrueWHenNextElementExists() {
		Object[] objects = { 1 };
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
		Object[] objects = { 1, 2, 3 };
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
		Object[] objects = { 1, 2, 3 };
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
		Object[] objects = { 1 };
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		assertFalse(listIterator.hasPrevious());
	}

	@Test
	public void shouldReturnTrueWhenPreviousElementExist() {
		Object[] objects = { 1, 2 };
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
		Object[] objects = { 1, 2 };
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		assertEquals(Integer.valueOf(1), listIterator.previous());
	}

	// next() and previous()
	@Test
	public void shouldReturnTrueWhenFirstCallIsMethodNextAndSecondCallIsMethodPrevious() {
		Object[] objects = { 98, 99 };
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		assertEquals(listIterator.next(), listIterator.previous());
	}

	// nextIndex()
	@Test
	public void shouldReturnTrueWhenCursorValueIsEqualsArrayLenght() {
		Object[] objects = { 1, 2 };
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		listIterator.next();
		assertEquals(objects.length, listIterator.nextIndex());
	}

	@Test
	public void shouldReturnTrueWhenIndexForNextElementIsCorrect() {
		Object[] objects = { 98, 99 };
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		assertEquals(1, listIterator.nextIndex());
	}

	// previousIndex()
	@Test
	public void shouldReturnTrueWhenListiteratorCursorHasStartPosition() {
		Object[] objects = { 1, 2 };
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		assertEquals(-1, listIterator.previousIndex());
	}

	@Test
	public void shouldreturnTrueWhenReturnedPreviousIndexIsCorrect() {
		Object[] objects = { 98, 99 };
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		assertEquals(1, listIterator.previousIndex());
	}

	// remove()
	@Test
	public void shouldReturnTrueWhenFirstElementRemovedByNextCall() {
		Object[] objects = { 1, 2 };
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		listIterator.remove();
		assertEquals(null, listIterator.previous());
	}

	@Test
	public void shouldReturnTrueWhenFirstElementRemovedByPreviousCall() {
		Object[] objects = { 1, 2 };
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		listIterator.previous();
		listIterator.remove();
		assertEquals(null, listIterator.next());
	}

	@Test(expected = IllegalStateException.class)
	public void shouldReturnIllegalStateExceptionWhenMethodsNextOrPreviousAreNotCalledBeforRemoveMethod() {
		Object[] objects = { 1, 2 };
		ListIterator<?> listIterator = new ListIteratorImpl<>(objects);
		listIterator.remove();
	}

	@Test(expected = IllegalStateException.class)
	public void shouldReturnIllegalStateExceptionWhenAfterMethodNextAreMethodAddCalledAndNotMethodRemove() {
		Integer[] integers = { 1, 2 };
		ListIterator<Integer> listIterator = new ListIteratorImpl<>(integers);
		listIterator.next();
		listIterator.next();
		listIterator.previous();
		listIterator.add(3);
		listIterator.remove();
	}

	@Test(expected = IllegalStateException.class)
	public void shouldReturnIllegalStateExceptionWhenAfterMethodPreviousAreMethodAddCalled() {
		Integer[] integers = { 1, 2 };
		ListIterator<Integer> listIterator = new ListIteratorImpl<>(integers);
		listIterator.next();
		listIterator.add(3);
		listIterator.remove();
	}

	// set()
	@Test(expected = ClassCastException.class)
	public void shouldReturnClassCastExceptionWhenSetedElementTypeIsNotCompatibel() {
		Object[] objects = { 1 };
		ListIterator<Object> listIterator = new ListIteratorImpl<>(objects);
		listIterator.set("a");
	}

	@Test
	public void shouldReturnTrueWhenElementIsSeted() {
		Integer[] objects = { 1 };
		ListIterator<Integer> listIterator = new ListIteratorImpl<>(objects);
		listIterator.next();
		listIterator.set(2);
		assertEquals(Integer.valueOf(2), listIterator.previous());
	}

	@Test(expected = IllegalStateException.class)
	public void shouldReturnIllegalStateExceptionWhenMethodsNextOrPreviousAreNotCalledBeforSetMethod() {
		Integer[] integers = { 1, 2 };
		ListIterator<Integer> listIterator = new ListIteratorImpl<>(integers);
		listIterator.set(3);
	}

	@Test(expected = IllegalStateException.class)
	public void shouldReturnIllegalStateExceptionWhenRemoveCalledAfterNextAndBeforeSet() {
		Integer[] integers = { 1, 2 };
		ListIterator<Integer> listIterator = new ListIteratorImpl<>(integers);
		listIterator.next();
		listIterator.remove();
		listIterator.set(3);
	}

	@Test(expected = IllegalStateException.class)
	public void shouldReturnIllegalStateExceptionWhenAddCalledAfterNextAndBeforeSet() {
		Integer[] integers = { 1, 2 };
		ListIterator<Integer> listIterator = new ListIteratorImpl<>(integers);
		listIterator.next();
		listIterator.add(3);
		listIterator.set(4);
	}

	// add()
	@Test
	public void shouldReturnTrueWhenReturnedElementIsEqualsToTheAddedElement() {
		Integer[] integers = {};
		ListIterator<Integer> listIterator = new ListIteratorImpl<>(integers);
		listIterator.add(Integer.valueOf(1));
		assertEquals(Integer.valueOf(1), listIterator.previous());
	}

	@Test(expected = ClassCastException.class)
	public void shouldReturnClassCastExceptionWhenAddedElementTypeIsNotCompatibel() {
		Object[] integers = { 1 };
		ListIterator<Object> listIterator = new ListIteratorImpl<>(integers);
		listIterator.add("a");
	}

	@Test
	public void shouldReturnTrueWhenPreviousElementIsEqualsWithNewAddedElement() {
		Integer[] integers = { 1, 2 };
		ListIterator<Integer> listIterator = new ListIteratorImpl<>(integers);
		listIterator.next();
		listIterator.add(3);
		assertEquals(Integer.valueOf(3), listIterator.previous());
	}

	@Test
	public void shouldReturnTrueWhenElementOfPosition3IsExist() {
		Integer[] integers = { 1, 2 };
		ListIterator<Integer> listIterator = new ListIteratorImpl<>(integers);
		listIterator.next();
		listIterator.add(3);
		assertEquals(Integer.valueOf(2), listIterator.next());
	}

}
