import static java.lang.System.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.IOException;
import p2utils.HashTable;


import java.util.Arrays;


public class FindGroupCollisions
{
  static final Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    if (args.length!=2) {
      err.printf("Usage: java -ea CheckGroups Group-File1 Group-File2\n");
      exit(1);
    }

    File f1 = new File(args[0]);
    File f2 = new File(args[1]);
    
    // Create a dictionary to store student -> group mapping
    HashTable<String> studentGroup1 = new HashTable<>(200);
    HashTable<String> studentGroup2 = new HashTable<>(200);

    // Load the file and store the data in the dictionary
    loadFile(f1, studentGroup1);
	loadFile(f2, studentGroup2);
	
    String[] salas1 = studentGroup1.keys();
    String[] salas2 = studentGroup2.keys();
    String[] a = new String[10];
    int i = 0;
    
    try
    {
		if (studentGroup1.contains(salas2[i]) && studentGroup2.contains(salas1[i]))
		{
			a[i] = salas1[i];
			i++;
			if (studentGroup1.get(a[i]).equals(studentGroup2.get(a[i])))
			{
				out.println(Arrays.toString(a));
				for (int j = 0; j < a.length; j++)
				{
					if (studentGroup1.get(a[j]).equals(studentGroup2.get(a[j])))
					{
						out.printf("In %s, group %s\n",args[0],a[j], studentGroup1.toString());
						out.println("includes students that were in same group");
						out.printf("in %s, group %s: [%s]\n\n",args[1],a[j], studentGroup2.toString());
					}
				}
			}
		}
	}
	catch (NullPointerException e)
	{	
	}
	
}	   

  // Load student -> group data from file and store in dictionary.
  public static void loadFile(File fin, HashTable<String> studentGroup) {
     try 
    {
		Scanner scf = new Scanner(fin);
		scf.nextLine();
		while (scf.hasNextLine())
		{
			String line = scf.nextLine();
			if (line.length() > 0)
			{
				String[] parts = line.split("\\s+");
				String value = parts[1].toLowerCase(); //nome do computador
				String keys = parts[0];//nº mecanografico dos alunos
				studentGroup.set(keys, value);
			}
		}
		scf.close();
		
    }
    catch (IOException e) {
      err.printf("%s: Error: %s\n", fin, e.getMessage());
      exit(1);
    }
  }
}

