import static java.lang.System.*;
import java.util.Calendar;

public class Data {
  private int dia, mes, ano;
  
  /** Inicia esta data com o dia de hoje. */
  public Data() {
    // Aqui usamos a classe Calendar da biblioteca standard para obter a data atual.
    Calendar today = Calendar.getInstance();
    dia = today.get(Calendar.DAY_OF_MONTH);
    mes = today.get(Calendar.MONTH) + 1;
    ano = today.get(Calendar.YEAR);
  }

  /** Inicia a data a partir do dia, mes e ano dados. */
  public Data(int dia, int mes, int ano) {
    this.dia = dia;
    this.mes = mes;
    this.ano = ano;
  }
  
	public int dia()
	{
		return dia;  
	}
	
	public int mes()
	{
		return mes;
	}
	
	public int ano()
	{
		return ano;
	}
	

  /** Devolve esta data segundo a norma ISO 8601. */
  public String toString() {
    return String.format("%04d-%02d-%02d", ano, mes, dia);
  }

  /** Indica se ano é bissexto. */
  public static boolean bissexto(int ano) {
    return ano%4 == 0 && ano%100 != 0 || ano%400 == 0;
  }

  // Crie métodos para obter o dia, mes e ano da data.
  public int getAno()
  {
	  return this.ano;
  }
  public int getMes()
  {
	  return this.mes;
  }
  public int getDia()
  {
	  return this.dia;
  }

  /** Dimensões dos meses num ano comum. */
  private static final
  int[] diasMesComum = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  
  //nomes dos meses
	private static final 
	String[] nomesMes = {"janeiro","fevereiro","março","abril","maio","junho","julho","agosto","setembro","outubro","novembro","dezembro"};
	
  /** Devolve o número de dias do mês dado. */
  public static int diasDoMes(int mes, int ano) {
    int dias = 0;
    
    if (mes == 2)
	{
		dias = bissexto(ano) ? 29:28;
		//if (bissexto(ano)){dias = 29;} else {dias = 28;}
		//traditional if-else contruct can be written this way
		//ex: if(a>b){result = x;} else{result = y;}
		//other way : result = a > b ? x : y;
		//whose form is: boolean statement ? true result : false result
		return dias;
	}
	else
	{
		return diasMesComum[(mes - 1)];
	}
  }

  /** Devolve o mes da data por extenso. */
  public String mesExtenso() {
    return nomesMes[(this.mes - 1)];
  }


  /** Devolve esta data por extenso. */
  public String extenso() {
    return String.format("%2d de %s de %d",this.dia,mesExtenso(),this.ano);
  }

  /** Indica se um termo (dia, mes, ano) forma uma data válida. */
  public static boolean dataValida(int dia, int mes, int ano) {
    if (mes <1 || mes >12)
	{
		return false;
	}
	else if ((mes == 2 && bissexto(ano)) && (dia < 1 || dia > 29))
	{
		return false;
	}
	else if (dia < 1 || dia > diasMesComum[(mes+1)])
	{
		return false;
	}
	else
	{
		return true;
	}
    
  }

	
  public void seguinte() {
    if (this.dia < diasMesComum[(this.mes - 1)])
	{
		this.dia++;
	}
	else
	{
		this.dia = 1;
		if (this.mes < 12)
		{
			this.mes++;
		}
		else
		{
			this.mes = 1;
			this.ano++;
		}
	}
  }


}

