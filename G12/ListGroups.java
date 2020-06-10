import static java.lang.System.*;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.File;
import java.io.IOException;
import p2utils.HashTable;

public class ListGroups
{
  static final Scanner in = new Scanner(System.in);

  public static void main(String[] args) {
    if (args.length!=1) {
      err.printf("Usage: java -ea ListGroups Group-File\n");
      exit(1);
    }

    File fin = new File(args[0]);
    
    // Create a dictionary to store student -> group mapping
    HashTable<String> studentGroup = new HashTable<>(200);

    // Load the file and store the data in the dictionary
    loadFile(fin, studentGroup);

    // will print the info on file until EOF
    //format->  "room: [nºmec,nºmec]
    String[] salas = studentGroup.keys();
    for (int i = 0; i < salas.length; i++)
	{
		out.printf("%s: [%s]\n", salas[i], studentGroup.get(salas[i]));
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
			String[] parts = scf.nextLine().split("\\s+");
			if (studentGroup.contains(parts[1]))
			{
				studentGroup.set(parts[1], studentGroup.get(parts[1]) + ", " + parts[0]);
			}
			else
			{
				studentGroup.set(parts[1], parts[0]);
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

