package tdd_listinterface;

import java.util.*;

public class IteratorImpl<E> implements Iterator<E> {
	private E[] internal;
	private int cursorPosition;

	public IteratorImpl(E[] internal) {
		super();
		this.internal = internal;
	}

	@Override
	public boolean hasNext() {
		return internal.length != 0 || internal.length != cursorPosition ? true : false;
	}

	@Override
	public E next() {
		if (internal.length == 0 || internal.length == cursorPosition) {
			throw new NoSuchElementException();
		}
		return internal[cursorPosition++];
	}

}
