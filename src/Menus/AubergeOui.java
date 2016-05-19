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
public class AubergeOui implements Auberge {

    /**
     * <p>
     * Cette méthode redéfinie {@link Auberge#getAuberge()} afin de retourner un
     * string "a : Auberge\n" à afficher dans les menus.</p>
     *
     * @author Jérémy Duval
     * @return String
     * @since 1.0
     */
    @Override
    public String getAuberge() {
        return "a : Auberge\n";
    }

}
