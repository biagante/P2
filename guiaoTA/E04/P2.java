import static java.lang.System.*;

public class P2
{
  public static void main(String[] args)
  {
	  for(String s : args)
	  {
		  out.printf("%s -> %s\n",s, invertString(s, "", 0));
	  }
  }
	
static String invertString(String s, String numbers, int i){
		//se a string for vazia retorna nada
		if(i > s.length() - 1)
		{ 
			return "";
		}
		//usa o primeiro char da frase
		char c = s.charAt(i);
		//se o char for um numero
		if(Character.isDigit(c))
		{
			//à parte numeros da string adiciona-se o novo c
			numbers = c + numbers;
			//se não houver mais nenhum carater ou mais nenhum número
			if(i == s.length()-1 || !Character.isDigit(s.charAt(i+1)))
			{
				//devolve os numeros innvertidos e a inversao da string
				return numbers + invertString(s, "", i + 1);
			}
			//invert a string de letras
			return invertString(s, numbers, i+1); 
		}
		//devolve a primero char e inverte os seguintes no caso deste
		//não ser um número
		else return c + invertString(s, "", i + 1);
	}
}

