package civilization;

public class Maison extends Batiment {
	// La somme des capacités des maisons disponibles devra être supérieur au
	// nombres d'habitants, sans quoi il sera impossible de créer de nouvelles
	// unités.
	public Maison() {
		super();
		batiment = "maison";
		cgold = 25;
		crock = 25;
		cwood = 25;
		cfood = 25;
		capacite = 10;
		temps = 2;// godmode

	}

	public int ftotal(Plateau m) {
		int total = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (m.getT()[i][j].equals("maison")) {
					total = total + 1;
				}
			}
		}
		return total * capacite;
	}

}
