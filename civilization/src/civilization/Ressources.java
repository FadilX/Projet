package civilization;

/**
 * Classes des ressources, je ne vois pas l'utilit�e de scinder cette classe en
 * plusieurs classes filles.
 */
public class Ressources extends Batiment {
	protected double Or;
	protected double Pierre;
	protected double Nourriture;
	protected double Bois;

	public Ressources() {

		Or = 300;
		Pierre = 300;
		Nourriture = 300;
		Bois = 300;

	}

	public double getgold() {
		return Or;

	}

	public double getrock() {
		return Pierre;

	}

	public double getwood() {
		return Bois;

	}

	public double getfood() {
		return Nourriture;
	}

	public void setfood(double a) {
		Nourriture = Nourriture + a;

	}

	public void setwood(double a) {
		Bois = Bois + a;
	}

	public void setrock(double a) {
		Pierre = Pierre + a;
	}

	public void setgold(double a) {
		Or = Or + a;
	}

	// Methode qui permet l'incr�mentation des ressources avec le temps et en
	// fonction de la main d'oeuvre affect�e par batiment
	// L� aussi il faut travailler avec des threads
	// bonus est une variable qui d�pend de la nb[][] affect� au batiment qui
	// r�colte la dite ressource, et de la techno;
	// Il y'a un probl�me ici, je ne sais pas encore comment tuer une Thread,
	// j'ai des id�es pour des m�thdes bourines mais y doit avoir une methode
	// faite pour
	public void incRessource(Bonus bon) {

		new Thread() {

			public void run() {

				int t = 0;

				while (t == 0) {

					// pour tuer if(param�tre control� depuis le main){
					// t=1;}
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("erreur");
					}
					setgold(1 + bon.getBgold());
					setrock(1 + bon.getBrock());
					setwood(1 + bon.getBwood());
					setfood(1 + bon.getBfood());

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

	public void affichRessource(double a) {
		System.out.print(a);
	}

	public static void main(String[] args) {
		Bonus b = new Bonus();
		Ressources r = new Ressources();
		r.incRessource(b);
	}

}
