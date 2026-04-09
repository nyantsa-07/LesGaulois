package Personnages;
import objects.*;
public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement[] tab = new Equipement[2];

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified(force) == true:"la force est positif";
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public void recevoirCoup(int forceCoup) {
		assert isInvariantVerified(forceCoup): "la force du coup reçu est positif";
		int forceAvant;
		forceAvant = force;
		force = forceAvant - forceCoup;
		if (force < 1) {
			parler("J'abandonne");

		} else {
			parler("Aie!");

		}
		assert forceAvant != force:"force a diminué";
	}

	private boolean isInvariantVerified(int force) {
		if (force >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public void sEquiper(Equipement equipement) {
		if (nbEquipement >= 2) {
			System.out.println("Le  soldat " + getNom()+" est déjà bien protégé !");
			
		}else if(nbEquipement == 1) {
			if (tab[0] == equipement) {
				System.out.println("Le  soldat " + getNom()+" possède déjà un " + equipement.toString());
			} else {
				tab[1] = equipement;
				System.out.println("Le  soldat " + getNom()+" s'equipe avec un " + equipement.toString());
				nbEquipement ++;
			}
		} else {
			tab[0] = equipement;
			System.out.println("Le  soldat " + getNom()+" s'equipe avec un " + equipement.toString());
			nbEquipement ++;
		}
		
	}

	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
		for (Equipement equipement : Equipement.values()) {
			System.out.println("- " + equipement);
		}
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.BOUCLIER);
	}

}
