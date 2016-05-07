/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

/**
 *<p><strong>Cette classe implémente {@link MaitreDesCompetences} et renvoie 
 * la ligne du menu correspondante.</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class MaitreDesCompetencesOui implements MaitreDesCompetences{
    /**
    *<p>Cette méthode redéfinie {@link MaitreDesCompetences#getMaitreDesCompetences()}
    * afin de retourner un string "e : Maitre des compétences\n" 
    * à afficher dans les menus.</p>
    * @author Jérémy Duval
    * @return String 
    * @since 1.0
    */
    @Override
    public String getMaitreDesCompetences() {
        return "e : Maitre des compétences\n";
    }
    
}
