package civilization;

/**
 * 
 * @author Fadil Classe qui gère les bonus
 */
// On rajoutera plus tard les bonus que procurent la science le commerce...
// En gros durant le 1ère age pas de "ressources" secondaires ;)

public class Bonus extends Ressources{
	protected int bgold;
	protected int bwood;
	protected int brock;
	protected int bfood;
	
	// Bon... Je commence à trouver ceci dégueulasse, je pense que
	// avec de l'héritage y'a moyen de rendre le code plus élégant, bosse là
	// dessus si tu veux
	//
	Map m = new Map();
	Ressources r = new Ressources();
	Buildings b = new Buildings();
	People p = new People();

	/**
	 * Constructeur
	 */
	public Bonus() {
		setBgold(0);
		setBwood(0);
		setBrock(0);
		setBfood(0);
	}

	public int getBgold() {
		return bgold;
	}

	public void setBgold(int a) {
		bgold = bgold + a;
	}

	public int getBfood() {
		return bfood;
	}

	public void setBfood(int a) {
		bfood = bfood + a;
	}

	public int getBwood() {
		return bwood;
	}

	public void setBwood(int a) {
		bwood = bwood + a;
	}

	public int getBrock() {
		return brock;
	}

	public void setBrock(int a) {
		brock = brock + a;
	}

	/**
	 * Cette fonction
	 * 
	 * @param us
	 *            Bonus
	 * @param m
	 *            Map
	 * @param r
	 *            Ressources
	 * @param b
	 *            Buildings
	 * @param p
	 *            People
	 */
	
	// Gaffe quand j'écrirais la fonction qui permet de faire sortir les
	// ouviers... Je pense que le a règle le problème 
	public static void cbonus(Bonus bon, Map m, Ressources r, Buildings b,
			People p) {
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
				default:
					;

				}
			}
		}
	}

	public static void main(String[] args) {
		Map m = new Map();
		Ressources r = new Ressources();
		Buildings b = new Buildings();
		Bonus bon = new Bonus();
		People p = new People();
		cbonus(bon, m, r, b, p);

	}

}
