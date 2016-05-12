/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mobs;

/**
 *<p><strong>Cette classe abstraite définie les types de monstre.</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public abstract class Monstres {
    protected int vie;
    protected int vie_max;
    protected int atq;
    protected int atq_mag;
    protected int def;
    protected int def_mag;
    protected int agilite;
    protected int xp;
    protected int or;
    protected int proba_atq;
    protected int proba_atq_mag;
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur ne fait rien.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public Monstres(){
    }
    
    
    //**************************************************************************
    //getters
    //**************************************************************************
    
    /**
    *<p>Cette méthode renvoie la vie du monstre.</p>
    *@return int : vie
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getVie(){
        return this.vie;
    }
    /**
    *<p>Cette méthode renvoie la vie max du monstre.</p>
    *@return int : vie
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getVieMax(){
        return this.vie_max;
    }
    /**
    *<p>Cette méthode renvoie l'attaque du monstre.</p>
    *@return int : atq
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getAttaque(){
        return this.atq;
    }
    /**
    *<p>Cette méthode renvoie l'attaque magique du monstre.</p>
    *@return int : atq_mag
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getAttaqueMagique(){
        return this.atq_mag;
    }
    /**
    *<p>Cette méthode renvoie la defense du monstre.</p>
    *@return int : def
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getDefense(){
        return this.def;
    }
    /**
    *<p>Cette méthode renvoie la defense magique du monstre.</p>
    *@return int : def_mag
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getDefenseMagique(){
        return this.def_mag;
    }
    /**
    *<p>Cette méthode renvoie l'agilité du monstre.</p>
    *@return int : agilite
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getAgilite(){
        return this.agilite;
    }
    /**
    *<p>Cette méthode renvoie l'xp rapporté par le monstre.</p>
    *@return int : xp
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getXp(){
        return this.xp;
    }
    /**
    *<p>Cette méthode renvoie l'or rapporté par le monstre.</p>
    *@return int : or
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getOr(){
        return this.or;
    }
    /**
    *<p>Cette méthode renvoie la proba d'attaque du monstre.</p>
    *@return int : proba_atq
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getProbaAtq(){
        return this.proba_atq;
    }
    /**
    *<p>Cette méthode renvoie la proba d'attaque du monstre.</p>
    *@return int : proba_atq_mag
    *@author Jérémy Duval
    *@since 1.0
    */
    public int getProbaAtqMag(){
        return this.proba_atq_mag;
    }
    
    //**************************************************************************
    //setters
    //**************************************************************************

    /**
    *<p>Cette méthode change la vie du monstre.</p>
    *@param n_vie : int : nouvelle vie
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setVie(int n_vie){
        this.vie = n_vie;
    }
    /**
    *<p>Cette méthode change l'attaque du monstre.</p>
    *@param n_atq : int : nouveaux points d'attaque
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setAttaque(int n_atq){
        this.atq = n_atq;
    }
    /**
    *<p>Cette méthode change l'attaque du monstre.</p>
    *@param n_atq_mag : int : nouveaux points d'attaque
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setAttaqueMagique(int n_atq_mag){
        this.atq_mag = n_atq_mag;
    }
    /**
    *<p>Cette méthode modifie la defense du monstre.</p>
    *@param n_def : int : nouveaux points défense
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setDefense(int n_def){
        this.def = n_def;
    }
    /**
    *<p>Cette méthode modifie la defense magique du monstre.</p>
    *@param n_def_magique : int : nouveaux points défense magique
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setDefenseMagique(int n_def_magique){
        this.def_mag = n_def_magique;
    }
    /**
    *<p>Cette méthode modifie l'agilité du monstre.</p>
    *@param n_agilite : int : nouveaux points d'agilité
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setAgilite(int n_agilite){
        this.agilite = n_agilite;
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
        return "*********************************\nMonstre :\n*********************************\n"
                + "\nVie réstante : " + this.getVie() +"\n";
    }
}
