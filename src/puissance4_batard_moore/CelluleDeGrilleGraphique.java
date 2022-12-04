/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package puissance4_batard_moore;

import javax.swing.JButton;

/**
 *
 * @author Administrateur
 */
public class CelluleDeGrilleGraphique extends JButton{
    CelluleDeGrille cellulleAssociee;
    public CelluleDeGrilleGraphique(CelluleDeGrille uneCellule){
        cellulleAssociee = uneCellule;
    }
}
