package tdd_listinterface;

import java.lang.reflect.Array;
import java.util.*;

public class ListIteratorImpl<E> implements ListIterator<E> {
	private E[] internal;
	private int cursorPosition;
	private boolean nextCommutator;
	private boolean previousCommutator;

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
		previousCommutator = false;
		nextCommutator = true;
		return internal[cursorPosition++];
	}

	@Override
	public boolean hasPrevious() {
		return internal.length != 0 && internal.length >= cursorPosition && cursorPosition != 0 ? true : false;
	}

	@Override
	public E previous() {
		if (internal.length == 0 || internal.length < cursorPosition || cursorPosition == 0) {
			throw new NoSuchElementException();
		}
		nextCommutator = false;
		previousCommutator = true;
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
		modificationInternal(null);
	}

	@Override
	public void set(E e) {
		validationType(e);
		modificationInternal(e);
	}

	private void modificationInternal(E e) {
		if (nextCommutator) {
			internal[cursorPosition - 1] = e;
			nextCommutator = false;
		} else if (previousCommutator) {
			internal[cursorPosition] = e;
			previousCommutator = false;
		} else {
			throw new IllegalStateException();
		}
	}

	@Override
	public void add(E e) {
		validationType(e);
		internal = initializingWithNewElement(e);
		nextCommutator = false;
		previousCommutator = false;
		cursorPosition++;
	}

	@SuppressWarnings("unchecked")
	private E[] initializingWithNewElement(E e) {
		Class<?> internalType = internal.getClass();
		E[] local = (E[]) Array.newInstance(internalType.getComponentType(), internal.length + 1);
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
		return local;
	}

	private void validationType(E e) {
		if (e != null) {
			Class<?> internalType = internal.getClass();
			if (internalType.getComponentType() != e.getClass()) {
				throw new ClassCastException();
			}
		}
	}

}
