package civilization;

import java.util.Scanner;

/**
 * main pour le test Eclipse ne permet pas de print en couleur (en utilsant les
 * ANSI) Cependant avec System.err.println on a du rouge :)
 * 
 * @author Fadil1
 * 
 *
 */

public class Simulation {
	// Y'a une petit message d'erreur, mais bourine �a marche
	// t'as le temps, et le nombre qui s'affiche c'est l'or, il s'icr�mente en
	// fonction du temps (+1/s). j'ai pris l'or atitdixemple
	// en gros tape 1 en premier pour construire, puis tappe le nom du batiment,
	// pas grave si t'arrive pas a taper le nom en moins d'une seconde
	// Moi j'y arrive mais tu peux pas test ;)
	// Puis tu choisis son emplacement, remarque que le gold est d�compt�
	// (comme les autres ressoources en ari�re plan)
	// Tu choisis si tu veux construire une nouvelle fois, pareil...
	// si t'as pas assez de ressources tappe 0
	// �a va t'envoyer sur la fonction affectation qui te permet d'affecter tes
	// unit�s a un batiment,
	// tu tapes 1 si tu veux affecter 0 sinon, apr�s tu tappes les coos de la
	// case, et le nb d'unit�

	public static void main(String[] args) {
		Attaque attaque = new Attaque();
		Batiment b = new Batiment();
		Population p = new Population();
		Plateau m=new Plateau();
		Ressources r = new Ressources();
		Scanner sc = new Scanner(System.in);
		Bonus us = new Bonus();
		Caserne caserne = new Caserne();
		Ferme ferme = new Ferme();
		Mine mine = new Mine();
		Maison maison = new Maison();
		Scierie scierie = new Scierie();
		Carriere carriere = new Carriere();
		Forum forum=new Forum();
		int d = 1;
		int e = 1;
		String a;

		p.population(p);
		// m.structure("T",4,3);
		// m.structure("/",3,1);
		// m.structure("n",2,1);
		Temps.temps();
		Ressources.incRessource(us);
		forum.build(m);
		
		while (d == 1) {
			System.err.println("Bienvenue, tapez 1 pour construire, 0 sinon");
			d = sc.nextInt();
			if (d == 1) {
				System.err
						.println("Tapez le nom du batiment que vous voulez construire (ferme, scierie, mine, carri�re, maison, caserne)");
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
				case "carriere":
					carriere.build(m);
				default:
					System.err.println("?");
				}
			} else {
				System.err.println("Bien, au revoir");
			}
		}
		/**
		 * 
		 * t'as une m�daille si t'arrive � montrer pourquoi les bonus ne sont
		 * pris en compte que apr�s que tu sois sortis de la boucle de
		 * l'affectation
		 */
		while (e == 1) {
			System.err
					.println("Voulez-vous affecter vos villageois � un batiment?");
			e = sc.nextInt();

			if (e == 1) {

				p.entrer(m, p);

			} else {
				System.err.println("Bien, au revoir");
				e = 0;
			}

		}

		e = 1;
		while (e == 1) {
			System.err
					.println("Voulez-vous faire sortir des unit�es d'un batiment?");
			e = sc.nextInt();

			if (e == 1) {

				p.sortir(m, p);

			} else {
				System.err.println("Bien, au revoir");
				e = 0;
			}
			Bonus.cbonus(us, m, r, b, p);
			Plateau.afficher(m);
		}
		
		System.err
				.println("Voulez-vous detruire un batiment ? (vous perdrez tous les villageois qu'il y a dedans)");
		int n = sc.nextInt();
		if (n == 1) {
			System.err.println("Choisissez un batiment");
			int x = sc.nextInt();
			int y = sc.nextInt();
			m.anhilate(m, x, y);
		} else {
			System.err.println("Bien, au revoir");
		}
		System.err.println("Voulez-vous cr�er des villageois?");
		int k=sc.nextInt();
		if(k==1){
		System.err.println("Combien?");
		int v=sc.nextInt();
		forum.creevillageois( m,  maison,  p,  v);
		}
		else{System.err.println("Bien, au revoir");}
		// il faudra bien sur avoir d�j� construit une caserne... (un simple test if sur toutes les cases suffit)
		System.err.println("Voulez vous cr�er des soldats?");
		int q=sc.nextInt();
		if(q==1){
		System.err.println("Combien?");
		int w=sc.nextInt();
		caserne.creeguerrier( m,  maison,  p,  w);
		}
		else{System.err.println("Bien, au revoir");}
		System.err.println("Voulez-vous tuer des unit�s ?");
		int z=sc.nextInt();
		if(z==1){
			System.err.println("Combien?");
			int h=sc.nextInt();
			p.kill(p, h);
		
		}	
		Bonus.cbonus(us, m, r, b, p);
		Plateau.afficher(m);
		attaque.go(p);

	}
}
//  Done: v�rifier si une case est libre avant de construire.
//  Donefonction :qui permet de retirer des habitants d'un batiment
// Done fonction  qui d�molie un batiment (tu perds les unit�s qu'il y'a dedans, et tu // regagnes aucune ressource)
// Done fonction: suicide (pour tuer des unit�es)
//Done Classe HDV
//Done:Les classes HDV et caserne produisent des unit�es
//Done: le nombre d'unit� pouvant �tre produite est d�termin� par le nombre de // maisons
//Comment tuer une thread? car cbonus sous sa forme actuelle ne tient pas// compte des MAJ (destruction de batiment, changement du nombre d'unit�)
//http://openclassrooms.com/courses/bien-fermer-ses-threads-en-java http://stackoverflow.com/questions/671049/how-do-you-kill-a-thread-in-java


//A faire:
// Phase d'attaque... oulahlah va falloir �tablir des r�gles en gros t'as 2
// choix tu te d�ffends ou tu payes

// Passage � un nouvel age (am�liorations globale)
//Classes secondaires
// Ressource secondaires (des classes qui d�penderont du nombre de guerriers scitifi...)
// batiments secondaires
//Les batiments poss�dent des am�liorations(en plus que les am�liorations que procurera le passage � un nouvel age... (compliqu�, pas n�cessaire mais
//styl�)
// Interface graphique
// fun, cameo de personnages historiques, air spatiale=stage bonus, et enfin les
// Cheats :').
