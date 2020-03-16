import static java.lang.System.*;

public class DatasPassadas {

  public static void main(String[] args) {
    Data atual = new Data();    
    out.printf("atual.extenso() = %s\n", atual.extenso());
    
    Data natal = new Data(25, 12, 2019);
    
    out.printf("%s\n",natal.extenso());
    
    while (atual.dia() != natal.dia() || atual.mes() != natal.mes() )
	{
		natal.seguinte();
		out.printf("%s\n",natal.extenso());
	}	
			
	}
}

