package gestionale;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Starter 
{
	
	public static void Menu()
	{
		System.out.println("Menu principale");
		System.out.println("Operazioni disponibili");
		System.out.println("1) Inserire nuova prenotazione");
		System.out.println("2) Visualizzare prenotazioni registrate");
		System.out.println("3) Cancellare prenotazione");
		System.out.println("4) Genera un resoconto");
		System.out.println("5) Visualizza storico clienti");
		System.out.println("6) Esci");
		System.out.print("> ");
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException, ParseException 
	{
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		Integer scelta;
		
		List<Prenotazione> Prenotazioni = new ArrayList<Prenotazione>();
		List<Cliente> Clienti = new ArrayList<Cliente>();
		
		do
		{
			Starter.Menu();
			scelta = Integer.parseInt(read.readLine());
			
			if(scelta == 1)
			{
				System.out.println("Inserimento dati cliente");
				
				String nome, cognome, email, telefono;
				Date arrivo = new Date();
				Date termine = new Date();
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				
				int numero_ospiti;
				
				do
				{
					System.out.print("Nome: ");
					nome = read.readLine();
				}while(nome.length() <= 0);
				
				do
				{
					System.out.print("Cognome: ");
					cognome = read.readLine();
				}while(cognome.length() <= 0);
				do
				{
					System.out.print("Email: ");
					email = read.readLine();
				}while(email.length() <= 0);
				do
				{
					System.out.print("Telefono: ");
					telefono = read.readLine();
				}while(telefono.length() <= 0);
				
				Cliente cliente = new Cliente(nome, cognome, email, telefono);
				
				Clienti.add(cliente);
				
				System.out.println("Inserimento dati prenotazione");
				
				do
				{
					System.out.print("Numero ospiti: ");
					numero_ospiti = Integer.parseInt(read.readLine());
				}while(numero_ospiti <= 0);
				
				Camera camera = new Camera(numero_ospiti);
				
				do
				{
					System.out.print("Arrivo (giorno/mese/anno): ");
					
					arrivo = format.parse(read.readLine());
					
					System.out.print("Termine (giorno/mese/anno): ");
					
					termine = format.parse(read.readLine());
					
					if(arrivo.compareTo(termine) >= 0)
						System.out.println("Inserimento date non corretto");
					
				}while(arrivo.compareTo(termine) >= 0);		//se la data di arrivo è "maggiore" di quella di termine errore
				
				Prenotazione nuova = new Prenotazione(cliente, camera, arrivo, termine);
				
				boolean controllo = Prenotazioni.add(nuova);
				
				if(controllo)
				{
					System.out.println("Prenotazione aggiunta correttamente\n");
				}else
				{
					System.out.println("Prenotazione non aggiunta\n");
				}
				
			}else if(scelta == 2)
			{
				
				if(Prenotazioni.size() == 0)
				{
					System.out.println("Nessuna prenotazione registrata");
				}else
				{
					System.out.println("Prenotazioni registrate (ordine alfabetico)");
					
					java.util.Collections.sort(Prenotazioni);
										
					int numero_prenotazione = 1;
					
					for(Prenotazione p : Prenotazioni)
					{
						System.out.println("Prenotazione " + numero_prenotazione);
						System.out.println(p);
						numero_prenotazione++;
					}
					
				}
			}else if(scelta == 3)
			{
				if(Prenotazioni.size() == 0)
				{
					System.out.println("Nessuna prenotazione registrata");
				}else
				{
					System.out.print("Inserire identificativo prenotazione da eliminare: ");
					
					int numero_prenotazione = Integer.parseInt(read.readLine());
					
					if(numero_prenotazione <= 0 || numero_prenotazione > Prenotazioni.size())
					{
						System.out.println("Prenotazione non trovata");
					}else
					{		
						Prenotazioni.remove(numero_prenotazione - 1);
						System.out.println("Prenotazione rimossa");
					}
				}
				
			}else if(scelta == 4)
			{
				if(Prenotazioni.size() == 0)
				{
					System.out.println("Nessuna prenotazione registrata");
				}else
				{
					
					File resoconto = new File("resoconto.txt");			
					
					FileWriter fw = new FileWriter(resoconto);
					
					for(Prenotazione p : Prenotazioni)
					{
						try
						{
							fw.append(p.toString());
							fw.append('\n');
						}catch(IOException e)
						{
							e.printStackTrace();
						}
					}
					
					fw.close();
					
					System.out.println("Resoconto generato");
				}
				
			}else if(scelta == 5)
			{
				if(Clienti.size() == 0)
				{
					System.out.println("Nessun cliente registrato");
				}else
				{
					System.out.println("Clienti hotel");
					
					for(Cliente c : Clienti)
					{
						System.out.println(c);
					}
				}
			}
			
		}while(scelta != 6);
	}

}
