package civilization;

import java.util.Scanner;

/**
 *
 * @author Fadil Voilà la tant attendue phase attaque déffense On laissera le
 *         choix au joueur: payer ou se battre
 */
public class Attaque {
	private int vague;
	private int end=0;
	Temps temps = new Temps();
	Ressources ressources = new Ressources();

	public Attaque() {
		vague = 1;
	}
public int getEnd(){
	return end;
}
public void setEnd(int end){
	this.end=end;
}
	public int getVague() {
		return vague;
	}

	public void setVague(int vague) {
		this.vague = vague;
	}

	public void clash(Population Population) {
		System.err
				.println("TOUOOOOOOOO, TOUTUOUTOUTOUTROUROUROU (corne de guerre :/");
		System.out.println("En avant!! SUs à l'ennemi!");
		if (Population.getWarrior() < getVague() * 8) {
			System.err.println("Vous avez perdu la guerre");
			setEnd(1);
			
		} else {
			System.err
					.println(" Vous avez terrasé l'ennemi ! Vous êtes venez à bout de la "
							+ getVague() + " Vague");
			setVague(getVague() + 1);
		}

	}

	public void go(Population Population) {
		Scanner sc = new Scanner(System.in);

		// wait...

		System.err
				.println("Etrangers!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
						+ " Votre ville est encerclée, payez" +400*getVague()+ "Or, ou subbissez notre COUROU!");
		System.err.println("tapez 1 pour payer, 0 sinon");
		int a = sc.nextInt();
		if (a == 1) {
			if (ressources.getgold() >= 400*getVague()) {
				ressources.setgold(-400*getVague());
				System.err.println("Trés bien vous vivrez pour cette fois...");
			} else {
				System.err
						.println("Vous n'avez pas assez d'or, vous êtes contraint d'attaquer... Brace Yourself");
				// fonction attaque
				clash(Population);
			}

		} else {
			clash(Population);
		}

	}
}
