package Personnages;

import village_gaulois.*;
import objects.*;

public class Gaulois {
	private String nom;
//	private int force;
	private int effetPotion = 1;
	private Village village = null;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;

	}

	public int getForce() {
		return force;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}

//	@Override
//	public String toString() {
//		return "Gaulois [nom=" + nom + ", force=" + force + "]";
//	}

//	public void frapper(Romain romain) {
//		int forcerecu;
//		forcerecu = force * effetPotion;
//		System.out.println(nom + " envoie un grang coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup(forcerecu / 3);
//		if (effetPotion > 1) {
//			effetPotion = effetPotion - 1;
//		}

//	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public void sePresenter() {
		if (getVillage() == null) {
			parler(" Bonjour,je m'appelle " + getNom() + ". Je voyage de villages en villages. ");
		} else if (getVillage().getChef() == this) {
			parler(" Bonjour,je m'appelle " + getNom() + ". Je suis le chef du village: " + getVillage().getNom()
					+ ".");
		} else {
			parler(" Bonjour,je m'appelle " + getNom() + ". J'habite au village: " + getVillage().getNom() + ".");
		}

	}

	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] trophees1 = romain.recevoirCoup((force / 3) * effetPotion);
		effetPotion--;
		if (effetPotion < 1) {
			effetPotion = 1;
		}
		for (int i = 0; trophees1 != null && i < trophees1.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = trophees1[i];
		}
	}

	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);

	}

}
