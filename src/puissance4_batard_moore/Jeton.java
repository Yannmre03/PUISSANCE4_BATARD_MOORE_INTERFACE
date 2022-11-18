/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4_batard_moore;

/**
 *
 * @author Administrateur
 */
public class Jeton {
    private String couleur;
    
    public Jeton (String couleur){
        this.couleur = couleur;
    }
    public String lireCouleur(){
        return couleur;
    }
    @Override
    public String toString () {                             // méthode string 
        if (couleur == "rouge") {
            return "R";
        } else {
            return "J";
        }
        
    }
}
