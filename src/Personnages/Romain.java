package Personnages;

public class Romain {
	private String nom;
	private int force;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert isInvariantVerified() == true;
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
		force = force - forceCoup;
		if (force < 1) {
			parler("J'abandonne");

		} else {
			parler("Aie!");

		}
		assert isInvariantVerified() == true;
	}

	private boolean isInvariantVerified() {
		if (force >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Romain minus;
		minus = new Romain("Minus", 6);
	}

}
