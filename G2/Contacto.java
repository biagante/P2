
public class Contacto {
	
	//caso contenham email
	public Contacto(String nome, String telefone, String eMail)
	{
		this.nome = nome;
		this.telefone = telefone;
		this.eMail = eMail;
	}	
	
	//caso nao contenham email 
	public Contacto(String nome, String telefone)
	{
		this.nome = nome;
		this.telefone = telefone;
	}
	
	public String eMail()
	{
		 return eMail;
	}
	
	public String telefone()
	{
		return telefone;
	}
	
	public String nome()
	{
		return nome;
	}
	
	private String nome;
	private String telefone;
	public String eMail;
}
