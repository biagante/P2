import java.io.*;
import java.util.Scanner;

public class ListRec {
	
	public static void main (String[] args) {
		String path;
		if (args.length >= 1)
		{
			path = args[0];
		}
		else
		{
			//utiliza o diretorio onde se encontra
			path = ".";
		}
		
		File folder = new File(path);
		if (folder.exists())
		{
			listDir(folder);
		}
		else
		{
			System.err.printf("ERRO: O directorio \"%s\" nao existe!\n",path);
		}
	}
	
	public static void listDir(File folder)
	{
		if (folder.isDirectory())
		{
			File[] files = folder.listFiles();
			if (files != null)
			{
				for(File file : files)
				{
					if (file.isDirectory())
					{
						listDir(file);
					}
					else
					{
						System.out.println(file.getPath());
					}
				}
			}
		}
	}
}

