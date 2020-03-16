package pt.ua.prog2;

public class Contacto2 {
	
	//caso contenham email
	public Contacto2(String nome, String telefone, String eMail)
	{
		this.nome = nome;
		this.telefone = telefone;
		this.eMail = eMail;
	}	
	
	//caso nao contenham email 
	public Contacto2(String nome, String telefone)
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
		return nome.toUpperCase();
	}
	
	private String nome;
	private String telefone;
	private String eMail;
}
