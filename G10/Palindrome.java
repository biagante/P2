import p2utils.*;
import static java.lang.System.*;

/* 93418 - Beatriz Agante
 * 95288 - Lara Matos
 * */

public class Palindrome {
	
	public static void main (String[] args) {
		if (args.length != 1)
		{
			System.out.println("Usage: java -ea Palindrome <text>");
			System.exit(1);
		}
		
		Queue <Character> queue = new Queue<Character>();
		Stack <Character> stack = new Stack<Character>();
		
		for (int i = 0; i < args[0].length(); i++)
		{
			char d = (args[0].charAt(i));
			char c = Character.toLowerCase(d);
			
			if (c != ' ')
			{
				stack.push(c);
				queue.in(c);
			}
		}
		
		String result = "";
		do
		{
			if (stack.top().compareTo(queue.peek()) != 0)
			{
				result = "not";
			}
			stack.pop();
			queue.out();
		} while (!stack.isEmpty());
		
		out.printf("Text \"%s\" is %s a palindrome\n",args[0],result);
		
		
		
	}
}

