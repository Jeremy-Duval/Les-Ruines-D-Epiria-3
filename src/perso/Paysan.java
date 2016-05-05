/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perso;

import armes.All;

/**
 *<p><strong>Définie le type de personnage Paysan.</strong></p>
 *<p>Hérite de {@link Personnage}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class Paysan extends Personnage {
    public Paysan(){
        super();
        this.classe_pers = "Paysan";
        this.arme_possible = new All();
    }
    
    //getters
    
    //setters
    
    //fonctions
    
    //redéfinition
    
    //redèf toString()
}
