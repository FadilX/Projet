package civilization;

public class Scierie extends Batiment {
	// La somme des capacités des maisons disponibles devra être supérieur au
	// nombres d'habitants, sans quoi il sera impossible de créer de nouvelles
	// unités.
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
