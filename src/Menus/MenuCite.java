/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 * <p>
 * <strong>Cette classe implémente {@link MenuGeneral} et renvoie la ligne du
 * menu correspondant à la cité.</strong></p>
 *
 * @author Jérémy Duval
 * @since 1.0
 */
public class MenuCite extends MenuGeneral {

    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
     * <p>
     * <Strong>Ce constructeur permet d'initialiser le menu en tant que celui de
     * la cité.</Strong></p>
     *
     * @author Jérémy Duval
     * @since 1.0
     */
    public MenuCite() {
        super();
        nomMenu = "Vous marchez dans la cité :";
        auberge = new AubergeOui();
        vente_arme = new VenteArmeCite();
        maitre_competences = new MaitreDesCompetencesOui();
        lieu[0] = new LieuPlaine();
        lieu[1] = new LieuNon();
        lieu[2] = new LieuNon();
        lieu[3] = new LieuNon();
        lieu[4] = new LieuNon();
        type_menu = new LieuCite();
    }
}
