package village_gaulois;
import objects.*;
import Personnages.*;
public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int  nbTrophee = 0;

	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee tropheeSeul ;
		tropheeSeul = new Trophee(gaulois, equipement);
		trophees[nbTrophee] = tropheeSeul ;
		nbTrophee ++;
	}

	public String extraireInstructionsOCaml() {
		String texte = "let musee = [ \n";
		for (int i = 0; i < nbTrophee - 1; i++) {
			texte += "    \"" + trophees[i].getGaulois().getNom() + " \",  \"" 
		+ trophees[i].getEquipement().toString() + "\" ;\n" ;
		}
		texte += "    \"" + trophees[nbTrophee - 1].getGaulois().getNom() + " \",  \"" +
		trophees[nbTrophee - 1].getEquipement().toString() + "\" \n ]";
		return texte;
	}
	
}
