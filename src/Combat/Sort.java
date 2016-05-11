/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Combat;

/**
 *<p><strong>Cette interface définie la méthode retournant un type de sort.</strong></p>
 *Elle est implémentée par : <ul><li>{@link SortAttaque}</li>
 *                              <li>{@link SortSoin}</li></ul>
 * @author Jérémy Duval
 * @since 1.0
 */
public interface Sort {
    /**
    *<p>Cette méthode (à redéfinir) sert à retourner un string 
    * correspondant au type de sort utilisable par le perso.</p>
    * @return String 
    * @author Jérémy Duval
    * @since 1.0
    */
    public String getSort();
}
