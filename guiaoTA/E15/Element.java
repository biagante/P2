public class Element 
{
	public final int elem;
	public int number;
	
	Element(int elem, int num)
	{
		this.elem = elem;
		number = num;
	}
	
	public String toString()
	{
		return "[" + elem + ":" + number + "]";
	}
	
	public boolean contains(int e)
	{
		return elem == e;
	}
	
}
