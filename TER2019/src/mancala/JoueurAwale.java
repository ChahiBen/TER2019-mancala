package mancala;
//peut jouer un coup en fonction du plateau.
//le comportement change q'il s'agit d'un humain ou d'une IA
public abstract class JoueurAwale extends Joueur{
	
	GameManagerAwale gameManagerAwale;

	public JoueurAwale(String nomJoueur, int score, int numeroJoueur) {
		super(nomJoueur, score, numeroJoueur);
	}

	@Override
	public void jouerUnCoup(int caseJouee, GameManagerAwale gameManagerAwale) {//mise a jour des valeurs du plateau
		int CaseActuelle = caseJouee;
		int nbrGrainesADeplacer = gameManagerAwale.Partie.getPlateau()[caseJouee];
		gameManagerAwale.Partie.getPlateau()[caseJouee]=0;
		
		while(nbrGrainesADeplacer>0) {
			if(caseJouee==0 && CaseActuelle==11) CaseActuelle = 1;
			else if(CaseActuelle == caseJouee-1)CaseActuelle += 2;
			else if (CaseActuelle == 11) CaseActuelle = 0;
			else CaseActuelle++;
			gameManagerAwale.Partie.getPlateau()[CaseActuelle]++;
			nbrGrainesADeplacer--;			
		}
		//enlever les graines = 2 ou =3
		// diminuer le nbr de graines du plateau
		prendreGraines(CaseActuelle, gameManagerAwale);
		
	}
	public void prendreGraines(int CaseActuelle, GameManagerAwale gameManagerAwale) {
		//enlever les graines = 2 ou =3 et augmenter le score du joueurs
		int min,max;
		if( this.getNumeroJoueur() == 2 ) {
			min= 0;
			max= 5;
		}
		else {
			min = 6;
			max= 11; 
		}
		while( CaseActuelle <= max && CaseActuelle >= min && ( gameManagerAwale.Partie.getPlateau()[CaseActuelle] == 2 || gameManagerAwale.Partie.getPlateau()[CaseActuelle] == 3 ) ) {
			this.setScore(gameManagerAwale.Partie.getPlateau()[CaseActuelle]);
			
			gameManagerAwale.Partie.setNbrGrainesEnJeu(gameManagerAwale.Partie.getNbrGrainesEnJeu() - gameManagerAwale.Partie.getPlateau()[CaseActuelle] );
			
			gameManagerAwale.Partie.getPlateau()[CaseActuelle] = 0;
			CaseActuelle--;
		}
		
	}

	@Override
	public abstract int getJeu();//a redefinir dans classe fille
		

}