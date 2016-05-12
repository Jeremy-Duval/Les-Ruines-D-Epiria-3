/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perso;

import Combat.SortAttaque;
import armes.ArmeUtilise;
import armes.Sceptre;
import java.util.TreeMap;
import utilitaire.Comparateur;

/**
 *<p><strong>Définie le type de personnage Mage.</strong></p>
 * <p>Hérite de {@link Personnage}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class Mage extends Personnage {
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un personnage 
    *de type "Mage".</Strong></p>
    *<p>Ce concstructeur est le constructeur par défault, complètant
    * celui de {@link Personnage}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public Mage(){
        super();
        this.classe_pers = "Mage";
        this.arme_possible = new Sceptre();
        this.arme_use = new ArmeUtilise(arme_possible, 0);
        this.type_sort = new SortAttaque();
        this.carac_level = new TreeMap<>(new Comparateur());
        carac_level.put("Vie", 3);
        carac_level.put("Pm", 4);
        carac_level.put("Attaque", 1);
        carac_level.put("AttaqueMagique", 3);
        carac_level.put("Defense", 1);
        carac_level.put("DefenseMagique", 2);
        carac_level.put("Agilite", 1);
        carac_level.put("Intelligence", 4);
        carac_level.put("Sagesse", 1);
    }
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un personnage 
    *de type "Mage" ainsi que son inventaire, tout en initialisant l'arme utilisée
    * par une passée en paramètre.</Strong></p>
    *<p>Ce concstructeur complète celui de {@link Personnage}</p>
    *@author Jérémy Duval
    *@param arme_u : ArmeUtilise : arme utilisé
    *@since 1.0
    */
    public Mage(ArmeUtilise arme_u){
        super();
        this.classe_pers = "Mage";
        this.arme_possible = new Sceptre();
        this.arme_use = new ArmeUtilise(arme_u.getTypeArme(), arme_u.getValeurArme());
    }
}
