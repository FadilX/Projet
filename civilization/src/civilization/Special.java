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
				.println("J'ai d�couvert les lois de l'optique, la loi universelle de la gravitation et inventer le calcul int�gral avant d'avoir 26 ans");
		System.err.println("Je suis? (Nom de famille)");
		reponse = sc.nextLine();
		if (reponse.equals("Newton")) {
			System.err.println("Felicitation vous avez d�bloqu� Isaac Newton");
			System.out.println("Vous benificiez d'un bonus de 5 or");
			bonus.setBgold(5);
		} else {
			System.err.println("Mauvaise r�ponse");
		}
	}

	public void choixSpecial2(Bonus bonus) {
		Scanner sc = new Scanner(System.in);
		String reponse;
		System.err
				.println("J'ai inventer le premier moteur �lectrique et d�couvris l'induction electromagn�tique");
		System.err.println("Je suis? (Nom de famille)");
		reponse = sc.nextLine();
		if (reponse.equals("Faraday")) {
			System.err.println("Felicitation vous avez d�bloqu� Micheal Faraday");
			System.out.println("Vous benificiez d'un bonus de 10 or et 5 nouriture");
			bonus.setBgold(10);
			bonus.setBfood(5);
		} else {
			System.err.println("Mauvaise r�ponse");
		}
	}
	public void choixSpecial3(Bonus bonus) {
		Scanner sc = new Scanner(System.in);
		String reponse;
		System.err
				.println("J'ai cr�� PayPal, Tesla Motors, SolarCity, SpaceX et je r�ve de coloniser Mars");
		System.err.println("Je suis? (Nom de famille)");
		reponse = sc.nextLine();
		if (reponse.equals("Musk")) {
			System.err.println("Felicitation vous avez d�bloqu� Elon Musk");
			System.out.println("Vous benificiez d'un bonus de 10 pour toutes les ressources");
			bonus.setBgold(10);
			bonus.setBfood(10);
			bonus.setBwood(10);
			bonus.setBrock(10);
		} else {
			System.err.println("Mauvaise r�ponse");
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
