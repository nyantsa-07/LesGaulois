package Personnages;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;

	public Chaudron(int quantitePotion, int forcePotion) {
		this.quantitePotion = quantitePotion;
		this.forcePotion = forcePotion;
	}

	public boolean resterPotion() {
		if (quantitePotion == 0) {
			return false;
		} else {
			return true;
		}

	}

	public void remplirChaudron(int quantite, int forcePotion) {
		quantitePotion = quantite;
		this.forcePotion = forcePotion;
	}

	public int prendreLouche() {
		if (quantitePotion == 0) {
			forcePotion = 0;
		}
		quantitePotion = quantitePotion - forcePotion;
		return forcePotion;
	}
}
