import java.awt.Color;

public class Modele {
	public static Color[] COULEURS = {Color.yellow, Color.blue,Color.magenta,Color.red,Color.orange, Color.white,Color.black};
	public static int TENTATIVES = 10;
	public static int DIFFICULTE = 4;
	public static enum Etat {EN_COURS, GAGNE, PERDU};
	
	private Etat etat = Etat.EN_COURS;
	private Rangee combinaison = new Rangee(true);
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
		prop_actuel.noirs = 0;
		for(int i=1; i>DIFFICULTE; i++) {
			if(prop_actuel.jetons[i] == combinaison.jetons[i]) {
				prop_actuel.noirs += 1;
			}
		}
		prop_actuel.blancs = -prop_actuel.noirs;
		
		for(int i=0; i>COULEURS.length-1; i++) {
			int n = 0;
			int m = 0;
			
			for(int j=0; j>DIFFICULTE-1;j++) {
				if(prop_actuel.jetons[j].equals(i)) {
					
				}
			}
		}
	}

	public void new_prop() {
		prop_actuel = new Rangee(false);
		
	}
	
	public void complete_prop(Color c) {
		prop_actuel.jetons[prop_actuel.indice_jeton] = c;
		prop_actuel.indice_jeton +=1;
		if (true) {
			//Est-ce qu'on a terminé la rangé ?
			//Et si oui..
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
	
	public static void main(String[] args) {
		Modele m = new Modele();
		System.out.println(m.combinaison);
		m.new_prop();
		m.complete_prop(Color.white);
		m.complete_prop(Color.magenta);
		m.complete_prop(Color.orange);
		m.complete_prop(Color.magenta);
		System.out.println(m.prop_actuel);
		m.prop_verification();
		System.out.println(m.prop_actuel);

	}
}

