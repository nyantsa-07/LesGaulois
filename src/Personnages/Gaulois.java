package Personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

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

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + "]";
	}

	public void frapper(Romain romain) {
		int forcerecu;
		forcerecu = force * effetPotion;
		System.out.println(nom + " envoie un grang coup dans la mâchoire de " + romain.getNom());
		romain.recevoirCoup(forcerecu / 3);
		if (effetPotion > 1) {
			effetPotion = effetPotion - 1;
		}

		

	}

	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
	}

	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix);

	}

}
