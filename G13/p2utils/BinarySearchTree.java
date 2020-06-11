package p2utils;

import static java.lang.System.*;

public class BinarySearchTree<E>
{
	private BSTNode<E> root = null;
	private int size = 0;

  public BinarySearchTree() { }

  public void set(String key, E elem) {
    assert key != null;

		root = set(key, elem, root);

    assert contains(key);
    assert get(key) == elem;
  }
  
  private BSTNode<E> set(String key, E elem, BSTNode<E> n)
  {
	  if (n == null)
	  {
		  size++;
		  return new BSTNode(key,elem);
	  }
	  
	  int i = key.compareTo(n.key);
	  if (i < 0)
	  {
		  n.left = set(key, elem, n.left);
		  return n;
	  }
	  else if (i > 0)
	  {
		  n.right = set(key, elem, n.right);
		  return n;
	  }
	  else
	  {
		  n.elem = elem;
		  return n;
	  }
	  
  }

  public E get(String key) {
    assert key != null;
    assert contains(key);

    return get(key, root);
  }
  
  private E get(String key, BSTNode<E> n){
	  int i = key.compareTo(n.key);
	  if (i < 0)
	  {
		  return get(key, n.left);
	  }
	  else if (i > 0)
	  {
		  return get(key, n.right);
	  }
	  else
	  {
		  return n.elem;
	  }
  }  

  public void remove(String key) {
    assert key != null;
    assert contains(key);

    root = remove(key, root);

    assert !contains(key);
  }
  
  private BSTNode remove(String key, BSTNode n){
	  int i = key.compareTo(n.key);
	  if (i < 0)
	  {
		  n.left = remove(key, n.left);
	  }
	  else if (i > 0)
	  {
		  n.right = remove(key, n.right);
	  }
	  else if (n.left == null)
	  {
		  n = n.right;
	  }
	  else if (n.right == null)
	  {
		  n = n.left;
	  }
	  else
	  {
		  n = n.subTreeMin();
		  remove(n.key);
	  }
	  return n;
  }

  public boolean contains(String key) {
    assert key != null;
    return root != null && root.contains(key);
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public int size() {
    return size;
  }

  public void clear() {
    root.left = null;
    root.right = null;
  }

  public String[] keys() {
    String[] keys = new String[0];
    if (root != null)
	{
		return keys(root, keys);
	}
	else
	{
		return new String[0];
	}
  }
  
  private String[] keys(BSTNode<E> n, String[] keys){
	  if(n.left != null)
	  {
		  keys = keys(n.left, keys);
	  }
	  if (n.right != null)
	  {
		  keys = keys(n.right, keys);
	  }
	  
	  String[] tmp = new String[keys.length + 1];
	  arraycopy(keys, 0, tmp, 0, keys.length);
	  tmp[keys.length] = n.key;
	  return tmp;
  }

  public String toString() {
    String[] keys = keys();
    String result = "{";
    for (int i = 0; i < keys.length ; i++)
	{
		result += get(keys[i]).toString();
		if (i < keys.length - 1)
		{
			result += " ";
		}
	}
	return result + "}";	
  }

}

