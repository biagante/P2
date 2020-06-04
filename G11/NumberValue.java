import static java.lang.System.*;
import java.util.*;
import java.io.*;
import p2utils.*;

public class NumberValue {
	
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
			int result = 0;
			int midNum = 0;
			for (int i = 0; i < array.length; i++)
			{
				out.print(array[i] + " ");
				if (dictionary.contains(array[i]))
				{
					int count = (int)dictionary.get((array[i]));
					if (midNum == 0 || count < midNum)
					{
						result += midNum;
						midNum = count;
					}
					else
					{
						midNum *= count;

					}										
				}	
			}
			result += midNum;
			out.print("-> " + result);
			out.println();
		} while (true); //works until ctrl-d/ctrl-c/ctrl-z
		
		
	}	
			
}

