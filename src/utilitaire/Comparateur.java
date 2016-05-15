/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitaire;

import java.io.Serializable;
import java.util.Comparator;

/**
 *Redéfinition de "compare" afin de l'utiliser lors de création de treeMap.
 * @author p1501022
 * @since 1.0
 */
public class Comparateur implements Comparator<String>, Serializable{

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);//décroissant
    }
    
}
