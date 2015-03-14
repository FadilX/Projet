package civilization;

/**
 * 
 * @author Fadil Classe qui gère les bonus
 */
// On rajoutera plus tard les bonus que procurent la science le commerce...
// En gros durant le 1ère age pas de "ressources" secondaires ;)

public class Bonus extends Ressources{
	protected double bgold=0;
	protected double bwood=0;
	protected double brock=0;
	protected double bfood=0;
	
	// Bon... Je commence à trouver ceci dégueulasse, je pense que
	// avec de l'héritage y'a moyen de rendre le code plus élégant, bosse là
	// dessus si tu veux
	//
	Plateau m = new Plateau();
	Ressources r = new Ressources();
	Batiment b = new Batiment();
	Population p = new Population();

	/**
	 * Constructeur
	 */
	public Bonus() {
		setBgold(0);
		setBwood(0);
		setBrock(0);
		setBfood(0);
	}

	public double getBgold() {
		return bgold;
	}

	public void setBgold(double a) {
		bgold = bgold + a;
	}

	public double getBfood() {
		return bfood;
	}

	public void setBfood(double a) {
		bfood = bfood + a;
	}

	public double getBwood() {
		return bwood;
	}

	public void setBwood(double a) {
		bwood = bwood + a;
	}

	public double getBrock() {
		return brock;
	}

	public void setBrock(double a) {
		brock = brock + a;
	}

	/**
	 * Cette fonction
	 * 
	 * @param us
	 *            Bonus
	 * @param m
	 *            Plateau
	 * @param r
	 *            Ressources
	 * @param b
	 *            Batiment
	 * @param p
	 *            Population
	 * @return 
	 */
	
	
	public static double calcbonus(int z){
		double coef;
		
			if (z==0)
				coef = 0;
			if (z>0 && z<4)
				coef = 5*z;
			if (z>3 && z<7)
				coef = 5*(3+(2*(z-3)));
			if (z>6 && z<10)
				coef = 5*(9+((z-6)*3));
			if (z==10)
				coef = 100;
			else
				coef=0;
			return coef;	
		}
	
	public static void pbonus(Bonus bon, Plateau m, Ressources r, Batiment b, Population p) {
		int[][] a= new int [10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				switch (m.getT()[i][j]) {
				case "mine":
					
					bon.setBgold(m.getNb()[i][j]-a[i][j]);
					a[i][j]=m.getNb()[i][j]; 
					break;
				case "ferme":
					bon.setBfood(m.getNb()[i][j]-a[i][j]);
					a[i][j]=m.getNb()[i][j]; 
					break;
				case "scierie":
					bon.setBwood(m.getNb()[i][j]-a[i][j]);
					a[i][j]=m.getNb()[i][j]; 
					break;
				case "carriere":
					bon.setBrock(m.getNb()[i][j]-a[i][j]);
					a[i][j]=m.getNb()[i][j]; 
					break;
				default:
					;

				}
			}
		}
		}
		public static void mbonus(Bonus bon, Plateau m, Ressources r, Batiment b, Population p) {
			int[][] a= new int [10][10];
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {

					switch (m.getT()[i][j]) {
					case "mine":
						
						bon.setBgold((m.getNb()[i][j]-a[i][j])-bon.getBfood());
						a[i][j]=m.getNb()[i][j]; 
						break;
					case "ferme":
						bon.setBfood((m.getNb()[i][j]-a[i][j])-bon.getBfood());
						a[i][j]=m.getNb()[i][j]; 
						break;
					case "scierie":
						bon.setBwood((m.getNb()[i][j]-a[i][j])-bon.getBfood());
						a[i][j]=m.getNb()[i][j]; 
						break;
					case "carriere":
						bon.setBrock((m.getNb()[i][j]-a[i][j])-bon.getBrock());
						break;
					default:
						;
						

					}
				}
			}
	}
	


	/*
	public static void main(String[] args) {
		
		Ressources r = new Ressources();
		Batiment b = new Batiment();
		Bonus bon = new Bonus();
		Population p = new Population();
		cbonus(bon, m, r, b, p);

	}*/

}
