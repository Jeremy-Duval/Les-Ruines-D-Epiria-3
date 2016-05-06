/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perso;

import armes.ArmeUtilise;
import armes.Sceptre;

/**
 *<p><strong>Définie le type de personnage Mage.</strong></p>
 * <p>Hérite de {@link Personnage}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class Mage extends Personnage {
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un personnage 
    *de type "Mage" ainsi que son inventaire.</Strong></p>
    *<p>Ce concstructeur est le constructeur par défault, complètant
    * celui de {@link Personnage}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public Mage(){
        super();
        this.classe_pers = "Mage";
        this.arme_possible = new Sceptre();
        this.arme_use = new ArmeUtilise(arme_possible, 0);
    }
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un personnage 
    *de type "Mage" ainsi que son inventaire, tout en initialisant l'arme utilisée
    * par une passée en paramètre.</Strong></p>
    *<p>Ce concstructeur complète celui de {@link Personnage}</p>
    *@author Jérémy Duval
    *@param arme_u : ArmeUtilise : arme utilisé
    *@since 1.0
    */
    public Mage(ArmeUtilise arme_u){
        super();
        this.classe_pers = "Mage";
        this.arme_possible = new Sceptre();
        this.arme_use = new ArmeUtilise(arme_u.getTypeArme(), arme_u.getValeurArme());
    }
}
