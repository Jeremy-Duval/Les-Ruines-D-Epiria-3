/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Combat;

import java.io.Serializable;

/**
 *<p><strong>Cette classe implémente {@link Sort} et définie le type "Soin".</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class SortSoin implements Sort, Serializable{
    /**
    *<p>Cette méthode redéfinie {@link Sort#getSort()} afin de retourner 
    * un string "Soin" correspondant au type de sort.</p>
    * @return String 
    * @author Jérémy Duval
    * @since 1.0
    */
    public String getSort(){
        return "Soin";
    }
}
