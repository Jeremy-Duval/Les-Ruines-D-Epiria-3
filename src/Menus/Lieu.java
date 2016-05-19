/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 * <p>
 * <strong>Cette interface définie la méthode retournant un type de
 * lieu.</strong></p>
 * Elle est implémentée par : <ul><li>{@link LieuCite}</li>
 * <li>{@link LieuPlaine}</li>
 * <li>{@link LieuLac}</li>
 * <li>{@link LieuForet}</li>
 * <li>{@link LieuCampement}</li></ul>
 *
 * @author Jérémy Duval
 * @since 1.0
 */
public interface Lieu {

    /**
     * <p>
     * Cette méthode (à redéfinir) sert à retourner un string correspondant à
     * l'accès à un lieu dans le menu.</p>
     *
     * @return String
     * @author Jérémy Duval
     * @since 1.0
     */
    public String getLieu();
}
