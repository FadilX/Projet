package civilization;

import java.util.Scanner;

/**
 * Crée un objet building, j'hésite à scinder cette classe en plusieurs classes
 * filles (caserne, maison...)
 * 
 * @author Fadil
 *
 */
public class Batiment extends Plateau {

	/**
	 * Cette fonction permet de construire un batiment, le placer et fait la MAJ
	 * des ressources
	 * 
	 * @param m
	 *            Plateau
	 * @param r
	 *            Ressources
	 */
	String batiment;
	int habitant;
	int capacite;
	int cgold;
	int crock;
	int cwood;
	int cfood;
	int temps;
	
	
	public Batiment() {
		batiment= "batiment";
		habitant = 0;
		cgold = 0;
		crock = 0;
		cwood = 0;
		cfood = 0;
		temps=0;
		
		
	}
	/**
	 * getters/setters
	 * @param a
	 */
	
	
	public void settemps(int t){
		temps=t;
	}
	public int gettemps(){
		return temps;
	}
	public void sethabitant(int a){
		habitant=a;
	}
	public int gethabitant(){
		return habitant;
	}
	public void setcapacite(int a){
		capacite=a;
	}
	public int getcapacite(){
		return capacite;
	}
	public void setcgold(int a) {
		cgold = a;
	}

	public void setcrock(int a) {
		crock = a;
	}

	public void setcfood(int a) {
		cfood = a;
	}

	public void setcwood(int a) {
		cwood = a;
	}

	public int getcgold() {
		return cgold;
	}

	public int getcfood() {
		return cfood;
	}

	public int getcwood() {
		return cwood;
	}

	public int getcrock() {
		return crock;
	}

	public void build(Plateau m) {
		int i=0;
		Scanner sc = new Scanner(System.in);
		if (Ressources.getgold() >= getcgold() && Ressources.getrock() >= getcrock()
				&& Ressources.getwood() >= getcwood() && Ressources.getfood()>=getcfood()) {
			 System.err.println("choisissez l'emplacement de votre " + batiment );
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (m.getT()[x][y].equals("("+x+","+y+")")) {
			// do while pour vérifier case libre ;)
			
			Ressources.setgold(-cgold);
			Ressources.setrock(-crock);
			Ressources.setwood(-cwood);
			Ressources.setfood(-cfood);
			m.setT(x, y, "construction en cours");
			Plateau.afficher(m);
			while(i<=gettemps()){
				try {
				    Thread.sleep(1000);                
				} catch(InterruptedException ex) {
				    Thread.currentThread().interrupt();
				}
			i++;}
			m.setT(x, y, batiment);
			m.setCap(x, y, capacite);
			Plateau.afficher(m);}
			else{System.err.println("Cette case est pleine");}
		} else {
			 System.err.println("vous n'avez pas assez de ressources");
		}

	}
	// a rajoouter les bonus que procure le batiment (sciences, philo...)

	// J'invoque ici l'objet Ressources et Plateau pour agir durant toutes la durée
	// du programme sur la même entité

	/* public void build(Plateau m) {

		System.out
				.println("Que voulez vous construire? (caserne, maison, scierie, mine, ferme)");
		Scanner sc = new Scanner(System.in);
		String B = sc.nextLine();
		switch (B) {
		case "caserne":
			if (Ressources.getgold() > 50 && Ressources.getrock() > 75
					&& Ressources.getwood() > 75) {
				System.out.println("choisissez l'emplacement de votre caserne");
				int x = sc.nextInt();
				int y = sc.nextInt();
				// do while pour vérifier case libre ;)
				// faudra écrire une méthode aussi pour alléger
				Ressources.setgold(50);
				Ressources.setrock(75);
				Ressources.setwood(75);
				m.getT()[x][y] = "caserne";
			} else {
				System.out.println("vous n'avez pas assez de ressources");
			}
			break;
		case "ferme":
			if (Ressources.getwood() > 50 && Ressources.getgold() > 25) {
				System.out.println("choisissez l'emplacement de votre ferme");
				int x = sc.nextInt();
				int y = sc.nextInt();

				Ressources.setgold(25);
				Ressources.setwood(50);
				m.getT()[x][y] = "ferme";
			} else {
				System.out.println("vous n'avez pas assez de ressources");

			}
			break;
		case "mine":
			if (Ressources.getwood() > 25 && Ressources.getgold() > 25
					&& Ressources.getrock() > 75) {
				System.out.println("choisissez l'emplacement de votre mine");
				int x = sc.nextInt();
				int y = sc.nextInt();

				Ressources.setgold(25);
				Ressources.setwood(25);
				Ressources.setrock(75);
				m.getT()[x][y] = "mine";
			} else {
				System.out.println("vous n'avez pas assez de ressources");

			}
			break;
		case "scierie":
			if (Ressources.getwood() > 75 && Ressources.getgold() > 25) {
				System.out.println("choisissez l'emplacement de votre scierie");
				int x = sc.nextInt();
				int y = sc.nextInt();

				Ressources.setgold(25);
				Ressources.setwood(75);

				m.getT()[x][y] = "scierie";
			} else {
				System.out.println("vous n'avez pas assez de ressources");

			}
			break;
		case "maison":
			if (Ressources.getwood() > 25 && Ressources.getgold() > 25
					&& Ressources.getrock() > 25) {
				System.out.println("choisissez l'emplacement de votre maison");
				int x = sc.nextInt();
				int y = sc.nextInt();

				Ressources.setgold(25);
				Ressources.setwood(25);
				Ressources.setrock(25);
				m.getT()[x][y] = "maison";
			} else {
				System.out.println("vous n'avez pas assez de ressources");

			}
			break;
		default:
			System.out.println("?");
		}

	}
*/
	/**
	 * Cette fonction invoque la fonctio build en boucle, on en aura pas besoin
	 * pour le jeu, c'était pour tester le code
	 * 
	 * @param m
	 *            Plateau
	 * @param r
	 *            Ressources
	 */

	// Pour le jeu il faudra construire une sorte de grosse boucle (qui démare
	// du début du jeu jusqu'à la fin de la partie), dans cette boucle il y'aura
	// plein de test if qui
	// renverront en fonction de ce qu'écrit l'utilisateur a une fonction donnée
	
	
	/* public void construct(Plateau m, Ressources r) {
		int c = 1;
		while (c == 1) {

			System.out.println("tapez 1 pour construire 0 sinon");
			Scanner sc = new Scanner(System.in);
			int a = sc.nextInt();
			c = a;
			if (c == 1) {
				build(m);
				afficher(m);
			} else {
				break;
			}

		}

	}*/
}

