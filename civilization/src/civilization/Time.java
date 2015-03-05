package civilization;

public class Time {
	 static int seconde=0; // j'en ai besoin pour l'attaque
	
	public static int getSeconde(){
		return Time.seconde;
	}
	public static void setSeconde(int seconde){
		Time.seconde=seconde;
	}

	public static void temps() {
		int t = 0;
		// Notre timer, on l'utilisera pour l'enchainement des vagues
		// les thread permettent d'executer plusieurs fonctions en même temps
		new Thread()

		{
			int s = 0;
			int m = 0;
			int h = 0;

			public void run() {

				while (t == 0) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("erreur");
					}
					if (s < 59) {
						s++;
					} else {
						s = 0;
						if (m < 59) {

							m++;
						} else {
							m = 0;
							h++;
						}

					} 
					System.out.println(" time" +'\t' + h + ":" + m + ":" + s);
					setSeconde(1+seconde);
					
				}
			}
		}.start();

	}

	public static void main(String[] args) {
		temps();

	}

}
