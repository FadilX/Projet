package civilization;

import java.util.Scanner;

public class Scierie extends Buildings {

	Buildings b = new Buildings();

	// La somme des capacités des maisons disponibles devra être supérieur au
	// nombres d'habitants, sans quoi il sera impossible de créer de nouvelles
	// unités.
	public Scierie() {
		super();
		batiment = "scierie";
		cgold = 25;
		crock = 2;
		cwood = 50;
		cfood = 25;
		capacite = 10;
		temps = 2;//godmode
	}

	

}
