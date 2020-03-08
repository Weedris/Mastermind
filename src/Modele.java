import java.awt.Color;

public class Modele {
	public static Color[] COULEURS = {Color.yellow, Color.blue, Color.magenta, Color.red, Color.orange, Color.white, Color.black};
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
	
	public int getTentative() {
		return tentatives;
	}
	
	public void prop_verification() {
		prop_actuel.noirs = 0;
		for(int i=0; i<DIFFICULTE; i++) {
			if(prop_actuel.jetons[i] == combinaison.jetons[i]) {
				prop_actuel.noirs += 1;
			}
		}
		prop_actuel.blancs = -prop_actuel.noirs;
		
		for(int i=0; i<COULEURS.length; i++) {
			int n = 0;
			int m = 0;
			
			for(int j=0; j<DIFFICULTE;j++) {
				if(prop_actuel.jetons[j].equals(COULEURS[i])) {
					n = n+1;
				}
				if(combinaison.jetons[j].equals(COULEURS[i])){
					m = m+1;
				}
			}
			if(n<m){
				prop_actuel.blancs = prop_actuel.blancs+n;
			}
			else{
				prop_actuel.blancs = prop_actuel.blancs+m;
			}
		}
		System.out.println(prop_actuel.blancs);
		System.out.println(prop_actuel.noirs);
		
	}

	public void new_prop() {
		prop_actuel = new Rangee(false);
		
	}
	
	public void complete_prop(Color c) {
		prop_actuel.jetons[prop_actuel.indice_jeton] = c;
		prop_actuel.indice_jeton +=1;
		if (prop_actuel.indice_jeton == DIFFICULTE) {
			prop_verification();
			if(win()){
				archiverProp();
				System.out.println("C'est gagner");
			}
			else{
				System.out.println("Perdu on recommence !");
				archiverProp();
				new_prop();
			}
		}
	}
	
	public boolean win() {
		if(prop_actuel.noirs == DIFFICULTE) {
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
		System.out.println(m.prop_actuel);
		m.complete_prop(Color.orange);//white
		m.complete_prop(Color.magenta);//magenta
		m.complete_prop(Color.blue);//orange
		m.complete_prop(Color.magenta);//magenta
		//________________________________________
		m.complete_prop(Color.magenta);
		m.complete_prop(Color.magenta);
		m.complete_prop(Color.blue);
		m.complete_prop(Color.blue);
		//________________________________________
		m.complete_prop(Color.white);
		m.complete_prop(Color.magenta);
		m.complete_prop(Color.orange);
		m.complete_prop(Color.magenta);
		
		System.out.println(m.tentatives);
		
		Vue v = new Vue(m);
		
	}
}

