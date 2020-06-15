import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import pt.ua.p2utils.*;

public class Restaurante {

	static HashTable<Integer> stock = new HashTable<>(100);
	static Queue<HashTable<Integer>> queue = new Queue<HashTable<Integer>>();
	
  public static void main(String[] args) throws IOException{
    for (String arg : args)
	{
		processOrders(arg);
	}
	printStock();
	printPending();

  }

  static void processOrders(String file) throws IOException{
	  Scanner rd = new Scanner(new File(file));
	  while (rd.hasNextLine())
	  {
		  String[] line = rd.nextLine().split(" ");
		  if (line[0].equals("entrada:"))
		  {
			  if (!stock.contains(line[1]))
			  {
				  stock.set(line[1], 1);
			  }
			  else
			  {
				  stock.set(line[1], stock.get(line[1]) + 1);
			  }
		  }
		  else if (line[0].equals("saida:"))
		  {
			  HashTable<Integer> stockIn = new HashTable<>(1000);
			  for (int i = 1; i < line.length; i++)
			  {
				  String[] pedido = line[i].split(":");
				  stockIn.set(pedido[0], Integer.parseInt(pedido[1]));
			  }
			  queue.in(stockIn);
		  }		  
	  }
	  rd.close();
	  HashTable<Integer> nextOrder = queue.peek();
	  while (canBeServed(nextOrder))
	  {
		  if (!queue.isEmpty())
		  {
			  serveOrder(nextOrder);
			  out.printf("Refeicao servida: %s\n", orderToString(nextOrder));
		  }
		  nextOrder = queue.peek();
	  }	  
  }
  
  static void serveOrder(HashTable<Integer> order)
  {
	  String[] keys = order.keys();
		for(String key : keys)
		{
			stock.set(key, stock.get(key) - order.get(key));
			if (stock.get(key) == 0)
			{
				stock.remove(key);
			}
		}
		queue.out();	
  }
  
  static boolean canBeServed(HashTable<Integer> order)
  {
	  String[] keys = order.keys();
		boolean serve = true;
		for(String key : keys)
		{
			if (!stock.contains(key))
			{
				serve = false;
				break;
			}
			else if (stock.get(key) < order.get(key))
			{
				serve = false;
				break;
			}
		}
		return serve;
  }
  
  static void printStock()
  {
	  String[] keys = stock.keys();
	  out.println("Comida em stock: ");
	  for (String key : keys)
	  {
		  if (stock.get(key) > 0) 
		  {
			  out.printf(" %s: %d\n", key, stock.get(key));
		  }
	  }
  }
  
  static void printPending()
  {
	  while(!queue.isEmpty())
	  {
			out.printf("Refeição pendente: %s\n", orderToString(queue.peek()));
			queue.out();
		}
  }
  
  static String orderToString(HashTable<Integer> order)
  {
	  String result = "";
	  String[] keys = order.keys();
	  for(String key : keys)
	  {
		  result += key + ":" + order.get(key) + " ";
	  }
	  return result;
  }

}

