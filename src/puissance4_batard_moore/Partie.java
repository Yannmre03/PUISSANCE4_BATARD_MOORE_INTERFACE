/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4_batard_moore;

import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author Administrateur
 */
public class Partie {
    private Joueur [] ListeJoueurs = new Joueur[2]; // tableau de joueurs 
    private Joueur joueurCourant;
    private PlateauDeJeu plateau = new PlateauDeJeu();
    
    public Partie(Joueur joueur1, Joueur joueur2){ // il faut recreer le tableau? 
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;        
    }
    
    public void attribuerCouleursAuxJoueurs(){      //temporaire
        Random r = new Random();
        int tempInt = r.nextInt(1, 2);
        if(tempInt == 1){
            ListeJoueurs[0].affecterCouleur("rouge");
            ListeJoueurs[1].affecterCouleur("jaune");
        }
        else{
            ListeJoueurs[0].affecterCouleur("jaune");
            ListeJoueurs[1].affecterCouleur("rouge");
        }
    }
        
    public void creerEtAffecterJeton(Joueur joueur){
        Jeton [] jetons = new Jeton[30];
        for (int i=0; i < 30; i++){
            jetons[i] = new Jeton(joueur.couleur);
            joueur.ajouterJeton(jetons[i]);
        }
    }
    
    public void placerTrousNoirsEtDesintegrateurs(){
        Random l = new Random();
        Random c = new Random();
        for (int i=0; i<3; i++){
            int ligne = l.nextInt(0, 6);
            int colonne = c.nextInt(0, 7);
            if (plateau.presenceTrouNoir(ligne, colonne) == false && plateau.presenceDesintegrateur(ligne, colonne) == false){
                plateau.placerTrouNoir(ligne, colonne);
                plateau.placerDesintegrateur(ligne, colonne);
            }
            else{
                i -=1;
            }
        }
        for (int j=0;j<2;j++){
            int ligne = l.nextInt(0, 6);
            int colonne = c.nextInt(0, 7);
            if (plateau.presenceDesintegrateur(ligne, colonne) == false){
                plateau.placerDesintegrateur(ligne, colonne);
            }
            else{
                j -=1;
            }
        }
        for (int k=0; k<2; k++){
            int ligne = l.nextInt(0, 6);
            int colonne = c.nextInt(0, 7);
            if (plateau.presenceTrouNoir(ligne, colonne) == false && plateau.presenceDesintegrateur(ligne, colonne) == false){
                plateau.placerTrouNoir(ligne, colonne);
            }
            else{
                k -=1;
            }
        }
        
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
            plateau.placerTrouNoir(ligne, colonne);
            if (i % 2 !=0){
                plateau.placerDesintegrateur(ligne, colonne);
            }
        }
        for (int j =0; j<3; j++){
            Random rand = new Random();
            int ligne = rand.nextInt(5);
            int colonne = rand.nextInt(6);
            if (plateau.placerTrouNoir(ligne, colonne) == false && plateau.placerDesintegrateur(ligne, colonne)){
                plateau.placerDesintegrateur(ligne, colonne);
                
            }else{
                j-=1;
            }
        }      
    }
    
}
