import java.util.*;

public class ex16 {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int secret = (int)(100.0*Math.random()) + 1;
		String s = "";
		int a, b, n = 0;
		
		System.out.print("Adivinha o número: ");
		a = sc.nextInt();
		
		while (a != secret)
		{
			b = Math.abs(secret -a);
			if (b <= 5)
			{
				s = "Está muito perto";
			}
			if (b <= 10 & b > 5)
			{
				s = "Está perto";
			}
			if (b > 10 & b <20)
			{
				s = "Está longe";
			}
			if (b > 20)
			{
				s = "Está muito longe";
			}
			n++;
			System.out.printf("Tentativa errada\n %s\n Tente Novamente: ",s);
			a = sc.nextInt();
		}
		n = n -1;
		System.out.printf("Pontuação: %d",n);
	}
}

