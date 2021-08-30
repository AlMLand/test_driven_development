package tdd_listinterface;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ListIteratorImpl<E> implements ListIterator<E> {
	private Object[] internal;
	private int elementIndex;

	public ListIteratorImpl(Object[] internal) {
		super();
		this.internal = internal;
	}

	@Override
	public boolean hasNext() {
		return internal.length != 0 && internal.length != elementIndex ? true : false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		if(internal.length == 0 || internal.length == elementIndex) {
			throw new NoSuchElementException();
		}
		return (E) internal[elementIndex++];
	}

	@Override
	public boolean hasPrevious() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E previous() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextIndex() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int previousIndex() {
		// TODO Auto-generated method stub
		return 0;
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
