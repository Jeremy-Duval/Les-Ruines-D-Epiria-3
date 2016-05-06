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
public class VenteArmeNon implements VenteArme{
    /**
    *<p>Cette méthode redéfinie {@link VenteArme#getVenteArme()} afin de retourner 
    * un string "". Le magasin d'armes n'apparaitra pas dans le menu.</p>
    * @author Jérémy Duval
    * @return String 
    * @since 1.0
    */
    @Override
    public String getVenteArme() {
        return "";
    }
}
