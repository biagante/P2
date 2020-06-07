import static java.lang.System.*;
import java.io.IOException;
import java.io.File;
import p2utils.*;
import java.util.*;

public class CountBigrams2
{

  public static void main(String[] args) {
    HashTable<KeyValueList<Integer>> counts = new HashTable<KeyValueList<Integer>>(100000); // Usamos hash table!

    for (int a = 0; a < args.length; a++) { // Processa cada ficheiro
      File fin = new File(args[a]);
      analyseText(fin, counts); // atualiza contagens de bigramas
    }
    
    printCounts(counts);
    try
	{
		while (true)
		{
			out.print("Word? (Ctrl+D to stop) ");
			mostFrequent(counts, new Scanner(in).nextLine());
		}
	}
	catch (NoSuchElementException e) {}
  }

  // Read input text file word by word and count occurences of bigrams
  static void analyseText(File fin, HashTable<KeyValueList<Integer>> counts) {
    try {
      Scanner scf = new Scanner(fin);
      scf.useDelimiter("[^\\p{IsAlphabetic}]+");
      // ^ Isto serve para especificar que o separador de "tokens" no scanner
      // será qualquer sequência de 1 ou mais carateres não alfabéticos.
      // Assim, cada token devolvido por scf.next() é uma palavra no sentido
      // mais convencional: uma sequência composta apenas de letras!

      String prevWord = null; // serve para guardar a palavra anterior
      prevWord = scf.next();

      while (scf.hasNext()) { // Processa cada palavra
        // palavra atual: é lida do scanner e normalizada:
        String currWord = scf.next().toLowerCase();

        if (prevWord != null)
		{
			if (counts.contains(prevWord))
			{
				KeyValueList<Integer> list1 = counts.get(prevWord);
				if (list1.contains(currWord))
				{
					list1.set(currWord, (list1.get(currWord) + 1));
				}
				else
				{
					list1.set(currWord, 1);
				}
			}
			else
			{
				KeyValueList newList1 = new KeyValueList<Integer>();
				newList1.set(currWord, 1);
				counts.set(prevWord, newList1);  
			}
			prevWord = currWord;
		}
      }
      scf.close();
    }
    catch (IOException e) {
      err.printf("ERROR: %s\n", e.getMessage());
      exit(1);
    }
  }

  // Print each key (bigram) and its count
  static void printCounts(HashTable<KeyValueList<Integer>> counts) {
    String[] countKeys = counts.keys();
    Arrays.sort(countKeys);
    for (int i = 0; i < countKeys.length; i++)
	{
		out.println(countKeys[i] + " -> " + counts.get(countKeys[i]));
	}
	out.println();
  }
    
  // Find and print the key with most occurrences
  // and its relative frequency.
  static void mostFrequent(HashTable<KeyValueList<Integer>> counts, String word) {
	int count = 0;
	int max = -1;
    String mostFrequent = null;
    try
    {
		KeyValueList<Integer> list1 = counts.get(word);

		String[] countKeys = list1.keys();
		Arrays.sort(countKeys);
		for (int i = 0; i < countKeys.length ; i++)
		{
			out.println(countKeys[i]);
			int value = list1.get(countKeys[i]);
			if (value != max)
			{
				max = value;
				mostFrequent = countKeys[i];
				
			}
			count += value;
		}
		
		float frequency = 100*(float)max/(float)count;
		out.printf("After \"%s\": \n",word);
		out.println("Number of keys: " + (countKeys.length));
		out.printf("Most frequent key: \"%s\" (%d/%d = %.2f%%)\n", mostFrequent, max, count, frequency);
	}
	catch(AssertionError e)
	{
		out.printf("Word \"%s\" never ocurred!\n", word);
	}
  }
}
