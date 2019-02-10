package mancala;

import java.util.Scanner;

public class Principale {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/* */
		System.out.println("Choisissez, un ou deux joueurs? ");
		int choix = sc.nextInt();
		GameManagerAwale ArbitreAwale = new GameManagerAwale(choix);
		
		System.out.println("Choisissez la difficulté ");
		int difficulte = sc.nextInt();
		ArbitreAwale.lancerUneNouvellePartie(difficulte);
		/*
		Awale awale = new Awale("","",2);
		awale.initialisationJeu();
		 */
		//int tabInt[] = {3,12,3,3,3,3,3,3,3,4,4,4};
		/*
		JoueurAwale joueur1 = new JoueurAwaleHumain("joueur1", 0, 1);
		JoueurAwale joueur2 = new JoueurAwaleHumain("joueur2", 0, 2);
		*/
		
		while( !ArbitreAwale.finPartie() ) {
			
			//System.out.println("Donner coup a jouer : ");
			//int coupJouee = sc.nextInt();
			int coupJouee;
					
			// gestion tour:
			if( ArbitreAwale.gestionTour() == ArbitreAwale.joueur1){
				coupJouee = (int) Math.random() * (6 - 0) ;
				if( ArbitreAwale.verifierCoupValide(ArbitreAwale.joueur1,coupJouee) )
					ArbitreAwale.joueur1.jouerUnCoup(coupJouee,ArbitreAwale);
			}
			else {
				coupJouee = (int) Math.random() * ( 12 - 6 ) ;
				if( ArbitreAwale.verifierCoupValide(ArbitreAwale.joueur2,coupJouee) )
					ArbitreAwale.joueur2.jouerUnCoup(coupJouee,ArbitreAwale);
			}
			
			System.out.println(ArbitreAwale.Partie.getNbrGrainesEnJeu());
			
		}
		
		
	}

}
