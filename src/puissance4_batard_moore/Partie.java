/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4_batard_moore;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Administrateur
 */
public class Partie {

    private Joueur [] ListeJoueurs = new Joueur[2]; // tableau de joueurs 
    private Joueur joueurCourant;
    private PlateauDeJeu plateau = new PlateauDeJeu();

    public Partie(String nomJ1, String nomJ2) { // il faut recreer le tableau? 
        Joueur joueur1 = new Joueur(nomJ1);
        Joueur joueur2 = new Joueur(nomJ2);
        ListeJoueurs[0] = joueur1;
        ListeJoueurs[1] = joueur2;
    }
    
    public Joueur [] getListeJoueur(){
        return ListeJoueurs;
    }

    public PlateauDeJeu getPlateau(){
        return plateau;
    }
    
    public void attribuerCouleursAuxJoueurs() {      //temporaire
        Random r = new Random();
        int tempInt = r.nextInt(0, 2);
        if (tempInt == 1) {
            ListeJoueurs[0].affecterCouleur("rouge");
            ListeJoueurs[1].affecterCouleur("jaune");
        } else {
            ListeJoueurs[0].affecterCouleur("jaune");
            ListeJoueurs[1].affecterCouleur("rouge");
        }
    }

    public void creerEtAffecterJeton(Joueur joueur) {
        Jeton[] jetons = new Jeton[30];
        for (int i = 0; i < 30; i++) {
            jetons[i] = new Jeton(joueur.getCouleur());
            joueur.ajouterJeton(jetons[i]);
        }
    }

    public void placerTrousNoirsEtDesintegrateurs() {
        Random l = new Random();
        Random c = new Random();
        for (int i = 0; i < 3; i++) {
            int ligne = l.nextInt(0, 6);
            int colonne = c.nextInt(0, 7);
            if (plateau.presenceTrouNoir(ligne, colonne) == false && plateau.presenceDesintegrateur(ligne, colonne) == false) {
                plateau.placerTrouNoir(ligne, colonne);
                plateau.placerDesintegrateur(ligne, colonne);
            } else {
                i -= 1;
            }
        }
        for (int j = 0; j < 2; j++) {
            int ligne = l.nextInt(0, 6);
            int colonne = c.nextInt(0, 7);
            if (plateau.presenceDesintegrateur(ligne, colonne) == false) {
                plateau.placerDesintegrateur(ligne, colonne);
            } else {
                j -= 1;
            }
        }
        for (int k = 0; k < 2; k++) {
            int ligne = l.nextInt(0, 6);
            int colonne = c.nextInt(0, 7);
            if (plateau.presenceTrouNoir(ligne, colonne) == false && plateau.presenceDesintegrateur(ligne, colonne) == false) {
                plateau.placerTrouNoir(ligne, colonne);
            } else {
                k -= 1;
            }
        }
    }

    public void initialiserPartie() {
        attribuerCouleursAuxJoueurs();
        creerEtAffecterJeton(ListeJoueurs[0]);
        creerEtAffecterJeton(ListeJoueurs[1]);
        placerTrousNoirsEtDesintegrateurs();
    }
    
    public Jeton recupererUnJeton(){
       int ligne, colonne; 
       Scanner sc = new Scanner(System.in);
       System.out.println("De quelle colonne veux tu recuperer ton jeton?");
       colonne = sc.nextInt();
       System.out.println("De quelle ligne veux tu recuperer ton jeton?");
       ligne = sc.nextInt();
       
       Jeton temp = plateau.recupererJeton(ligne, colonne);
       
       plateau.supprimerJeton(ligne, colonne);
       
       plateau.tassercolonne(colonne);
       
       return temp;
    }
    
    public void poserJeton(Joueur joueurCourant,String couleur){
            int colonne;
            do {
                Scanner sc = new Scanner(System.in);
                System.out.println("Dans quelle colonne veux tu placer ton jeton? (entre 0 et 6) \n");
                colonne = sc.nextInt(); // coup valide? 
                if (colonne < 0 ) {
                System.out.println("Attention! Ton chiffre est inférieur à 0. \n");
                   
                } else if (colonne > 6) {
                  System.out.println("Attention! Ton chiffre est supérieur à 6. \n");
            
                } else if (plateau.colonneRemplie(colonne)) {
                    System.out.println("Attention! La colonne que vous avez choisi est déjà remplie. \n");
                    
                }    
            } while (colonne < 0 || colonne > 6 || plateau.colonneRemplie(colonne));
            
            int ligne = plateau.derniereLigneLibre(colonne);
            if (plateau.presenceTrouNoir(ligne, colonne)){
                plateau.supprimerJeton(ligne, colonne);
                plateau.supprimerTrouNoir(ligne, colonne);
            }
            else if(plateau.presenceDesintegrateur(ligne, colonne)){
                joueurCourant.obtenirDesintegrateur();
                plateau.supprimerDesintegrateur(ligne, colonne);
                ligne = plateau.ajouterJetonDansColonne(joueurCourant.jouerJeton(), colonne);                
            }else{
                ligne = plateau.ajouterJetonDansColonne(joueurCourant.jouerJeton(), colonne);
            }
           
    }
    
    public void utiliserDesintegrateur(){       
            Scanner sc = new Scanner(System.in);
            int ligne;
            int colonne; 
            do {
                System.out.println("sur quelle ligne est le Jeton que vous voulez desintegrer?");
                ligne = sc.nextInt();
                System.out.println("sur quelle colonne est le Jeton que vous voulez desintegrer?");
                colonne = sc.nextInt();
                if(joueurCourant.getCouleur() == plateau.lireCouleurDuJeton(ligne,colonne)){
                    System.out.println("veuillez désintegrer un jeton adverse");
                }
            } while (joueurCourant.getCouleur() == plateau.lireCouleurDuJeton(ligne,colonne)); 
            joueurCourant.utiliserDesintegrateur();
            plateau.supprimerJeton(ligne, colonne);
            plateau.tassercolonne(colonne);
    }
    
    public void lancerPartie() {
        initialiserPartie();
        Random jr = new Random();
        int nvJoueur = jr.nextInt(0, 2);
        joueurCourant = ListeJoueurs[nvJoueur];
        while (plateau.partieGagnee(joueurCourant.getCouleur()) != true || plateau.grilleRemplie() != true) {            
            Scanner sc = new Scanner(System.in);
            int choix;
            do{
            System.out.println("\nau tour de: " + joueurCourant.getName());
            System.out.println("tapez 1 pour poser un jeton, 2 pour récuperer un jeton, 3 pour désintegrer un jeton adverse, 4 pour quitter la partie");
            choix = sc.nextInt();
            if(choix == 1){
                poserJeton(joueurCourant, joueurCourant.getCouleur());}
            
            else if(choix == 2) {
                joueurCourant.ajouterJeton(recupererUnJeton());}
            
            else if(choix == 3 && joueurCourant.getNbDesintegrateurs()>0){
                utiliserDesintegrateur();}
            
            plateau.afficherGrilleSurConsole();
            }while ((choix != 3 && choix != 2 && choix != 1 && choix != 4));
            
            if(choix ==4){break;}
            if(ListeJoueurs[0].getCouleur() == joueurCourant.getCouleur()){joueurCourant = ListeJoueurs[1];}
            else{joueurCourant = ListeJoueurs[0];}
        }
    }
}
