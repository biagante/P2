import p2utils.Queue;
import p2utils.HashTable;
import static java.lang.System.*;

public class SupermarketOrdering{
	
	private int numOrders = 0;
	private Queue<Order> orders = new Queue<>();
	private HashTable<Integer> products = new HashTable<>(10);
	
	//enterOrder(order) - regista uma nova encomenda;
	public void enterOrder(Order order){
		//inserts element in queue
		orders.in(order);
		numOrders++;
		//checks previous request for the product
		if (!products.contains(order.prodName)) //if not requested, create new
		{
			products.set(order.prodName, order.quantity);
		}
		else //if exists, add requested number to request
		{
			products.set(order.prodName, products.get(order.prodName) + order.quantity);
		}
	}
	
	//serveOrder() - dá baixa da encomenda mais antiga e devolve-a;
	public Order serveOrder(){
		//stores oldest order
		Order served = orders.peek();
		//decreases the amount requested
		products.set(served.prodName, products.get(served.prodName) - served.quantity);
		
		//removes from queue
		orders.out();
		numOrders--;
		return served;
	}
	
	//displayOrders() - imprime a lista de encomendas, por ordem de chegada, e o
	//+número total de unidades encomendadas de cada produto;
	public void displayOrders(){
		out.println("List of orders: " + orders.toString());
		String[] keys = products.keys();
		out.print("Summary by product: ");
		for (int i = 0; i < keys.length ; i++)
		{
			int requested = products.get(keys[i]);
			if (requested > 0)
			{
				out.print(keys[i] + ":" + requested + " ");
			}
		}
		out.println();
	}
	
	public int numOrders(){
		return numOrders;
	}
	
	//query(product) - devolve o número de unidades de um dado produto que estão
	//pedidas nas encomendas actuais;
	private int query(String product){
		return products.get(product);	
	}
	
	
}
