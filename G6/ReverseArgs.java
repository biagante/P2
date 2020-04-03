import static java.lang.System.*;

public class ReverseArgs {
	
	public static void main(String[] args) {
    printArray(args, args.length);
  }
  
  /** Imprime as N primeiras strings do array, uma por linha. */
  public static void printArray(String[] array, int N) {
	  //para array vazios
	  if (array.length == 0)
	  {
		  return;
	  }
	  // Implemente de forma recursiva...
	  else
	  {
		  out.println(array[N-1]);
		  
		  int i = N-1;
		  if (i > 0)
		  {
			  printArray(array,i--);
		  }
	  }
    
  }

}

