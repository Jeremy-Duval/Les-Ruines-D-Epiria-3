/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perso;

import armes.ArmeUtilise;
import armes.Epee;

/**
 *<p><strong>Définie le type de personnage Guerrier.</strong></p>
 * <p>Hérite de {@link Personnage}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class Guerrier extends Personnage {
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un personnage 
    *de type "Guerrier" ainsi que son inventaire.</Strong></p>
    *<p>Ce concstructeur est le constructeur par défault, complètant
    * celui de {@link Personnage}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public Guerrier(){
        super();
        this.classe_pers = "Guerrier";
        this.arme_possible = new Epee();
        this.arme_use = new ArmeUtilise(arme_possible, 0);
    }
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un personnage 
    *de type "Guerrier" ainsi que son inventaire, tout en initialisant l'arme utilisée
    * par une passée en paramètre.</Strong></p>
    *<p>Ce concstructeur complète celui de {@link Personnage}</p>
    *@author Jérémy Duval
    *@param arme_u : ArmeUtilise : arme utilisé
    *@since 1.0
    */
    public Guerrier(ArmeUtilise arme_u){
        super();
        this.classe_pers = "Guerrier";
        this.arme_possible = new Epee();
        this.arme_use = new ArmeUtilise(arme_u.getTypeArme(), arme_u.getValeurArme());
    }
    /*
    public Guerrier(Personnage guerrier){
        this.classe_pers = "Guerrier";
        this.level = guerrier.getLevel();
        this.vie = guerrier.getVie();
        this.vie_actu = guerrier.getVieAcutelle();
        this.pm = guerrier.getPm();
        this.pm_actu = guerrier.getPmActuel();
        this.atq = guerrier.getAttaque();
        this.atq_mag = guerrier.getAttaqueMagique();
        this.def = guerrier.getDefense();
        this.def_mag = guerrier.getDefenseMagique();
        this.agilite = guerrier.getAgilite();
        this.intelligence = guerrier.getIntelligence();
        this.sagesse = guerrier.getSagesse();
        this.xp = guerrier.getXp();
        this.xp_nec = this.xpLevelSuivant();
    }*/
}
