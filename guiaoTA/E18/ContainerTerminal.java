 
import static java.lang.System.*;

public class ContainerTerminal {
  ContainerStack[] sa;    // the stacks of containers
  int num;  // number of parallel stacks of containers
  int max;  // maximum height of each stack of containers
  int numcontainers;  // number of containers on the terminal
  
  public ContainerTerminal(int num, int max) {
    sa = new ContainerStack[num];
    for (int k = 0; k < num; k++) {
      sa[k] = new ContainerStack(max);
    }
    this.num = num;
    this.max = max;
    numcontainers = 0;
  }
  
  /**
   * Is the terminal full?
   * A full terminal must still have enough free space to enable
   * retrieving any given container.
   */
  public boolean isFull() {
    return numcontainers >= num*max - max;
  }
  
  /**
   * Checks if a container of a certain type exists
   */
  public boolean containerTypeExists(String type) {
    return findStackContaining(type) >= 0;
  }

  
  /**
   * Find first stack with free space, other than the stackToAvoid.
   * @return the index of the found stack
   */
  private int findOtherStack(int stackToAvoid) {
    assert !isFull();
    int k = 0;
    while (k==stackToAvoid || sa[k].isFull()) {
      k++;
    }
    return k;
  }
  
  /**
   * Find a stack that includes a container with a given type of cargo
   * @return the index of the found stack, or -1 if no such cargo exists.
   */
  private int findStackContaining(String type) {
    int k = 0;
    while (k < num) {
      if (sa[k].search(type) >= 0) return k;
      k++;
    }
    return -1;
  }
  
  public void print() {
    out.printf("Terminal numcontainers=%d isFull=%s\n",
                      numcontainers, isFull());
    for (int k = 0; k < num; k++) {
      out.printf("%2d: %s\n", k, sa[k].toString());
    }
  }

  // Log: historical log of retrieved containers: it's a linked list
  HistoryNode log;

  private void logContainerInfo(Container c) {
    HistoryNode n = new HistoryNode();
    //n.type = c.type();
    n.numops = c.numops();
    n.next = log;
    log = n;
  }
  
  //funcao store(container)
  public void store(Container c){
	  assert !isFull();
	  for (int i = 0; i < num; i++)
	  {
		  if (!sa[i].isFull())
		  {
			  sa[i].push(c);
			  break;
		  }
	  }
	  numcontainers++;	  
  }
  
  //funcao retrieve(type)
  public Container retrieve(String type){
	  Container c = null;
	  int index = findStackContaining(type);
	  ContainerStack stack = sa[index];
	  if (index != -1)
	  {
		  int numAbove = stack.search(type);
		  if (numAbove > 0)
		  {
			  for (int i = 1; i <= numAbove; i++)
			  {
				  Container container = stack.top();
				  stack.pop();
				  for (int j = index; i < num; i++)
				  {
					  ContainerStack temp = sa[findOtherStack(j)];
					  if (!temp.isFull())
					  {
						  temp.push(container);
						  break;
					  }
				  }				  
			  }			  
		  }
		  c = stack.top();
		  stack.pop();
		  logContainerInfo(c);
		  numcontainers--;
	  }
	  return c;
  }
  
  public double averageOpsPerContainer(){
		double[] count = averageOpsPerContainer(log, new double[2]);
		return (double)count[0]/count[1];
	}
	
	private double[] averageOpsPerContainer(HistoryNode n, double[] a){
		if(n==null)return a;
		else{
			a[0] += n.numops;
			a[1]++;
			return averageOpsPerContainer(n.next, a);
		}
	}

}

