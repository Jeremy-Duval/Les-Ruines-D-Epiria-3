/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boutiques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.ceil;
import java.util.Random;
import java.util.TreeMap;
import perso.Personnage;

/**
 * <p>
 * <strong>Cette classe permet la création du menu de la boutique du marchand
 * ambulant.</strong></p>
 *
 * @author Jérémy Duval
 * @since 1.0
 */
public class BoutiqueMarchand {

    private final int nb_item = 2;
    protected int[] prix = new int[nb_item];
    protected int[] puissance = new int[nb_item];

    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
     * <p>
     * <Strong>Ce constructeur ne fait rien.</Strong></p>
     *
     * @author Jérémy Duval
     * @since 1.0
     */
    public BoutiqueMarchand() {
    }

    ;
    
    /**
    *<p>Cette fonction ouvre le menu de la boutique du marchand ambulant. 
    * Le joueur peut acheter des items. La puissance le l'arme varie entre 
    * 5 à 10 fois le level du perso * un coef (entre1.1 et 1.3). 
    * Le prix est de 25 + puissance_arme/10 + un nombre aléatoire entre 0 et 15</p>
    * @param tree_perso : TreeMap: String,Personnage
    * @param perso : String : l'étiquette de la classe dans le TreeMap
    * @throws java.io.IOException : lecture de buffer
    * @author jeremy
    * @since 1.0
    */
    public void boutiqueMarchand(TreeMap<String, Personnage> tree_perso, String perso) throws IOException {
        Random aleat = new Random();
        Random aleat_coef = new Random();
        float coef;
        int[] item = new int[nb_item];
        boolean continuer = false;
        int compteur_achat = 0;
        BufferedReader buff = new BufferedReader(
                new InputStreamReader(System.in));
        String choix;

        System.out.println(perso.toString());

        System.out.println("\nBienvenue dans ma boutique ambulante...");
        System.out.println("Prenez votre temps et admirez ces articles rares.");

        for (int i = 0; i < puissance.length; i++) {
            coef = (Math.abs(aleat_coef.nextInt(3))) + 11 / 10;
            puissance[i] = (int) (Math.abs(aleat.nextInt(tree_perso.get(perso).getLevel() * 10)) % (tree_perso.get(perso).getLevel() * 5) * coef);
        }
        for (int i = 0; i < prix.length; i++) {
            prix[i] = (int) (25 + puissance[i] / 10 + Math.abs(aleat.nextInt(15)));
        }

        for (int i = 0; i < item.length; i++) {
            item[i] = Math.abs(aleat.nextInt(5));//on vérifie qu'il n'y ai pas deux fois le même item
            for (int j = 0; j <= i; j++) {
                if ((item[i] == item[j]) && (j != i)) {
                    item[i] = Math.abs(aleat.nextInt(5));
                    j = 0;
                }
            }
            switch (item[i]) {
                case 0:
                    System.out.println("e : Epee, puissance " + puissance[i] + " : " + prix[i] + " or");
                    break;
                case 1:
                    System.out.println("s : Scpetre, puissance " + puissance[i] + " : " + prix[i] + " or");
                    break;
                case 2:
                    System.out.println("t : Talisman, puissance " + puissance[i] + " : " + prix[i] + " or");
                    break;
                case 3:
                    System.out.println("v : Potion de vie, puissance " + puissance[i] + " : " + prix[i] + " or");
                    break;
                case 4:
                    System.out.println("m : Potion de mana, puissance " + puissance[i] + " : " + prix[i] + " or");
                    break;
                case 5:
                    System.out.println("a : Armure, puissance " + puissance[i] + " : " + prix[i] + " or");
                    break;
                default:
                    item[i] = 6;
                    System.out.println("r : Armure magique, puissance " + puissance[i] + " : " + prix[i] + " or");
                    break;
            }
        }
        System.out.println("\np : partir");

        while (!continuer) {
            choix = buff.readLine();
            switch (choix) {
                case "e":
                    for (int i = 0; i < item.length; i++) {
                        if (item[i] == 0) {
                            if (tree_perso.get(perso).getArgent() - prix[i] < 0) {
                                System.out.println("Vous n'avez pas assez d'argent !");
                            } else {
                                tree_perso.get(perso).setArgent(tree_perso.get(perso).getArgent() - prix[i]);
                                tree_perso.get(perso).setEpee(puissance[i]);
                                compteur_achat++;
                                System.out.println("Merci à vous...");
                            }
                        }
                    }
                    break;
                case "s":
                    for (int i = 0; i < item.length; i++) {
                        if (item[i] == 1) {
                            if (tree_perso.get(perso).getArgent() - prix[i] < 0) {
                                System.out.println("Vous n'avez pas assez d'argent !");
                            } else {
                                tree_perso.get(perso).setArgent(tree_perso.get(perso).getArgent() - prix[i]);
                                tree_perso.get(perso).setSceptre(puissance[i]);
                                compteur_achat++;
                                System.out.println("Merci à vous...");
                            }
                        }
                    }
                    break;
                case "t":
                    for (int i = 0; i < item.length; i++) {
                        if (item[i] == 2) {
                            if (tree_perso.get(perso).getArgent() - prix[i] < 0) {
                                System.out.println("Vous n'avez pas assez d'argent !");
                            } else {
                                tree_perso.get(perso).setArgent(tree_perso.get(perso).getArgent() - prix[i]);
                                tree_perso.get(perso).setTalisman(puissance[i]);
                                compteur_achat++;
                                System.out.println("Merci à vous...");
                            }
                        }
                    }
                    break;
                case "v":
                    for (int i = 0; i < item.length; i++) {
                        if (item[i] == 3) {
                            if (tree_perso.get(perso).getArgent() - prix[i] < 0) {
                                System.out.println("Vous n'avez pas assez d'argent !");
                            } else {
                                tree_perso.get(perso).setArgent(tree_perso.get(perso).getArgent() - prix[i]);
                                tree_perso.get(perso).setPotionVie(puissance[i]);
                                compteur_achat++;
                                System.out.println("Merci à vous...");
                            }
                        }
                    }
                    break;
                case "m":
                    for (int i = 0; i < item.length; i++) {
                        if (item[i] == 4) {
                            if (tree_perso.get(perso).getArgent() - prix[i] < 0) {
                                System.out.println("Vous n'avez pas assez d'argent !");
                            } else {
                                tree_perso.get(perso).setArgent(tree_perso.get(perso).getArgent() - prix[i]);
                                tree_perso.get(perso).setPotionPM(puissance[i]);
                                compteur_achat++;
                                System.out.println("Merci à vous...");
                            }
                        }
                    }
                    break;
                case "a":
                    for (int i = 0; i < item.length; i++) {
                        if (item[i] == 5) {
                            if (tree_perso.get(perso).getArgent() - prix[i] < 0) {
                                System.out.println("Vous n'avez pas assez d'argent !");
                            } else {
                                tree_perso.get(perso).setArgent(tree_perso.get(perso).getArgent() - prix[i]);
                                tree_perso.get(perso).setArmure(puissance[i]);
                                compteur_achat++;
                                System.out.println("Merci à vous...");
                            }
                        }
                    }
                    break;
                case "r":
                    for (int i = 0; i < item.length; i++) {
                        if (item[i] == 6) {
                            if (tree_perso.get(perso).getArgent() - prix[i] < 0) {
                                System.out.println("Vous n'avez pas assez d'argent !");
                            } else {
                                tree_perso.get(perso).setArgent(tree_perso.get(perso).getArgent() - prix[i]);
                                tree_perso.get(perso).setArmureMagique(puissance[i]);
                                compteur_achat++;
                                System.out.println("Merci à vous...");
                            }
                        }
                    }
                    break;
                case "p":
                    continuer = true;
                    break;
                default:
                    System.out.println("Je n'ai pas encore cet article...");
                    break;
            }
        }
        System.out.println("Merci et à bientôt...");
    }
}
