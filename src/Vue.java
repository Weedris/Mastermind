import java.awt.Button;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Panel;

public class Vue extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5769119333854024922L;

	
	private Panel VueClavier;
	private Canvas VuePropositions;
	
	public Vue() {
		super();
		VueClavier = new Panel();
		VuePropositions = new Canvas();

		initButton(Modele.COULEURS.length);
		
		this.setSize(400, 400);
		this.add(VuePropositions);
		this.add(VueClavier);
		this.setVisible(true);
		
	}
	
	private void initButton(int A) {
		for (int i = 0; i < A; i++) {
			Button b = new Button();
			b.setBackground(Modele.COULEURS[i]);
			VueClavier.add(b);
		}
	}
	
	
	
	public static void main(String[] args) {
		Vue v = new Vue();
	}

}
