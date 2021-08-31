package tdd_listinterface;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ListIteratorImpl<E> implements ListIterator<E> {
	private Object[] internal;
	private int cursorPosition;

	public ListIteratorImpl(Object[] internal) {
		super();
		this.internal = internal;
	}

	@Override
	public boolean hasNext() {
		return internal.length != 0 && internal.length != cursorPosition ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		if (internal.length == 0 || internal.length == cursorPosition) {
			throw new NoSuchElementException();
		}
		return (E) internal[cursorPosition++];
	}

	@Override
	public boolean hasPrevious() {
		return internal.length != 0 && cursorPosition != internal.length && cursorPosition != 0 ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E previous() {
		if (internal.length == 0 || cursorPosition == 0) {
			throw new NoSuchElementException();
		}
		return (E) internal[--cursorPosition];
	}

	@Override
	public int nextIndex() {
		if (cursorPosition == internal.length) {
			return internal.length;
		}
		return cursorPosition;
	}

	@Override
	public int previousIndex() {
		return cursorPosition == 0 ? -1 : cursorPosition;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void set(E e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(E e) {

	}

}
