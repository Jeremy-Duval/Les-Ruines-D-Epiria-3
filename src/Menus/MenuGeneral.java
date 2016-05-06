/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 *
 * @author jeremy
 */
public abstract class MenuGeneral implements Serializable{
    protected Auberge auberge;
    protected VenteArme vente_arme;
    protected Lieu[] lieu = new Lieu[5];
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
    //fonctions
    //**************************************************************************
    public void redirectionChoix() throws IOException{
        BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
        boolean continuer = false;
        int i;
        Auberge test_auberge;
        VenteArme test_vente_arme;
        Lieu test_lieu;
    
        while(!continuer){
            choix = buff.readLine();
            //auberge
            test_auberge = new AubergeOui();
            if(this.choix.equals("a")){
                if(this.auberge.getAuberge().equals(test_auberge.getAuberge())){//on vérifie la possibilité d'accès
                    continuer = true;
                    //renvoie au sous-programme d'auberge
                }
            }
            //marchand
            test_vente_arme = new VenteArmeCite();
            if(this.choix.equals("m")){
                if(!this.vente_arme.getVenteArme().equals(test_vente_arme.getVenteArme())){//si magasin de la cité
                    continuer = true;
                    //renvoie au sous-programme boutique cité
                }
                test_vente_arme = new VenteArmeMarchand();
                if(!this.vente_arme.getVenteArme().equals(test_vente_arme.getVenteArme())){//si marchand ambulant
                    continuer = true;
                    //renvoie au sous-programme marchand ambulant
                }
            }
            //Lieu
            if(this.choix.equals("c")){
                i = 0;
                while(i<lieu.length)
                {
                    test_lieu = new LieuCite();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si le lieu est la cité
                        continuer = true;
                        //renvoie au sous-programme cité
                    }
                    test_lieu = new LieuPlaine();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu la plaine
                        continuer = true;
                        //renvoie au sous-programme plaine
                    }
                    test_lieu = new LieuForet();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu de la foret
                        continuer = true;
                        //renvoie au sous-programme foret
                    }
                    test_lieu = new LieuLac();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu du lac
                        continuer = true;
                        //renvoie au sous-programme lac
                    }
                    test_lieu = new LieuCampement();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu du campement
                        continuer = true;
                        //renvoie au sous-programme campement
                    }
                }
                
            }
            //Lieu
            if(this.choix.equals("q")){
                continuer = true;
                //sous programme de sauvegarde
                //maj de la variable pour quitter le programme
            }
        }
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
        return this.nomMenu + "\n" + this.auberge.getAuberge() +
                this.vente_arme.getVenteArme() + this.lieu[0].getLieu()
                + this.lieu[1].getLieu() + this.lieu[2].getLieu() 
                + this.lieu[3].getLieu() + this.lieu[4].getLieu() 
                + "q : Sauvegarder et quitter\n";
    }
}
