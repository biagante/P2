package p2utils;

public class BSTNode<E>{
	
	final String key;
	E elem;
	BSTNode<E> left;
	BSTNode<E> right;
	
	BSTNode(String key, E elem)
	{
		this.key = key;
		this.elem = elem;
		
	}
	
	public boolean contains(String key)
	{
		int i = key.compareTo(this.key);
		if (i < 0)
		{
			if (left != null)
			{
				return left.contains(key);
			}
			else
			{
				return false;
			}
		}
		else if(i > 0)
		{
			if (right != null)
			{
				return right.contains(key);
			}
			else
			{
				return false;
			}
		}
		else
		{
			return true;
		}
	}
	
	public String toString(){
		return "(" + key + ", " + elem + ")";		
	}
	
	public BSTNode<E> subTreeMin(){
		return subTreeMin(this);
	}
	
	private BSTNode<E> subTreeMin(BSTNode<E> n)
	{
		if (n.left == null)
		{
			return n;
		}
		return subTreeMax(n.left);
	}
	
	private BSTNode<E> subTreeMax(){
		return subTreeMax(this);
	}
	
	private BSTNode<E> subTreeMax(BSTNode<E> n){
		if (n.right == null)
		{
			return n;
		}
		return subTreeMax(n.right);
	}
	
}
