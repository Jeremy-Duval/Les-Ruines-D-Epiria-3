/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perso;

import armes.Epee;

/**
 *<p><strong>Définie le type de personnage Guerrier.</strong></p>
 * <p>Hérite de {@link Personnage}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class Guerrier extends Personnage {
    public Guerrier(){
        super();
        this.classe_pers = "Guerrier";
        this.arme_possible = new Epee();
    }
    
    //getters
    
    //setters
    
    //fonctions
    
    //redéfinition
    
    //redèf toString()
}
