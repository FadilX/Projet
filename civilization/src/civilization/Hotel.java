package civilization;

import java.util.Scanner;

public class Hotel extends Buildings {
	int coutVillageois;

	Buildings b = new Buildings();

	public Hotel() {
		super();
		batiment = "Hotel De Ville";
		temps = 2;// godmode
		coutVillageois = 20;

	}

	// t'as le droit de creez un certain nombre d'unit� puis de d�truire des
	// maisons, � ce moment l� tu peux avoir total< nb d'unit�es mais tu peux
	// pas en cr�er
	public void creevillageoi(Map m, Maison maison, People p, int a) {
		if (a + p.totalpop(m, p) <= maison.ftotal(m)
				&& Ressources.getfood() >= a * coutVillageois) {
			p.worker = p.worker + a;
			Ressources.setfood(-a * coutVillageois);
		} else {
			if (a + p.totalpop(m, p) > maison.ftotal(m)) {
				System.err.println("Vous devez construire plus de maisons");
			} else {
				System.err.println("Vous n'avez pas assez de nouritture");
			}
		}

	}

	public void build(Map m) {
		m.setT(5, 5, batiment);
		m.setCap(5, 5, capacite);
		Map.afficher(m);
	}

}
