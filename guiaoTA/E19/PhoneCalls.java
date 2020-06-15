import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import pt.ua.p2utils.*;

public class PhoneCalls
{
	static HashTable<KeyValueList> calls = new HashTable<>(1000);
	static HashTable<String> hash = new HashTable<>(1000);
	
  public static void main(String[] args) throws IOException{
	  for (String arg : args)
	  {
		  if (arg.contains(".nms"))
		  {
			  Scanner rd = new Scanner(new File(arg));
			  while (rd.hasNextLine())
			  {
				  String[] line = rd.nextLine().split(" ");
				  hash.set(line[0], line[1] + " " + line[2]);
				  //número + nome(1º + apelido)
			  }
		  }
		  else if (arg.contains(".cls"))
		  //nº de origem, nº de destino, tempo da chamada
		  {
			  Scanner scf = new Scanner(new File(arg));
			  while (scf.hasNextLine())
			  {
				  String[] line = scf.nextLine().split(" ");
				  String origem = line[0];
				  String destino = line[1];
				  if (hash.contains(line[0]))
				  {
					  origem = hash.get(line[0]);
				  }
				  if (hash.contains(line[1]))
				  {
					  destino = hash.get(line[1]);
				  }
				  if (calls.contains(line[0]))
				  {
					  KeyValueList<String> list = calls.get(line[0]);
					  list.set(line[2], line[1]);
					  calls.set(line[0], list);
				  }
				  else
				  {
					  KeyValueList<String> list = new KeyValueList<>();
					  list.set(line[2], line[1]);
					  calls.set(line[0], list);
				  }
				  out.printf("%s to %s (%s seconds)\n", origem,destino, line[2]);
			  }
		  }
		  else
		  {
			  printCallsMadeBy(arg);
			  printCallsMadeTo(arg);
		  }
	  }
  }
  
  static void printCallsMadeBy(String number)
  {
	  String name = number;
	  if (hash.contains(number));
	  {
		  name = hash.get(number);
	  }
	  out.println("\nCalls made by " + name + ":");
	  if (calls.contains(number))
	  {
		  KeyValueList<String> list = calls.get(number);
		  String[] keys = list.keys();
		  for (String k : keys)
		  {
			  String destino = list.get(k);
			  if (hash.contains(destino))
			  {
				  destino = hash.get(destino);
			  }
			  out.printf(" - to phone %s (%s seconds)\n", destino, k);
		  }
	  }
  }
  
  static void printCallsMadeTo(String number){
	  String name = number;
	  if (hash.contains(number))
	  {
		  name = hash.get(number);
	  }
	  out.println("\nCalls made to " + name + ":");
	  String[] allKeys = calls.keys();
	  for(String origem : allKeys)
	  {
		  if (calls.contains(origem))
		  {
			  KeyValueList<String> list = calls.get(origem);
			  String[] keys = list.keys();
			  for (String s: keys)
			  {
				  String destino = list.get(s);
				  if (destino.equals(number))
				  {
					  String pessoa = origem;
					  if (hash.contains(origem))
					  {
						  pessoa = hash.get(origem);
					  }
					  out.printf("  - from phone %s (%s seconds)\n", pessoa, s);
				  }
			  }
			  
		  }
	  }
  }

}

