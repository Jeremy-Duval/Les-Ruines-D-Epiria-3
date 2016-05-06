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
public class LieuLac implements Lieu{
    /**
    *<p>Cette méthode redéfinie {@link Lieu#getLieu()} afin de retourner 
    * un string "l : Lac\n" à afficher dans les menus.</p>
    * @author Jérémy Duval
    * @return String 
    * @since 1.0
    */
    @Override
    public String getLieu() {
        return "l : Lac\n";
    }
}
