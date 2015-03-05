package civilization;

import java.util.Scanner;

/**
 * main pour le test Eclipse ne permet pas de print en couleur (en utilsant les
 * ANSI) Cependant avec System.err.println on a du rouge :)
 * 
 * @author Fadil
 *
 */

public class Simulation {
	// Y'a une petit message d'erreur, mais bourine ça marche
	// t'as le temps, et le nombre qui s'affiche c'est l'or, il s'icrémente en
	// fonction du temps (+1/s). j'ai pris l'or atitdixemple
	// en gros tape 1 en premier pour construire, puis tappe le nom du batiment,
	// pas grave si t'arrive pas a taper le nom en moins d'une seconde
	// Moi j'y arrive mais tu peux pas test ;)
	// Puis tu choisis son emplacement, remarque que le gold est décompté
	// (comme les autres ressoources en arière plan)
	// Tu choisis si tu veux construire une nouvelle fois, pareil...
	// si t'as pas assez de ressources tappe 0
	// ça va t'envoyer sur la fonction affectation qui te permet d'affecter tes
	// unités a un batiment,
	// tu tapes 1 si tu veux affecter 0 sinon, aprés tu tappes les coos de la
	// case, et le nb d'unité

	public static void main(String[] args) {
		Buildings b = new Buildings();
		People p = new People();
		Map m = new Map();
		Ressources r = new Ressources();
		Scanner sc = new Scanner(System.in);
		Bonus us = new Bonus();
		Caserne caserne = new Caserne();
		Ferme ferme = new Ferme();
		Mines mine = new Mines();
		Maison maison = new Maison();
		Scierie scierie = new Scierie();
		Hotel hotel=new Hotel();
		Attaque attaque=new Attaque();
		int d = 1;
		int e = 1;
		String a;

		p.population(p);
		// m.structure("T",4,3);
		// m.structure("/",3,1);
		// m.structure("n",2,1);
		Time.temps();
		Ressources.incRessource(us);
		hotel.build(m);
		
		while (d == 1) {
			System.err.println("Bienvenue, tapez 1 pour construire 0 sinon");
			d = sc.nextInt();
			if (d == 1) {
				System.err
						.println("tapez le nom du batiment que vous voulez construire (caserne, maison, ferme, mine)");
				Scanner s = new Scanner(System.in);
				a = s.nextLine();

				switch (a) {

				case "caserne":
					caserne.build(m);
					break;
				case "mine":
					mine.build(m);
					break;
				case "ferme":
					ferme.build(m);
					break;
				case "maison":
					maison.build(m);
					break;
				case "scierie":
					scierie.build(m);
				default:
					System.err.println("????");
				}
			} else {
				System.err.println("ok bye");
			}
		}
		/**
		 * 
		 * t'as une médaille si t'arrive à montrer pourquoi les bonus ne sont
		 * pris en compte que aprés que tu sois sortis de la boucle de
		 * l'affectation
		 */
		while (e == 1) {
			System.err
					.println("Voulez vous affecter vos ouvriers a un batiment?");
			e = sc.nextInt();

			if (e == 1) {

				p.entrer(m, p);

			} else {
				System.err.println("ok bye");
				e = 0;
			}

		}

		e = 1;
		while (e == 1) {
			System.err
					.println("Voulez vous faire sortir des unitées d'un batiment?");
			e = sc.nextInt();

			if (e == 1) {

				p.sortir(m, p);

			} else {
				System.err.println("ok bye");
				e = 0;
			}
			Map.afficher(m);
		}
		System.err
				.println("Voulez vous detruire un batiment, vous perdrez tous les villageois qu'il y'a dedans");
		int n = sc.nextInt();
		if (n == 1) {
			System.err.println("Choisissez un batiment");
			int x = sc.nextInt();
			int y = sc.nextInt();
			m.anhilate(m, x, y);
		} else {
			System.err.println("Ok bye");
		}
		System.err.println("Voulez vous creez des villageois?");
		int k=sc.nextInt();
		if(k==1){
		System.err.println("Combien?");
		int v=sc.nextInt();
		hotel.creevillageoi( m,  maison,  p,  v);
		}
		else{System.err.println("Ok bye");}
		// il faudra bien sur avoir déjà construit une caserne... (un simple test if sur toutes les cases suffis)
		System.err.println("Voulez vous creez des Guerriers?");
		int q=sc.nextInt();
		if(q==1){
		System.err.println("Combien?");
		int w=sc.nextInt();
		caserne.creeguerrier( m,  maison,  p,  w);
		}
		else{System.err.println("Ok bye");}
		System.err.println("Voulez vous... tuer des unitees :)?");
		int z=sc.nextInt();
		if(z==1){
			System.err.println("Combien?");
			int h=sc.nextInt();
			p.kill(p, h);
		}
		Bonus.cbonus(us, m, r, b, p);
		Map.afficher(m);
		attaque.go(p);
	}
}
//  Done: vérifier si une case est libre avant de construire.
//  Donefonction :qui permet de retirer des habitants d'un batiment
// Done fonction  qui démolie un batiment (tu perds les unités qu'il y'a dedans, et tu // regagnes aucune ressource)
// Done fonction: suicide (pour tuer des unitées)
//Done Classe HDV
//Done:Les classes HDV et caserne produisent des unitées
//Done: le nombre d'unité pouvant être produite est déterminé par le nombre de // maisons
//Comment tuer une thread? car cbonus sous sa forme actuelle ne tient pas// compte des MAJ (destruction de batiment, changement du nombre d'unité)
//http://openclassrooms.com/courses/bien-fermer-ses-threads-en-java http://stackoverflow.com/questions/671049/how-do-you-kill-a-thread-in-java


//A faire:
// Phase d'attaque... oulahlah va falloir établir des régles en gros t'as 2
// choix tu te déffends ou tu payes
/**
 * AVIS:
 * pourquoi ne pas avoir qu'une seul classe d'unité, des citoyens
 * tu determinera alors leurs role en les plaçants dans les batiments
 * ex: si tu as 10 citoyens, si t'en place 4 dans une caserne et 6 dans une ferme
 * t'aura 4 guerriers qui feront augmenté ta puissance militaire et 6 fermiers qui feront augmenter ta production de bouf
 * qu'en dis-tu? 
 */

// Passage à un nouvel age (améliorations globale)
//Classes secondaires
// Ressource secondaires (des classes qui dépenderont du nombre de guerriers scitifi...)
// batiments secondaires
//Les batiments possèdent des améliorations(en plus que les améliorations que procurera le passage à un nouvel age... (compliqué, pas nécessaire mais
//stylé)
// Interface graphique
// fun, cameo de personnages historiques, air spatiale=stage bonus, et enfin les
// Cheats :').
