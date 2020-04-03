import static java.lang.System.*;
import java.util.Scanner;

public class ReverseString {
	
	public static void main (String[] args) {
		Scanner rd = new Scanner(System.in);
		String s;
		if (args.length < 1)
		{
			exit(1);
		}
		
		else
		{
			for (int i = 0; i < args.length; i++)
			{
				out.printf("\"%s\" -> \"%s\"\n",args[i],reverseString(args[i]));
			}
			
		}
	}
	
	public static String reverseString(String s)
	{
		//se a string tiver apenas um caracter
		if (s.length() == 1)
		{
			return s;
		}
		//implementação recursiva para inverter
		return s.charAt(s.length()-1) + reverseString(s.substring(0, s.length()-1));
	}
}

