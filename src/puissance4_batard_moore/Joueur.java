/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4_batard_moore;

import java.util.ArrayList;

/**
 *
 * @author Administrateur
 */
public class Joueur {
    private String nom;
    private String couleur;
    private ArrayList<Jeton> reserveJetons = new ArrayList();
    private int nombreDesintegrateurs;
    
    public Joueur(String nom){
        this.nom = nom;
        this.couleur = null;
        this.nombreDesintegrateurs = 0;
    }
    
    public void affecterCouleur(String couleur){
        this.couleur = couleur;
    }
    public int nombreDeJetons(){
        return reserveJetons.size();
    }
            
    public void ajouterJeton(Jeton newJeton){
        reserveJetons.add(newJeton);
    }
    
    public Jeton jouerJeton(){
        Jeton temp = reserveJetons.remove(0);
        return temp;
    }
    public void obtenirDesintegrateur(){
        nombreDesintegrateurs+=1;
    }
    
    public int getNbDesintegrateurs(){
        return nombreDesintegrateurs;
    }
    
    public void utiliserDesintegrateur(){
            nombreDesintegrateurs-=1;      
    }
    
    public String getName(){
        return nom;
    }
    
    public String getCouleur(){
        return couleur;
    }
}
