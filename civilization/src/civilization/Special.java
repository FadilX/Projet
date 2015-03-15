package civilization;

import java.util.Scanner;

/**
 * 
 * @author Fadil Classe Easter Egg :)
 */
public class Special {

	public void choixSpecial1(Bonus bonus) {
		Scanner sc = new Scanner(System.in);
		String reponse;
		System.err
				.println("J'ai découvert les lois de l'optique, la loi universelle de la gravitation et inventer le calcul intégral avant d'avoir 26 ans");
		System.err.println("Je suis? (Nom de famille)");
		reponse = sc.nextLine();
		if (reponse.equals("Newton")) {
			System.err.println("Felicitation vous avez débloqué Isaac Newton");
			System.out.println("Vous benificiez d'un bonus de 5 or");
			bonus.setBgold(5);
		} else {
			System.err.println("Mauvaise réponse");
		}
	}

	public void choixSpecial2(Bonus bonus) {
		Scanner sc = new Scanner(System.in);
		String reponse;
		System.err
				.println("J'ai inventer le premier moteur électrique et découvris l'induction electromagnétique");
		System.err.println("Je suis? (Nom de famille)");
		reponse = sc.nextLine();
		if (reponse.equals("Faraday")) {
			System.err.println("Felicitation vous avez débloqué Micheal Faraday");
			System.out.println("Vous benificiez d'un bonus de 10 or et 5 nouriture");
			bonus.setBgold(10);
			bonus.setBfood(5);
		} else {
			System.err.println("Mauvaise réponse");
		}
	}
	public void choixSpecial3(Bonus bonus) {
		Scanner sc = new Scanner(System.in);
		String reponse;
		System.err
				.println("J'ai créé PayPal, Tesla Motors, SolarCity, SpaceX et je rêve de coloniser Mars");
		System.err.println("Je suis? (Nom de famille)");
		reponse = sc.nextLine();
		if (reponse.equals("Musk")) {
			System.err.println("Felicitation vous avez débloqué Elon Musk");
			System.out.println("Vous benificiez d'un bonus de 10 pour toutes les ressources");
			bonus.setBgold(10);
			bonus.setBfood(10);
			bonus.setBwood(10);
			bonus.setBrock(10);
		} else {
			System.err.println("Mauvaise réponse");
		}
	}
	public void Cspecial(Age age, Bonus bonus){
		switch(age.getNage()){
		case 2:
			choixSpecial1(bonus);
			break;
		case 3:
			choixSpecial2(bonus);
			break;
		case 4:
			choixSpecial3(bonus);
		}
	}
	
}
