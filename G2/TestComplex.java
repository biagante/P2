import static java.lang.System.*;

public class TestComplex {
  // Exemplo simples de utilização da class Complex
  static int b;
  static int c;
  public static void main(String[] args) {
	 
	 b = Integer.parseInt(args[0]);
	 c = Integer.parseInt(args[1]);
	 Complex d = new Complex(b,c); 
	  
    Complex a = new Complex(5.0, 6.0);

    // Vamos usar métodos do objeto a
    out.println("(" + a.real() + " + " + a.imag() + "i)");
    out.println("  parte real = " + a.real());
    out.println("  parte imaginaria = " + a.imag());
    out.println("  modulo = " + a.abs());
    out.printf("  argumento =  %2.2f\n", a.arg());
    
    //metodos para d
    out.println("(" + d.real() + " + " + d.imag() + "i)");
    out.println("  parte real = " + d.real());
    out.println("  parte imaginaria = " + d.imag());
    out.println("  modulo = " + d.abs());
    out.printf("  argumento =  %2.2f\n", d.arg());
  }

}
