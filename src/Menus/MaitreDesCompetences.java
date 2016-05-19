/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 * <p>
 * <strong>Cette interface définie la méthode retournant si le maitre des
 * compétence est accessible ou non.</strong></p>
 * Elle est implémentée par : <ul><li>{@link MaitreDesCompetencesOui}</li>
 * <li>{@link MaitreDesCompetencesNon}</li></ul>
 *
 * @author Jérémy Duval
 * @since 1.0
 */
public interface MaitreDesCompetences {

    /**
     * <p>
     * Cette méthode (à redéfinir) sert à retourner un string correspondant à
     * l'accès au maitre des compétences dans le menu.</p>
     *
     * @return String
     * @author Jérémy Duval
     * @since 1.0
     */
    public String getMaitreDesCompetences();
}
