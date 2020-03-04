import java.awt.Color;

public class Modele {
	public static Color[] COULEURS = {Color.yellow, Color.blue,Color.magenta,Color.red,Color.orange, Color.white,Color.black};
	public static int TENTATIVES = 10;
	public static int DIFFICULTE = 4;
	public static enum Etat {EN_COURS, GAGNE, PERDU};
	
	private Etat etat = Etat.EN_COURS;
	private Rangee combinaison = new Rangee();
	private Rangee[] propositions = new Rangee[TENTATIVES];
	private Rangee prop_actuel;
	private int tentatives = 0;
	
	public void archiverProp() {
		propositions[tentatives] = prop_actuel;
		tentatives +=1;
	}
	
	public Rangee[] get_prop() {
		return propositions;
	}
	
	public void prop_verification() {
		if(prop_actuel.indice_jeton+1 == combinaison.jetons.length) {
			for(int i = 0; i<combinaison.jetons.length; i++) {
				for(int j = 0; j<combinaison.jetons.length; j++) {
					if(prop_actuel.jetons[j].equals(combinaison.jetons[i]) && i == j){
						prop_actuel.blancs +=1;
					}
					else if(prop_actuel.jetons[j].equals(combinaison.jetons[i])) {
						prop_actuel.noirs +=1;
					}
				}
			}
		}
	}

	public void new_prop() {
		prop_actuel.indice_jeton = 0;
		prop_actuel.blancs = 0;
		prop_actuel.noirs = 0;
		
	}
	
	public void complete_prop(Color c, int i) {
		if(i<prop_actuel.indice_jeton) {
			prop_actuel.jetons[i] = c;
			prop_actuel.indice_jeton +=1;
		}
	}
	
	public boolean win() {
		if(prop_actuel.blancs == DIFFICULTE) {
			etat = Etat.GAGNE;
		}
		else if(tentatives>=TENTATIVES) {
			etat = Etat.PERDU;
		}
		
		return etat == Etat.GAGNE;
	}
	
}

