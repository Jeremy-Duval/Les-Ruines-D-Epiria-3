/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import java.util.Random;

/**
 *<p><strong>Cette classe implémente {@link MenuGeneral} et renvoie la ligne du 
 * menu correspondant au lac.</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MenuLac extends MenuGeneral{
    private Random aleat = new Random();
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur permet d'initialiser le menu en tant que celui 
    * du lac.</Strong></p>
    *<p>L'apparition du marchand ambulant est aléatoire (une chance sur trois).</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MenuLac(){
        super();
        nomMenu = "Vous marchez sur les rives du lac :";
        auberge = new AubergeNon();
        if(Math.abs(aleat.nextInt(2))>=1){
            vente_arme = new VenteArmeNon();
        }else {
            vente_arme = new VenteArmeMarchand();
        }
        maitre_competences = new MaitreDesCompetencesNon();
        lieu[0] = new LieuPlaine();
        lieu[1] = new LieuForet();
        lieu[2] = new LieuLac();
        lieu[3] = new LieuNon();
        lieu[4] = new LieuNon();
        type_menu = new LieuLac();
    }
}
