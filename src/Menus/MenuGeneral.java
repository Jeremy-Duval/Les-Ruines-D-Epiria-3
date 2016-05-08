/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import Boutiques.BoutiqueAuberge;
import Boutiques.BoutiqueCite;
import Boutiques.BoutiqueMarchand;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import perso.Personnage;

/**
 *<p><strong>Cette interface définie la méthode retournant un type de menu.</strong></p>
 *Elle est implémentée par : <ul><li>{@link MenuCite}</li>
 *                              <li>{@link MenuPlaine}</li>
 *                              <li>{@link MenuLac}</li>
 *                              <li>{@link MenuForet}</li>
 *                              <li>{@link MenuCampement}</li></ul>
 * @author Jérémy Duval
 * @since 1.0
 */
public abstract class MenuGeneral implements Serializable{
    protected Auberge auberge;
    protected VenteArme vente_arme;
    protected Lieu[] lieu = new Lieu[5];
    protected MaitreDesCompetences maitre_competences;
    protected String choix;
    protected String nomMenu;
    protected Lieu type_menu;
    
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
    /**
    *<p>Cette méthode renvoie un lieu correspondant au lieu du menu à afficher.</p>
    *@param perso : Personnage
    * @throws java.io.IOException
    *@return Lieu
    *@author Jérémy Duval
    *@since 1.0
    */
    public Lieu redirectionChoix(Personnage perso) throws IOException{
        BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
        boolean continuer = false;
        int i;
        Auberge test_auberge;
        VenteArme test_vente_arme;
        Lieu test_lieu;
        Lieu lieu_return = new LieuCite();
        MaitreDesCompetences test_maitre_competences;
        BoutiqueAuberge boutique_auberge = new BoutiqueAuberge();
        BoutiqueCite boutique_cite = new BoutiqueCite();
        BoutiqueMarchand boutique_marchand = new BoutiqueMarchand();
    
        while(!continuer){
            choix = buff.readLine();
            //auberge
            test_auberge = new AubergeOui();
            if(this.choix.equals("a")){
                if(this.auberge.getAuberge().equals(test_auberge.getAuberge())){//on vérifie la possibilité d'accès
                    continuer = true;
                    boutique_auberge.boutiqueAuberge(perso);
                }
                lieu_return = type_menu;
            }
            //marchand
            if(this.choix.equals("m")){
                test_vente_arme = new VenteArmeCite();
                if(this.vente_arme.getVenteArme().equals(test_vente_arme.getVenteArme())){//si magasin de la cité
                    continuer = true;
                    boutique_cite.boutiqueCite(perso);
                }
                lieu_return = type_menu;
            }
            if(this.choix.equals("n")){
                test_vente_arme = new VenteArmeMarchand();
                if(!this.vente_arme.getVenteArme().equals(test_vente_arme.getVenteArme())){//si marchand ambulant
                    continuer = true;
                    boutique_marchand.boutiqueMarchand(perso);
                }
                lieu_return = type_menu;
            }
            //Lieu
            //accès cité
            if(this.choix.equals("c")){
                i = 0;
                while(i<lieu.length)
                {
                    test_lieu = new LieuPlaine();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu la plaine
                        continuer = true;
                        lieu_return = new LieuCite();
                        
                    }
                    i++;
                }
                
            }
            //accès plaine
            if(this.choix.equals("p")){
                i = 0;
                while(i<lieu.length)
                {
                    test_lieu = new LieuCite();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si le lieu est la cité
                        continuer = true;
                        lieu_return = new LieuPlaine();
                        
                    }
                    test_lieu = new LieuForet();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu de la foret
                        continuer = true;
                        lieu_return = new LieuPlaine();
                        
                    }
                    test_lieu = new LieuLac();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu du lac
                        continuer = true;
                        lieu_return = new LieuPlaine();
                        
                    }
                    i++;
                }
                
            }
            //accès forêt
            if(this.choix.equals("f")){
                i = 0;
                while(i<lieu.length)
                {
                    test_lieu = new LieuPlaine();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu la plaine
                        continuer = true;
                        lieu_return = new LieuForet();
                        
                    }
                    test_lieu = new LieuLac();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu du lac
                        continuer = true;
                        lieu_return = new LieuForet();
                        
                    }
                    test_lieu = new LieuCampement();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu du campement
                        continuer = true;
                        lieu_return = new LieuForet();
                        
                    }
                    i++;
                }
                
            }
            //accès lac
            if(this.choix.equals("l")){
                i = 0;
                while(i<lieu.length)
                {
                    test_lieu = new LieuPlaine();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu la plaine
                        continuer = true;
                        lieu_return = new LieuLac();
                        
                    }
                    test_lieu = new LieuForet();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu de la foret
                        continuer = true;
                        lieu_return = new LieuLac();
                        
                    }
                    i++;
                }
                
            }
            //accès campement
            if(this.choix.equals("k")){
                i = 0;
                while(i<lieu.length)
                {
                    test_lieu = new LieuForet();
                    if(!this.lieu[i].getLieu().equals(test_lieu.getLieu())){//si lieu de la foret
                        continuer = true;
                        lieu_return = new LieuCampement();
                        
                    }
                    i++;
                }
                
            }
            //Maitre des compétences
            if(this.choix.equals("e")){
                test_maitre_competences = new MaitreDesCompetencesOui();
                if(!this.maitre_competences.getMaitreDesCompetences().equals(test_maitre_competences.getMaitreDesCompetences())){//si lieu du campement
                    continuer = true;
                    //renvoie au sous-programme competence
                }
                lieu_return = type_menu;
            }
            //Quitter
            if(this.choix.equals("q")){
                continuer = true;
                //sous programme de sauvegarde
               lieu_return = type_menu; 
            }
        }
        return lieu_return;//+ maj de la variable pour quitter le programme si besoin !!!!!!!!!!!!!!!!!!!!!!!!!
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
                this.vente_arme.getVenteArme() 
                + this.maitre_competences.getMaitreDesCompetences()
                + this.lieu[0].getLieu()
                + this.lieu[1].getLieu() + this.lieu[2].getLieu() 
                + this.lieu[3].getLieu() + this.lieu[4].getLieu() 
                + "q : Sauvegarder et quitter\n";
    }
}
