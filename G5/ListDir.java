import java.io.*;
import static java.lang.System.*;

public class ListDir {
	
	public static void main (String[] args) {
		File folder = null;
		try
		{
			folder = openFolder(args);
		}
		catch (NullPointerException e)
		{
			out.println("Invalid arguments");
			exit(1);
		}
		File[] files = folder.listFiles();
		for (File file : files)
		{
			if (file.isFile())
			{
				out.print("F");
			}
			if (file.isDirectory())
			{
				out.print("D");
			}
			if (file.canRead())
			{
				out.print("R");
			}
			if (!file.canRead())
			{
				out.print("-");
			}
			if (file.canWrite())
			{
				out.print("W");
			}
			if (!file.canWrite())
			{
				out.print("-");
			}
			out.print(" ./"+file.getName()+"\n");
		}
		
	}
	
	static File openFolder(String[] args)
	{
		File folder = null;
		if (args.length == 1)
		{
			folder = new File(args[0]); //para diretorio especifico
		}
		else if (args.length == 0)
		{
			folder = new File("."); //para diretorio atual
		}
		if (!folder.exists())
		{
			out.printf("ERROR: input directory \"%s\" does not exist!\n",args[0]);
			exit(1);
		}
		return folder;
	}
}

