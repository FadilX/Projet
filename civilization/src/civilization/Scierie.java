package civilization;

import java.util.Scanner;

public class Scierie extends Buildings {

	Buildings b = new Buildings();

	// La somme des capacit�s des maisons disponibles devra �tre sup�rieur au
	// nombres d'habitants, sans quoi il sera impossible de cr�er de nouvelles
	// unit�s.
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
