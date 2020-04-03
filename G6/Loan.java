import static java.lang.System.*;

public class Loan {
	
	static double juro;
	static int P;
	
	public static void main (String[] args) {
		if(args.length != 4) out.println("USO: java -ea Loan n M T P");
		
		try{ //Verifica se todos os argumentos são válidos
			for(String a : args)
				Integer.parseInt(a);
		}catch(Exception e){
			out.println("USO: java -ea p66 <n> <M> <T> <P>");
			exit(1);
		}
		
		int n = Integer.parseInt(args[0]);
		int M = Integer.parseInt(args[1]);
		int T = Integer.parseInt(args[2]);
		P = Integer.parseInt(args[3]);
		
		double div = (double)M;
		juro = 1 + (double)T/100;
		
		//iterativo
		for (int i = 1; i <= n; i++)
		{
			div = div*juro - P;
		}
		out.printf("(iterativo) d(%d) = %.5f\n", n, div);
		
		//recursivo
		div = divida(M,n);
		out.printf("(recursivo) d(%d) = %.5f\n", n, div);
		
	}
	
	public static double divida(int M, int n)
	{
		if (n == 0)
		{
			return M;
		}
		return divida(M,n-1)*juro - P;
	}
	
	static {  // A static block. Cool!
    boolean ea = false;
    assert ea = true; // assert with a side-effect, on purpose!
    if (!ea) 
	{
      err.println("USO: java -ea Loan n M T P");
      exit(1);
    }
  }
}

