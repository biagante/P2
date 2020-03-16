import static java.lang.System.*;
import java.util.Scanner;

public class p13 {
  public static final Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    int n;
    while (true) {
      out.print("Number: ");
      n = in.nextInt();
      if (n > 0) break;
      err.println("ERROR: invalid number!");
    }

    String verb = isPrime(n)? "is" : "is not";
    out.printf("Number %d %s prime\n", n, verb);
  }

  public static boolean isPrime(int n) {
	// Complete a função para verificar se n é primo...
	boolean primo = true;
	int m = n/2;
	int test = 0;
	if (n == 0 || n == 1)
	{
		primo = false;
	}
	else
	{
		for (int i = 2; i <= m; i++)
		{
			if (n%i == 0)
			{
				primo = false;
				test = 1;
				break;
			}
			if (test == 0)
			{
				primo = true;
			}
		}
		
	}
	return primo;
  }	
}
