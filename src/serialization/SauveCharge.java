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
     * <p>
     * <Strong>Ce constructeur ne fait rien.</Strong></p>
     *
     * @author Jérémy Duval
     * @since 1.0
     */
    public SauveCharge() {
    }

    ;
    
    public enum EmplacementSauvegarde {
        A("A"),
        B("B"),
        C("C");

        private final String suffixe;

        EmplacementSauvegarde(String suffixe) {
            this.suffixe = suffixe;
        }

        public String getSuffixe() {
            return suffixe;
        }
    }

    /**
     * <p>
     * Cette fonction permet de sauvegarder la partie (3 sauvegardes
     * possibles).</p>
     *
     * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets
     * personnages
     * @param perso : String : classe du personnage
     * @param arme : ArmeUtilise : arme utilisée par le perso
     * @throws java.io.IOException : lecture de buffer
     * @since 1.0
     */
    public void sauvegarde(TreeMap<String, Personnage> treePerso, String perso, ArmeUtilise arme) throws IOException {
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
        boolean continuer = true;
        EmplacementSauvegarde empl = null;
        while (continuer) {
            choix = buff.readLine();
            switch (choix) {
                case "a":
                    empl = EmplacementSauvegarde.A;
                    continuer = false;
                    break;
                case "b":
                    empl = EmplacementSauvegarde.B;
                    continuer = false;
                    break;
                case "c":
                    empl = EmplacementSauvegarde.C;
                    continuer = false;
                    break;
                default:
                    System.out.println("Désolé, mais ce fichier ne peut être créé...");
                    break;
            }
        }
        if (empl == null) {
            throw new RuntimeException("L'emplacement de sauvegarde est invalide");
        }
        try {
            final String suffixe = empl.getSuffixe();
            //save du TreeMap treePerso
            fSaveTree = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("sauvegardeTree" + suffixe))));
            fSaveTree.writeObject(treePerso);
            fSaveTree.close();

            //save du String perso
            fSavePerso = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("sauvegardePerso" + suffixe))));

            fSavePerso.writeObject(perso);
            fSavePerso.close();

            //save de ArmeUtilise arme
            fSaveArme = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File("sauvegardeArme" + suffixe))));
            fSaveArme.writeObject(arme);
            fSaveArme.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <p>
     * Cette fonction permet de charger la partie (3 sauvegardes possibles).</p>
     *
     * @param treePerso : TreeMap (String,Personnage) : tout les objets
     * personnages
     * @return List : <ul><li>perso : String : nom de la classe utilisée</li>
     * <li>arme : ArmeUtilise : arme utilisée par le personnage</li></ul>
     * @author Jérémy Duval
     * @throws java.io.IOException : lecture de buffer
     * @since 1.0
     */
    public List charge(TreeMap<String, Personnage> treePerso) throws IOException {
        String perso = new String();
        ArmeUtilise arme = new ArmeUtilise();

        List liste = new ArrayList();
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
        boolean continuer = true;
        EmplacementSauvegarde empl = null;
        while (continuer) {
            choix = buff.readLine();
            switch (choix) {
                case "a":
                    empl = EmplacementSauvegarde.A;
                    continuer = false;
                    break;
                case "b":
                    empl = EmplacementSauvegarde.B;
                    continuer = false;
                    break;
                case "c":
                    empl = EmplacementSauvegarde.C;
                    continuer = false;
                    break;
                default:
                    System.out.println("Désolé, mais ce fichier ne peut être créé...");
                    break;
            }
        }
        if (empl == null) {
            throw new RuntimeException("L'emplacement de sauvegarde est invalide");
        }
        try {
            final String suffixe = empl.getSuffixe();
            //charge du String perso
            fChargePerso = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("sauvegardePerso" + suffixe))));

            perso = (String) fChargePerso.readObject();
            fChargePerso.close();
            //charge de ArmeUtilise arme
            fChargeArme = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("sauvegardeArme" + suffixe))));

            arme = (ArmeUtilise) fChargeArme.readObject();
            fChargeArme.close();
            //charge du TreeMap treePerso
            fChargeTree = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File("sauvegardeTree" + suffixe))));

            System.out.println(fChargeTree.readObject());
            treePerso = (TreeMap<String, Personnage>) fChargeTree.readObject();
            fChargeTree.close();
            System.out.println(treePerso);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        liste.add(0, perso);
        liste.add(1, arme);
        return liste;
    }

}
