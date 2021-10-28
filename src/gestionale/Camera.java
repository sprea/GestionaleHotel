package gestionale;

public class Camera 
{
	private int Ospiti;
	
	private int Tariffa;
	
	public Camera(int ospiti)
	{
		Ospiti = ospiti;
		if(Ospiti >= 1 && Ospiti <= 2)
		{
			Tariffa = 30;
		}else if(Ospiti > 2 && Ospiti < 5)
		{
			Tariffa = 80;
		}else
		{
			Tariffa = 100;
		}
	}

	public int getOspiti() {
		return Ospiti;
	}

	public int getTariffa() {
		return Tariffa;
	}

	@Override
	public String toString() {
		return "Ospiti: " + Ospiti + ", Tariffa: " + Tariffa + "€";
	}
	
	
}
