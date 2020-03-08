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
			for(int j = 0; j < r[i].jetons.length; j++) {
				g.setColor(r[i].jetons[j]);
				g.fillOval(j * 50, i * 50, 40, 40);
			}
			
			int noir = r[i].noirs;
			int blanc = r[i].blancs;
			for(int j = 0; j < r[i].jetons.length; j++) {
				if (noir >= 0) {
					g.setColor(Modele.COULEURS[6]);
					g.fillOval(r[i].jetons.length * 50 + j * 20, i * 50, 20, 20);
					noir -= 1;
				}
				else if (blanc >= 0){
					g.setColor(Modele.COULEURS[5]);
					g.fillOval(r[i].jetons.length * 50 + j * 20, i * 50, 20, 20);
					blanc -= 1;
				}
			}
		}
		
		if(m.get_etat() == Modele.Etat.EN_COURS) {
			Rangee enCour = m.get_prop_actuel();
			for(int i = 0; i < Modele.DIFFICULTE; i++) {
				if (enCour.jetons[i] == null) {
					g.setColor(Modele.COULEURS[6]);
					g.drawOval(i * 50, (r[0].jetons.length - 1) * 50, 40, 40);
				}
				else {
					g.setColor(enCour.jetons[i]);
					g.fillOval(i * 50, (r[0].jetons.length - 1) * 50, 40, 40);
				}
				
			}
		}
	}
}
