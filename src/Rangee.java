import java.awt.Color;
import java.util.Random;

public class Rangee {
	public int indice_jeton;
	public Color[] jetons = new Color[Modele.DIFFICULTE];
	public int noirs = 0;
	public int blancs = 0;
	
	public Rangee() {
		Random r = new Random();
		for(int i=0;i<Modele.DIFFICULTE;i++) {
			int s = r.nextInt(Modele.COULEURS.length);
			this.jetons[i] = Modele.COULEURS[s];
		}
	}
	
}
