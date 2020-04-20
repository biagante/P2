import static java.lang.System.*;
import java.io.File;

import p2utils.LinkedList;

public class ListRec2 {

  public static void main(String[] args) {
    if (args.length != 1) {
      err.println("Uso: java -ea ListRec2 <dir>");
      exit(1);
    }

    File dir = new File(args[0]);

    // Verificar entrada
    if (!dir.exists()) {
      err.printf("ERRO: %s nao existe!\n", dir);
      exit(2);
    }

    LinkedList<File> files = recListFiles(dir);
    files.print();
  }

  /** Devolve uma lista com o conteúdo de um directório f
   *  e de todos os seus subdirectórios recursivamente.
   */
  public static LinkedList<File> recListFiles(File f) {
    return recListFiles(new LinkedList<File>(), f);
  }
  
  private static LinkedList<File> recListFiles(LinkedList<File> flist, File f)
  {
	  if (f.isDirectory()) //se for dir continua à procura de mais subdir
	  {
		  flist.addLast(f); //addiciona dir à lista
		  File[] dir = f.listFiles();
		  for (File file: dir)
		  {
			  recListFiles(flist, file); // repete a procura
		  }
		  
	  }
	  else //se chegar a este ponto, é um ficheiro
	  {
		  flist.addLast(f); //adiciona-o à lista
	  }
	  
	  return flist; //retorna a LinkedList criada
  }
}
