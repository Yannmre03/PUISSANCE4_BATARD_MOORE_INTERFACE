/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4_batard_moore;

import java.util.Random;

/**
 *
 * @author Administrateur
 */
public class Partie {
    Joueur [] ListeJoueurs = new Joueur[2]; // tableau de joueurs 
    Joueur joueurCourant;
    PlateauDeJeu grilleJeu = new PlateauDeJeu();
    
    public void attribuerCouleursAuxJoueurs(){      //temporaire
        ListeJoueurs[0].affecterCouleur("rouge");       
        ListeJoueurs[1].affecterCouleur("jaune");
    }
    
    public void initialiserPartie(){
        
        for (int i=0; i<21; i++){
            ListeJoueurs[0].ajouterJeton(new Jeton(ListeJoueurs[0].couleur));
            ListeJoueurs[1].ajouterJeton(new Jeton(ListeJoueurs[1].couleur));
        }
        for (int i =0; i<5; i++){
            Random rand = new Random();
            int ligne = rand.nextInt(5);
            int colonne = rand.nextInt(6);
            grilleJeu.placerTrouNoir(ligne, colonne);
            if (i % 2 !=0){
                grilleJeu.placerDesintegrateur(ligne, colonne);
            }
        }
        for (int j =0; j<3; j++){
            Random rand = new Random();
            int ligne = rand.nextInt(5);
            int colonne = rand.nextInt(6);
            if (grilleJeu.placerTrouNoir(ligne, colonne) == false && grilleJeu.placerDesintegrateur(ligne, colonne)){
                grilleJeu.placerDesintegrateur(ligne, colonne);
                
            }else{
                j-=1;
            }
        }      
    }
    
}
