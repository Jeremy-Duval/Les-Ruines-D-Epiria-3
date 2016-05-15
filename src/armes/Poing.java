/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armes;

import java.io.Serializable;

/**
 *<p><strong>Cette classe implémente {@link Arme} et définie le type "Poing".</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class Poing implements Arme, Serializable{
    /**
    *<p>Cette méthode redéfinie {@link Arme#getArmeUtil()} afin de retourner 
    * un string "Poing" correspondant au type d'arme.</p>
    * @return String 
    * @author Jérémy Duval
    * @since 1.0
    */
    @Override
    public String getArmeUtil() {
        return "Poing";
    }
    
}
