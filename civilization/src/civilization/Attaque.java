package civilization;

import java.util.Scanner;

/**
 * 
 * @author Fadil
 *Voil� la tant attendue phase attaque d�ffense
 *On laissera le choix au joueur: payer ou se battre
 */
public class Attaque {
	int vague;
	Time temps=new Time();
	Ressources ressources=new Ressources();
	
	public Attaque(){
		vague=0;
	}
	
	public int getVague(){
		return vague;
	}
	public void setVague(int vague){
		this.vague=vague;
	}
	public void clash(People people){
		System.err.println("TOUOOOOOOOO, TOUTUOUTOUTOUTROUROUROU (corne de guerre :/");
		System.out.println("En avant!! SUs � l'ennemi!");
		if(people.getWarrior()<=5){
			System.err.println("Vous avez perdu la guerre");
		}
		else{
			System.err.println(" Vous avez terras� l'ennemi ! Vous �tes venez � bout de la "+getVague()+" Vague");
		}
		
	}
	public void go(People people){
		Scanner sc = new Scanner(System.in);
		while(temps.seconde<=10){
			// wait...
		}
		
	System.err.println("Etrangers!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
			+ " Votre ville est encercl�e, payez 400 Or, ou subbissez notre COUROU!");
	System.err.println("tapez 1 pour payer, 0 sinon");
	int a=sc.nextInt();
	if(a==1)
	{	
		if(ressources.getgold()>=400){
		ressources.setgold(-400);
		System.err.println("Tr�s bien vous vivrez pour cette fois...");
		}
		else{
			System.err.println("Vous n'avez pas assez d'or, vous �tes contraint d'attaquer... Brace Yourself");
			// fonction attaque
			clash(people);
		}
		
	}
	else{
		clash(people);
	}
	
	}
}

