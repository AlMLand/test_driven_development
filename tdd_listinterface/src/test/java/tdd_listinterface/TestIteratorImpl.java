package tdd_listinterface;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TestIteratorImpl {
	
	// hasNext()
	@Test
	public void shouldReturnFalseWhenArrayLenghtIs0() {
		Object[] objects = new Object[] {};
		Iterator<Object> iterator = new IteratorImpl<>(objects);
		assertFalse(iterator.hasNext());
	}
	
	@Test
	public void shouldReturnTrueWhenArrayHasNextElement() {
		Integer[] integers = new Integer[] {1};
		Iterator<Integer> iterator = new IteratorImpl<>(integers);
		assertTrue(iterator.hasNext());
	}
	
	// next()
	@Test(expected = NoSuchElementException.class)
	public void shouldReturnNoSuchElementExceptionWhenNoElementsExists() {
		Integer[] integers = {};
		Iterator<Integer> iterator = new IteratorImpl<>(integers);
		iterator.next();
	}
	
	@Test
	public void shouldReturnTwoElementsWhenTwoElementsExists() {
		Integer[] integers = {1, 2};
		Iterator<Integer> iterator = new IteratorImpl<>(integers);
		assertEquals(Integer.valueOf(1), iterator.next());
		assertEquals(Integer.valueOf(2), iterator.next());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void shouldReturnFirstElementsWhenFirstElementsExistsAndNoSuchElementExceptionBySecondElement() {
		Integer[] integers = {1};
		Iterator<Integer> iterator = new IteratorImpl<>(integers);
		assertEquals(Integer.valueOf(1), iterator.next());
		iterator.next();
	}
	
	// hasNext() and next()
	@Test
	public void shouldReturnTrueWhenElementExistsAndReturnElementWithSameValue() {
		Integer[] integers = {3};
		Iterator<Integer> iterator = new IteratorImpl<>(integers);
		assertTrue(iterator.hasNext());
		assertEquals(Integer.valueOf(3), iterator.next());
	}

}
