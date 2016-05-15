/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import Boutiques.BoutiqueAuberge;
import Boutiques.BoutiqueCite;
import Boutiques.BoutiqueMarchand;
import Combat.Combat;
import armes.AccesInventaire;
import armes.ArmeUtilise;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import perso.Personnage;
import serialization.SauveCharge;

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
    * @param treePerso : TreeMap: String,Personnage
    * @param perso : String
     * @param arme : ArmeUtilise
    * @throws java.io.IOException : lecture de buffer
    *@return liste : ArrayList <ul><li>lieu_return : Lieu : lieu dans lequel se placer</li>
    *                              <li>perso : String : nom de la classe du perso</li>
    *                              <li>arme: ArmeUtilise : arme actuelle du perso</li>
    *                              <li>quitter : boolean : true si on quitte le jeu</li></ul>
    *@author Jérémy Duval
    *@since 1.0
    */
    public List redirectionChoix(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme) throws IOException{
        BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
        boolean continuer = false;
        boolean quitter = false;
        int i;
        Auberge test_auberge;
        VenteArme test_vente_arme;
        Lieu test_lieu;
        Lieu lieu_return = new LieuCite();
        MaitreDesCompetences test_maitre_competences;
        BoutiqueAuberge boutique_auberge = new BoutiqueAuberge();
        BoutiqueCite boutique_cite = new BoutiqueCite();
        BoutiqueMarchand boutique_marchand = new BoutiqueMarchand();
        List liste = new ArrayList();
        Combat combat = new Combat();
        AccesInventaire acces_Inventaire = new AccesInventaire();
        SauveCharge sauvegarder = new SauveCharge();
    
        while(!continuer){
            choix = buff.readLine();
            //auberge
            test_auberge = new AubergeOui();
            if(this.choix.equals("a")){
                if(this.auberge.getAuberge().equals(test_auberge.getAuberge())){//on vérifie la possibilité d'accès
                    continuer = true;
                    boutique_auberge.boutiqueAuberge(treePerso,perso);
                }
                lieu_return = type_menu;
            }
            //marchand
            if(this.choix.equals("m")){
                test_vente_arme = new VenteArmeCite();
                if(this.vente_arme.getVenteArme().equals(test_vente_arme.getVenteArme())){//si magasin de la cité
                    continuer = true;
                    boutique_cite.boutiqueCite(treePerso,perso);
                }
                lieu_return = type_menu;
            }
            if(this.choix.equals("n")){
                test_vente_arme = new VenteArmeMarchand();
                if(this.vente_arme.getVenteArme().equals(test_vente_arme.getVenteArme())){//si marchand ambulant
                    continuer = true;
                    boutique_marchand.boutiqueMarchand(treePerso,perso);
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
                lieu_return = combat.menuCombat(treePerso,perso,arme,lieu_return);//on lance le menuCombat
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
                lieu_return = combat.menuCombat(treePerso,perso,arme,lieu_return);//on lance le menuCombat
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
                lieu_return = combat.menuCombat(treePerso,perso,arme,lieu_return);//on lance le menuCombat
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
                if(this.maitre_competences.getMaitreDesCompetences().equals(test_maitre_competences.getMaitreDesCompetences())){//si lieu du campement
                    continuer = true;
                    MenuMaitreCompetences menu_maitre_competences = new MenuMaitreCompetences();
                    liste = menu_maitre_competences.menu(treePerso, perso, arme);
                    perso = (String) liste.get(0);
                    arme = (ArmeUtilise) liste.get(1);
                }
                lieu_return = type_menu;
            }
            //Inventaire
            if(this.choix.equals("i")){
                continuer = true;
                arme = acces_Inventaire.changementArme( treePerso, perso, arme);
                lieu_return = type_menu;
            }
            //Quitter
            if(this.choix.equals("q")){
               continuer = true;
               sauvegarder.sauvegarde(treePerso, perso, arme);
               quitter = true;
               lieu_return = type_menu; 
            }
        }
        
        liste.add(0, lieu_return);
        liste.add(1, perso);
        liste.add(2, arme);
        liste.add(3, quitter);
        return liste;//+ maj de la variable pour quitter le programme si besoin !!!!!!!!!!!!!!!!!!!!!!!!!
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
                + "i : inventaire\n"
                + "q : Sauvegarder et quitter\n";
    }
}
