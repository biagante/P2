import java.io.*;

public class FindFile {
	
	public static void main (String[] args) {
		String path;
		if (args.length == 0 || args.length == 1 || args.length > 2)
		{
			System.out.println("Uso: java -ea FindFile <padrao> [<dir>]");
			System.exit(1);
		}
		
		path = args[1];
		
		File dir = new File(path);
		findFich(dir, args[0]);
	}
	
	static void findFich(File file, String pattern){
		
		if(file.isFile() && file.getName().indexOf(pattern) != -1)
		{
			System.out.println(file.getPath());
		}		
		if(file.isDirectory())
		{
			File[] dir = file.listFiles();
			for(File f : dir){
				findFich(f, pattern);
			}
		}
		else if (file.isDirectory())
		{
			System.err.printf("ERRO: O directório \"%s\" não existe!\n",file.getName());
		}
	}
}

