//package lists;

import java.lang.Comparable;
import java.util.*;

public class Sorts {

	public static <E extends Comparable> void SelectionSort(List<E> c) {
		// Implement selection sort using the ListIterator interface
		// Look up the selection sort code in our notes and translate
		// it line by line.
		// Use the ListIterator methods hasNext(), next(), nextIndex(),
		// and set(E)
		// The first line is included to get you started.
		ListIterator<E> iit = c.listIterator(), jit;

		int n = c.size();

		for (int i = 0; i < n-1; i++){
			E min_idx = c.get(i);
			int indexes = i;
			for (int j = i+1; j < n; j++){
				if (c.get(j).compareTo(min_idx) < 0) {
					min_idx = c.get(j);
					indexes = j;
				}
			}
			//System.out.println(min_idx+"MINIDX");
			E temp = c.get(i);

			c.set(i,min_idx);

			c.set(indexes,temp);
		}
		//this implementation only works for arraylists
		//im sorry i couldnt figure out how to implement the generic selection sort
		//for the linked&doublylinkedlist, ive tried every way but nothing seems to work
		// I've done the dlinkedlist iterator

		//Here are all the implementations of selection sort that ive tried
/*
		//Sets jit to be iit but one after
		jit = c.listIterator(iit.nextIndex()+1);



		System.out.println(c.size()+" SIZE");



		while(iit.hasNext()||iit.nextIndex()!=c.size()){
			E min_idx = iit.next();
			int minINdex = iit.nextIndex();
			//iit.nextIndex();
			int indexes = iit.nextIndex()-1;
			System.out.println(min_idx+"IITSSSSSSSSS");
			while (jit.hasNext()){
				if (jit.next().compareTo(min_idx)<0){
					min_idx = c.get(jit.nextIndex()-1);
					indexes = jit.nextIndex()-1;
				}
			}

			E temp = c.get(iit.nextIndex()-1);

			c.set(iit.nextIndex()-1,min_idx);

			c.set(indexes,temp);

*/


/*
			E temp = c.get(iit.nextIndex()-1);

			int tempIndx = indexes;
			c.remove(iit.nextIndex()-1);

			c.add(iit.nextIndex()-1,min_idx);

			c.remove(indexes);

			c.add(indexes, temp);*/

/*
		for (iit.nextIndex(); iit.nextIndex()<c.size();iit.nextIndex()){

			 E min_idx = iit.next();
			int indexes = iit.nextIndex()-1;
			for (jit.nextIndex(); jit.nextIndex()<c.size()-1;jit.nextIndex()){
				if (jit.next().compareTo(min_idx)<0){

					min_idx = c.get(jit.nextIndex()-1);
					indexes = jit.nextIndex()-1;

				}
			}


			E temp = c.get(iit.nextIndex()-1);

			int tempIndx = indexes;
			c.remove(iit.nextIndex()-1);

			c.add(iit.nextIndex()-1,min_idx);

			c.remove(indexes);

			c.add(indexes, temp);
			//c.set(iit.nextIndex()-1,min_idx);

			//c.set(indexes,temp);
		}
*/
	}

	public static void printList(List c) {
		for (Object i : c) {
			System.out.print(i + ", ");
		}
		System.out.println();
	}

	public static void fillList(List c) {

		Random r = new Random();
		for (int i = 0; i < 20; i++) c.add(i);
		Collections.shuffle(c);
	/*
		c.add(5);
		c.add(3);
		c.add(8);
		c.add(1);
		c.add(9);
		c.add(4);
		c.add(2);
*/
	}

	public static void testList(List c) throws Exception {
		fillList(c);
		printList(c);
		SelectionSort(c);
		printList(c);
		List cc = new ArrayList(c);
		Collections.sort(c);
		for (int i = 0; i < c.size(); i++) 
			if (c.get(i) != cc.get(i))
				throw new Exception("List not sorted");
	}

	
	public static void main(String[] args) throws Exception {

		List<Integer> lst2 = new ArrayList<Integer>();
		testList(lst2);
/*
		List<Integer> lst1 = new DLinkedList<Integer>();
		testList(lst1);

		List<Integer> lst3 = new LinkedList<Integer>();
		testList(lst3);
*/
		//Implemented selection sort but only for ArrayList
		//Implemented some methods of DoublyLinkedListIterator
		//DoublyLinkedListIterators working methods are previousIndex(), remove(), and hasPrevious();
		//previous() works but for some reason starts at the 0th index and works its way backwards


		List<Integer> doubll = new DLinkedList<Integer>();
		doubll.add(3);
		doubll.add(4);
		doubll.add(8);
		doubll.add(7);

		System.out.println();


		ListIterator iit = doubll.listIterator();

		System.out.println(iit.next());
		System.out.println(iit.next());
		System.out.println(iit.next());
		System.out.println(iit.previousIndex());
		System.out.println(iit.previousIndex());
		iit.remove();
		System.out.println(iit.previousIndex());
		System.out.println();















	}
}
