/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4_batard_moore;

/**
 *
 * @author Administrateur
 */
public class CelluleDeGrille {
    private Jeton jetonCourant;
    private boolean avoirTrouNoir;
    private boolean avoirDesintegrateur;
    
    public CelluleDeGrille(){
        jetonCourant = null;
        avoirTrouNoir = false;
        avoirDesintegrateur = false;
        
                
    }
    
    public boolean presenceJeton(){
        return jetonCourant!= null;
    }
    
    public void affecterJeton(Jeton nomDuJeton) {
        jetonCourant = nomDuJeton;
    }
    
    public String lireCouleurDuJeton () {
        if (jetonCourant != null){
            return jetonCourant.lireCouleur();
        }
        else{
        return "vide"; 
        }
    }
    public void placerTrouNoir(){
        avoirTrouNoir =true;
    }   
    public void supprimerTrouNoir(){
        avoirTrouNoir = false;
    }
    public boolean presenceTrouNoir(){
        return avoirTrouNoir;   
        }  
 
    public Jeton recupererJeton(){
        Jeton temp = jetonCourant;
        jetonCourant = null;
        return temp;
    }
    public void supprimerJeton(){
        jetonCourant = null;
    }
    
    public boolean presenceDesintegrateur(){
        return avoirDesintegrateur;
    }
    public void placerDesintegrateur(){
        avoirDesintegrateur =true;
    }   
    public void supprimerDesintegrateur(){
        avoirDesintegrateur = false;
    }
    
    public void activerTrouNoir(){
        supprimerJeton();
        supprimerTrouNoir();
    }
    
    @Override
    public String toString () {                             // méthode string 
        if (lireCouleurDuJeton() == "rouge"){
            return "R";
        }
        if(lireCouleurDuJeton() == "jaune"){
            return "J";
        }
        
        if(avoirTrouNoir){
            return "@";
        }
        else if(avoirDesintegrateur){
            return "D";
        }
    return ".";
    }
    
}