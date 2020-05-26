import static java.lang.System.*;
import java.util.Scanner;
import p2utils.*;

public class RPNCalculator
{
	public static void main (String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Stack<Double> stack = new Stack<Double>();
		double result = 0;
		while (sc.hasNext())
		{
			if (sc.hasNextDouble())
			{
				stack.push(sc.nextDouble());
			}
			else
			{
				String operand = sc.next();
				if (!operand.equals("*") && !operand.equals("+") && !operand.equals("/") && !operand.equals("-"))
				{
					out.println("ERROR: invalid operand");
					exit(0);
				}
				if (stack.isEmpty())
				{
					out.println("ERROR: two operands missing!");
					exit(2);
				}
				
				double a = stack.top();
				stack.pop();
				assert !stack.isEmpty() : "ERROR: one operand missing!";
				double b = stack.top();
				stack.pop();
				if (operand.equals("*"))
				{
					result = b * a;
				}
				else if(operand.equals("/"))
				{
					result = b / a;
				}
				else if(operand.equals("+"))
				{
					result = b + a;
				}
				else if(operand.equals("-"))
				{
					result = b - a;
				}
				stack.push(result);
			}
			
			out.printf("Stack: %s \n", stack.reverseToString());
		}
		
	}
}

