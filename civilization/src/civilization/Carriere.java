package civilization;

public class Carriere extends Batiment {

	// La somme des capacit�s des maisons disponibles devra �tre sup�rieur au
	// nombres d'habitants, sans quoi il sera impossible de cr�er de nouvelles
	// unit�s.
	public Carriere() {
		super();
		batiment = "carriere";
		cgold = 25;
		crock = 50;
		cwood = 25;
		cfood = 25;
		capacite = 10;
		temps = 5;
	}

}
