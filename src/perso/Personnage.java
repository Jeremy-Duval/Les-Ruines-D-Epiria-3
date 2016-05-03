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
 *<p><strong>Cette classe abstraite définie les types de personnages</strong></p>
 * @author Jérémy Duval
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
    private static int argent;
    private static Map <String, Integer> inventaire;
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
        argent = 0;
        inventaire = new TreeMap<>(new Comparateur());
        inventaire.put("Epee", 0);
        inventaire.put("Sceptre", 0);
        inventaire.put("Talisman", 0);
        inventaire.put("PotionVie", 0);
        inventaire.put("PotionPM", 0);
    }
    
    //**************************************************************************
    //getters
    //**************************************************************************
    
    /**
    *<p>Cette méthode renvoie le level du perso.</p>
    *@return Int : level
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getLevel(){
        return this.level;
    }
    /**
    *<p>Cette méthode renvoie la vie du perso.</p>
    *@return Int : vie
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getVie(){
        return this.vie;
    }
    /**
    *<p>Cette méthode renvoie la vie actuelle du perso.</p>
    *@return Int : vie_actu
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getVieAcutelle(){
        return this.vie_actu;
    }
    /**
    *<p>Cette méthode renvoie les pm du perso.</p>
    *@return Int : pm
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getPm(){
        return this.pm;
    }
    /**
    *<p>Cette méthode renvoie les pm du perso.</p>
    *@return Int : pm_actu
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getPmActuel(){
        return this.pm_actu;
    }
    /**
    *<p>Cette méthode renvoie l'attaque du perso.</p>
    *@return Int : atq
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getAttaque(){
        return this.atq;
    }
    /**
    *<p>Cette méthode renvoie l'attaque magique du perso.</p>
    *@return Int : atq_mag
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getAttaqueMagique(){
        return this.atq_mag;
    }
    /**
    *<p>Cette méthode renvoie la defense du perso.</p>
    *@return Int : def
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getDefense(){
        return this.def;
    }
    /**
    *<p>Cette méthode renvoie la defense magique du perso.</p>
    *@return Int : def_mag
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getDefenseMagique(){
        return this.def_mag;
    }
    /**
    *<p>Cette méthode renvoie l'agilité du perso.</p>
    *@return Int : agilite
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getAgilite(){
        return this.agilite;
    }
    /**
    *<p>Cette méthode renvoie l'intelligence du perso.</p>
    *@return Int : intelligence
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getIntelligence(){
        return this.intelligence;
    }
    /**
    *<p>Cette méthode renvoie la sagesse du perso.</p>
    *@return Int : sagesse
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getSagesse(){
        return this.sagesse;
    }
    /**
    *<p>Cette méthode renvoie les points d'xp du perso.</p>
    *@return Int : xp
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getXp(){
        return this.xp;
    }
    /**
    *<p>Cette méthode renvoie les point d'xp nécessaire pour passer au niveau suivant.</p>
    *@return Int : xp_nec
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getXpNecessaire(){
        return this.xp_nec;
    }
    /**
    *<p>Cette méthode renvoie l'argent du perso.</p>
    *@return Int : argent
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getArgent(){
        return argent;
    }
    /**
    *<p>Cette méthode renvoie la valeur de l'épée du perso.</p>
    *@return Int : inventaire.get("Epee")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getEpee(){
        return inventaire.get("Epee");
    }
    /**
    *<p>Cette méthode renvoie la valeur du sceptre du perso.</p>
    *@return Int : inventaire.get("Sceptre")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getSceptre(){
        return inventaire.get("Sceptre");
    }
    /**
    *<p>Cette méthode renvoie la valeur du talisman du perso.</p>
    *@return Int : inventaire.get("Talisman")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getTalisman(){
        return inventaire.get("Talisman");
    }
    /**
    *<p>Cette méthode renvoie la valeur de la potion de vie du perso.</p>
    *@return Int : inventaire.get("PotionVie")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getPotionVie(){
        return inventaire.get("PotionVie");
    }
    /**
    *<p>Cette méthode renvoie la valeur de la potion de vie du perso.</p>
    *@return Int : inventaire.get("PotionPM")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getPotionPm(){
        return inventaire.get("PotionPM");
    }
    
    //**************************************************************************
    //setters
    //**************************************************************************
    
    //**************************************************************************
    //fonctions
    //**************************************************************************
    
    /**
    *<p>Cette méthode calcul le nombre d'XP necessaire au prochain level.</p>
    *@return Int : nombre d'XP nécessaire au passage du prochain niveau.
    *@author Jérémy Duval
    *@since 1.0
    */
    protected int xpLevelSuivant(){
        return (int)(this.level*10*0.75);
    }
    
    /**
    *<p>Cette méthode renvoie le contenu de l'inventaire.</p>
    *@return String : contenu de l'inventaire.
    * @author Jérémy Duval
    * @since 1.0
    */
    public String toInventaire(){
        return "*********************************\nInventaire :\n*********************************\nEpee : " 
                + this.getEpee() + "\nSceptre : " + this.getSceptre() + "\nTalisman : " + this.getTalisman() 
                + "\nPotion de soin : " + this.getPotionVie() + "\nPotion de PM : " + this.getPotionPm() 
                + "\nOr : " + this.getArgent() + "\n";
    }
    
    //**************************************************************************
    //redéfinition
    //**************************************************************************
    
    /**
    *<p>Redéfinition de toString() afin d'afficher les statistiques du personnage
    * ainsi que le contenu de son inventaire.</p>
    * @return String : statistiques et contenu de l'inventaire.
    * @author Jérémy Duval
    * @since 1.0
    */
    @Override
    public String toString(){
        return "*********************************\nStats :\n*********************************\n"
                + "Classe : " + this.classe_pers + "\nNiveau : " + this.level + "\nVie : " + this.vie_actu + "/" + this.vie
                + "\nPm : " + this.pm_actu + "/" + this.pm + "\nAttaque : " + this.atq + "\nAttaque magique : " + this.atq_mag
                + "\nDefense : " + this.def + "\nDefense magique : " + this.def_mag + "\nIntelligence : " + this.intelligence 
                + "\nSagesse : " + this.sagesse + "\nPoints d'XP : " + this.xp + "/" + this.xp_nec + "\n" +this.toInventaire();
    }
}
