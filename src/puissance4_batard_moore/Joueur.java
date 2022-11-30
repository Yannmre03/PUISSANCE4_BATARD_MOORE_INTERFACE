/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4_batard_moore;

import java.util.Vector;

/**
 *
 * @author Administrateur
 */
public class Joueur {
    private String nom;
    String couleur;
    Vector reserveJetons = new Vector();
    int nombreJetonsRestants;
    int nombreDesintegrateurs = 0;
    
    public Joueur(String nom){
        this.nom = nom;
    }
    
    public void affecterCouleur(String couleur){
        this.couleur = couleur;
    }
    public void ajouterJeton(Jeton newJeton){
        reserveJetons.add(newJeton);
        nombreJetonsRestants +=1;
    }
    
    
    
    
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs+=1;
    }
    public boolean utiliserDesintegrateur(){
        if(nombreDesintegrateurs >0){
            nombreDesintegrateurs-=1;
            return true;
        }
        else{
            return false;
        }
        
    }
}
