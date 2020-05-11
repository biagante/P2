import static java.lang.System.*;

public class AllDivisors
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			out.println("Usage: java -ea AllDivisors <NUM>");
			exit(1);
		}
		else
		{
			int n = Integer.parseInt(args[0]);
			divisors(n, 0);
		}
		
		
	}
	public static void divisors(int n, int space)
	{
		//imprime o espaçamento demonstrado
		for (int i = 0; i < space; i++)
		{
			out.print("   ");
		}
		//imprime o número que se encontra na função
		out.println(n);
		
		for (int i = n/2; i > 1 ; i--)
		{
			//se for divisor recursivamente aplica a função outra vez
			if (n % i == 0)
			{
				divisors(i, space + 1);
			}
		}
		
	}
	
}

