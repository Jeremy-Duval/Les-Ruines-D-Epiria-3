/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perso;

import armes.All;
import armes.ArmeUtilise;

/**
 *<p><strong>Définie le type de personnage Paysan.</strong></p>
 *<p>Hérite de {@link Personnage}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class Paysan extends Personnage {
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un personnage 
    *de type "Paysan" ainsi que son inventaire.</Strong></p>
    *<p>Ce concstructeur complète celui de {@link Personnage}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public Paysan(){
        super();
        this.classe_pers = "Paysan";
        this.arme_possible = new All();
        this.arme_use = new ArmeUtilise();
    }
    

}
