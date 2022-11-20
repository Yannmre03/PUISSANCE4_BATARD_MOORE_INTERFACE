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
        for (int k=5; k >=0; k--){
            if (grille[k][colonne].lireCouleurDuJeton() == "rouge" || grille[k][colonne].lireCouleurDuJeton() == "jaune") {
                grille[k+1][colonne].affecterJeton(UnJeton);
                return k+1; // en cours
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
        for (int i= 0; i <6; i++){
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
        
        for (int i=3; i<6; i++){
            for (int j=0; j<7; j++){
                if (grille[i-compteur][j].lireCouleurDuJeton() == couleur){
                    compteur+=1;
                    if (compteur == 4){
                        return true;
                    }
                }
                else{
                    compteur = 0;
                    if (j >= 3){
                        break;
                    }
                }
            }
        }
        return false; 
    }
    
    }

