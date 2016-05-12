/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perso;

import Combat.SortAttaque;
import armes.ArmeUtilise;
import armes.Epee;
import java.util.TreeMap;
import utilitaire.Comparateur;

/**
 *<p><strong>Définie le type de personnage Guerrier.</strong></p>
 * <p>Hérite de {@link Personnage}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class Guerrier extends Personnage {
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un personnage 
    *de type "Guerrier".</Strong></p>
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
        this.type_sort = new SortAttaque();
        this.carac_level = new TreeMap<>(new Comparateur());
        carac_level.put("Vie", 4);
        carac_level.put("Pm", 2);
        carac_level.put("Attaque", 3);
        carac_level.put("AttaqueMagique", 1);
        carac_level.put("Defense", 2);
        carac_level.put("DefenseMagique", 1);
        carac_level.put("Agilite", 2);
        carac_level.put("Intelligence", 2);
        carac_level.put("Sagesse", 1);
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
