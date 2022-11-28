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
    private PlateauDeJeu grilleJeu = new PlateauDeJeu();
    
    public Partie(Joueur joueur1, Joueur joueur2){
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
        
    public void crerEtAffecterJeton(Joueur joueur1){
        ArrayList<Jeton> jetons = new ArrayList();
        for (int i=0; i < 30; i++){      
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
