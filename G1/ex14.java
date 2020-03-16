import java.util.*;

public class ex14 {
	
	static Scanner rd = new Scanner(System.in);
	
	public static void main (String[] args) {
		
	String frase0, frase1="";
	System.out.println("Insira uma frase: ");
	do
	{
		frase0 = rd.nextLine();
		frase1 = dialeto(frase0);
		System.out.println(frase1);	
		
	}while(frase0.length() != 0);
}
	
	public static String dialeto(String frase){
		String frase1 = "";
		for (int i = 0; i < frase.length(); i++)
		{
			char c = frase.charAt(i);
		
			if (c == 'l')
			{
				c = 'u';
			}
			if (c == 'r')
			{
				continue;
			}
		
			frase1 += c;
		}
		return frase1;
	}
}
