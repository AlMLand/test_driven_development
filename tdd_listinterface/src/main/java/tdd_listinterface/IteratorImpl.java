package tdd_listinterface;

import java.util.*;

public class IteratorImpl<E> implements Iterator<E> {
	private E[] internal;
	private int indexOfElement;

	public IteratorImpl(E[] internal) {
		super();
		this.internal = internal;
	}

	@Override
	public boolean hasNext() {
		return internal.length != 0 || internal.length != indexOfElement ? true : false;
	}

	@Override
	public E next() {
		if (internal.length == 0 || internal.length == indexOfElement) {
			throw new NoSuchElementException();
		}
		return internal[indexOfElement++];
	}

}
