package civilization;

/**
 * Classes des ressources, je ne vois pas l'utilit�e de scinder cette classe en
 * plusieurs classes filles.
 */
public class Ressources extends Buildings {
	protected static double gold;
	protected static double rock;
	protected static double food;
	protected static double wood;

	public Ressources() {
		//godmode
		gold = 500; 
		rock =500;
		food = 500;
		wood = 500;

	}

	// Rien de sp�cial, des geters & seters pour rendre cette classe plus...
	// classe
	public static double getgold() {
		return gold;

	}

	public static double getrock() {
		return rock;

	}

	public static double getwood() {
		return wood;

	}

	public static double getfood() {
		return food;
	}

	public static void setfood(double a) {
		food = food + a;

	}

	public static void setwood(double a) {
		wood = wood + a;
	}

	public static void setrock(double a) {
		rock = rock + a;
	}

	public static void setgold(double a) {
		gold = gold + a;
	}

	// Methode qui permet l'incr�mentation des ressources... avec le temps
	// cette methode d�pends du temps de la taskforce et je rajouterais plustard
	// la technologie et �volutions...
	// L� aussi il faut travailler avec des threads
	// bonus est une variable qui d�pend de la nb[][] affect� au batiment qui
	// r�colte la dite ressource, et de la techno;
	// Il y'a un probl�me ici, je ne sais pas encore comment tuer une Thread,
	// j'ai des id�es pour des m�thdes bourines mais y doit avoir une methode
	// faite pour
	public static void incRessource(Bonus bonus) {

		new Thread() {

			public void run() {

				int t = 0;

				while (t == 0) {
					
					// pour tuer if(parametre controler depuis le main){
						//t=1;}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("erreur");
					}
					setgold(1 + bonus.getBgold());
					setrock(1 + bonus.getBrock());
					setwood(1 + bonus.getBwood());
					setfood(1 + bonus.getBfood());

					System.out.print("gold:");
					affichRessource(getgold());
					System.out.print(" rock:");
					affichRessource(getrock());
					System.out.print(" food:");
					affichRessource(getfood());
					System.out.print(" wood:");
					affichRessource(getwood());
				}

			}
		}.start();
	}

	public static void affichRessource(double a) {
		System.out.print(a);
	}

	public static void main(String[] args) {
		Bonus b = new Bonus();
		incRessource(b);
	}

}
