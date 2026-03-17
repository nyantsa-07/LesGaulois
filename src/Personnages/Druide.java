package Personnages;

public class Druide {
	private String nom;
	private int force;

	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;

	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}

	public Chaudron fabriquerPotion(int quantite, int forcePotion) {
		Chaudron potion;
		potion = new Chaudron(quantite, forcePotion);
		potion.remplirChaudron(quantite, forcePotion);
		parler("J'ai concocté " + quantite + " doses de potion magique. " + "Elle a une force de " + forcePotion + ".");
		return potion;
	}

	public void booster(Gaulois gaulois, Chaudron potion) {
		String nom_g;
		nom_g = gaulois.getNom();		
		if (potion.resterPotion()) {
			if (nom_g == "Obélix") {
				parler("Non, " + nom_g + " Non! .... et tu le sais très bien!");
			} else {
				gaulois.boirePotion(potion.prendreLouche());
				parler("Tiens " + nom_g + " un peu de potion magique");
			}
		} else {
			parler("Désolé, " + nom_g + " il n'y a plus une seule goutte de potion");
		}
	}

}
