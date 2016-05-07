/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 *<p><strong>Cette classe implémente {@link MenuGeneral} et renvoie la ligne du 
 * menu correspondant au campement.</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MenuCampement extends MenuGeneral{
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur permet d'initialiser le menu en tant que celui 
    * du campement.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MenuCampement(){
        super();
        nomMenu = "Campement :";
        auberge = new AubergeOui();
        vente_arme = new VenteArmeNon();
        maitre_competences = new MaitreDesCompetencesNon();
        lieu[0] = new LieuForet();
        lieu[1] = new LieuNon();
        lieu[2] = new LieuNon();
        lieu[3] = new LieuNon();
        lieu[4] = new LieuNon();
        type_menu = new LieuCampement();
    } 
}
