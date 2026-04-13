package village_gaulois;
import objects.*;
import Personnages.*;
public class Musee {
	private Equipement[] trophees = new Equipement[200];
	private int  nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		trophees[nbTrophee] = equipement;
		nbTrophee ++;
	}
	
}
