import java.awt.Canvas;
import java.awt.Graphics;
public class VuePropositions extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 253187160713907717L;
	
	private Modele m;
	
	public VuePropositions(Modele m) {
		this.m = m;
	}
	
	public void paint(Graphics g){
		Rangee[] r = m.get_prop();
		for(int i = 0; i < m.getTentative(); i++) {
			// Dessin des cercles
			for(int j = 0; j < r[i].jetons.length; j++) {
				g.setColor(r[i].jetons[j]);
				g.fillOval(j * 50, i * 50, 40, 40);
			}
			// Dessin des cercle de verif
			
			int noir = r[i].noirs;
			int blanc = r[i].blancs;
			for(int j = 0; j < r[i].jetons.length; j++) {
				if (noir >= 0) {
					g.setColor(Modele.COULEURS[6]);
					g.fillOval(r[i].jetons.length * 50 + j * 20, i * 50, 20, 20);
					noir -= 1;
				}
				else {
					g.setColor(Modele.COULEURS[5]);
					g.fillOval(r[i].jetons.length * 50 + j * 20, i * 50, 20, 20);
					blanc -= 1;
				}
			}
		}
	}
	
}
