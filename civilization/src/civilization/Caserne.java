package civilization;

import java.util.Scanner;

public class Caserne extends Batiment {
	int coutGuerrier;
	Batiment b = new Batiment();
	private Scanner sc;

	public Caserne() {
		super();
		batiment = "caserne";
		cgold = 50;
		crock = 75;
		cwood = 75;
		cfood = 25;
		capacite = 20;
		coutGuerrier = 50; // 50 de nouriture, j'ai trop la flemme d'utiliser
							// les autres ressources
							// fait le toi pour t'entrainer.
		temps = 5;// godmode
	}

	public void creeguerrier(Plateau m, Maison maison, Population p, int a) {
		int b = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				if (m.getT()[i][j].equals("caserne")) {
					b = 1;
				}
			}
		}
		if (a + p.totalpop(m, p) <= maison.ftotal(m)
				&& Ressources.getfood() >= a * coutGuerrier && b == 1) {
			p.soldat = p.soldat + a;
			Ressources.setfood(-a * coutGuerrier);
			System.err.println("Les hommes sont prêts au combat");
		} else {
			if (a + p.totalpop(m, p) > maison.ftotal(m)) {
				System.err.println("Vous devez construire plus de maisons");
			} else {
				if (b == 0) {
					System.err.println("Vous devez construire une caserne");
				} else {
					System.err.println("Vous n'avez pas assez de nouritture");
				}
			}
		}

	}

}
