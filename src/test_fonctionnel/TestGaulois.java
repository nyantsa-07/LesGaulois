package test_fonctionnel;

import Personnages.*;

public class TestGaulois {
	public static void main(String[] args) {
		Gaulois asterix;
		asterix = new Gaulois("Astérix", 8);
		
		Gaulois obelix;
		obelix = new Gaulois("Obélix", 16);
		
		asterix.parler("Bonjour Obélix");
		obelix.parler("Bonjour Astérix. Ca te dirais d'aller chasser des\r\n"
				+ "sangliers ?)");
		asterix.parler("Oui très bonne idée.");
	}
	

}
