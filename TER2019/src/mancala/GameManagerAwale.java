package mancala;
//gere le jeu en fonction des regles de l'awale
//il enregistre aussi l'historique de la partie
public class GameManagerAwale extends GameManager{
	
	private int NbrJoueursHumain;
	private int historiquePlateau[][] = null;
	private boolean Tour = true;
	
	JoueurAwale joueur1;
	JoueurAwale joueur2;
	Awale Partie;
	
	int i =0;
	
	//constructeurs :
	public GameManagerAwale(int nbrJoueursHumain) {
		super();
		NbrJoueursHumain = nbrJoueursHumain;
	}
	//getters & setters :
	public int getNbrJoueursHumain() {return NbrJoueursHumain;}
	public void setNbrJoueursHumain(int nbrJoueursHumain) {	NbrJoueursHumain = nbrJoueursHumain;}
	public int[][] getHistoriquePlateau() {	return historiquePlateau;}
	public void setHistoriquePlateau(int[][] historiquePlateau) {this.historiquePlateau = historiquePlateau;}
	public boolean isTour() {return Tour;}
	public void setTour(boolean tour) {Tour = tour;}

	//methods :
	public void lancerUneNouvellePartie(int difficulte){
		if(this.NbrJoueursHumain == 1) {
			this.joueur1 = new JoueurAwaleHumain("joueur1", 0, 1);
			this.joueur2 = new JoueurAwaleIA("joueur2", 0, 2);
		}
		else {
			this.joueur1 = new JoueurAwaleHumain("joueur1", 0, 1);
			this.joueur2 = new JoueurAwaleHumain("joueur2", 0, 2);
		}
		
		this.Partie  = new Awale("MonAwale","MesRègles",difficulte);
		this.Partie.initialisationJeu();
		
	}
	public void stockerEtatMouvement(int[] etatActuel) {//Historique
		for(int j=0;j<12;j++) {
			this.historiquePlateau[i][j] = etatActuel[j];
		}
		i++;
	}
	public boolean verifierCoupValide(JoueurAwale joueur, int caseJouee) {//bonne case avec bonnes regles
		//case non vide :
		if(this.Partie.getPlateau()[caseJouee] != 0) {
			if(joueur.getNumeroJoueur() == 1) {
				if( caseJouee >= 0 && caseJouee < 6 ) return true;
			}
			else {
				if( caseJouee >= 6 && caseJouee < 12 ) return true;
			}
		}
		return false;
	}
	@Override
	public JoueurAwale gestionTour() { //décide de qui va jouer
		if(i%2 == 0) return this.joueur2;
		return this.joueur1;
	}
	@Override
	public boolean finPartie() {//dire si c'est une fin de partie et arreter le jeu en fonction
		if(this.Partie.getNbrGrainesEnJeu() > 0)	return false;
		return true;//fin de partie
	}
	@Override
	public void gestionTemps() {//gere le temps allouer a chaque joueur tour a tour
		
	}
}
