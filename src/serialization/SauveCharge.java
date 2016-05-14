/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import armes.ArmeUtilise;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.TreeMap;
import mobs.Monstres;
import perso.Personnage;

/**
 *
 * @author jeremy
 */
public class SauveCharge {
    /**
    *<p><Strong>Ce constructeur ne fait rien.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public SauveCharge(){};
    
    /**
    *<p>Cette fonction permet de sauvegarder la partie (3 sauvegardes possibles).</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @param arme : ArmeUtilise : arme utilisée par le perso
     * @throws java.io.IOException : lecture de buffer
    * @since 1.0
    */
    public void sauvegarde(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme, Monstres mob) throws IOException{
        boolean continuer = false;
        BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
        String choix;
        ObjectOutputStream fSaveTree;
        ObjectOutputStream fSavePerso;
        ObjectOutputStream fSaveTreeArme;
        
        System.out.println("Bien sûr ! Sur quelle sauvegarde ?");
        System.out.println("a : Sauvegarde A");
        System.out.println("b : Sauvegarde B");
        System.out.println("c : Sauvegarde C");
        while(!continuer){
            choix = buff.readLine();
            switch(choix){
                case "a" :
                    try{
                        //save du TreeMap treePerso
                        fSaveTree = new ObjectOutputStream(
                                        new BufferedOutputStream (
                                            new FileOutputStream(
                                                new File("sauvegardeTreeA"))));

                       
                        fSaveTree.writeObject(treePerso);
                        fSaveTree.close();
                        //save du String perso
                        fSavePerso = new ObjectOutputStream(
                                        new BufferedOutputStream (
                                            new FileOutputStream(
                                                new File("sauvegardePersoA"))));

                       
                        fSavePerso.writeObject(perso);
                        fSavePerso.close();
                        //save de ArmeUtilise arme
                        fSaveTreeArme = new ObjectOutputStream(
                                            new BufferedOutputStream (
                                                new FileOutputStream(
                                                    new File("sauvegardeArmeA"))));

                       
                        fSaveTreeArme.writeObject(arme);
                        fSaveTreeArme.close();

                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                    }catch(IOException e){
                        e.printStackTrace();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    continuer = true;
                    break;
                    
                case "b" :
                    try{
                        //save du TreeMap treePerso
                        fSaveTree = new ObjectOutputStream(
                                        new BufferedOutputStream (
                                            new FileOutputStream(
                                                new File("sauvegardeTreeB"))));

                       
                        fSaveTree.writeObject(treePerso);
                        fSaveTree.close();
                        //save du String perso
                        fSavePerso = new ObjectOutputStream(
                                        new BufferedOutputStream (
                                            new FileOutputStream(
                                                new File("sauvegardePersoB"))));

                       
                        fSavePerso.writeObject(perso);
                        fSavePerso.close();
                        //save de ArmeUtilise arme
                        fSaveTreeArme = new ObjectOutputStream(
                                            new BufferedOutputStream (
                                                new FileOutputStream(
                                                    new File("sauvegardeArmeB"))));

                       
                        fSaveTreeArme.writeObject(arme);
                        fSaveTreeArme.close();

                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                    }catch(IOException e){
                        e.printStackTrace();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    continuer = true;
                    break;
                    
                case "c" :
                    try{
                        //save du TreeMap treePerso
                        fSaveTree = new ObjectOutputStream(
                                        new BufferedOutputStream (
                                            new FileOutputStream(
                                                new File("sauvegardeTreeC"))));

                       
                        fSaveTree.writeObject(treePerso);
                        fSaveTree.close();
                        //save du String perso
                        fSavePerso = new ObjectOutputStream(
                                        new BufferedOutputStream (
                                            new FileOutputStream(
                                                new File("sauvegardePersoC"))));

                       
                        fSavePerso.writeObject(perso);
                        fSavePerso.close();
                        //save de ArmeUtilise arme
                        fSaveTreeArme = new ObjectOutputStream(
                                            new BufferedOutputStream (
                                                new FileOutputStream(
                                                    new File("sauvegardeArmeC"))));

                       
                        fSaveTreeArme.writeObject(arme);
                        fSaveTreeArme.close();

                    }catch(FileNotFoundException e){
                        e.printStackTrace();
                    }catch(IOException e){
                        e.printStackTrace();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    continuer = true;
                    break;
                default :
                    System.out.println("Désolé, mais ce fichier ne peut être créé...");
                    break;
            }
        }
    }
    
    /**
    *<p>Cette fonction permet de charger la partie (3 sauvegardes possibles).</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @param arme : ArmeUtilise : arme utilisée par le perso
    * @since 1.0
    */
    public void charge(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme, Monstres mob) throws IOException{ 
        
    } 
}
