/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 * <p>
 * <strong>Cette classe implémente {@link Lieu} et renvoie la ligne du menu
 * correspondant au campement.</strong></p>
 *
 * @author Jérémy Duval
 * @since 1.0
 */
public class LieuCampement implements Lieu {

    /**
     * <p>
     * Cette méthode redéfinie {@link Lieu#getLieu()} afin de retourner un
     * string "k : Campement\n" à afficher dans les menus.</p>
     *
     * @author Jérémy Duval
     * @return String
     * @since 1.0
     */
    @Override
    public String getLieu() {
        return "k : Campement\n";
    }
}
