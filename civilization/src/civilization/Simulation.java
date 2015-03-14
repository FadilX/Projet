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
		Plateau m = new Plateau();
		Ressources r = new Ressources();
		Scanner sc = new Scanner(System.in);
		Bonus us = new Bonus();
		Caserne caserne = new Caserne();
		Ferme ferme = new Ferme();
		Mine mine = new Mine();
		Maison maison = new Maison();
		Scierie scierie = new Scierie();
		Carriere carriere = new Carriere();
		Forum forum = new Forum();
		Age age=new Age();
		Special special=new Special();
		Temps temp=new Temps();
		int d = 1;
		int e = 1;
		String a;
		String com;

		p.population(p);
		// m.structure("T",4,3);
		// m.structure("/",3,1);
		// m.structure("n",2,1);
		temp.temps();
		Ressources.incRessource(us);
		forum.build(m);
		System.err.println("Bienvenue, vous �tes le leader que nous attendions");
		while(attaque.getEnd()==0) {
			System.err.println("Que voulez vous faire?"
					+ " Tapez construire pour.. construire, vcreer pour creer des vilageois, gcreer pour creer des guerriers,"
					+"affecter pour r�partir vos villageois dans les diff�rents batiments,"
					+ "detruire pour d�truire un batiment, attention! vous perdrez toutes les unit�es qui s'y trouvent"
					+ "vastalavista pour tuer des villageois"
					+ "gastalavista pour tuer des guerriers"
					+"sortir pour faire sortir vos villageois d'un batiment"
					+"Age pour passer � l'age suivant"
					);
			
			 com=sc.nextLine();
			switch (com) {
			case "construire":
			
				
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
				
			break;
			
			
			/**
			 * 
			 * t'as une m�daille si t'arrive � montrer pourquoi les bonus ne
			 * sont pris en compte que apr�s que tu sois sortis de la boucle de
			 * l'affectation
			 */
			case "affecter":
			
			p.entrer( m, p,us,b,r);
			

				
			break;

			case "sortir":
			
			p.sortir( m, p,us,b,r);
					
					//Plateau.afficher(m);
				
			break;
				
			
			case "detruire":
			
				System.err.println("Choisissez un batiment");
				int x = sc.nextInt();
				int y = sc.nextInt();
				m.anhilate(m, x, y);
			 
			break;
			case "vcreer": 
			
				System.err.println("Combien?");
				int v = sc.nextInt();
				forum.creevillageois(m, maison, p, v);
				System.err.println("Nos femmes ont mis au monde de nouveaux citoyens");
			 
			break;
			// il faudra bien sur avoir d�j� construit une caserne... (un simple
			// test if sur toutes les cases suffit)
			case "gcreer":
				System.err.println("Combien?");
				int w = sc.nextInt();
				caserne.creeguerrier(m, maison, p, w);
				
			break;
			case "age":
				 age.newAge(m,special,age,us,r,maison,mine,carriere,ferme, scierie);
				 break;

			case "vastalavista":
			
				System.err.println("Combien?");
				int h = sc.nextInt();
				p.kill(p, h);
				
			break;
			
			default:
				System.out.println("commande non reconnue");
			}
			if((temp.seconde)/300==attaque.getVague()){
				attaque.go(p);
			}
			
		}
		System.out.println("Continue??");}
	
}

// Done: v�rifier si une case est libre avant de construire.
// Donefonction :qui permet de retirer des habitants d'un batiment
// Done fonction qui d�molie un batiment (tu perds les unit�s qu'il y'a dedans,
// et tu // regagnes aucune ressource)
// Done fonction: suicide (pour tuer des unit�es)
// Done Classe HDV
// Done:Les classes HDV et caserne produisent des unit�es
// Done: le nombre d'unit� pouvant �tre produite est d�termin� par le nombre de
// // maisons
// Comment tuer une thread? car cbonus sous sa forme actuelle ne tient pas//
// compte des MAJ (destruction de batiment, changement du nombre d'unit�)
// http://openclassrooms.com/courses/bien-fermer-ses-threads-en-java
// http://stackoverflow.com/questions/671049/how-do-you-kill-a-thread-in-java

// A faire:
// Phase d'attaque... oulahlah va falloir �tablir des r�gles en gros t'as 2
// choix tu te d�ffends ou tu payes

// Passage � un nouvel age (am�liorations globale)
// Classes secondaires
// Ressource secondaires (des classes qui d�penderont du nombre de guerriers
// scitifi...)
// batiments secondaires
// Les batiments poss�dent des am�liorations(en plus que les am�liorations que
// procurera le passage � un nouvel age... (compliqu�, pas n�cessaire mais
// styl�)
// Interface graphique
// fun, cameo de personnages historiques, air spatiale=stage bonus, et enfin les
// Cheats :').
// Pourquoi ne pas faire une sorte de jeu d'arcade ou le joueur aurait un nombre de coins :) on poura faire notre chaine
// avec �a :p, on aura genre un d�compte 10, 9, 8, 7 COntinue :)?