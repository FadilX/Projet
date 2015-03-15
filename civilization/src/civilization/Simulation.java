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
	// t'as le temps, et le nombre qui s'affiche c'est l'or, il s'icrémente en
	// fonction du temps (+1/s). j'ai pris l'or
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
		Age age = new Age();
		Special special = new Special();
		Cheat cheat = new Cheat();
		Temps temp = new Temps();

		String a;
		String com;

		p.population(p);
		// m.structure("T",4,3);
		// m.structure("/",3,1);
		// m.structure("n",2,1);
		temp.temps();
		r.incRessource(us);
		forum.build(m);
		System.err
				.println("Bienvenue, vous êtes le leader que nous attendions");
		while (attaque.getEnd() == 0) {
			System.err
					.println("Que voulez vous faire?"
							+ " Tapez construire pour.. construire, vcreer pour creer des vilageois, gcreer pour creer des guerriers,"
							+ "affecter pour répartir vos villageois dans les différents batiments,"
							+ "detruire pour détruire un batiment, attention! vous perdrez toutes les unitées qui s'y trouvent"
							+ "vastalavista pour tuer des villageois"
							+ "gastalavista pour tuer des guerriers"
							+ "sortir pour faire sortir vos villageois d'un batiment"
							+ "Age pour passer à l'age suivant"

					);

			com = sc.nextLine();
			switch (com) {
			case "construire":

				System.err
						.println("Tapez le nom du batiment que vous voulez construire (ferme, scierie, mine, carrière, maison, caserne)");
				Scanner s = new Scanner(System.in);
				a = s.nextLine();

				switch (a) {

				case "caserne":
					caserne.build(m, r);
					break;
				case "mine":
					mine.build(m, r);
					break;
				case "ferme":
					ferme.build(m, r);
					break;
				case "maison":
					maison.build(m, r);
					break;
				case "scierie":
					scierie.build(m, r);
					break;
				case "carriere":
					carriere.build(m, r);
					break;
				default:
					System.err.println("?");
				}

				break;

			/**
			 * 
			 * t'as une médaille si t'arrive à montrer pourquoi les bonus ne
			 * sont pris en compte que aprés que tu sois sortis de la boucle de
			 * l'affectation
			 */
			case "affecter":

				p.entrer(m, p, us, b, r);

				break;

			case "sortir":

				p.sortir(m, p, us, b, r);

				// Plateau.afficher(m);

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
				forum.creevillageois(m, maison, p, r, v);
				System.err
						.println("Nos femmes ont mis au monde de nouveaux citoyens");

				break;
			// il faudra bien sur avoir déjà construit une caserne... (un simple
			// test if sur toutes les cases suffit)
			case "gcreer":
				System.err.println("Combien?");
				int w = sc.nextInt();
				caserne.creeguerrier(m, maison, p, r, w);

				break;
			case "age":
				age.newAge(m, special, age, us, r, maison, mine, carriere,
						ferme, scierie);
				break;

			case "vastalavista":

				System.err.println("Combien?");
				int h = sc.nextInt();
				p.kill(p, h);

				break;
			case "Adrien":
				cheat.AdrienCheat(r);
				break;
			case "Fadil":
				cheat.FadilCheat(r);
				break;

			default:
				System.out.println("commande non reconnue");
			}
			if ((temp.seconde) / 120 == attaque.getVague()) {
				attaque.go(p, r);
			}

		}
		System.out.println("La partie est terminée");

	}

}

// Done: vérifier si une case est libre avant de construire.
// Donefonction :qui permet de retirer des habitants d'un batiment
// Done fonction qui démolie un batiment (tu perds les unités qu'il y'a dedans,
// et tu // regagnes aucune ressource)
// Done fonction: suicide (pour tuer des unitées)
// Done Classe HDV
// Done:Les classes HDV et caserne produisent des unitées
// Done: le nombre d'unité pouvant être produite est déterminé par le nombre de
// // maisons
// Comment tuer une thread? car cbonus sous sa forme actuelle ne tient pas//
// compte des MAJ (destruction de batiment, changement du nombre d'unité)
// http://openclassrooms.com/courses/bien-fermer-ses-threads-en-java
// http://stackoverflow.com/questions/671049/how-do-you-kill-a-thread-in-java

// A faire:
// Phase d'attaque... oulahlah va falloir établir des régles en gros t'as 2
// choix tu te déffends ou tu payes

// Passage à un nouvel age (améliorations globale)
// Classes secondaires
// Ressource secondaires (des classes qui dépenderont du nombre de guerriers
// scitifi...)
// batiments secondaires
// Les batiments possèdent des améliorations(en plus que les améliorations que
// procurera le passage à un nouvel age... (compliqué, pas nécessaire mais
// stylé)
// Interface graphique
// fun, cameo de personnages historiques, air spatiale=stage bonus, et enfin les
// Cheats :').
// Pourquoi ne pas faire une sorte de jeu d'arcade ou le joueur aurait un nombre
// de coins :) on poura faire notre chaine
// avec ça :p, on aura genre un décompte 10, 9, 8, 7 COntinue :)?