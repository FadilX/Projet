package civilization;

public class Scierie extends Batiment {
	// La somme des capacit�s des maisons disponibles devra �tre sup�rieur au
	// nombres d'habitants, sans quoi il sera impossible de cr�er de nouvelles
	// unit�s.
	public Scierie() {
		super();
		batiment = "scierie";
		cgold = 25;
		crock = 25;
		cwood = 50;
		cfood = 25;
		capacite = 10;
		temps = 5;// godmode
	}

}
