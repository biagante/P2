import static java.lang.System.*;
import java.io.*;
import java.util.Scanner;
// import java.util.*;   // => "error: reference to LinkedList is ambiguous"
// java.util.LinkedList colide com p2utils.LinkedList!
import p2utils.*;

public class FilterLines2
{
  public static void main(String[] args) throws IOException
  {
    if (args.length != 1) {
      err.printf("Usage: java -ea FilterLines2 text-file\n");
      exit(1);
    }
    File fil = new File(args[0]);

    // Criar listas para as linhas curtas, médias e longas.
		LinkedList curtas = new LinkedList();
		LinkedList medias = new LinkedList();
		LinkedList longas = new LinkedList();

    Scanner sf = new Scanner(fil);
    // exceções poderiam ser intercetadas e mostrar mensagem de erro.
    while (sf.hasNextLine()) {
      String line = sf.nextLine();
      
      // Guardar linha na lista apropriada, consoante o tamanho.
      if (line.length() < 20)
	  {
		  curtas.addFirst(line);
	  }
	  else if (line.length() >= 20 && line.length() < 40)
	  {
		  medias.addLast(line);
	  }
	  else
	  {
		  longas.addLast(line);
	  }

    }
    sf.close();

    // Escrever conteúdo das listas...
    curtas.print();

    medias.print();

    longas.print();
  }

}
