package civilization;

import java.util.Scanner;

// Les habitants 
public class Population extends Batiment {
	public int villageois;
	public int soldat;
	
	
	
	//public int scientist;
	//public int merchant;
	//public int phylosopher;

	// Constructeur
	public Population() {
		villageois =10;// godmode
		soldat = 0;
		
		
		
		
		//scientist = 0;
		//merchant = 0;
		//phylosopher = 0;
	}

	/*
	public static void cbonus(Bonus bon, Plateau m, Ressources r, Batiment b, Population p) {
		int[][] a= new int [10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				switch (m.getT()[i][j]) {
				case "mine":
					
					bon.setBgold(calcbonus(m.getNb()[i][j]-a[i][j]));
					a[i][j]=m.getNb()[i][j]; 
					break;
				case "ferme":
					bon.setBfood(calcbonus(m.getNb()[i][j]-a[i][j]));
					a[i][j]=m.getNb()[i][j]; 
					break;
				case "scierie":
					bon.setBwood(calcbonus(m.getNb()[i][j]-a[i][j]));
					a[i][j]=m.getNb()[i][j]; 
					break;
				default:
					;

				}
			}
		}
	}*/
	
//fonction qui tue des unitees 3:)
public void kill(Population p, int a){
	if(a<=p.villageois){
	p.villageois=p.villageois-a;}
	else{System.err.println("Vous n'avez pas autant d'unité");}
	
}
	public int totalpop(Plateau m,Population p){
		int t=0;
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				t=getNb()[i][j]+t;
			}
		}
		t=t+p.villageois+p.soldat; //+p.scientist+p.merchant+p.phylosopher;
		return t;
	}
	
	public int getWarrior(){
	
		return soldat;
	}
	
	// il faudra gérer que les ouvriers pour préviligier la récolte de telle ou
	// telle ressources,
	// la présence des autres classes seuls suffira pour bénificier de leur
	// bonus
	public void in(Plateau m, Population p, int a, int x, int y) {
		if (a <= p.villageois && m.getNb()[x][y] + a <= m.getCap(x, y)) {
			m.setNb(x, y, m.getNb()[x][y]+a);
			p.villageois = p.villageois - a;
			Plateau.afficher(m);
		}
		// Je comprends... c'est pour ça qu'il nous disait mot de passe ou nom
		// de compte invalides, les flemmards!
		else {
			if (a > p.villageois) {
				System.err
						.println("Vous n'avez pas assez d'ouvrier, vous pouvez en creez contre de la nouriture à l'HDV");
			} else {
				System.err.println(" Le batiment est plein ");
			}
		}
	}

	public void out(Plateau m, Population p, int a, int x, int y) {
		if (a <= m.getNb()[x][y]) {
			m.setNb(x, y, m.getNb()[x][y]-a);
			p.villageois = p.villageois + a;
			Plateau.afficher(m);
		}
		// Je comprends... c'est pour ça qu'il nous disait mot de passe ou nom
		// de compte invalides, les flemmards!
		else {

			System.err.println("Ce batiment ne contient pas autant d'ouvrier ");

		}
	}

	public void population(Population p) {

		new Thread() {

			public void run() {

				int t = 0;

				while (t == 0) {

					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						System.out.println("erreur");
					}

					System.out.println("villageois :" + p.villageois);
					System.out.println(" guerrier :" + p.soldat);
					//System.out.println("scientifique:" + p.scientist);
					//System.out.println(" marchand:" + p.merchant);
					//System.out.println("philosophe:" + p.phylosopher);
				}

			}
		}.start();
	}

	public void entrer(Plateau m, Population p) {
		Scanner sc = new Scanner(System.in);
		System.err.println("Choisissez un batiment");
		int x = sc.nextInt();
		int y = sc.nextInt();
		int d=0;
		// doesnt work... why? idk
		// pour vérifier si il y'a un batiment dans la case
		// solution: mettre un switch case
		switch (m.getT()[x][y]) {
		case "caserne":
			System.err.println("Ceci est une caserne");
			break;
		case "maison":
			System.err.println("Ceci est une maison");
			break;
		case "scierie":
			System.err.println("Ceci est une scierie");
			break;
		case "mine":
			System.err.println("Ceci est une mine");
			break;
		case "ferme":
			System.err.println("Ceci est une ferme");
			break;
		default:
			System.err.println("Action impossible");
			d=1;
		}
if(d==0){
		System.err.println("Combien d'unite voulez vous y placez");
		int c = sc.nextInt();
		in(m, p, c, x, y);}
else{ System.err.println("Choisissez une autre case");}

	}

	// il est possible de se restreindre a une seule méthode pour faire rentrer
	// et sortir des unitées d'un batiment
	// seulement, je pense que ça serait trop lourd et que ça ne présente pas
	// vraiment de problème d'autant plus
	// qu'intuitivement c'est plus logique pour l'interface graphique)
	public void sortir(Plateau m, Population p) {
		Scanner sc = new Scanner(System.in);
		System.err.println("Choisissez un batiment");
		int x = sc.nextInt();
		int y = sc.nextInt();
		int d=0;
		// doesnt work... why? idk
		// pour vérifier si il y'a un batiment dans la case
		// solution: mettre un switch case
		switch (m.getT()[x][y]) {
		case "caserne":
			System.err.println("Ceci est une caserne");
			break;
		case "maison":
			System.err.println("Ceci est une maison");
			break;
		case "scierie":
			System.err.println("Ceci est une scierie");
			break;
		case "mine":
			System.err.println("Ceci est une mine");
			break;
		case "ferme":
			System.err.println("Ceci est une ferme");
			break;
		default:
			System.err.println("Action impossible");
			d=1;
		}
		if(d==0){
		System.err.println("Combien d'unités voulez-vous évacuer du batiment");
		int c = sc.nextInt();
		out(m, p, c, x, y);
		}
		else{System.err.println("Choisissez une autre case");}
	}
}
