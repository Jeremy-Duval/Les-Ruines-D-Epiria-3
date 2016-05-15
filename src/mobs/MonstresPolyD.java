/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobs;

/**
 *<p><strong>Définie le type de monstre polivalents de rang D.</strong></p>
 *<p>Hérite de {@link Monstres}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MonstresPolyD extends Monstres{
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un monstre
    * polivalents de rang D ainsi que ses probabilités d'attaque et d'attaque
    * magique.</Strong></p>
    *<p>Ce concstructeur est le constructeur par défault, complètant
    * celui de {@link Monstres}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MonstresPolyD(){
        super();
        this.vie_max = 20;
        this.vie = 20;
        this.atq = 10;
        this.atq_mag = 10;
        this.def = 7;
        this.def_mag = 7;
        this.agilite = 10;
        this.xp = 20;
        this.or = 10;
        this.proba_atq = 5;
        this.proba_atq_mag = 5;
    }
}
