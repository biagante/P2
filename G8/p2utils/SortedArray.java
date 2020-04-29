package p2utils;

public class SortedArray<E extends Comparable<E>>
{
  // private attributes
  private int size = 0;
  private int dimensao;
  private E[] array;
  
  
  @SuppressWarnings("unchecked")
public SortedArray(int dimensao) { 
	  this.dimensao = dimensao;
	  this.array = (E[]) new Comparable[dimensao];
  }

  public int size() { return size; }

  public boolean isEmpty() { return size == 0; }
  
  public boolean isFull() { return size == dimensao; }

 
  public E first() {
	   assert !isEmpty(): "empty!";
	   return array[0];
  }
  
  
  public void insert(E e) {
	  assert size!=dimensao;
	  boolean maxvalue = true;
	  if(size == 0) {
		  array[0] = e;
	  }
	  else {
		  for(int i = 0; i<size; i++) {
			  if(e.compareTo(array[i])<0) {
				  for(int j = size; j > i; j--) {
					  array[j] = array[j-1];
				  }
			  array[i] = e;
			  maxvalue = false;
			  break;
			  }  
	  	}
		if(maxvalue) {
			array[size] = e;
		}
	  }
	  size++;
  }

  /** Removes the first element in the list.
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    for(int i = 0; i < size-1; i++) {
    	array[i] = array[i+1];
    }
    array[size-1] = null;
    size--;
  }

  /** Checks if the list is sorted.
   * @return {@code true} if sorted, {@code false} otherwise
   */
  public boolean isSorted() { 
    if (size < 2) return true;
    for(int i = 0; i < size-1; i++) {
    	if (array[i].compareTo(array[i+1])==1) return false;
    }
    return true;
  }
  
  public E get(int i) {
	  return array[i];
  }

  
  //copy
  
  public SortedArray<E> copy() {
	  SortedArray<E> nova = new SortedArray<E>(this.dimensao);
	  for(int i = 0; i < size; i++) {
	    nova.insert(array[i]);
	  }
	  return nova;
  }
  
  //contains
  public boolean contains(E e) {
	  for(int i = 0; i < size; i++) {
	    	if (array[i].compareTo(e)==0) return true;
	   }
	  return false;
  }
  
  
  //toString
  public String toString() {
	  String s = "[";
	  for (int i = 0; i < size; i++) {
		  s += array[i];
		  if(i+1 < size) {
			  s += ", ";
		  }
	  }
	  s += "]";
	  return s;
  }
  
  //merge
  public SortedArray<E> merge(SortedArray<E> sl) {
	  SortedArray<E> nova = new SortedArray<E>(this.dimensao + sl.dimensao);
	  for(int i = 0; i < size; i++) {
	    nova.insert(array[i]);
	  }
	  for(int i = 0; i < sl.size; i++) {
		    nova.insert(sl.array[i]);
	  }
	  return nova;
  }
  	

}
