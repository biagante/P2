import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import pt.ua.p2utils.*;

public class CityTraveler
{
  static HashTable<LinkedList<String>> info = new HashTable<>(20);
  
  public static void main(String[] args) throws IOException{
	  if (args.length == 0)
	  {
		  System.err.println("Usage: java -ea CityTraveler <FICH1> <FICH2> ... ");
		  System.exit(1);
	  }
	  for (String city : args)
	  {
		  Scanner rd = new Scanner(new File(city));
		  while (rd.hasNextLine())
		  {
			  String pessoa = rd.nextLine();
			  if (!info.contains(pessoa))
			  {
				  LinkedList<String> list = new LinkedList<String>();
				  list.addLast(city);
				  info.set(pessoa, list);
			  }
			  else
			  {
				  LinkedList<String> list = info.get(pessoa);
				  list.addLast(city);
				  info.set(pessoa, list);
			  }
		  }
	  }
	  printInfo();	  	  
  }
  
  static void printInfo()
  {
	  String[] keys = info.keys();
	  for (String name : keys)
	  {
		  out.printf("%-15s: %s\n", name, info.get(name).toString(""," ",""));
	  }
	  
  }
}

