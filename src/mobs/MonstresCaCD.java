/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobs;

/**
 *<p><strong>Définie le type de monstre corps à corps de rang D.</strong></p>
 *<p>Hérite de {@link Monstres}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MonstresCaCD extends Monstres{
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un monstre
    * au corps à corps de rang D ainsi que ses probabilités d'attaque et d'attaque
    * magique.</Strong></p>
    *<p>Ce concstructeur est le constructeur par défault, complètant
    * celui de {@link Monstre}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MonstresCaCD(){
        super();
        this.vie = 30;
        this.atq = 12;
        this.atq_mag = 6;
        this.def = 9;
        this.def_mag = 4;
        this.agilite = 5;
        this.xp = 40;
        this.or = 15;
        this.proba_atq = 7;
        this.proba_atq_mag = 3;
    }
}
