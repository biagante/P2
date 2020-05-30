import static java.lang.System.*;
import java.util.*;
import java.io.*;
import p2utils.*;

public class TranslateNumbers {
	
	public static void main (String[] args) throws IOException{
		
		Scanner scf = new Scanner(new File("numbers.txt"));
		
		KeyValueList dictionary = new KeyValueList<>();
		while (scf.hasNextLine())
		{
			String line = scf.nextLine();
			if (line.length() > 0)
			{
				String[] parts = line.split(" - ");
				String keys = parts[1].toLowerCase();
				int value = Integer.parseInt(parts[0]);
				dictionary.set(keys, value);
			}
		}
		scf.close();
		
		Scanner sc = new Scanner(System.in);
		do
		{
			String input = sc.nextLine();
			String[] array = input.split(" ");
			for (int i = 0; i < array.length; i++)
			{
				if (dictionary.contains(array[i]))
				{
					out.printf(dictionary.get(array[i]) + " ");
				}
				else
				{
					out.printf(array[i] + " ");
				}
			}
			out.println();
		} while (true); //works until ctrl-d/ctrl-c/ctrl-z
		
		
	}	
			
}

