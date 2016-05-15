/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serialization;

import armes.ArmeUtilise;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
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
    public void sauvegarde(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme) throws IOException{
        boolean continuer = false;
        BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
        String choix;
        ObjectOutputStream fSaveTree;
        ObjectOutputStream fSavePerso;
        ObjectOutputStream fSaveArme;
        
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
                        fSaveArme = new ObjectOutputStream(
                                            new BufferedOutputStream (
                                                new FileOutputStream(
                                                    new File("sauvegardeArmeA"))));

                       
                        fSaveArme.writeObject(arme);
                        fSaveArme.close();

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
                        fSaveArme = new ObjectOutputStream(
                                            new BufferedOutputStream (
                                                new FileOutputStream(
                                                    new File("sauvegardeArmeB"))));

                       
                        fSaveArme.writeObject(arme);
                        fSaveArme.close();

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
                        fSaveArme = new ObjectOutputStream(
                                            new BufferedOutputStream (
                                                new FileOutputStream(
                                                    new File("sauvegardeArmeC"))));

                       
                        fSaveArme.writeObject(arme);
                        fSaveArme.close();

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
    * @return List : <ul><li>treePerso : TreeMap (String,Personnage) : le TreeMap contenant les classes de personnages</li>
    *                    <li>perso : String : nom de la classe utilisée</li>
    *                    <li>arme : ArmeUtilise : arme utilisée par le personnage</li></ul> 
    * @author Jérémy Duval
     * @throws java.io.IOException : lecture de buffer
    * @since 1.0
    */
    public List charge() throws IOException{ 
        TreeMap<String,Personnage> treePerso = new TreeMap();
        String perso = new String();
        ArmeUtilise arme = new ArmeUtilise();
        
        List liste = new ArrayList();
        boolean continuer = false;
        BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
        String choix;
        ObjectInputStream fChargeTree;
        ObjectInputStream fChargePerso;
        ObjectInputStream fChargeArme;
        
        System.out.println("Bien sûr ! Quelle sauvegarde voulez-vous charger ?");
        System.out.println("a : Sauvegarde A");
        System.out.println("b : Sauvegarde B");
        System.out.println("c : Sauvegarde C");
        while(!continuer){
            choix = buff.readLine();
            switch(choix){
                case "a" :
                    try{
                        //charge du TreeMap treePerso
                        fChargeTree = new ObjectInputStream(
                                        new BufferedInputStream (
                                            new FileInputStream(
                                                new File("sauvegardeTreeA"))));

                       
                        treePerso = (TreeMap<String, Personnage>) fChargeTree.readObject();
                        fChargeTree.close();
                        //charge du String perso
                        fChargePerso = new ObjectInputStream(
                                            new BufferedInputStream (
                                                new FileInputStream(
                                                    new File("sauvegardePersoA"))));

                       
                        perso = (String) fChargePerso.readObject();
                        fChargePerso.close();
                        //charge de ArmeUtilise arme
                        fChargeArme = new ObjectInputStream(
                                            new BufferedInputStream (
                                                new FileInputStream(
                                                    new File("sauvegardeArmeA"))));

                       
                        arme = (ArmeUtilise) fChargeArme.readObject();
                        fChargeArme.close();

                    }catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    continuer = true;
                    break;
                    
                case "b" :
                    try{
                        //charge du TreeMap treePerso
                        fChargeTree = new ObjectInputStream(
                                        new BufferedInputStream (
                                            new FileInputStream(
                                                new File("sauvegardeTreeB"))));

                       
                        treePerso = (TreeMap<String, Personnage>) fChargeTree.readObject();
                        fChargeTree.close();
                        //charge du String perso
                        fChargePerso = new ObjectInputStream(
                                            new BufferedInputStream (
                                                new FileInputStream(
                                                    new File("sauvegardePersoB"))));

                       
                        perso = (String) fChargePerso.readObject();
                        fChargePerso.close();
                        //charge de ArmeUtilise arme
                        fChargeArme = new ObjectInputStream(
                                            new BufferedInputStream (
                                                new FileInputStream(
                                                    new File("sauvegardeArmeB"))));

                       
                        arme = (ArmeUtilise) fChargeArme.readObject();
                        fChargeArme.close();

                    }catch(ClassNotFoundException e){
                        e.printStackTrace();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    continuer = true;
                    break;
                    
                case "c" :
                    try{
                        //charge du TreeMap treePerso
                        fChargeTree = new ObjectInputStream(
                                        new BufferedInputStream (
                                            new FileInputStream(
                                                new File("sauvegardeTreeC"))));

                       
                        treePerso = (TreeMap<String, Personnage>) fChargeTree.readObject();
                        fChargeTree.close();
                        //charge du String perso
                        fChargePerso = new ObjectInputStream(
                                            new BufferedInputStream (
                                                new FileInputStream(
                                                    new File("sauvegardePersoC"))));

                       
                        perso = (String) fChargePerso.readObject();
                        fChargePerso.close();
                        //charge de ArmeUtilise arme
                        fChargeArme = new ObjectInputStream(
                                            new BufferedInputStream (
                                                new FileInputStream(
                                                    new File("sauvegardeArmeC"))));

                       
                        arme = (ArmeUtilise) fChargeArme.readObject();
                        fChargeArme.close();

                    }catch(ClassNotFoundException e){
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
        liste.add(0, treePerso);
        liste.add(1, perso);
        liste.add(2, arme);
        return liste;
    } 
    
}
