/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 *<p><strong>Cette interface définie la méthode retournant si la boutique d'arme
 * est accessible ou non.</strong></p>
 * Elle est implémentée par : <ul><li>{@link VenteArmeCite}</li>
 *                                <li>{@link VenteArmeMarchand}</li>
 *                                <li>{@link VenteArmeNon}</li></ul>
 * @author Jérémy Duval
 * @since 1.0
 */
public interface VenteArme {
    /**
    *<p>Cette méthode (à redéfinir) sert à retourner un string 
    * correspondant à l'accès au magasin d'arme dans le menu.</p>
    * @return String 
    * @author Jérémy Duval
    * @since 1.0
    */
    public String getVenteArme();
}
