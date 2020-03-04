import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;

public class VueClavier extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5095883922391434360L;
	
	
	public VueClavier(int A) {
		super();
		for (int i = 0; i < A; i++) {
			Button b = new Button();
			b.setBackground(Modele.COULEURS[i]);
			this.add(b);
		}
	}
	
}
