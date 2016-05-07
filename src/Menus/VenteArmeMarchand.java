/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 *<p><strong>Cette classe implémente {@link VenteArme} et renvoie la ligne du 
 * menu correspondant au magasin du marchand ambulant.</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class VenteArmeMarchand implements VenteArme{
    /**
    *<p>Cette méthode redéfinie {@link VenteArme#getVenteArme()} afin de retourner 
    * un string "m : magasin d'armes\n" à afficher dans les menus.</p>
    * @author Jérémy Duval
    * @return String 
    * @since 1.0
    */
    @Override
    public String getVenteArme() {
        return "m : marchand ambulant\n";
    }
    
}
