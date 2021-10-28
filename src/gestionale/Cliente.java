package gestionale;

public class Cliente extends Persona
{
	private String Email;
	
	private String Telefono;
	
	
	public Cliente(String nome, String cognome, String email, String telefono)
	{
		super(nome, cognome);
		Email = email;
		Telefono = telefono;
	}
	
	@Override
	public String toString() {
		return this.getCognome() + " " + this.getNome() + 
				"\nContatti\n " + "Email: " + this.getEmail() + " Telefono: " + this.getTelefono() + "\n";
	}

	public String getNome() 
	{
		return super.Nome;
	}

	public String getCognome()
	{
		return super.Cognome;
	}

	public String getEmail() {
		return Email;
	}

	public String getTelefono() {
		return Telefono;
	}
}
