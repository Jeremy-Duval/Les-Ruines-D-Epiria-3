/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perso;

import java.util.Map;
import java.util.TreeMap;
import utilitaire.Comparateur;

/**
 *Cette classe abstraite définie les types de personnages.
 * @author p1501022
 * @since 1.0
 */
public abstract class Personnage {
    
    //Caracteristique du personnage :
    protected String classe_pers;
    protected int level;
    protected int vie;
    protected int vie_actu;
    protected int pm;
    protected int pm_actu;
    protected int atq;
    protected int atq_mag;
    protected int def;
    protected int def_mag;
    protected int agilite;
    protected int intelligence;
    protected int sagesse;
    //Atributs spécifiques :
    protected int xp;
    protected int xp_nec;
    protected int argent;
    protected Map <String, Integer> inventaire;
    //arme
    //cf interface
    
    //constructeurs
    public Personnage(){
        this.level = 1;
        this.vie = 20;
        this.vie_actu = 20;
        this.pm = 5;
        this.pm_actu = 5;
        this.atq = 7;
        this.atq_mag = 7;
        this.def = 2;
        this.def_mag = 2;
        this.agilite = 3;
        this.intelligence = 0;
        this.sagesse = 0;
        this.xp = 0;
        this.xp_nec = this.xpLevelSuivant();
        this.argent = 0;
        inventaire = new TreeMap<>(new Comparateur());
        inventaire.put("Epee", 0);
        inventaire.put("Sceptre", 0);
        inventaire.put("Talisman", 0);
        inventaire.put("PotionVie", 0);
        inventaire.put("PotionPM", 0);
    }
    
    
    //getters
    
    //setters
    
    //fonctions
    protected int xpLevelSuivant(){
        return (int)(this.level*10*0.75);
    }
    
    //redéfinition
    
    //redèf toString()
}
