package civilization;

/**
 * 
 * @author Fadil Cette premi�re classe permet de g�n�rer notre plateau. Chaque
 *         case est repr�sent� par ces coordon�es (x,y) j'ai choisis deux
 *         boucles for imbriqu�es pour la cr�ation... assez bourin, je
 *         r�fl�chirais a une m�thode r�cursive
 */

// t repr�sente les coordonn�es de la case
// nb le nombre d'unit� plac� dans le batiment sur cette case.

public class Plateau {

	protected static int abs = 10;
	protected static int ord = 10;

	protected String[][] t = new String[abs][ord];
	protected int[][] nb = new int[abs][ord];
	protected int[][] cap = new int[abs][ord];

	/**
	 * intialisation � 0
	 * 
	 */

	public Plateau() {
		for (int i = 0; i < abs; i++) {
			for (int j = 0; j < ord; j++) {
				setT(i, j, "(" + i + "," + j + ")");
				setNb(i, j, 0);
				setCap(i, j, 0);
			}
		}
	}

	/**
	 * getters & setters On en a besoin pour pouvoir acc�der aux variables
	 * priv�es de l'ext�rieur de la classe
	 * 
	 * @return
	 */
	public int getCap(int x, int y) {
		return cap[x][y];
	}

	public void setCap(int i, int j, int a) {
		cap[i][j] = a;
	}

	// try public string get(int x int y){
	// return t[x][y];
	// }
	public String[][] getT() {
		return t;
	}

	public void setT(int i, int j, String a) {
		t[i][j] = a;
	}

	public int[][] getNb() {
		return nb;
	}

	public void setNb(int i, int j, int a) {
		nb[i][j] = a;
	}

	/**
	 * Affiche le plateau
	 */
	public static void afficher(Plateau m) {

		for (int i = 0; i < abs; i++) {
			for (int j = 0; j < ord; j++) {
				System.out.print(m.getT()[i][j] + m.getNb()[i][j] + '\t');
			}
			System.out.println();
		}
	}

	public void anhilate(Plateau m, int x, int y) {

		setT(x, y, "(" + x + "," + y + ")");
		setNb(x, y, 0);
		setCap(x, y, 0);
	}

	/**
	 * 
	 * @param T
	 *            arbre, rivi�re, colline
	 * @param n
	 *            nombre d �l�ments
	 * @param d
	 *            densit� des �l�ments permet la g�n�ration al�atoire des
	 *            �l�ments du d�cor cette fonction requiert beaucoup trop de
	 *            calculs... je pense enlever l'aspect al�atoire... ou repenser
	 *            les if else...
	 */
	public static void structure(String T, int n, int d) {
		/*
		 * int a = 0; int max = 9; int min = 0; int b = 0; int x = (int)
		 * (Math.random() * (max - min + 1)) + min; int y = (int) (Math.random()
		 * * (max - min + 1)) + min; while (x < 10 && x >= 0 && y < 10 && y >= 0
		 * && a < n) { if (t[x][y] == T) { a--; } else { t[x][y] = T; if (x < 9
		 * && b <d ) { x++; b++; } else { if (b < d) { x--; } else { if (y < 9)
		 * { y++; } else { y--; } b = 0; } }
		 * 
		 * } a++;
		 * 
		 * }
		 */
	}

	public static void main(String[] args) {
		Plateau m = new Plateau();
		afficher(m);
		m.setNb(2, 2, 1);
		afficher(m);
	}

}