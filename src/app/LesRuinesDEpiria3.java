/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import perso.Guerrier;
import perso.Mage;
import perso.Paysan;
import perso.Personnage;
import perso.Pretre;
import utilitaire.Comparateur;

/**
 *Cette classe est la classe principale du jeu.
 * @author p1501022
 * @version 1.0
 */
public class LesRuinesDEpiria3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Personnage paysan = new Paysan();
        Personnage guerrier = new Guerrier();
        Personnage mage = new Mage();
        Personnage pretre = new Pretre();
        
        Map <String, Personnage> perso = new TreeMap<>(new Comparateur());
        //stockage des objets dans un treeMap
        perso.put("Paysan", paysan);
        perso.put("Guerrier", guerrier);
        perso.put("Mage", mage);
        perso.put("Pretre", pretre);
        
        Set <String> clés = perso.keySet();
        System.out.println("Clefs : "+clés);
        
        //to string à redèf
        for(String i : clés){
            System.out.println("Pour la clé "+i+" on a :");
            System.out.println(perso.get(i));
        }
    }
    
}
