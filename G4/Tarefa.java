public class Tarefa {
	
	private Data inicio;
	private Data fim;
	private String texto = "";
	
	public Tarefa(Data inicio, Data fim, String texto){
		assert(!texto.isEmpty()) : "Texto de tarefa vazia";
		assert(inicio.compareTo(fim) < 0) : "inicio should be lower than fim";
		this.inicio = inicio;
		this.fim = fim;
		this.texto = texto;
	}
	
	public Data inicio(){
		return inicio;
	}
	public Data fim(){
		return fim;
	}
	public String texto(){
		return texto;
	}

	public String toString(){
		String in = inicio.toString();
		String f = fim.toString();
		return (in + " --- " + f + ": " + texto);
		
	}
	
	public boolean interseta(Tarefa t) {
		// compara as datas iniciais e finais das tarefas, this e t.
		//data ini e igual
		//se this.ini > t; i>0
		int i = this.inicio.compareTo(t.inicio);
		int j = this.inicio.compareTo(t.fim);
		//data fin e igual
		//se this.fin > t.fin;i>0
		int f = this.fim.compareTo(t.fim);
		int g = this.fim.compareTo(t.inicio);
		
		/*a data inicial de this esta entre a data inicial e a data final de t
		 * ou
		 * a data final de this esta entra a data inicial e a data final de t 
		 * ou
		 * a data inicial de this e menor que a de t e a data final de this e maior que a de t (t esta entre as datas inicial e final de this)
		 */
		
		if((i>=0 && j<=0) || (g>=0 && f<=0) ||(i<=0 &&f>=0)) 
		{
			return true;
		}
		else 
		{
			return false;
		} 
	}
	
}

