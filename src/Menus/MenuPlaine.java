/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import java.util.Random;

/**
 *<p><strong>Cette classe implémente {@link MenuGeneral} et renvoie la ligne du 
 * menu correspondant à la plaine.</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MenuPlaine extends MenuGeneral{
    private Random aleat = new Random();
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur permet d'initialiser le menu en tant que celui 
    * de la plaine.</Strong></p>
    * <p>L'apparition du marchand ambulant est aléatoire (une chance sur trois).</p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MenuPlaine(){
        super();
        nomMenu = "Vous marchez dans la plaine :";
        auberge = new AubergeNon();
        if(Math.abs(aleat.nextInt(2))>=1){
            vente_arme = new VenteArmeNon();
        }else {
            vente_arme = new VenteArmeMarchand();
        }
        maitre_competences = new MaitreDesCompetencesNon();
        lieu[0] = new LieuCite();
        lieu[1] = new LieuForet();
        lieu[2] = new LieuLac();
        lieu[3] = new LieuPlaine();
        lieu[4] = new LieuNon();
        type_menu = new LieuPlaine();
    }
}
