package gestionale;

public abstract class Persona
{
	Persona(String nome, String cognome)
	{
		Nome = nome;
		Cognome = cognome;
	}
	
	protected String Nome;
	
	protected String Cognome;

	public abstract String getNome();

	public abstract String getCognome();
}
