package civilization;
import java.util.Scanner;
 
public class Age {

	private String age;
	private int nage;

	public Age() {
		age = "Age de pierre";
		nage = 1;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public int getNage() {
		return nage;
	}

	public void setNage(int nage) {
		this.nage = nage;
	}

	public void nameAge() {
		switch (nage) {
		case 1:
			setAge("Age de fer");
			setNage(nage + 1);
			break;
		case 2:
			setAge("Age de scilicone");
			setNage(nage + 1);
			break;
		case 3:
			setAge("Age de la conquete spatiale");
			setNage(nage + 1);
			break;

		default:
			System.out.println("It's the final frontiere...");
		}
		
	}
	/**
	 * Fonction pour améliorer les batiments déjà construit
	 * @param plateau
	 */
	public void upgradeBatiment(Plateau plateau,Maison maison, Mine mine, Carriere carriere, Ferme ferme, Scierie scierie){
		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
				
				switch(plateau.getT()[i][j]){
				case "ferme":
					plateau.setCap(i,j,ferme.getcapacite());
					break;
				case "maison":
					plateau.setCap(i,j,maison.getcapacite());
					break;
				case "scierie":
					plateau.setCap(i,j,scierie.getcapacite());
					break;
				case "carriere":
					plateau.setCap(i,j,carriere.getcapacite());
					break;
				case "mine":
					plateau.setCap(i,j,mine.getcapacite());
					break;
				}
			}
		}
	}
	
	/**
	 * Fonction pour améliorer les nouveaux batiments
	 * @param maison
	 * @param mine
	 * @param carriere
	 * @param ferme
	 * @param scierie
	 */
	public void evolutionBatiment(Maison maison, Mine mine, Carriere carriere, Ferme ferme, Scierie scierie){
		maison.setcapacite(maison.getcapacite()+5);
		carriere.setcapacite(carriere.getcapacite()+10);
		mine.setcapacite(mine.getcapacite()+10);
		ferme.setcapacite(ferme.getcapacite()+10);
		scierie.setcapacite(scierie.getcapacite()+10);
	}
	public void newAge(Plateau plateau,Special special, Age age, Bonus bonus, Ressources ressources,Maison maison, Mine mine, Carriere carriere, Ferme ferme, Scierie scierie){
		Scanner sc = new Scanner(System.in);
		String r;
		System.err.println("Payer" +getNage()*300+" de chaque ressources pour avancer à l'age suivant ?");
		System.err.println("Tous vos batiment de production auront +10 de capacite et vos maisons pouront accueillir 5 habitant de plus");
		System.out.println("Tapez oui ou non");
		r=sc.nextLine();
		if(r.equals("oui")){
			if(ressources.getgold()>=getNage()*300 && ressources.getwood() >=getNage()*300 && ressources.getfood()>=getNage()*300 && ressources.getrock()>= getNage()*300){
			ressources.setgold(-getNage()*300);
			ressources.setwood(-getNage()*300);
			ressources.setrock(-getNage()*300);
			ressources.setfood(-getNage()*300);
			nameAge();
			evolutionBatiment(maison,mine,carriere,ferme,scierie);
			upgradeBatiment(plateau,maison,mine,carriere,ferme,scierie);
			System.err.println("Felicitation vous avez atteint l'"+getAge()+"!");
			System.err.println("Vous avez débloqué 1 nouveau personnage spécial!");
			special.Cspecial(age,bonus);
			}
			else{
				System.err.println("Vous n'avez pas assez de ressources");
			}
		
		}
		else{
			System.err.println("Le progrès attendra");
		}
	
}}