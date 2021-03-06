import static java.lang.System.*;
import java.util.Arrays;

public class Ngrams {

  public static void main(String[] args) {
    int N = 3;
    switch (args.length) {
    case 1:
      break;
    case 2:
      try {
        N = Integer.parseInt(args[1]);
      }
      catch (NumberFormatException e) {
        err.printf("Second argument must be a number.\n");
        exit(1);
      }
      break;
    default:
      out.println("USO: java -ea Ngrams ABC [N]");
      exit(1);
    }
    String[] a;
    // Crie a função allNgrams e altere a invocação abaixo...
    //a = all3grams(args[0]);
    a = allNgrams(args[0],N);
    out.println(Arrays.toString(a));
  }

  // Gera todos os arranjos de 3 símbolos escolhidos do alfabeto alpha.
  public static String[] all3grams(String alpha) {
    int l = alpha.length();
    String[] arr = new String[l*l*l];
    int n = 0;
    for (int i = 0; i < l; i++) {
      for (int j = 0; j < l; j++) {
        for (int k = 0; k < l; k++) {
          arr[n] = "" +  alpha.charAt(i) + alpha.charAt(j) + alpha.charAt(k);
          n++;
        }
      }
    }
    assert n == arr.length;
    return arr;
  }

  // Gera todos os N-gramas de símbolos escolhidos do alfabeto alpha.
  public static String[] allNgrams(String alpha, int n) {
    assert n >= 0;
    int l = alpha.length(); //comprimento da string introduzida
    String[] arr = {""}; //array vazio para armazenar palavras formadas
    
    if (n > 0)
	{
		String[] arr2 = allNgrams(alpha, (n-1)); //recorrência
		arr = new String[l*arr2.length]; //atribuição de tamanho ao array
		
		int c = 0;
		for (int i = 0; i < arr2.length ; i++) //enquanto i for menor que o array novo
		{
			for (int k = 0; k < l; k++) //e k menor que comprimento da string
			{
				arr[c] = arr2[i] + alpha.charAt(k); //no array fica palavra do array novo mais um carater
				c++; //incrementa c para armazenar
			}
		}
	}
    return arr; //devolve array de palavras modificadas
  }
}

