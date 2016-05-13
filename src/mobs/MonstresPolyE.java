/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobs;

/**
 *<p><strong>Définie le type de monstre polivalents de rang E.</strong></p>
 *<p>Hérite de {@link Monstres}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MonstresPolyE extends Monstres{
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un monstre
    * polivalents de rang E ainsi que ses probabilités d'attaque et d'attaque
    * magique.</Strong></p>
    *<p>Ce concstructeur est le constructeur par défault, complètant
    * celui de {@link Monstres}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MonstresPolyE(){
        super();
        this.vie_max = 15;
        this.vie = 15;
        this.atq = 6;
        this.atq_mag = 6;
        this.def = 3;
        this.def_mag = 3;
        this.agilite = 3;
        this.xp = 20;
        this.or = 5;
        this.proba_atq = 5;
        this.proba_atq_mag = 5;
    }
}
