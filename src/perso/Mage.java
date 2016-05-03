/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perso;

/**
 *<p><strong>Définie le type de personnage Mage.</strong></p>
 * <p>Hérite de {@link Personnage}</p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class Mage extends Personnage {
    public Mage(){
        super();
        this.classe_pers = "Mage";
    }
}
