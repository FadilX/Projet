package civilization;

public class Forum extends Batiment {
	protected int coutVillageois;

	public Forum() {
		super();
		batiment = "Forum";
		temps = 5;// godmode
		coutVillageois = 20;

	}

	// t'as le droit de creez un certain nombre d'unit� puis de d�truire des
	// maisons, � ce moment l� tu peux avoir total< nb d'unit�es mais tu peux
	// pas en cr�er
	public void creevillageois(Plateau m, Maison maison, Population p,
			Ressources ressources, int a) {
		if (a + p.totalpop(m, p) <= maison.ftotal(m)
				&& ressources.getfood() >= a * coutVillageois) {
			p.villageois = p.villageois + a;
			ressources.setfood(-a * coutVillageois);
		} else {
			if (a + p.totalpop(m, p) > maison.ftotal(m)) {
				System.err.println("Vous devez construire plus de maisons");
			} else {
				System.err.println("Vous n'avez pas assez de nouritture");
			}
		}

	}

	public void build(Plateau m) {
		m.setT(5, 5, batiment);
		m.setCap(5, 5, capacite);
		Plateau.afficher(m);
	}

}
