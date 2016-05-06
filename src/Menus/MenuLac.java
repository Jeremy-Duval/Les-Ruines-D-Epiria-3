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
public class MenuLac extends MenuGeneral{
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur permet d'initialiser le menu en tant que celui 
    * du lac.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MenuLac(){
        super();
        nomMenu = "Lac :";
        auberge = new AubergeNon();
        vente_arme = new VenteArmeNon();
        lieu1 = new LieuPlaine();
        lieu2 = new LieuForet();
        lieu3 = new LieuNon();
        lieu4 = new LieuNon();
        lieu5 = new LieuNon();
    }
}
