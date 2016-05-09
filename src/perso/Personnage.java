/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perso;

import armes.Arme;
import armes.ArmeUtilise;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import utilitaire.Comparateur;

/**
 *<p><strong>Cette classe abstraite définie les types de personnages.</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public abstract class Personnage implements Serializable{
    
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
    protected Arme arme_possible;
    protected ArmeUtilise arme_use;
    private static Map <String, Integer> level_arme;
    
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur permet d'initialiser tout les stats du personnage 
    * ainsi que son inventaire.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
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
        inventaire.put("Armure", 0);
        inventaire.put("ArmureMagique", 0);
        level_arme = new TreeMap<>(new Comparateur());
        level_arme.put("Epee", 1);
        level_arme.put("Sceptre", 1);
        level_arme.put("Talisman", 1);
    }
    
    //**************************************************************************
    //getters
    //**************************************************************************
    
    /**
    *<p>Cette méthode renvoie le level du perso.</p>
    *@return int : level
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getLevel(){
        return this.level;
    }
    /**
    *<p>Cette méthode renvoie la vie du perso.</p>
    *@return int : vie
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getVie(){
        return this.vie;
    }
    /**
    *<p>Cette méthode renvoie la vie actuelle du perso.</p>
    *@return int : vie_actu
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getVieAcutelle(){
        return this.vie_actu;
    }
    /**
    *<p>Cette méthode renvoie les pm du perso.</p>
    *@return int : pm
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getPm(){
        return this.pm;
    }
    /**
    *<p>Cette méthode renvoie les pm du perso.</p>
    *@return int : pm_actu
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getPmActuel(){
        return this.pm_actu;
    }
    /**
    *<p>Cette méthode renvoie l'attaque du perso.</p>
    *@return int : atq
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getAttaque(){
        return this.atq;
    }
    /**
    *<p>Cette méthode renvoie l'attaque magique du perso.</p>
    *@return int : atq_mag
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getAttaqueMagique(){
        return this.atq_mag;
    }
    /**
    *<p>Cette méthode renvoie la defense du perso.</p>
    *@return int : def
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getDefense(){
        return this.def;
    }
    /**
    *<p>Cette méthode renvoie la defense magique du perso.</p>
    *@return int : def_mag
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getDefenseMagique(){
        return this.def_mag;
    }
    /**
    *<p>Cette méthode renvoie l'agilité du perso.</p>
    *@return int : agilite
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getAgilite(){
        return this.agilite;
    }
    /**
    *<p>Cette méthode renvoie l'intelligence du perso.</p>
    *@return int : intelligence
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getIntelligence(){
        return this.intelligence;
    }
    /**
    *<p>Cette méthode renvoie la sagesse du perso.</p>
    *@return int : sagesse
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getSagesse(){
        return this.sagesse;
    }
    /**
    *<p>Cette méthode renvoie les points d'xp du perso.</p>
    *@return int : xp
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getXp(){
        return this.xp;
    }
    /**
    *<p>Cette méthode renvoie les point d'xp nécessaire pour passer au niveau suivant.</p>
    *@return int : xp_nec
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getXpNecessaire(){
        return this.xp_nec;
    }
    /**
    *<p>Cette méthode renvoie l'argent du perso.</p>
    *@return int : argent
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getArgent(){
        return argent;
    }
    /**
    *<p>Cette méthode renvoie la valeur de l'épée du perso.</p>
    *@return int : inventaire.get("Epee")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getEpee(){
        return inventaire.get("Epee");
    }
    /**
    *<p>Cette méthode renvoie la valeur du sceptre du perso.</p>
    *@return int : inventaire.get("Sceptre")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getSceptre(){
        return inventaire.get("Sceptre");
    }
    /**
    *<p>Cette méthode renvoie la valeur du talisman du perso.</p>
    *@return int : inventaire.get("Talisman")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getTalisman(){
        return inventaire.get("Talisman");
    }
    /**
    *<p>Cette méthode renvoie la valeur de la potion de vie du perso.</p>
    *@return int : inventaire.get("PotionVie")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getPotionVie(){
        return inventaire.get("PotionVie");
    }
    /**
    *<p>Cette méthode renvoie la valeur de la potion de vie du perso.</p>
    *@return int : inventaire.get("PotionPM")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getPotionPm(){
        return inventaire.get("PotionPM");
    }
    /**
    *<p>Cette méthode renvoie la valeur de l'armure du perso.</p>
    *@return int : inventaire.get("Armure")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getArmure(){
        return inventaire.get("Armure");
    }
    /**
    *<p>Cette méthode renvoie la valeur de l'armure magique du perso.</p>
    *@return int : inventaire.get("ArmureMagique")
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getArmureMagique(){
        return inventaire.get("ArmureMagique");
    }
    /**
    *<p>Cette méthode renvoie le type d'arme utilisable par le perso.
    * Ce type est implémenté par l'interface {@link Arme}</p>
    *@return String : arme
    *@author Jérémy Duval
    *@since 1.0
    */
    public String getArmePossible(){
        return this.arme_possible.getArmeUtil();
    }
    /**
    *<p>Cette méthode renvoie le nom du type d'arme utilisé par le perso.
    * Ce type est implémenté par l'interface {@link ArmeUtilise}</p>
    *@return String 
    *@author Jérémy Duval
    *@since 1.0
    */
    public String getArmeUseNom(){
        return arme_use.getNomArme();
    }
    /**
    *<p>Cette méthode renvoie le type d'arme utilisé par le perso.
    * Ce type est implémenté par l'interface {@link ArmeUtilise}</p>
    *@return Arme
    *@author Jérémy Duval
    *@since 1.0
    */
    public Arme getArmeUseType(){
        return arme_use.getTypeArme();
    }
    /**
    *<p>Cette méthode renvoie la valeur de l'arme utilisé par le perso.
    * Ce type est implémenté par l'interface {@link ArmeUtilise}</p>
    *@return int
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getArmeUseValeur(){
        return arme_use.getValeurArme();
    }
    /**
    *<p>Cette méthode renvoie le niveau à l'épée du perso.</p>
    *@return int 
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getLevelEpee(){
        return level_arme.get("Epee");
    }
    /**
    *<p>Cette méthode renvoie le niveau au sceptre du perso.</p>
    *@return int 
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getLevelSceptre(){
        return level_arme.get("Sceptre");
    }
    /**
    *<p>Cette méthode renvoie le niveau au talisman du perso.</p>
    *@return int 
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getLevelTalisman(){
        return level_arme.get("Talisman");
    }
    /**
    *<p>Cette méthode renvoie la classe du perso.</p>
    *@return int 
    *@author Jérémy Duval
    *@since 1.0
    */
    public String getClassePerso(){
        return this.classe_pers;
    }
    
    //**************************************************************************
    //setters
    //**************************************************************************
    /**
    *<p>Cette méthode change le level du perso ainsi que les xp nécessaires au prochain level.</p>
    *@param n_lev : int : nouveau level
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setLevel(int n_lev){
        this.level = n_lev;
        xpLevelSuivant();
    }
    /**
    *<p>Cette méthode change la vie du perso.</p>
    *@param n_vie : int : nouvelle vie
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setVie(int n_vie){
        this.vie = n_vie;
    }
    /**
    *<p>Cette méthode change la vie actuelle du perso.</p>
    *@param n_vie_actu : int : nouvelle vie actuelle
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setVieAcutelle(int n_vie_actu){
        this.vie_actu = n_vie_actu;
    }
    /**
    *<p>Cette méthode change les pm du perso.</p>
    *@param n_pm : int : nouveaux pm
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setPm(int n_pm){
        this.pm = n_pm;
    }
    /**
    *<p>Cette méthode change les pm du perso.</p>
    *@param n_pm_actu : int : nouveaux pm actuels
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setPmActuel(int n_pm_actu){
        this.pm_actu = n_pm_actu;
    }
    /**
    *<p>Cette méthode change l'attaque du perso.</p>
    *@param n_atq : int : nouveaux points d'attaque
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setAttaque(int n_atq){
        this.atq = n_atq;
    }
    /**
    *<p>Cette méthode change l'attaque du perso.</p>
    *@param n_atq_mag : int : nouveaux points d'attaque
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setAttaqueMagique(int n_atq_mag){
        this.atq_mag = n_atq_mag;
    }
    /**
    *<p>Cette méthode modifie la defense du perso.</p>
    *@param n_def : int : nouveaux points défense
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setDefense(int n_def){
        this.def = n_def;
    }
    /**
    *<p>Cette méthode modifie la defense magique du perso.</p>
    *@param n_def_magique : int : nouveaux points défense magique
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setDefenseMagique(int n_def_magique){
        this.def_mag = n_def_magique;
    }
    /**
    *<p>Cette méthode modifie l'agilité du perso.</p>
    *@param n_agilite : int : nouveaux points d'agilité
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setAgilite(int n_agilite){
        this.agilite = n_agilite;
    }
    /**
    *<p>Cette méthode modifie l'intelligence du perso.</p>
    *@param n_intelligence : int : nouveaux points d'intelligence
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setIntelligence(int n_intelligence){
        this.intelligence = n_intelligence;
    }
    /**
    *<p>Cette méthode modifie la sagesse du perso.</p>
    *@param n_sagesse : int : nouveaux points de sagesse
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setSagesse(int n_sagesse){
        this.sagesse = n_sagesse;
    }
    /**
    *<p>Cette méthode modifie les points d'xp du perso.</p>
    *@param n_xp : int : nouveaux points d'xp
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setXp(int n_xp){
        this.xp = n_xp;
    }
    /**
    *<p>Cette méthode modifie l'argent du perso.</p>
    *@param n_argent : int : nouvel argent
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setArgent(int n_argent){
        argent = n_argent;
    }
    /**
    *<p>Cette méthode modifie la valeur de l'épée du perso.</p>
    *@param n_epee : int : nouvelle épée
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setEpee(int n_epee){
        inventaire.remove("Epee", inventaire.get("Epee"));
        inventaire.put("Epee", n_epee);
    }
    /**
    *<p>Cette méthode modifie la valeur du sceptre du perso.</p>
    *@param n_sceptre : int : nouveau sceptre
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setSceptre(int n_sceptre){
        inventaire.remove("Sceptre", inventaire.get("Sceptre"));
        inventaire.put("Sceptre", n_sceptre);
    }
    /**
    *<p>Cette méthode modifie la valeur du talisman du perso.</p>
    *@param n_talisman : int : nouveau talisman
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setTalisman(int n_talisman){
        inventaire.remove("Talisman", inventaire.get("Talisman"));
        inventaire.put("Talisman", n_talisman);
    }
    /**
    *<p>Cette méthode modifie la valeur de la potion de vie du perso.</p>
    *@param n_potion_vie : int : nouvelle potion de vie
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setPotionVie(int n_potion_vie){
        inventaire.remove("PotionVie", inventaire.get("PotionVie"));
        inventaire.put("PotionVie", n_potion_vie);
    }
    /**
    *<p>Cette méthode modifie la valeur de la potion de pm du perso.</p>
    *@param n_potion_pm : int : nouvelle potion de pm
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setPotionPM(int n_potion_pm){
        inventaire.remove("PotionPM", inventaire.get("PotionPM"));
        inventaire.put("PotionPM", n_potion_pm);
    }
    /**
    *<p>Cette méthode modifie la valeur de l'armure du perso.</p>
    *@param n_armure : int : nouvelle armure
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setArmure(int n_armure){
        inventaire.remove("Armure", inventaire.get("Armure"));
        inventaire.put("Armure", n_armure);
    }
    /**
    *<p>Cette méthode modifie la valeur de l'armure magique du perso.</p>
    *@param n_armure_magique : int : nouvelle armure magique
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setArmureMagique(int n_armure_magique){
        inventaire.remove("ArmureMagique", inventaire.get("ArmureMagique"));
        inventaire.put("ArmureMagique", n_armure_magique);
    }
    /**
    *<p>Cette méthode modif l'arme utilisé par le perso.
    * Ce type est implémenté par l'interface {@link ArmeUtilise}</p>
    * @param new_arme : Arme
    * @param new_val : int
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setArmeUse(Arme new_arme, int new_val){
        this.arme_use.setArme(new_arme, new_val);
    }
    /**
    *<p>Cette méthode change le niveau à l'épée du perso.</p> 
    * @param nlevel_epee : int
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setLevelEpee(int nlevel_epee){
        level_arme.remove("Epee", level_arme.get("Epee"));
        level_arme.put("Epee", nlevel_epee);
    }
    /**
    *<p>Cette méthode change le niveau au sceptre du perso.</p> 
    *@param nlevel_sceptre : int
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setLevelSceptre(int nlevel_sceptre){
        level_arme.remove("Sceptre", level_arme.get("Sceptre"));
        level_arme.put("Sceptre", nlevel_sceptre);
    }
    /**
    *<p>Cette méthode change le niveau au talisman du perso.</p> 
    * @param nlevel_talisman : int
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setLevelTalisman(int nlevel_talisman){
        level_arme.remove("Talisman", level_arme.get("Talisman"));
        level_arme.put("Talisman", nlevel_talisman);
    }
    
    //**************************************************************************
    //fonctions
    //**************************************************************************
    
    /**
    *<p>Cette méthode calcul le nombre d'XP necessaire au prochain level.</p>
    *@return Int : nombre d'XP nécessaire au passage du prochain niveau.
    *@author Jérémy Duval
    *@since 1.0
    */
    protected final int xpLevelSuivant(){
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
                + "\nSagesse : " + this.sagesse + "\nPoints d'XP : " + this.xp + "/" + this.xp_nec + "\nArme utilisable : "
                + this.arme_possible.getArmeUtil() + "\nArme utilisée : " + this.arme_use.getNomArme() + ", de puissance : "
                + this.arme_use.getValeurArme() + "\n" + this.toInventaire();
    }
}
