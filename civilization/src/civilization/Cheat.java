package civilization;

public class Cheat {
	/**
	 * 
	 */
	public void AdrienCheat(Ressources ressources) {
		System.err.println("Le dev Adrien vous offre 100 bois et 100 pierres");
		ressources.setrock(100);
		ressources.setwood(100);
	}

	public void FadilCheat(Ressources ressources) {
		System.err.println("Le dev Fadil vous offre 100 or et 100 nourritures");
		ressources.setgold(100);
		ressources.setfood(100);
	}
}
