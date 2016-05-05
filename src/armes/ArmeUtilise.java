/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armes;

import java.io.Serializable;

/**
 *<p><strong>Cette classe permet la création d'un objet ArmeUtilise représentant l'arme utilisé par le personnage.</strong></p>
 * Elle comprend : <ul><li>Le type de l'arme : {@link Arme}</li>
 *                     <li>Le nom du type de l'arme : String</li>
 *                     <li>La valeur de l'arme : int</li></ul>
 * @author Jérémy Duval
 * @since 1.0
 */
public class ArmeUtilise implements Serializable{
    protected String type;
    protected int valeur;
    private Arme type_arme;
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur permet d'initialiser le type d'arme à {@link Poing},
    * son nom à "Poing" et sa valeur à 0.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public ArmeUtilise(){
        type_arme = new Poing();
        this.type = type_arme.getArmeUtil();
        valeur = 0;
    }
    /**
    *<p><Strong>Ce constructeur permet d'initialiser le type d'arme à celui voulu,
    * ainsi que son nom et sa valeur.</Strong></p>
    * @param arme : Arme : type de l'arme
    * @param val : int : valeur de l'arme
    *@author Jérémy Duval
    *@since 1.0
    */
    public ArmeUtilise(Arme arme, int val){
        type_arme = arme;
        this.type = type_arme.getArmeUtil();
        valeur = val;
    }
    
    //**************************************************************************
    //getters
    //**************************************************************************
    /**
    *<p>Cette méthode renvoie le type d'arme défini par {@link Arme}.</p>
    *@return Arme : type_arme
    *@author Jérémy Duval
    *@since 1.0
    */
    public Arme getTypeArme(){
        return type_arme;
    }
    /**
    *<p>Cette méthode renvoie le nom du type d'arme défini par {@link Arme}.</p>
    *@return String : type
    *@author Jérémy Duval
    *@since 1.0
    */
    public String getNomArme(){
        return type;
    }
    
    //**************************************************************************
    //setters
    //**************************************************************************
    /**
    *<p>Cette méthode change le type d'arme, son nom ainsi que sa valeur.</p>
    *@param arme : Arme : nouveau type d'arme
    *@param val : int : valeur de l'arme
    *@author Jérémy Duval
    *@since 1.0
    */
    public void setArme(Arme arme, int val){
        type_arme = arme;
        this.type = type_arme.getArmeUtil();
        valeur = val;
    }
    
}
