package Personnages;

import objects.*;

public class Romain {
	private String nom;
	private int force;
	private int nbEquipement = 0;
	private Equipement[] equipements = new Equipement[2];

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified(force) == true : "la force est positif";
	}

	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert isInvariantVerified(forceCoup): "la force du coup reçu est positif";
//		int forceAvant;
//		forceAvant = force;
//		force = forceAvant - forceCoup;
//		if (force < 1) {
//			parler("J'abandonne");
//
//		} else {
//			parler("Aie!");
//
//		}
//		assert forceAvant != force:"force a diminué";
//	}

	private boolean isInvariantVerified(int force) {
		if (force >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public void sEquiper(Equipement equipement) {
		if (nbEquipement >= 2) {
			System.out.println("Le  soldat " + getNom() + " est déjà bien protégé !");

		} else if (nbEquipement == 1) {
			if (equipements[0] == equipement) {
				System.out.println("Le  soldat " + getNom() + " possède déjà un " + equipement.toString());
			} else {
				equipements[1] = equipement;
				System.out.println("Le  soldat " + getNom() + " s'equipe avec un " + equipement.toString());
				nbEquipement++;
			}
		} else {
			equipements[0] = equipement;
			System.out.println("Le  soldat " + getNom() + " s'equipe avec un " + equipement.toString());
			nbEquipement++;
		}

	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = calculerResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		}else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		return equipementEjecte;
	}

	private int calculerResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
		
		for (int i = 0; i < nbEquipement;i++) {
		if ((equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER))) {
		resistanceEquipement += 6;
		} else {
		resistanceEquipement += 3;
		}}
		}
		if (resistanceEquipement >= forceCoup) {
			forceCoup = 0;
			texte += "\n Mais heureusement, grace à mon équipement sa force  a été complètement absorbée ";
			
		} else {
			forceCoup -= resistanceEquipement;
			texte += "\n Mais heureusement, grace à mon équipement sa force est diminué de " 
			+ resistanceEquipement + "!";

		}
		parler(texte);
		return forceCoup;
		}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
