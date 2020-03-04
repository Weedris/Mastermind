import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Vue extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5769119333854024922L;

	
	private VueClavier VC;
	private VuePropositions VP;
	
	public Vue(Modele m) {
		super();
		VC = new VueClavier(Modele.COULEURS.length);
		VP = new VuePropositions(m);

		
		this.setLayout(new BorderLayout());
		
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(400, 400);
		this.add(VP);
		this.add(VC, BorderLayout.SOUTH);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
		
	}
	
	
	
	public static void main(String[] args) {
		Modele m = new Modele();
		Rangee r = new Rangee();
		m.propositions = new Rangee[1];
		m.propositions[0] = r;
		Vue v = new Vue(m);
	}

}
