/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 * <p>
 * <strong>Cette classe implémente {@link MaitreDesCompetences} et renvoie la
 * ligne vide.</strong></p>
 *
 * @author Jérémy Duval
 * @since 1.0
 */
public class MaitreDesCompetencesNon implements MaitreDesCompetences {

    /**
     * <p>
     * Cette méthode redéfinie
     * {@link MaitreDesCompetences#getMaitreDesCompetences()} afin de retourner
     * un string "". Le Maitre des competences n'apparaitra pas dans le
     * menus.</p>
     *
     * @author Jérémy Duval
     * @return String
     * @since 1.0
     */
    @Override
    public String getMaitreDesCompetences() {
        return "";
    }
}
