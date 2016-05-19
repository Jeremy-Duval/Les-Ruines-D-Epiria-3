/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Combat.Combat;
import Menus.Lieu;
import Menus.LieuCite;
import Menus.MenuCampement;
import Menus.MenuCite;
import Menus.MenuForet;
import Menus.MenuGeneral;
import Menus.MenuLac;
import Menus.MenuMaitreCompetences;
import Menus.MenuPlaine;
import armes.AccesInventaire;
import armes.Arme;
import armes.ArmeUtilise;
import armes.Epee;
import armes.Poing;
import armes.Sceptre;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import perso.Guerrier;
import perso.Mage;
import perso.Paysan;
import perso.Personnage;
import perso.Pretre;
import serialization.SauveCharge;
import utilitaire.Comparateur;

/**
 * <p>
 * <strong>Cette classe est la classe principale du jeu.</strong></p>
 *
 * @author Jérémy Duval
 * @version 1.0
 */
public class LesRuinesDEpiria3 {

    //variable du menu
    private static MenuGeneral menu_general;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException : à traiter !
     */
    public static void main(String[] args) throws IOException {
        //objets principaux du programme
        Map treePerso = new TreeMap<>();
        String perso = "";
        ArmeUtilise arme = new ArmeUtilise();
        //variable servant au menu
        boolean continuer = false;
        BufferedReader buff = new BufferedReader(
                new InputStreamReader(System.in));
        String choix;
        //variables pour le chargement
        SauveCharge charger = new SauveCharge();
        List listeC = new ArrayList();
        //variable pour le jeu
        boolean quitter = false;
        Lieu lieu = new LieuCite();
        List listeM = new ArrayList();

        //**********************************************************************
        //début du programme
        //**********************************************************************
        System.out.println("Bienvenue dans Les Ruines d'Epiria 3 !");
        System.out.println("Que voulez vous faire ?");
        System.out.println("c : continuer");
        System.out.println("n : nouvelle partie");
        System.out.println("z : crédits");
        while (!continuer) {
            choix = buff.readLine();
            switch (choix) {
                case "c":
                    listeC = charger.charge((TreeMap<String, Personnage>) treePerso);
                    //affectation des valeurs retournées par la fonction de chargement
                    perso = (String) listeC.get(0);
                    arme = (ArmeUtilise) listeC.get(1);
                    continuer = true;
                    break;
                case "n":
                    listeC = newGame((TreeMap<String, Personnage>) treePerso);
                    //affectation des valeurs retournées par la fonction de création de partie
                    perso = (String) listeC.get(0);
                    arme = (ArmeUtilise) listeC.get(1);
                    continuer = true;
                    break;
                case "z":
                    System.out.println("\nJeu créé et développé par Jérémy Duval");
                    System.out.println("\nRemerciements :");
                    System.out.println("Merci à Dorian Wouters pour son aide, pour la partie serialization, ainsi que les révisions du projet !");
                    break;
            }
        }
        //**********************************************************************
        //Boucle du jeu
        //**********************************************************************
        while (!quitter) {
            setLieuToMenu(lieu);
            System.out.println(menu_general);
            listeM = menu_general.redirectionChoix((TreeMap<String, Personnage>) treePerso, perso, arme);
            lieu = (Lieu) listeM.get(0);
            perso = (String) listeM.get(1);
            arme = (ArmeUtilise) listeM.get(2);
            quitter = (boolean) listeM.get(3);
        }
        //**********************************************************************
        //Fin du jeu
        //********************************************************************** 
        System.out.println("Au revoir et à bientôt !");
    }

    /**
     * <p>
     * Cette méthode sert à changer la variable de menu en celui du lieu passé
     * en paramètre</p>
     *
     * @param lieu : Lieu : un lieu à passer en menu correspondant
     * @author Jérémy Duval
     * @version 1.0
     */
    public static void setLieuToMenu(Lieu lieu) {
        switch (lieu.getLieu()) {
            case "c : Cité\n":
                menu_general = new MenuCite();
                break;
            case "p : Plaines\n":
                menu_general = new MenuPlaine();
                break;
            case "f : Forêt\n":
                menu_general = new MenuForet();
                break;
            case "l : Lac\n":
                menu_general = new MenuLac();
                break;
            case "k : Campement\n":
                menu_general = new MenuCampement();
                break;
            default:
                menu_general = new MenuCite();
                break;
        }
    }

    /**
     * <p>
     * Cette méthode sert à initialiser le TreeMap contenant les objets
     * personnages, sa classe (String) et son arme utilisée (ArmeUtilise).</p>
     *
     * @param treePerso : TreeMap (String,Personnage) : tout les objets
     * personnages
     * @return List : <ul><li>perso : String : nom de la classe utilisée</li>
     * <li>arme : ArmeUtilise : arme utilisée par le personnage</li></ul>
     * @author Jérémy Duval
     * @version 1.0
     */
    public static List newGame(TreeMap<String, Personnage> treePerso) {
        List liste = new ArrayList();
        //premier perso est un paysan
        Personnage paysan = new Paysan();
        treePerso.put("Paysan", paysan);
        //cible le String dessus
        String perso = "Paysan";
        //arme de départ : poing
        Arme poing = new Poing();
        ArmeUtilise arme = new ArmeUtilise();
        arme.setArme(poing, 0);
        //on ajoute à la liste
        liste.add(0, perso);
        liste.add(1, arme);
        //on retourne la liste
        return liste;
    }
}
