/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perso;

import armes.All;
import armes.ArmeUtilise;
import java.util.TreeMap;
import utilitaire.Comparateur;

/**
 *<p><strong>Définie le type de personnage Paysan.</strong></p>
 *<p>Hérite de {@link Personnage}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class Paysan extends Personnage {
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats d'un personnage 
    *de type "Paysan" ainsi que son inventaire.</Strong></p>
    *<p>Ce concstructeur complète celui de {@link Personnage}</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public Paysan(){
        super();
        this.classe_pers = "Paysan";
        this.arme_possible = new All();
        this.arme_use = new ArmeUtilise();
        
        argent = 0;
        inventaire = new TreeMap<>(new Comparateur());
        inventaire.put("Epee", 0);
        inventaire.put("Sceptre", 0);
        inventaire.put("Talisman", 0);
        inventaire.put("PotionVie", 0);
        inventaire.put("PotionPM", 0);
        inventaire.put("Armure", 0);
        inventaire.put("ArmureMagique", 0);
        level_arme = new TreeMap<>(new Comparateur());
        level_arme.put("Epee", 1);
        level_arme.put("Sceptre", 1);
        level_arme.put("Talisman", 1);
        xp_arme = new TreeMap<>(new Comparateur());
        xp_arme.put("Epee", 0);
        xp_arme.put("Sceptre", 0);
        xp_arme.put("Talisman", 0);
        xp_nec_arme = new TreeMap<>(new Comparateur());
        xp_nec_arme.put("Epee", this.xpLevelSuivantEpee());
        xp_nec_arme.put("Sceptre", this.xpLevelSuivantSceptre());
        xp_nec_arme.put("Talisman", this.xpLevelSuivantTalisman());
    }
    

}
