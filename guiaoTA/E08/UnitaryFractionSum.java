import static java.lang.System.*;

public class UnitaryFractionSum
{
	public static void main(String[] args)
	{
		if (args.length < 2)
		{
			out.println("Usage: java -ea UnitaryFractionSum <NUM> <DEN>");
			exit(1);
		}
		
		try
		{
			int num = Integer.parseInt(args[0]);
			int den = Integer.parseInt(args[1]);
			out.print(num + "/" + den + " = ");
			fraction(num, den);
			out.println();
		}
		catch (NumberFormatException e)
		{
			out.printf("ERROR: one of the arguments (%s, %s) is not an integer number!\n",args[0], args[1]);
			exit(1);
		}
		
	}
	
	public static void fraction(int num, int den)
	{
		int d = (int)Math.ceil((float)den/(float)num);
		num = d * num - den;
		den = d * den;
		if (num % den == 0)
		{
			out.print("1/" + d);
		}
		else
		{
			out.print("1/"+ d + " + ");
			fraction(num,den);
		}
	}
}

