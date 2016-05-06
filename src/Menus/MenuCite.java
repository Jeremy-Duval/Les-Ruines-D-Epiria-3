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
public class MenuCite extends MenuGeneral{
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur permet d'initialiser le menu en tant que celui 
    * de la cité.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MenuCite(){
        super();
        nomMenu = "Cité :";
        auberge = new AubergeOui();
        vente_arme = new VenteArmeCite();
        lieu1 = new LieuPlaine();
        lieu2 = new LieuNon();
        lieu3 = new LieuNon();
        lieu4 = new LieuNon();
        lieu5 = new LieuNon();
    }
}
