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
            else{
                return 0; //en cours 
            }
        }
        return 0; // en cours 
    }
}

