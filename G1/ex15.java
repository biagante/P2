import java.util.*;

public class ex15 {
	
	static Scanner kb = new Scanner(System.in);
	static double[] array = new double[20];
	
	public static void main (String[] args) {
		double a= 0;
		System.out.println("Introduza a lista de números: ");
		for (int i = 0; i < array.length; i++)
		{
			a = kb.nextInt();
			if (a == 0)
			{
				break;
			}
			else
			{
				array[i] = a;
			}
		}
		
		double soma = 0;
		int d = 1;
		double media;
		for (int i = 0; i < array.length; i++)
		{
			if(array[i] == 0)
			{
				break;
			}
			else
			{
				soma = soma + array[i];
				d++;
			}
		}
		System.out.printf("A soma da lista de números é %.2f\n",soma);
		media = soma/(d-1);
		System.out.printf("A média da lista de números é %.2f\n",media);
		
	}
}

