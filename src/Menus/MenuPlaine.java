/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 *
 * @author jeremy
 */
public class MenuPlaine extends MenuGeneral{
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur permet d'initialiser le menu en tant que celui 
    * de la plaine.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MenuPlaine(){
        super();
        nomMenu = "Plaine :";
        auberge = new AubergeNon();
        vente_arme = new VenteArmeNon();
        lieu1 = new LieuCite();
        lieu2 = new LieuForet();
        lieu3 = new LieuLac();
        lieu4 = new LieuNon();
        lieu5 = new LieuNon();
    }
}
