// This program should use the generic mergeSort method in p2utils.Sorting
// to sort its string arguments.

import static java.lang.System.*;
import java.util.Scanner;
import java.util.Arrays;

import static p2utils.Sorting.*; //import sorting methods

public class TestGenericSort{
	
	static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args){
	  if (args.length < 1) {
        err.println("Test sorting algorithms for an array of size N.");
        err.println("Usage: java -ea TestGenericSort  <palavras a ordenar>");
        exit(1);
      }
		//guarda o input num array
		String[] array = args;
		
		//make a copy of the array
		String[] array2 = array.clone();
		
		//sort the first n elements in the array with the homemade algorithm
		mergeSort(array, 0, array.length);
		
		//print the result
		out.println(Arrays.toString(array));
		
		//sort the second array with Java's method
		Arrays.sort(array2);
		
		//checks if everything went nicely
		assert Arrays.equals(array, array2);
	}
	
}



