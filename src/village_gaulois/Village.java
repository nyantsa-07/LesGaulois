package village_gaulois;

import Personnages.*;

public class Village {
	private String nom;
	private Gaulois chef;
	private int nbVillageois = 0;
	private int nbVillageoisMax;
	private Gaulois[] villageois ;
	

	public Village(String nom, Gaulois chef, int nbVillageoisMax) {
		super();
		this.nom = nom;
		this.chef = chef;
		chef.setVillage(this);
		this.nbVillageoisMax = nbVillageoisMax;
		this.villageois = new Gaulois[nbVillageoisMax];
	}

	public String getNom() {
		return nom;
	}

	public Gaulois getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois >= nbVillageoisMax) {
			System.out.println("Le village est plein");
		} else {
			villageois[nbVillageois] = gaulois;
			gaulois.setVillage(this);
			nbVillageois++;
		}
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois > nbVillageois) {
			System.out.println("Il n’y a pas autant d’habitants dans notre village !");
			return null;
		} else {
			return villageois[numVillageois - 1];
		}
	}
	
	public void afficherVillage() {
		System.out.println("Dans le village \""+ getNom() + "\" du chef "+ getChef().getNom() 
				+ " vivent les légendaires gaulois :");
		for (int i = 0; i<nbVillageois;i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Gaulois abraracourcix;
		Gaulois asterix;
		Gaulois doublepolemix;
		Gaulois obelix;
		Village village;
		abraracourcix = new Gaulois("Abraracourcix", 6);
		asterix = new Gaulois("Astérix", 8);
		obelix =  new Gaulois("Obélix", 25);
		doublepolemix = new Gaulois("Doublepolémix", 4);
		village = new Village("Village des Irréductibles", abraracourcix, 30);
		village.trouverVillageois(30);
		village.ajouterVillageois(asterix);
		village.ajouterVillageois(obelix);
		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);
		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);
		village.afficherVillage();
		asterix.sePresenter();
		abraracourcix.sePresenter();
		doublepolemix.sePresenter();

	}

}
