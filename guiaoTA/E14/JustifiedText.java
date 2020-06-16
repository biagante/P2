import static java.lang.System.*;
import java.util.Scanner;
import java.io.*;
import pt.ua.p2utils.*;

public class JustifiedText{
	public static void main(String[] args) throws IOException{
		if(args.length != 2){
			err.println("Usage: java -ea JustifiedText <NUM-COLUMNS> <FILE>");
			exit(1);
		}
		int n = -1;
		try{
			n = Integer.parseInt(args[0]);
		}catch(NumberFormatException e){
			err.print("ERROR: argument "+args[0]+" is not an integer number!");
			exit(1);
		}
		Scanner scf = new Scanner(new File(args[1]));
		String text = "";
		Queue<String> queue = new Queue<>();
		
		while(scf.hasNextLine())
		{
			String line = scf.nextLine();
			if(line.length() != 0)
			{
				Scanner lineScanner = new Scanner(line);
				while(lineScanner.hasNextLine())
				{
					String word = lineScanner.next();
					queue.in(word);
				}
			}else
				queue.in("\n");
		}
		String currentLine = "";
		String next = "";
		while(!queue.isEmpty()){
			next = queue.peek();
			int numNewChars = 1 + next.length();
			int numChars = currentLine.length() + numNewChars;
			if(next != "\n"){
				if(numChars <= n){ //If the word fits in the line
					currentLine += " " + next;
					currentLine = currentLine.trim();
				}else{ //If the word doesn't fit in the line. Resets all variables
					text += insertSpaces(currentLine, n) + "\n";
					currentLine = next;
				}
			}else{
				text += currentLine + "\n\n";
				currentLine = "";
			}
			if(queue.size() == 1){
				text += currentLine; 
			}
			queue.out();
		}
		out.println(text);
	}
	
	static String insertSpaces(String s, int n){ 
		String result = "";
		s = s.trim();
		int numWords = s.split(" ").length;
		int spaces = n - s.length(); 
		float averageSpaces = (float)spaces/(float)(numWords-1); 
		int numSpaces = (int)averageSpaces; 
		int excess = (int)((averageSpaces - numSpaces) * (numWords-1)); 
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == ' ')
			{ 
				for(int j = numSpaces; j > 0; j--){
					result += " ";
				}
				if(excess > 0){
					result += " ";
					excess--;
				}
			}
			result += s.charAt(i);
		}
		return result;
	}

}
