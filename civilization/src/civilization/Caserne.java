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
		capacite=20; 
		coutGuerrier=50; // 50 de nouriture, j'ai trop la flemme d'utiliser les autres ressources
						// fait le toi pour t'entrainer.
		temps=5;//godmode
	}

	public void creeguerrier(Plateau m, Maison maison, Population p, int a) {
		if (a + p.totalpop(m, p) <= maison.ftotal(m)
				&& Ressources.getfood() >= a * coutGuerrier) {
			p.soldat = p.soldat + a;
			Ressources.setfood(-a * coutGuerrier);
		} else {
			if (a + p.totalpop(m, p) > maison.ftotal(m)) {
				System.err.println("Vous devez construire plus de maisons");
			} else {
				System.err.println("Vous n'avez pas assez de nouritture");
			}
		}

	}

	
}
