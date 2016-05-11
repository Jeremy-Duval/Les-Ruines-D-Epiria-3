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
import java.util.TreeMap;
import perso.Personnage;

/**
 *<p><strong>Cette classe permet la création du menu de l'auberge.</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class BoutiqueAuberge {
    protected int prix;
    private String choix;
    private boolean continuer = false;
    BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur ne fait rien.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public BoutiqueAuberge(){};
    /**
    *<p>Cette fonction ouvre le menu de l'auberge. Le joueur peut s'y soigner.
    * Le prix est proportionnel aux dégats reçus par le joueur</p>
    * @param tree_perso : TreeMap: String,Personnage
    * @param perso : String : l'étiquette de la classe dans le TreeMap
    * @throws java.io.IOException : lecture de buffer
    * @author jeremy
    * @since 1.0
    */
    public void boutiqueAuberge(TreeMap<String,Personnage> tree_perso,String perso) throws IOException{
        System.out.println("\nBienvenue dans l'auberge !");
        prix =(int)((tree_perso.get(perso).getVieAcutelle()-tree_perso.get(perso).getVie())/10);
        System.out.println("Voulez-vous passez une nuit ici ?");
        System.out.println("C'est seulement "+prix+" pièces d'or.");
        System.out.println("o : Oui");
        System.out.println("n : non");
        while(!continuer){
            choix = buff.readLine();
            if(this.choix.equals("o")){
                continuer = true;
                if(tree_perso.get(perso).getArgent()-prix < 0){
                    System.out.println("Vous n'avez pas assez d'argent !");
                    System.out.println("Je peux juste vous offrir ce verre d'eau...\n");
                    tree_perso.get(perso).setVie(tree_perso.get(perso).getVie()+1);
                }else{
                   tree_perso.get(perso).setArgent(tree_perso.get(perso).getArgent()-prix);
                   tree_perso.get(perso).setVie(tree_perso.get(perso).getVieAcutelle());
                   System.out.println("Je vous souhaite une agréable nuit !\n"); 
                }
            }
            if(this.choix.equals("n")){
                continuer = true;
                System.out.println("Vous partez...");
            }
        }
        
    }
}
