package tdd_listinterface;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ListIteratorImpl<E> implements ListIterator<E> {
	private E[] internal;
	private int cursorPosition;

	public ListIteratorImpl(E[] internal) {
		super();
		this.internal = internal;
	}

	@Override
	public boolean hasNext() {
		return internal.length != 0 && internal.length > cursorPosition ? true : false;
	}

	@Override
	public E next() {
		if (internal.length == 0 || internal.length == cursorPosition) {
			throw new NoSuchElementException();
		}
		return internal[cursorPosition++];
	}

	@Override
	public boolean hasPrevious() {
		return internal.length != 0 && cursorPosition != internal.length && cursorPosition != 0 ? true : false;
	}

	@Override
	public E previous() {
		if (internal.length == 0 || cursorPosition == 0) {
			throw new NoSuchElementException();
		}
		return internal[--cursorPosition];
	}

	@Override
	public int nextIndex() {
		return cursorPosition == internal.length ? internal.length : cursorPosition;
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

	@SuppressWarnings("unchecked")
	@Override
	public void add(E e) {
		if (internal.length != 0 && e != null) {
			E internalElement = internal[0];
			if (internalElement.getClass() != e.getClass()) {
				throw new ClassCastException();
			}
		}
		Object[] local = new Object[internal.length + 1];
		for (int i = 0; i < local.length; i++) {
			if (i == cursorPosition) {
				local[i] = e;
				continue;
			} else if (i > cursorPosition) {
				local[i] = internal[i - 1];
				continue;
			} else {
				local[i] = internal[i];
			}
		}
		cursorPosition++;
		internal = (E[]) local;
	}

}
