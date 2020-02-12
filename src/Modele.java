import java.awt.Color;

public class Modele {
	public static Color[] COULEURS = {Color.yellow, Color.blue,Color.magenta,Color.red,Color.orange, Color.white,Color.black};
	public static int TENTATIVES = 10;
	public static int DIFFICULTE = 4;
	public static enum Etat {EN_COURS, GAGNE, PERDU};
	
	private Etat etat;
	private Rangee combinaison = new Rangee();
	private Rangee[] propositions = new Rangee[TENTATIVES];
	private int tentatives;
	
	public void archiverProp() {
		
	}
	
	public Rangee[] getProp() {
		return propositions;
	}
	
	
}
