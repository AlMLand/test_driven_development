package tdd_listinterface;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListImpl<E> implements List<E> {
	private Object[] internalArray = {};

	public int size() {
		return internalArray.length;
	}

	public boolean isEmpty() {
		return internalArray.length == 0;
	}

	public boolean contains(Object o) {
		return internalArray.length == 0 ? false : searchForMatchesInArray(o);
	}

	public Iterator<E> iterator() {
		return new IteratorImpl<>(internalArray);
	}

	public Object[] toArray() {
		return internalArray.clone();
	}

	@SuppressWarnings("unchecked")
	public <T> T[] toArray(T[] a) {
		if (internalArray.length > a.length) {
			a = (T[]) new Object[internalArray.length];
			a = copyArrayElements(a).clone();
			return a;
		} else {
			a = copyArrayElements(a).clone();
			return a;
		}
	}

	public boolean add(E e) {
		Object[] newArray = new Object[internalArray.length + 1];
		newArray = copyArrayElements(newArray);
		newArray[internalArray.length] = e;
		internalArray = newArray;
		return true;
	}

	@SuppressWarnings("unchecked")
	private <T> T[] copyArrayElements(T[] a) {
		for (int i = 0; i < internalArray.length; i++) {
			a[i] = (T) internalArray[i];
		}
		return a;
	}

	public boolean remove(Object o) {
		if (o != null && searchForMatchesInArray(o)) {
			Object[] newArray = new Object[internalArray.length - 1];
			int index = 0;
			for (Object object : internalArray) {
				if (object.equals(o)) {
					continue;
				}
				newArray[index++] = object;
			}
			internalArray = newArray;
			return true;
		}
		return false;
	}

	private boolean searchForMatchesInArray(Object o) {
		for (Object object : internalArray) {
			if (object == o)
				return true;
		}
		return false;
	}

	public boolean containsAll(Collection<?> c) {
		if (!c.isEmpty()) {
			if(!typeMatcher(c)) {
				throw new ClassCastException();
			}
			boolean foundElement = false;
			int count = 0;
			for (Object object : c.toArray()) {
				foundElement = searchForMatchesInArray(object);
				if (foundElement) {
					count++;
				}
			}
			if (count == c.size()) {
				return true;
			}
		}
		return false;
	}

	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeAll(Collection<?> c) {
		if (internalArray.length != 0 && !c.isEmpty()) {
			if (!typeMatcher(c)) {
				throw new ClassCastException();
			}
			boolean foundElement = false;
			for (Object object : c.toArray()) {
				boolean targetElement = searchForMatchesInArray(object);
				if (targetElement) {
					foundElement = remove(object);
				}
			}
			return foundElement ? true : false;
		}
		return false;
	}

	private boolean typeMatcher(Collection<?> c) {
		Object inputElement = c.stream().filter(element -> element != null).findAny().get();
		Object internalElement = List.of(internalArray).stream().filter(element -> element != null).findAny().get();
		return inputElement.getClass() == internalElement.getClass();
	}

	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public E get(int index) {
		return (E) internalArray[index];
	}

	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(int index, E element) {
		// TODO Auto-generated method stub

	}

	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
