/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4_batard_moore;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Administrateur
 */
public class CelluleDeGrilleGraphique extends JButton{
    CelluleDeGrille celluleAssociee;
    ImageIcon img_vide = new javax.swing.ImageIcon(getClass().getResource("/images/celluleVide.png"));
    ImageIcon img_rouge = new javax.swing.ImageIcon(getClass().getResource("/images/jetonRouge.png"));
    ImageIcon img_jaune = new javax.swing.ImageIcon(getClass().getResource("/images/jetonJaune.png"));
    ImageIcon img_desintegrateur = new javax.swing.ImageIcon(getClass().getResource("/images/desintegrateur.png"));
    ImageIcon img_trouNoir = new javax.swing.ImageIcon(getClass().getResource("/images/trouNoir.png"));
    
    public CelluleDeGrilleGraphique(CelluleDeGrille uneCellule){
        celluleAssociee = uneCellule;
    }
    
    @Override
    public void paintComponent(Graphics G){
        super.paintComponent(G);
        if(celluleAssociee.presenceTrouNoir()){
            setIcon(img_trouNoir);
        }else if(celluleAssociee.presenceDesintegrateur()){
            setIcon(img_desintegrateur);
        }
        switch(celluleAssociee.lireCouleurDuJeton()){
            case "jaune" : 
                setIcon(img_jaune);
                break;
            case "rouge" : 
                setIcon(img_rouge);
                break;
            case "vide" : 
                setIcon(img_vide);
                break;
    }
        
        
        
    }
}
