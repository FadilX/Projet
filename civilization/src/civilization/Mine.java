package civilization;

import java.util.Scanner;

public class Mine extends Batiment {

	Batiment b = new Batiment();

	// La somme des capacit�s des maisons disponibles devra �tre sup�rieur au
	// nombres d'habitants, sans quoi il sera impossible de cr�er de nouvelles
	// unit�s.
	public Mine() {
		super();
		batiment = "mine";
		cgold = 25;
		crock = 50;
		cwood = 50;
		cfood = 25;
		capacite = 10;
		temps = 5;
	}

	
}

