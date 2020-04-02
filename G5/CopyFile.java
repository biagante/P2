import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class CopyFile{
	
	public static void main (String[] args) throws IOException {
		try
		{
			assert(!args[0].isEmpty()) : "Usage: java -ea CopyFile <source-file> <destination-file>";
			assert(!args[1].isEmpty()) : "Usage: java -ea CopyFile <source-file> <destination-file>";
		}
		catch (Exception e)
		{
			out.println("Usage: java -ea CopyFile <source-file> <destination-file>");
			exit(1);
		}
		String file1 = args[0];
		String file2 = args[1];
		
		Scanner sc = new Scanner(System.in);
		
		if (file1.equals(file2))
		{
			out.println("ERROR: input and output files are the same!");
			exit(1);
		}
		
		File input = new File(file1);
		if (!input.exists())
		{
			out.printf("ERROR: input file \"%s\" does not exist!\n",file1);
			exit(1);
		}
		File output = new File(file2);
		if (output.exists())
		{
			out.printf("WARNING: output file \"%s\" already exists!\n",file2);
			out.print("Copy over existing file (y/n)? ");
			String answer = sc.nextLine();
			while (answer.isEmpty())
			{
				answer = sc.nextLine();
			}
			if (answer.compareTo("n")==0)
			{
				exit(1);
			}
		}
		Scanner scf = new Scanner(input);
		PrintWriter pwf = new PrintWriter(output);
		while (scf.hasNextLine())
		{
			String line = scf.nextLine();
			pwf.println(line);
		}
		pwf.close();
		sc.close();
	}

// Check if program is being run with -ea, exit if not.
  static {  // A static block. Cool!
    boolean ea = false;
    assert ea = true; // assert with a side-effect, on purpose!
    if (!ea) 
    {
      err.println("Usage: java -ea CopyFile <source-file> <destination-file>");
      exit(1);
    }
}
}

