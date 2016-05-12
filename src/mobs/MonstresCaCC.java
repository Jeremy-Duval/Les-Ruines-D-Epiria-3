/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobs;

/**
 *<p><strong>Définie le type de monstre corps à corps de rang C.</strong></p>
 *<p>Hérite de {@link Monstres}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MonstresCaCC extends Monstres{
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un monstre
    * au corps à corps de rang C ainsi que ses probabilités d'attaque et d'attaque
    * magique.</Strong></p>
    *<p>Ce concstructeur est le constructeur par défault, complètant
    * celui de {@link Monstres}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MonstresCaCC(){
        super();
        this.vie_max = 70;
        this.vie = 70;
        this.atq = 40;
        this.atq_mag = 20;
        this.def = 18;
        this.def_mag = 10;
        this.agilite = 15;
        this.xp = 80;
        this.or = 40;
        this.proba_atq = 7;
        this.proba_atq_mag = 3;
    }
}
