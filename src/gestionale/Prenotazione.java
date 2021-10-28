package gestionale;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Prenotazione implements Comparable<Prenotazione>
{
	private Cliente Cliente;
	
	private Camera Camera;
	
	private Date Arrivo;
	
	private Date Termine;
	
	public Prenotazione(Cliente cliente, Camera camera, Date arrivo, Date termine)
	{
		Cliente = cliente;
		Camera = camera;
		Arrivo = arrivo;
		Termine = termine;
	}
	
	public static long CalcolaGiorniSoggiorno(Date arrivo, Date termine)
	{
		long giorni = (arrivo.getTime() - termine.getTime()) / 86400000;	//86400000 rappresenta il valore di millisecondi al giorno
		
		return Math.abs(giorni);
	}
	
	public int compareTo(Prenotazione p)
	{
		return this.Cliente.getCognome().compareTo(p.Cliente.getCognome());
	}
	
	@Override
	public String toString()
	{
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		
		String arrivo = formatter.format(Arrivo);
		String termine = formatter.format(Termine);
		
		return "Cliente: " + Cliente + "\n Camera: " + Camera + "\n Arrivo: " + arrivo + "\n Termine: " + termine + 
				"\n Giorni permanenza: " + Prenotazione.CalcolaGiorniSoggiorno(Arrivo, Termine) + "\n" +
				"******************************************************************************************";
	}
	
	
}
