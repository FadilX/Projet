package civilization;

public class Carriere extends Batiment {

	// La somme des capacités des maisons disponibles devra être supérieur au
	// nombres d'habitants, sans quoi il sera impossible de créer de nouvelles
	// unités.
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
