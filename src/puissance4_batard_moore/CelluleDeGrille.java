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
    
    public CelluleDeGrille (){
        jetonCourant =null;
        avoirTrouNoir = false;
        avoirDesintegrateur = false;
        
                
    }
    public boolean presenceJeton(){
        if (jetonCourant!= null){
            return true;
        }
        else {
            return false;
        }
        
    }
    
    public void affecterJeton(Jeton nomDuJeton) {
        jetonCourant = nomDuJeton;
    }
    
    public String lireCouleurDuJeton () {
        if (jetonCourant != null){
            if (jetonCourant.lireCouleur() == "rouge"){
                return "rouge";
            }
            else {
                return "Jaune";
            }   
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
        if (avoirTrouNoir == true){
            return true;
        }
        else{
            return false;
        }  
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
        if (avoirDesintegrateur == true){
            return true;
        }
        else{
            return false;
        }  
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
    
}