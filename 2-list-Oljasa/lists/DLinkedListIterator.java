//package lists;

import java.util.*;

public class DLinkedListIterator<E> implements ListIterator<E> {
	protected DLinkedList<E>.Node next, lastReturned;
	protected DLinkedList<E>.Node prev;
	protected int nextIndex;
	protected int prevIndex;
	protected DLinkedList<E> list;

	public DLinkedListIterator(DLinkedList<E> list, DLinkedList<E>.Node next,DLinkedList<E>.Node prev, int nextIndex) {
		this.next = next;
		this.prev = prev;
		this.nextIndex = nextIndex;
		this.list = list;
		this.lastReturned = null;
	}

	public boolean hasNext() {
		return next != list.head;
	}

	public boolean hasPrevious() {
		return prev!=list.head;
		//throw new UnsupportedOperationException();		// TODO
	}

	public E next() {
		if (next == list.head) throw new NoSuchElementException();
		E elt = next.data;
		lastReturned = next;
		next = next.next;
		nextIndex++;
		return elt;
	}

	public E previous() {
		if (prev == list.head) throw new NoSuchElementException();
		E elt = prev.data;
		lastReturned = prev;
		prev = prev.prev;
		nextIndex=nextIndex-2;
		return elt;
		//throw new UnsupportedOperationException(); 	// TODO
	}
	
	public int nextIndex() { return nextIndex; }
	public int previousIndex() {
		//-2 because we're still using nextIndex instead of prev index and nextindex
		//points to the nextindex which will be n+1 so to get the prev index we have to do (n+1)-2.
		return nextIndex-2;
		//throw new UnsupportedOperationException();
	}	// TODO

	public void add(E elt) {
		DLinkedList<E>.Node nnd = list.new Node(elt);
		nnd.next = next;		// TODO
		nextIndex++;
		lastReturned = null;
	}

	public void remove() {
		if (lastReturned == null) throw new IllegalStateException();
		DLinkedList<E>.Node tnd = list.head;
		while (tnd.next != lastReturned) tnd = tnd.next;
		tnd.next = tnd.next.next;		// TODO
		tnd.prev = tnd.prev.prev; //DID THIS
		nextIndex--;
		lastReturned = null;
	}

	public void set(E elt) {
		if (lastReturned == null) throw new IllegalStateException();
		lastReturned.data = elt;
	}

}
