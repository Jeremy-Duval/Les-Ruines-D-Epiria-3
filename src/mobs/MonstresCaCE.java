/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobs;

/**
 *<p><strong>Définie le type de monstre corps à corps de rang E.</strong></p>
 *<p>Hérite de {@link Monstres}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MonstresCaCE extends Monstres{
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un monstre
    * au corps à corps de rang E ainsi que ses probabilités d'attaque et d'attaque
    * magique.</Strong></p>
    *<p>Ce concstructeur est le constructeur par défault, complètant
    * celui de {@link Monstres}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MonstresCaCE(){
        super();
        this.vie_max = 20;
        this.vie = 20;
        this.atq = 6;
        this.atq_mag = 3;
        this.def = 4;
        this.def_mag = 1;
        this.agilite = 2;
        this.xp = 20;
        this.or = 5;
        this.proba_atq = 7;
        this.proba_atq_mag = 3;
    }
}
