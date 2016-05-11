/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Combat;

/**
 *<p><strong>Cette classe implémente {@link Sort} et définie le type "Attaque".</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class SortAttaque implements Sort{
    /**
    *<p>Cette méthode redéfinie {@link Sort#getSort()} afin de retourner 
    * un string "Attaque" correspondant au type de sort.</p>
    * @return String 
    * @author Jérémy Duval
    * @since 1.0
    */
    public String getSort(){
        return "Attaque";
    }
}
