import static java.lang.System.*;

public class Factors {

  public static void main(String[] args) {
    for(int i = 0; i < args.length; i++)
      out.println(args[i]+" = "+factors(Integer.parseInt(args[i])));
  }
	
	
	public static String factors(int number){
		assert number >= 0;
		//se o numero for 1 ou 0 basta devolver o numero, daí começarmos o ciclo em 2
		for(int i = 2; i < number; i++)
		{
			if(number % i == 0) //verifica se é um fator do numero
			{
			   //se sim devolve o valor de i em string 
			   //e recursivamente factoriza o resto do numero
				 return String.valueOf(i) + " * " + factors(number/i);
			}
		}
		//devolve o numero em string
		return String.valueOf(number);
	}
}

