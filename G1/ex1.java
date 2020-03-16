import java.util.*;

public class ex1 {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) {
		double a,b;
		String op;
		
		System.out.print("Insira: ");
		
		a = sc.nextDouble();
		op = sc.next();
		b = sc.nextDouble();
		
		switch (op)
		{
			case "+":
				System.out.println("Resultado: " + (a+b));
				break;
			case "-":
				System.out.println("Resultado: " + (a-b));
				break;
			case "*":
				System.out.println("Resultado: " + (a*b));
				break;
			case "/":
				System.out.println("Resultado: " + (a/b));
				break;
			default: System.err.println("Operação inválida");
					 System.exit(1);
		}
		
	}
}

