package civilization;

import java.util.Scanner;

public class Mines extends Buildings {

	Buildings b = new Buildings();

	// La somme des capacités des maisons disponibles devra être supérieur au
	// nombres d'habitants, sans quoi il sera impossible de créer de nouvelles
	// unités.
	public Mines() {
		super();
		batiment = "mine";
		cgold = 25;
		crock = 50;
		cwood = 50;
		cfood = 25;
		capacite = 10;
		temps = 2; // god mode


	/*public void build(Map m) {
		// il peut y avoir un bléme avec le sleep que j'ai mis, ça va bloquer
		// tous le jeu 40 secondes, on pourra rien faire tant que la
		// construction n'est pas achevée, pour arranger ça encapsules le tous
		// dans un thread,
		int i = 0;
		Scanner sc = new Scanner(System.in);
		if (Ressources.getgold() >= getcgold()
				&& Ressources.getrock() >= getcrock()
				&& Ressources.getwood() >= getcwood()
				&& Ressources.getfood() >= getcfood()) {
			System.err.println("choisissez l'emplacement de votre " + batiment);
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (m.getT()[x][y].equals("("+x+","+y+")")) {
				Ressources.setgold(-cgold);
				Ressources.setrock(-crock);
				Ressources.setwood(-cwood);
				Ressources.setfood(-cfood);
				m.setT(x, y, "construction en cours");
				Map.afficher(m);
				while (i <= gettemps()) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {
						Thread.currentThread().interrupt();
					}
					i++;
				}
				m.setT(x, y, batiment);
				m.setCap(x, y, capacite);
				Map.afficher(m);
			} else {
				System.err.println("Cette case est pleine");
			}
		} else {
			System.err.println("vous n'avez pas assez de ressources");
		}

	}
}*/
	}
}
