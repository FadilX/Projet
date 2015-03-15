package civilization;

public class Temps {

	protected int seconde = -5;
	public int getSeconde(){
		return seconde;
	}
	public void setSeconde(int seconde){
		this.seconde=seconde;
	}
		
	public  void temps() {
		int t = 0;
		

		// Notre timer, on l'utilisera pour l'enchainement des vagues
		// les thread permettent d'executer plusieurs fonctions en même temps
		new Thread()

		{
			int s = 0;
			int m = 0;
			int h = 0;

			public void run() {

				while (t == 0) {seconde=seconde+5;
					

					try {
						Thread.sleep(5000);
						
					
					} catch (InterruptedException e) {
						System.out.println("erreur");
					}
					if (s < 55) {
						s=s+5;
					} else {
						s = 0;
						
						if (m < 59) {

							m++;
						} else {
							m = 0;
							h++;
						}

					} 
					System.out.println(" Temps" +'\t' + h + ":" + m + ":" + s);
				}
			}
		}.start();

	}

	/*public static void main(String[] args) {
		temps();

	}
*/
}
