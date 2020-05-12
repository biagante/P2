package p2utils;

public class LinkedList<E extends Comparable<E>> {

  private Node<E> first = null;
  private Node<E> last = null;
  private int size = 0;

  /** {@code LinkedList} constructor, empty so far.
   */
  public LinkedList() { }

  /** Returns the number of elements in the list.
   * @return Number of elements in the list
   */
  public int size() { return size; }

  /** Checks if the list is empty.
   * @return  {@code true} if list empty, otherwise {@code false}.
   */
  public boolean isEmpty() { return size == 0; }

  /** Returns the first element in the list.
   * @return  First element in the list
   */
  public E first() {
    assert !isEmpty(): "empty!";

    return first.elem;
  }

  /** Returns the last element in the list.
   * @return Last element in the list
   */
  public E last() {
    assert !isEmpty(): "empty!";

    return last.elem;
  }

  /** Adds the given element to the start of the list.
   * @param e the element to add
   */
  public void addFirst(E e) {
    first = new Node<>(e, first);
    if (isEmpty())
      last = first;
    size++;

    assert !isEmpty(): "empty!";
    assert first().equals(e) : "wrong element";
  }

  /** Adds the given element to the end of the list.
   * @param e the element to add
   */
  public void addLast(E e) {
    Node<E> newest = new Node<>(e);
    if (isEmpty())
      first = newest;
    else
      last.next = newest;
    last = newest;
    size++;

    assert !isEmpty(): "empty!";
    assert last().equals(e) : "wrong element";
  }

  /** Removes the first element in the list.
   */
  public void removeFirst() {
    assert !isEmpty(): "empty!";
    first = first.next;
    size--;
    if (isEmpty())
      last = null;
  }

  /** Removes all elements.
   */
  public void clear() {
    first = last = null;
    size = 0;
  }

  /** Returns a string representing the list contents.
   * @return A string representing the list contents
   */
  public String toString() {
    String sep = "";
    String s = "";
    for (Node<E> n = first; n != null; n = n.next) {
      s += sep + n.elem;
      sep = ", ";
    }
    return "[" + s + "]";
  }

  // funcoes adicionais pedidas no guião
  public int count(E e)
  {
	  return count(e, first);
  }
  
  private int count(E e, Node<E> n)
  {
	  if (n == null)
	  {
		  return 0;
	  }
	  if (e.compareTo(n.elem) == 0)
	  {
		  return 1 + count(e, n.next);
	  }
	  return count(e, n.next);
  }
  
  public int indexOf(E e)
  {
	  return indexOf(e, 0, first);
  }
  
  private int indexOf(E e, int i, Node<E> n)
  {
	  if (n == null)
	  {
		  return -1;
	  }
	  if (e.compareTo(n.elem) == 0)
	  {
		  return i;
	  }
	  return indexOf(e, i + 1, n.next);
  }

	public LinkedList<E> cloneReplace(E x, E y)
	{
		return cloneReplace(x, y, first);
	}
	
	private LinkedList<E> cloneReplace(E x, E y, Node<E> n)
	{
		if (n == null)
		{
			return new LinkedList<E>();
		}
		LinkedList<E> lista = cloneReplace(x, y, n.next);
		if (x.compareTo(n.elem) == 0)
		{
			lista.addFirst(y);
		}
		else
		{
			lista.addFirst(n.elem);
		}
		return lista;
	}
	
	public LinkedList<E> cloneSublist(int start, int end)
	{
		return cloneSublist(start, end, 0, first);
	}
	
	private LinkedList<E> cloneSublist(int start, int end, int index, Node<E> n)
	{
		if (n == null)
		{
			return new LinkedList<E>();
		}
		if (index > end)
		{
			return new LinkedList<E>();
		}
		LinkedList<E> lista = cloneSublist(start, end, index + 1, n.next);
		if (start <= index && index < end)
		{
			lista.addFirst(n.elem);
		}
		return lista;
	}
	
	public LinkedList<E> cloneExceptSublist(int start, int end)
	{
		return cloneExceptSublist(start, end, 0, first);
	}
	
	private LinkedList<E> cloneExceptSublist(int start, int end, int index, Node<E> n)
	{
		if (n == null)
		{
			return new LinkedList<E>();
		}
		LinkedList<E> lista = cloneExceptSublist(start, end, index + 1, n.next);
		if (start > index || index >= end)
		{
			lista.addFirst(n.elem);
		}
		return lista;
	}
	
	public void removeSublist(int start, int end)
	{
		removeSublist(start, end, 0, first);
	}
	
	private void removeSublist(int start, int end, int index, Node<E> n)
	{
		if (index < start - 1)
		{
			removeSublist(start, end, index + 1, n.next);
		}
		if (index == start - 1)
		{
			Node<E> node = n;
			int num = end - start + 1;
			do
			{
				node = node.next;
				num--;
			} while (num > 0);
			n.next = node;
			
		}
	}
}

