
import static java.lang.System.*;
import p2utils.*;

public class TestSortedList
{
  // Apresenta
  // * os números dados na linha de comando por ordem crescente;
  // * os restantes argumentos por ordem lexicográfica.  (FALTA FAZER!)
  // Utiliza duas listas ordenadas para fazer isto.

  public static void main(String[] args) {
    // Uma lista para os números:
    SortedList<Double> numbers = new SortedList<Double>();
    // Outra lista para as restantes strings:
    SortedList<String> strings = new SortedList<String>();

    for (int i=0; i<args.length; i++) {
	  try
	  {
      // Converte args[i] para número e guarda na lista:
      numbers.insert( Double.parseDouble(args[i]) );
	  }
	  catch(NumberFormatException e)
	  {
      // Caso não seja número, guardar args[i] noutra lista:
      strings.insert(args[i]);
      }
    }

    // Escrever a lista dos números (destruindo-a):
    out.printf("Numbers (%b):\n", numbers.isSorted());
    while (!numbers.isEmpty()) {
      out.println(numbers.first());
      numbers.removeFirst();
    }
    // Escrever a lista do resto:
    out.printf("Rest (%b): \n", strings.isSorted());
    while(!strings.isEmpty())
    {
		out.println(strings.first());
		strings.removeFirst();
	}
  }
  
  // Check if program is being run with -ea, exit if not.
  static {  // A static block. Cool!
    boolean ea = false;
    assert ea = true; // assert with a side-effect, on purpose!
    if (!ea) 
    {
      err.println("Usage: java -ea SortInts file1 ...");
      exit(1);
    }
}
}

