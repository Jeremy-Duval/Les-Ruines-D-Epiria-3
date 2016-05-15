/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armes;

/**
 *<p><strong>Cette interface définie la méthode retournant un type d'arme.</strong></p>
 *Elle est implémentée par : <ul><li>{@link Poing}</li>
 *                              <li>{@link Epee}</li>
 *                              <li>{@link Sceptre}</li>
 *                              <li>{@link Talisman}</li>
 *                              <li>{@link All}</li></ul>
 * @author Jérémy Duval
 * @since 1.0
 */
public interface Arme {
    /**
    *<p>Cette méthode (à redéfinir) sert à retourner un string 
    * correspondant au type d'arme.</p>
    * @return String 
    * @author Jérémy Duval
    * @since 1.0
    */
    public String getArmeUtil();
}
