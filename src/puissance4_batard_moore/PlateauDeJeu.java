/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4_batard_moore;

/**
 *
 * @author Administrateur
 */
public class PlateauDeJeu {
    CelluleDeGrille[][] grille = new CelluleDeGrille[6][7];
    
    public PlateauDeJeu(){
        for (int i=0; i < 6; i++){
            for (int j=0; j <7 ; j++){
                grille[i][j] = new CelluleDeGrille();
            }
        }
    }
    public int ajouterJetonDansColonne(Jeton UnJeton, int colonne){
        for (int k=0; k <6; k++){
            if (grille[k][colonne].lireCouleurDuJeton() == null) {
                grille[k][colonne].affecterJeton(UnJeton);
                return k; // en cours
            }
        }
        return 0;
    }
    public boolean grilleRemplie(){
            for (int j=0; j<7; j++){
                if (grille[5][j] == null){
                    return false;
                }
            }
            return true;
    }
    public void afficherGrilleSurConsole(){
        for (int i= 5; i >=0; i--){
           for (int j=0; j<7; j++){
               if (j == 6){
                   System.out.println(grille[i][j] + "\n");
               }
               else{
                   System.out.print(grille[i][j] + " " );
               }
            }
        }
    }
    public boolean presenceJeton(int ligne, int colonne){
        return grille[ligne][colonne].presenceJeton() == true;
    }
    
    public String lireCouleurDuJeton(int ligne, int colonne){
        return grille[ligne][colonne].lireCouleurDuJeton();
    }
    
    public boolean ligneGagnantePourCouleur(String couleur){
        int compteur = 0;
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                if (grille[i][j].lireCouleurDuJeton() == couleur){
                    compteur+=1;
                    if (compteur == 4){
                        return true;
                    }
                }
                else{
                    compteur=0;
                }
            }
            compteur = 0;
        }
        return false;
    }
    
    public boolean colonneGagnantePourCouleur(String couleur){
        int compteur = 0;
        for (int j=0; j<7; j++){
            for (int i=0; i<6; i++){
                if (grille[i][j].lireCouleurDuJeton() == couleur){
                    compteur+=1;
                    if (compteur == 4){
                        return true;
                    }
                }
                else{
                    compteur=0;
                }
            }
            compteur = 0;
        }
        return false;
    }
    
    public boolean diagonaleMontanteGagnantePourCouleur(String couleur){
        int compteur = 0;
        
        for (int i=0; i<3; i++){
            for (int j=0; j<4; j++){
                    for (int k=0; k<7; k++){
                        if (grille[i+k][j+k].lireCouleurDuJeton() == couleur){
                            compteur+=1;
                        }
                        else{
                            compteur = 0;
                    }
                        if (compteur == 4){
                            return true;
                        }
                        if (i==5 && j == 6){
                            break;
                        }
                    }
                compteur = 0;
            }
        }
        return false; 
    }
    
    public boolean diagonaleDesencanteGagnantePourCouleur(String couleur){
        int compteur = 0;
        
        for (int i=3; i<6; i++){
            for (int j=0; j<4; j++){
                    for (int k=0; k<7; k++){
                        if (grille[i-k][j+k].lireCouleurDuJeton() == couleur){
                            compteur+=1;
                        }
                        else{
                            compteur = 0;
                    }
                        if (compteur == 4){
                            return true;
                        }
                        if (i==0 && j == 6){
                            break;
                        }
                    }
                compteur = 0;
            }
        }
        return false; 
    }
    
    public void tasserLigne(int colonne){
        for (int i=0; i<6;i++){
            if(grille[i][colonne] == null){
                for (int j = i; j<5; j++){  
                    grille[j][colonne] = grille[j+1][colonne];
                }
                grille[5][colonne] = null;
            }       
        }
    }
    
    public boolean colonneRemplie(int colonne){
        return grille[5][colonne] != null;      
    }
    
    public void placerTrouNoir(int ligne, int colonne){
        grille[ligne][colonne].placerTrouNoir();
    }
    
    public void supprimerTrouNoir(int ligne, int colonne){
        grille[ligne][colonne].supprimerTrouNoir();
    }
    
    public void placerDesintegrateur(int ligne, int colonne){
        grille[ligne][colonne].placerDesintegrateur();
    }
    
    public boolean presenceDesintegrateur(int ligne, int colonne){
        return grille[ligne][colonne].presenceDesintegrateur();
    }
    
    public boolean presenceTrouNoir(int ligne, int colonne){
        return grille[ligne][colonne].presenceTrouNoir();
    }
    
    public void supprimerDesintegrateur(int ligne, int colonne){
        grille[ligne][colonne].supprimerDesintegrateur();
    }
    
    public void supprimerJeton(int ligne, int colonne){
        grille[ligne][colonne].supprimerJeton();
    }
    
    public Jeton recupererJeton(int ligne, int colonne){
        return grille[ligne][colonne].recupererJeton();
    }
    }
    
    
