/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobs;

/**
 *<p><strong>Définie le type de monstre magie de rang D.</strong></p>
 *<p>Hérite de {@link Monstres}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MonstresMagieD extends Monstres{
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un monstre
    * magie de rang D ainsi que ses probabilités d'attaque et d'attaque
    * magique.</Strong></p>
    *<p>Ce concstructeur est le constructeur par défault, complètant
    * celui de {@link Monstre}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MonstresMagieD(){
        super();
        this.vie = 30;
        this.atq = 6;
        this.atq_mag = 12;
        this.def = 4;
        this.def_mag = 9;
        this.agilite = 5;
        this.xp = 40;
        this.or = 15;
        this.proba_atq = 3;
        this.proba_atq_mag = 7;
    }
}
