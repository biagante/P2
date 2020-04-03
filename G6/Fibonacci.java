import static java.lang.System.*;

public class Fibonacci {

  public static void main(String[] args) {
    if (args.length < 1) {
      out.println("USO: java -ea Fibonacci N [N ...]");
      exit(1);
    }

    // Alguns testes:
    assert fibonacci(0) == 0;
    assert fibonacci(1) == 1;
    assert fibonacci(2) == 1;
    assert fibonacci(5) == 5;

    for(int i = 0; i < args.length; i++) {
      int n = Integer.parseInt(args[i]);
      long time = nanoTime();  // System.nanoTime() gives the time in ns.
      //int f = fibonacci(n);
      int fb = fibonacciM(n);
      time = nanoTime() - time;
      //out.printf("fibonacci(%d) = %d (%d ns)\n", n, f, time);
      out.printf("fibonacciM(%d) = %d (%d ns)\n", n, fb, time);
    }
  }

  public static int fibonacci(int n) {
    assert n >= 0;
    if (n == 0 || n == 1)
	{
		return n;
	}
	return fibonacci(n-2) + fibonacci(n-1);
  }
	
	//alinea b)
	public static int[] fib = new int[50]; //over 47, there's overflow
	
	public static int fibonacciM(int n)
	{
		fib[0] = 0;
		if (n > 0)
		{
			fib[1] = 1;
		
			for (int i = 2; i <= n; i++)
			{
				fib[i] = fib[i - 1] + fib[i-2];
			}
		}
		return fib[n];
	}
}
