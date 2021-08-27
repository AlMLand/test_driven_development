package tdd_listinterface;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorImpl<E> implements Iterator<E> {
	private Object[] objects;
	private int indexOfElement;

	public IteratorImpl(Object[] objects) {
		super();
		this.objects = objects;
	}

	@Override
	public boolean hasNext() {
		return objects.length != 0 || objects.length != indexOfElement ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		if (objects.length == 0 || objects.length == indexOfElement) {
			throw new NoSuchElementException();
		}
		return (E) objects[indexOfElement++];
	}

}
