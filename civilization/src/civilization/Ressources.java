package civilization;

/**
 * Classes des ressources, je ne vois pas l'utilitée de scinder cette classe en
 * plusieurs classes filles.
 */
public class Ressources extends Batiment {
	protected static double Or;
	protected static double Pierre;
	protected static double Nourriture;
	protected static double Bois;

	public Ressources() {
		
		Or = 500; 
		Pierre =500;
		Nourriture = 500;
		Bois = 500;

	}

	public static double getgold() {
		return Or;

	}

	public static double getrock() {
		return Pierre;

	}

	public static double getwood() {
		return Bois;

	}

	public static double getfood() {
		return Nourriture;
	}

	public static void setfood(double a) {
		Nourriture = Nourriture + a;

	}

	public static void setwood(double a) {
		Bois = Bois + a;
	}

	public static void setrock(double a) {
		Pierre = Pierre + a;
	}

	public static void setgold(double a) {
		Or = Or + a;
	}

	// Methode qui permet l'incrémentation des ressources avec le temps et en fonction de la main d'oeuvre affectée par batiment
	// Là aussi il faut travailler avec des threads
	// bonus est une variable qui dépend de la nb[][] affecté au batiment qui
	// récolte la dite ressource, et de la techno;
	// Il y'a un problème ici, je ne sais pas encore comment tuer une Thread,
	// j'ai des idées pour des méthdes bourines mais y doit avoir une methode
	// faite pour
	public static void incRessource(Bonus bon) {

		new Thread() {

			public void run() {

				int t = 0;

				while (t == 0) {
					
					// pour tuer if(paramètre controlé depuis le main){
						//t=1;}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("erreur");
					}
					setgold(5 + bon.getBgold());
					setrock(5 + bon.getBrock());
					setwood(5 + bon.getBwood());
					setfood(5 + bon.getBfood());

					System.out.print(" Nourriture:");
					affichRessource(getfood());
					System.out.print(" Bois:");
					affichRessource(getwood());
					System.out.print("Or:");
					affichRessource(getgold());
					System.out.print(" Pierre:");
					affichRessource(getrock());
					
					
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
