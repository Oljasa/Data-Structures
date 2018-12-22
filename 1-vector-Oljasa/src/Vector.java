import java.nio.charset.StandardCharsets;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;
import java.lang.RuntimeException;
import java.util.Arrays;

public class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess {

  protected Object[] data;
  protected int size;

  public int size() {
   	return size; 
  }
  
  private void rangeCheck(int index) {
   	 if (index < 0 || index >= size)

       throw new IndexOutOfBoundsException("");
  }
  

  private E data(int index) {
    return (E) data[index];
  }
  
  private void grow() {
    int newCapacity = data.length*2;
   	data = Arrays.copyOf(data, newCapacity); 
  }
  
  public Vector() {
  	this(10); 
  }
  
  public Vector(int initialCapacity) {
   	data = new Object[initialCapacity];
    size = 0;
  }
  
  public E get(int index) {
    rangeCheck(index);
    return data(index);
  }
  
  public E set(int index, E element) {
    rangeCheck(index);
    E oldValue = data(index);
   	data[index] = element; 
  	return oldValue;
  }
  
  public boolean add(E element) {
   	if (size == data.length) grow(); 
    data[size++] = element;
    return true;
  }
  
  public void add(int index, E element) {

      // Add element at index.
      rangeCheck(index);
      //if we run out of space within the vector, it doubles in size
      if (size == data.length) grow();
      //gives us the number of elements we have to copy within the arraycopy() method
      int numToMove=size-index;
      if(numToMove>0){
          //increases the size by one to accomodate the last element
          size++;
          //copies array from starting from the index that we want to add a new element at,
          //then makes a new array from the index position +1
          System.arraycopy(data,index,data,index+1,numToMove);
          //Sets the current index to the element we wish it to be.
          data[index]=element;
      }



  }

  public E remove(int index) {
      // Remove the element at index. Make sure there are no gaps
      // Return the removed element
      rangeCheck(index);
      //gives us the removedElement that we are removing
      E removedelement = (E) data[index];

     //gives us the number of elements we will have to move in the array
      int numToMove = size - index - 1;
      if(numToMove>0){
          //goes to the next element of the element we want to remove and copies
          //all elements from that number to numToMove which is the rest of the array
          System.arraycopy(data,index+1,data,index,numToMove);
      }
      //fills in the gaps at the end of array
      //sets null to be equal to the last element because if it wasnt it would be
      //the current element in that position
      data[size--] = null;

      return removedelement;

  }

	public int indexOf(Object o) {
		// Returns the index of the first occurrence of the specified element 
		// in this list, or -1 if this list does not contain the element.
        //iterates through the entire vector,
        for(int i=0;i<data.length;i++){
            //if it encounters the element we are looking for it will return i
            //which is the position of the element
            if(data[i]==o) {
                return i;
            }
        }
        //if not it returns -1
        return -1;

  }

  public static void main(String[] args) {
  	Vector<Integer> intlist = new Vector<Integer>();
    Vector<String> stringlist = new Vector<String>();
    Vector<Vector<Integer>> intveclist = new Vector<Vector<Integer>>();
    Vector<Vector<String>> stringveclist = new Vector<Vector<String>>();
      System.out.println("OLJAS ALISHEV CISC 3130");


      intlist.add(0);
      intlist.add(1);
      intlist.add(2);
      intlist.add(3);
      intlist.add(4);
      intlist.add(0);
      intlist.add(1);
      intlist.add(2);
      intlist.add(3);
      intlist.add(4);

      intveclist.add(intlist);

      System.out.println("ORIGINAL LIST");
      System.out.println(intveclist);
      System.out.println();

      intlist.add(1,99);
      System.out.println("Adding 99 to index 1");
      System.out.println(intveclist);
      System.out.println();

      intlist.remove(3);
      System.out.println("Removing index 3 which is element 2");
      System.out.println(intveclist);
      System.out.println();

      System.out.println("Finding element 99 within the vector");
      System.out.println("Located at index: "+intlist.indexOf(1));
      System.out.println("-------------------------------------------");

      stringlist.add("A");
      stringlist.add("B");
      stringlist.add("C");
      stringlist.add("D");
      stringlist.add("E");
      stringlist.add("A");
      stringlist.add("B");
      stringlist.add("C");
      stringlist.add("D");
      stringlist.add("E");

      stringveclist.add(stringlist);

      System.out.println("ORIGINAL LIST");
      System.out.println(stringveclist);
      System.out.println();

      stringlist.add(1,"HELLO");
      System.out.println("Inserting 'HELLO' to index 1");
      System.out.println(stringveclist);
      System.out.println();

      stringlist.remove(3);
      System.out.println("Removing index 3 which is element of letter C");
      System.out.println(stringveclist);
      System.out.println();

      System.out.println("Finding the letter B within the vector");
      System.out.println("Located at index: "+stringlist.indexOf("B"));

  }
}

