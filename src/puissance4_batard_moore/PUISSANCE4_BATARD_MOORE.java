/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package puissance4_batard_moore;

/**
 *
 * @author Administrateur
 */
public class PUISSANCE4_BATARD_MOORE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Joueur Julia = new Joueur("Julia");
        Joueur Yann = new Joueur("Yann");
        Partie nouvellePartie = new Partie(Julia, Yann);
        nouvellePartie.lancerPartie();
        
    }
    
}
