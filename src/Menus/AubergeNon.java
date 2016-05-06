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
public class AubergeNon implements Auberge{
    /**
    *<p>Cette méthode redéfinie {@link Auberge#getAuberge()} afin de retourner 
    * un string "". L'auberge n'apparaitra pas dans le menu.</p>
    * @author Jérémy Duval
    * @return String 
    * @since 1.0
    */
    @Override
    public String getAuberge() {
        return "";
    }
}
