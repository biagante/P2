import java.util.Scanner;

public class MDC {
	public static void main (String[] args) {
		Scanner rd = new Scanner(System.in);
		boolean again = true;
		
		while (again)
		{
			System.out.print("A: ");
			int a = rd.nextInt();
			System.out.print("B: ");
			int b = rd.nextInt();
			assert (a >= 0);
			assert (b >= 0);
		
			int result = mdc(a,b);
			System.out.println("MDC: " + result);
			System.out.print("Repetir (1=sim/0=não)? ");
			int c = rd.nextInt();
			if (c == 0)
			{
				again = false;
			}
		}
		
		
		
	}
	
	public static int mdc(int a,int b)
	{
		if (b == 0)
		{
			return a;
		}
		return mdc(b, a % b);
	}
}

