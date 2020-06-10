import static java.lang.System.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.IOException;
import p2utils.HashTable;

public class CheckGroups
{
  static final Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    if (args.length!=1) {
      err.printf("Usage: java -ea CheckGroups Group-File\n");
      exit(1);
    }

    File fin = new File(args[0]);
    
    // Create a dictionary to store student -> group mapping
    HashTable<String> studentGroup = new HashTable<>(200);

    // Load the file and store the data in the dictionary
    loadFile(fin, studentGroup);

    // Ask for pairs of students, until EOF
    boolean finished = false;
    while(!finished) {
      try {
        out.print("Student1? ");
        String a1 = in.nextLine();
        out.print("Student2? ");
        String a2 = in.nextLine();
        
        // Now, check if a1 and a2 were in same group or not
        if (studentGroup.contains(a1) && studentGroup.contains(a2))
		{
			if (studentGroup.get(a1).equals(studentGroup.get(a2)))
			{
				out.printf("Students %s and %s WERE in the same group!\n",a1,a2);
			}
			else
			{
				out.printf("Students %s and %s were NOT in the same group!\n",a1,a2);
			}
		}
		else
		{
			out.printf("Students %s and %s were NOT in the same group!\n",a1,a2);
		}
        
        out.println();
      }
      catch(NoSuchElementException e) {
        finished = true;
      }
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

