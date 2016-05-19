/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import java.util.Random;

/**
 * <p>
 * <strong>Cette classe implémente {@link MenuGeneral} et renvoie la ligne du
 * menu correspondant à la forêt.</strong></p>
 *
 * @author Jérémy Duval
 * @since 1.0
 */
public class MenuForet extends MenuGeneral {

    private Random aleat = new Random();

    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
     * <p>
     * <Strong>Ce constructeur permet d'initialiser le menu en tant que celui de
     * la forêt.</Strong></p>
     * <p>
     * L'apparition du marchand ambulant est aléatoire (une chance sur trois),
     * ainsi que celle du campement (une chance sur deux).</p>
     *
     * @author Jérémy Duval
     * @since 1.0
     */
    public MenuForet() {
        super();
        nomMenu = "Vous marchez dans la forêt :";
        auberge = new AubergeNon();
        if (Math.abs(aleat.nextInt(2)) >= 1) {
            vente_arme = new VenteArmeNon();
        } else {
            vente_arme = new VenteArmeMarchand();
        }
        maitre_competences = new MaitreDesCompetencesNon();
        lieu[0] = new LieuPlaine();
        lieu[1] = new LieuLac();
        if (Math.abs(aleat.nextInt(1)) >= 1) {
            lieu[2] = new LieuCampement();
        } else {
            lieu[2] = new LieuNon();
        }
        lieu[3] = new LieuForet();
        lieu[4] = new LieuNon();
        type_menu = new LieuForet();
    }
}
