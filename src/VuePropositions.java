import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
public class VuePropositions extends Canvas{

	/**
	 * 
	 */
	private static final long serialVersionUID = 253187160713907717L;
	
	private Modele m;
	
	public VuePropositions(Modele m) {
		this.m = m;
		this.setBackground(Color.blue);
	}
	
	public void paint(Graphics g){
		Rangee[] r = m.getProp();
		for(int i = 0; i < r.length; i++) {
			for(int j = 0; j < r[i].jetons.length; j++) {
				g.setColor(Color.green);
				g.drawOval(j * 50, i * 50, 40, 40);
				System.out.println(j * 50 + "   " + i * 50);
			}
		}
	}
	
}
