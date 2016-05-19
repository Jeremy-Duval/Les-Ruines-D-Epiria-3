/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobs;

/**
 * <p>
 * <strong>Définie le type de monstre magie de rang C.</strong></p>
 * <p>
 * Hérite de {@link Monstres}</p>
 *
 * @author Jérémy Duval
 * @since 1.0
 */
public class MonstresMagieC extends Monstres {

    /**
     * <p>
     * <Strong>Ce constructeur permet d'initialiser tout les stats d'un monstre
     * magie de rang C ainsi que ses probabilités d'attaque et d'attaque
     * magique.</Strong></p>
     * <p>
     * Ce concstructeur est le constructeur par défault, complètant celui de
     * {@link Monstres}</p>
     *
     * @author Jérémy Duval
     * @since 1.0
     */
    public MonstresMagieC() {
        super();
        this.vie_max = 70;
        this.vie = 70;
        this.atq = 20;
        this.atq_mag = 40;
        this.def = 10;
        this.def_mag = 18;
        this.agilite = 15;
        this.xp = 50;
        this.or = 25;
        this.proba_atq = 3;
        this.proba_atq_mag = 7;
    }
}
