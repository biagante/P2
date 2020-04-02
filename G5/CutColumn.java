import java.io.*;
import java.util.*;
import static java.lang.System.*;

public class CutColumn {
	
	public static void main (String[] args) throws IOException {
		try
		{
			assert(!args[0].isEmpty()) : "Usage: java -ea CutColumn <source-file> <column-number>";
			assert(!args[1].isEmpty()) : "Usage: java -ea CutColumn <source-file> <column-number>";
		}
		catch (Exception e)
		{
			out.println("Usage: java -ea CutColumn <source-file> <column-number>");
			exit(1);
		}
		String file1 = args[0];
		int column = 0;
		try
		{	
			column = Integer.parseInt(args[1]);
		}
		catch (Exception e)
		{
			out.printf("ERROR: argument %s (not a number)\n",args[1]);
		}
		
		File input = new File(file1);
		if (!input.exists())
		{
			out.printf("ERROR: %s (No such file or directory)",file1);
			exit(1);
		}
		Scanner scf = new Scanner(input);
		String[] line = null;
		do
		{
			line = scf.nextLine().split("[ \t]+");
			try
			{
				out.println(line[column -1]);
			}
			catch (Exception e)
			{
				out.println();
			}
		} while (scf.hasNextLine());
		
	}
	
	  static {  // A static block. Cool!
    boolean ea = false;
    assert ea = true; // assert with a side-effect, on purpose!
    if (!ea) 
	{
      err.println("Usage: java -ea CutColumn <source-file> <column-number>");
      exit(1);
    }
  }
}

