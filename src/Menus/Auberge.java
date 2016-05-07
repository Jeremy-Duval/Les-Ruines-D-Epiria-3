/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 *<p><strong>Cette interface définie la méthode retournant si l'auberge est
 * accessible ou non.</strong></p>
 *Elle est implémentée par : <ul><li>{@link AubergeOui}</li>
 *                              <li>{@link AubergeNon}</li></ul>
 * @author Jérémy Duval
 * @since 1.0
 */
public interface Auberge {
    /**
    *<p>Cette méthode (à redéfinir) sert à retourner un string 
    * correspondant à l'auberge dans le menu.</p>
    * @return String 
    * @author Jérémy Duval
    * @since 1.0
    */
    public String getAuberge();
}
