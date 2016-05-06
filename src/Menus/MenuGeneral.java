/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import java.io.Serializable;

/**
 *
 * @author jeremy
 */
public abstract class MenuGeneral implements Serializable{
    protected Auberge auberge;
    protected VenteArme vente_arme;
    protected Lieu lieu1;
    protected Lieu lieu2;
    protected Lieu lieu3;
    protected Lieu lieu4;
    protected Lieu lieu5;
    protected String choix;
    protected String nomMenu;
    
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur permet d'initialiser la variable 'choix' du menu
    * à "".</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MenuGeneral(){
        choix = "";
    }
    //**************************************************************************
    //getters
    //**************************************************************************
    
    //**************************************************************************
    //setters
    //**************************************************************************
    
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
        return this.nomMenu + "\n" + this.auberge.getAuberge() +
                this.vente_arme.getVenteArme() + this.lieu1.getLieu()
                + this.lieu2.getLieu() + this.lieu3.getLieu() 
                + this.lieu4.getLieu() + this.lieu5.getLieu() 
                + "q : Quitter\n";
    }
}
