package test_fonctionnel;

import Personnages.*;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);

		Gaulois obelix;
		obelix = new Gaulois("Obélix", 16);

		Romain minus;
		minus = new Romain("Minus", 6);
		
		Romain brutus;
		brutus = new Romain("Brutus", 14);

		Druide panoramix;
		panoramix = new Druide("Panoramix", 2);
		
		asterix.parler("Bonjour Obélix");
		obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des\r\n" + "sangliers ?)");
		asterix.parler("Oui très bonne idée.");

		System.out.println("Dans la forêt " + asterix.getNom() + " et " + obelix.getNom()
				+ " tombent nez à nez sur le romain " + minus.getNom());

		for (int i = 0; i < 3; i++) {
			asterix.frapper(minus);
		}
		Chaudron potion;
		potion = panoramix.fabriquerPotion(4,3);
		panoramix.booster(obelix);
		panoramix.booster(asterix);
		
		for (int i = 0; i < 3; i++) {
			asterix.frapper(brutus);
		}
	}

}
