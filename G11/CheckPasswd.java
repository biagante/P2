import p2utils.*;
import java.util.*;
import java.io.*;
import static java.lang.System.*;

public class CheckPasswd {
	
	public static void main (String[] args) throws IOException {
		if (args.length != 1)
		{
			out.println("Usage: java -ea CheckPasswd <password file>");
			exit(1);
		}
		
		Scanner scfile = new Scanner(new File(args[0]));
		KeyValueList<String> loginInfo = new KeyValueList<String>();
		while(scfile.hasNext())
		{
			loginInfo.set(scfile.next(), scfile.next());
		}
		
		Scanner read = new Scanner(System.in);
		do
		{
			try
			{
				out.print("Username: ");
				String username = read.nextLine();
				out.print("Password: ");
				String pass = read.nextLine();
				if (loginInfo.contains(username) && loginInfo.get(username).equals(pass))
				{
					out.println("Authentication successful\n");
				}
				else
				{
					out.println("Authentication failed\n");
				}
			}
			catch (Exception e)
			{
				exit(2);
			}
			out.print("Username: ");
			String username = read.nextLine();
			out.print("Password: ");
			String pass = read.nextLine();
			if (loginInfo.contains(username) && loginInfo.get(username).equals(pass))
			{
				out.println("Authentication successful\n");
			}
			else
			{
				out.println("Authentication failed\n");
			}
			
		} while (true); //ends/is broken by end of file(EOF)
		
	}
}

