import static java.lang.System.*;

public class P3 {

  public static void main(String[] args) 
  {
	if(args.length % 2 != 0)
	{
		 out.println("ERROR: even number of arguments required!");
		 exit(1);
	 }
	 
	 for (int i = 0; i < args.length/2; i++)
	 {
		 out.printf("\"%s\" is prefixed by \"%s\" -> ", args[i * 2], args[i * 2 + 1]);
		 if (isPrefix(args[i * 2], args[i * 2 + 1], 0))
		 {
			 out.println("true");
		 }
		 else
		 {
			 out.println("false");
		 }
	 }
	 

  }

	public static boolean isPrefix(String a, String b, int c)
	{
		if (b.equals(""))
		{
			return true;
		}
		if (a.equals(""))
		{
			return false;
		}
		if (a.length() < b.length())
		{
			return false;
		}
		if (c == b.length() - 1)
		{
			return true;
		}
		if (a.charAt(c) != b.charAt(c))
		{
			return false;
		}
		
		return isPrefix(a, b, c + 1);
	}

}

