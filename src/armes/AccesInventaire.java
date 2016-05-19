/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package armes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import perso.Personnage;

/**
 * <p>
 * <strong>Cette interface définie la méthode permettant de changer
 * d'arme.</strong></p>
 *
 * @author Jérémy Duval
 * @since 1.0
 */
public class AccesInventaire {

    /**
     * <p>
     * <Strong>Ce constructeur ne fait rien.</Strong></p>
     *
     * @author Jérémy Duval
     * @since 1.0
     */
    public AccesInventaire() {
    }

    ;
    
    /**
    *<p>Cette méthode permet de changer l'arme principale en utilisant une de 
    * celles qui se trouve dans l'inventaire. L'arme doit pouvoir être
    * utilisé par le perso actuel.</p>
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @param arme : ArmeUtilise : arme utilisée par le perso
     * @return arme : ArmeUtilise : nouvelle arme utilisé par le perso
     * @throws java.io.IOException : lecture de buffer
    *@author Jérémy Duval
    *@since 1.0
    */
    public ArmeUtilise changementArme(TreeMap<String, Personnage> treePerso, String perso, ArmeUtilise arme) throws IOException {
        boolean continuer = false;
        BufferedReader buff = new BufferedReader(
                new InputStreamReader(System.in));
        String choix;
        Arme arme_affecte;

        System.out.println(treePerso.get(perso).toString() + "\n");
        System.out.println("Vous voulez utiliser quelle arme ?");
        System.out.println("p : Poing");
        System.out.println("e : Epee");
        System.out.println("s : Scpetre");
        System.out.println("t : Talisman");
        System.out.println("r : retour");

        while (!continuer) {
            choix = buff.readLine();
            switch (choix) {
                case "p":
                    continuer = true;
                    arme_affecte = new Poing();
                    arme.setArme(arme_affecte, 0);
                    break;
                case "e":
                    continuer = true;
                    arme_affecte = new Epee();
                    if ((treePerso.get(perso).getArmePossible().equals(arme_affecte.getArmeUtil())) || (treePerso.get(perso).getArmePossible().equals("All"))) {
                        arme.setArme(arme_affecte, treePerso.get(perso).getEpee());
                    } else {
                        System.out.println("Vous ne pouvez pas porter cette arme avec ce personnage !");
                    }
                    break;
                case "s":
                    continuer = true;
                    arme_affecte = new Sceptre();
                    if ((treePerso.get(perso).getArmePossible().equals(arme_affecte.getArmeUtil())) || (treePerso.get(perso).getArmePossible().equals("All"))) {
                        arme.setArme(arme_affecte, treePerso.get(perso).getSceptre());
                    } else {
                        System.out.println("Vous ne pouvez pas porter cette arme avec ce personnage !");
                    }
                    break;
                case "t":
                    continuer = true;
                    arme_affecte = new Talisman();
                    if ((treePerso.get(perso).getArmePossible().equals(arme_affecte.getArmeUtil())) || (treePerso.get(perso).getArmePossible().equals("All"))) {
                        arme.setArme(arme_affecte, treePerso.get(perso).getTalisman());
                    } else {
                        System.out.println("Vous ne pouvez pas porter cette arme avec ce personnage !");
                    }
                    break;
                case "r":
                    continuer = true;
                    break;
                default:
                    System.out.println("Vous ne possedez pas cette arme !");
            }
        }

        return arme;
    }
}
