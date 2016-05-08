/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boutiques;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import perso.Personnage;

/**
 *<p><strong>Cette classe permet la création du menu de la boutique de la cité.</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class BoutiqueCite {
    protected int[] prix = new int[7];
    protected int[] puissance = new int[7];
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur ne fait rien.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public BoutiqueCite(){};
    
    /**
    *<p>Cette fonction ouvre le menu de la boutique de la cité. Le joueur peut .
    * acheter des items. La puissance le l'arme varie entre 5 à 10 fois le level
    * du perso. Le prix est de 25 + puissance_arme/10 + un nombre aléatoire
    * entre 0 et 15</p>
    * @param perso : Personnage
    * @throws java.io.IOException
    * @author jeremy
    * @since 1.0
    */
    public void boutiqueCite(Personnage perso) throws IOException{
        Random aleat = new Random();
        boolean continuer = false;
        int compteur_achat = 0;
        BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
        String choix;
        
        System.out.println(perso.toString());
        
        System.out.println("\nBienvenue dans notre boutique !");
        System.out.println("Prenez votre temps et admirez nos articles.");
        System.out.println("*********************************\nArmes :\n*********************************");
        for(int i = 0; i<puissance.length; i++){
            puissance[i] = Math.abs(aleat.nextInt(perso.getLevel()*10))%(perso.getLevel()*5);
        }
        for(int i = 0; i<prix.length; i++){
            prix[i] =(int)(25 + puissance[i]/10 + Math.abs(aleat.nextInt(15)));
        }
        System.out.println("e : Epee, puissance " + puissance[0] + " : " + prix[0] + " or");
        System.out.println("s : Scpetre, puissance " + puissance[1] + " : " + prix[1] + " or");
        System.out.println("t : Talisman, puissance " + puissance[2] + " : " + prix[2] + " or");
        System.out.println("*********************************\nPotions :\n*********************************");
        System.out.println("v : Potion de vie, puissance " + puissance[3] + " : " + prix[3] + " or");
        System.out.println("m : Potion de mana, puissance " + puissance[4] + " : " + prix[4] + " or");
        System.out.println("*********************************\nEquipements :\n*********************************");
        System.out.println("a : Armure, puissance " + puissance[5] + " : " + prix[5] + " or");
        System.out.println("r : Armure magique, puissance " + puissance[6] + " : " + prix[6] + " or");
        System.out.println("\np : partir");
        
        while(!continuer){
            choix = buff.readLine();
            switch(choix){
                case "e" :
                    if(perso.getArgent()-prix[0]<0){
                        System.out.println("Vous n'avez pas assez d'argent !");
                    } else {
                        perso.setArgent(perso.getArgent()-prix[0]);
                        perso.setEpee(puissance[0]);
                        compteur_achat++;
                        System.out.println("Merci à vous !");
                    }
                    break;
                case "s" :
                    if(perso.getArgent()-prix[1]<0){
                        System.out.println("Vous n'avez pas assez d'argent !");
                    } else {
                        perso.setArgent(perso.getArgent()-prix[1]);
                        perso.setSceptre(puissance[1]);
                        compteur_achat++;
                        System.out.println("Merci à vous !");
                    }
                    break;
                case "t" :
                    if(perso.getArgent()-prix[2]<0){
                        System.out.println("Vous n'avez pas assez d'argent !");
                    } else {
                        perso.setArgent(perso.getArgent()-prix[2]);
                        perso.setTalisman(puissance[2]);
                        compteur_achat++;
                        System.out.println("Merci à vous !");
                    }
                    break;
                case "v" :
                    if(perso.getArgent()-prix[3]<0){
                        System.out.println("Vous n'avez pas assez d'argent !");
                    } else {
                        perso.setArgent(perso.getArgent()-prix[3]);
                        perso.setPotionVie(puissance[3]);
                        compteur_achat++;
                        System.out.println("Merci à vous !");
                    }
                    break;
                case "m" :
                    if(perso.getArgent()-prix[4]<0){
                        System.out.println("Vous n'avez pas assez d'argent !");
                    } else {
                        perso.setArgent(perso.getArgent()-prix[4]);
                        perso.setPotionPM(puissance[4]);
                        compteur_achat++;
                        System.out.println("Merci à vous !");
                    }
                    break;
                case "a" :
                    if(perso.getArgent()-prix[5]<0){
                        System.out.println("Vous n'avez pas assez d'argent !");
                    } else {
                        perso.setArgent(perso.getArgent()-prix[5]);
                        perso.setArmure(puissance[5]);
                        compteur_achat++;
                        System.out.println("Merci à vous !");
                    }
                    break;
                case "r" :
                    if(perso.getArgent()-prix[6]<0){
                        System.out.println("Vous n'avez pas assez d'argent !");
                    } else {
                        perso.setArgent(perso.getArgent()-prix[6]);
                        perso.setArmureMagique(puissance[6]);
                        compteur_achat++;
                        System.out.println("Merci à vous !");
                    }
                    break;
                case "p" :
                    continuer = true;
                    break;
                default :
                    System.out.println("Je n'ai pas cet article en magasin...");
                    break;
            }
        }
        if(compteur_achat==3){
            System.out.println("Vous êtes bien brave de faire vivre des humbles commerçants comme nous.");
            System.out.println("J'espère vous revoir vite !");
        }
        if(compteur_achat >= 4){
            System.out.println("Vous êtes notre meilleur client !");
            System.out.println("Permettez-nous de vous offrir ces 50 pièces d'or !");
            perso.setArgent(perso.getArgent()+50);
        }
        System.out.println("Merci et à bientôt !");
    }
}
