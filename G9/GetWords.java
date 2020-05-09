import static java.lang.System.*;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

import static p2utils.Sorting.*;

public class GetWords
{
  public static void main(String[] args) {
    if (args.length != 1) {
      err.println("Usage: java GetWords <file>");
      exit(1);
    }
    for (int i = 0; i < args.length; i++)
	{
		File fin = new File(args[0]);
		String[] words = extractWords(fin);
		mergeSort(words, 0, words.length);
		int p = 1;
		int conta = 0;
		for(int m = 0; m < words.length; m++){
			if (!words[p].equals(words[m]))
			{
				out.printf("%s\n", words[m]);
				p++;
			}
			else
			{
				conta++;
			}
		}
		out.println("Number of distinct words is: " + (p - conta - 3) );
	}
	
    
  }


  // Read words from a file, return words in an array
  static String[] extractWords(File fin) {
    try {
      // count the words
      int n = 0;
      Scanner scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
      // (words are delimited by 1 or more punctuation or whitespace char)
      while (scf.hasNext()) {
        scf.next();
        n++;
      }
      scf.close();

      // create the array
      String[] result = new String[n];

      // read the words
      int i = 0;
      scf = new Scanner(fin).useDelimiter("[\\p{Punct}\\p{Space}]+");
      while (scf.hasNext()) {
        result[i] = scf.next();
        i++;
      }
      scf.close();

      return result;
    }
    catch (IOException e) {
      err.printf("Error: %s\n", e);
      exit(1);
      return null;  // never happens...
    }
  }

}
