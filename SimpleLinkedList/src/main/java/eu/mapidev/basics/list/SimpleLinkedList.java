package eu.mapidev.basics.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class SimpleLinkedList<T> implements List<T> {

    private Node<T> root = null;
    private Node<T> last = root;
    private int size = 0;

    public T getLast() {
	return last.value;
    }

    public T getFirst() {
	return root.value;
    }

    private static class Node<T> {

	private T value;
	private Node<T> next;

	public Node(T value, Node<T> next) {
	    this.value = value;
	    this.next = next;
	}
    }

    @Override
    public int size() {
	return size;
    }

    @Override
    public boolean isEmpty() {
	return size == 0;
    }

    @Override
    public boolean contains(Object object) {
	Iterator<T> it = iterator();
	while (it.hasNext()) {
	    if (it.next().equals(object)) {
		return true;
	    }
	}
	return false;
    }

    @Override
    public Iterator<T> iterator() {
	return new Iterator<T>() {

	    private Node<T> current = root;

	    @Override
	    public boolean hasNext() {
		return current != null;
	    }

	    @Override
	    public T next() {
		T value = current.value;
		current = current.next;
		return value;
	    }
	};
    }

    @Override
    public Object[] toArray() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(T value) {
	if (isEmpty()) {
	    root = new Node<T>(value, null);
	    last = root;
	} else {
	    last.next = new Node<>(value, null);
	    last = last.next;
	}
	size++;
	return true;
    }

    @Override
    public boolean remove(Object o) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
	size = 0;
	root = null;
	last = root;
    }

    @Override
    public T get(int index) {
	int iteratorIndex = 0;
	Iterator<T> it = iterator();

	while (it.hasNext()) {
	    T currentElement = it.next();
	    if (iteratorIndex == index) {
		return currentElement;
	    }
	    iteratorIndex++;
	}

	throw new IndexOutOfBoundsException("Input index must be in range of [0, size-1]");
    }

    @Override
    public T set(int index, T element) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, T element) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T remove(int index) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<T> listIterator(int index) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
