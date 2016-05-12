/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobs;

/**
 *<p><strong>Définie le type de monstre polivalents de rang C.</strong></p>
 *<p>Hérite de {@link Monstres}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MonstresPolyC extends Monstres{
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un monstre
    * polivalents de rang C ainsi que ses probabilités d'attaque et d'attaque
    * magique.</Strong></p>
    *<p>Ce concstructeur est le constructeur par défault, complètant
    * celui de {@link Monstres}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MonstresPolyC(){
        super();
        this.vie_max = 50;
        this.vie = 50;
        this.atq = 30;
        this.atq_mag = 30;
        this.def = 14;
        this.def_mag = 14;
        this.agilite = 30;
        this.xp = 80;
        this.or = 40;
        this.proba_atq = 5;
        this.proba_atq_mag = 5;
    }
}
