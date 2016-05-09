/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobs;

/**
 *<p><strong>Définie le type de monstre magie de rang E.</strong></p>
 *<p>Hérite de {@link Monstres}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MonstresMagieE extends Monstres{
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un monstre
    * magie de rang E ainsi que ses probabilités d'attaque et d'attaque
    * magique.</Strong></p>
    *<p>Ce concstructeur est le constructeur par défault, complètant
    * celui de {@link Monstres}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MonstresMagieE(){
        super();
        this.vie = 20;
        this.atq = 3;
        this.atq_mag = 6;
        this.def = 1;
        this.def_mag = 4;
        this.agilite = 2;
        this.xp = 20;
        this.or = 5;
        this.proba_atq = 3;
        this.proba_atq_mag = 7;
    }
}
