/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import Combat.Combat;
import Menus.Lieu;
import Menus.MenuCampement;
import Menus.MenuCite;
import Menus.MenuForet;
import Menus.MenuGeneral;
import Menus.MenuLac;
import Menus.MenuMaitreCompetences;
import Menus.MenuPlaine;
import armes.Arme;
import armes.ArmeUtilise;
import armes.Epee;
import armes.Sceptre;
import java.io.IOException;
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
import utilitaire.Comparateur;

/**
 *<p><strong>Cette classe est la classe principale du jeu.</strong></p>
 * @author Jérémy Duval
 * @version 1.0
 */
public class LesRuinesDEpiria3{
    private static MenuGeneral menu_general;
    /**
     * @param args the command line arguments
     * @throws java.io.IOException : à traiter !
     */
    public static void main(String[] args) throws IOException {
        Arme arme_use_epee_guerrier = new Epee();
        ArmeUtilise arme_use_gerrier = new ArmeUtilise(arme_use_epee_guerrier, 80);
        Personnage paysan = new Paysan();
        Personnage guerrier = new Guerrier(arme_use_gerrier);
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
        /*
        Set <String> clés2 = null;
        clés2 = inventaire.keySet();
        for(String i : clés2){
            System.out.println("Pour la clé "+i+" on a :");
            System.out.println(inventaire.get(i));
        }*/
        
        System.out.println("\n\nTest getter :\n\n");
        int xp = perso.get("Paysan").getXp();
        System.out.println("Xp : "+xp);
        int epee = perso.get("Paysan").getEpee();
        System.out.println("Epee : "+epee);
        
        System.out.println("\n\nTest setter :\n\n");
        perso.get("Paysan").setXp(5);
        xp = perso.get("Paysan").getXp();
        System.out.println("Xp : "+xp);
        perso.get("Paysan").setEpee(20);
        epee = perso.get("Paysan").getEpee();
        System.out.println("Epee : "+epee);
        
        System.out.println("\n\nTest interface arme :\n\n");
        System.out.println(perso.get("Paysan").getArmePossible());
        
        System.out.println("\n\nTest objet arme :\n\n");
        ArmeUtilise arme_use1 = new ArmeUtilise();
        ArmeUtilise arme_use2 = new ArmeUtilise(new Epee(), 50);
        System.out.println("Arme 1 : ");
        System.out.println("Type : "+arme_use1.getTypeArme());
        System.out.println("Nom : "+arme_use1.getNomArme());
        System.out.println("Valeur : "+arme_use1.getValeurArme());
        System.out.println("Arme 2 : ");
        System.out.println("Type : "+arme_use2.getTypeArme());
        System.out.println("Nom : "+arme_use2.getNomArme());
        System.out.println("Valeur : "+arme_use2.getValeurArme());
        System.out.println("Arme 1 modif : ");
        arme_use1.setArme(new Sceptre(), 75);
        System.out.println("Type : "+arme_use1.getTypeArme());
        System.out.println("Nom : "+arme_use1.getNomArme());
        System.out.println("Valeur : "+arme_use1.getValeurArme());
        
        
        System.out.println("\n\nTest objet menus :\n\n");
        Personnage prsng = new Paysan();
        String perso_principal = "Paysan";
        Map <String, Personnage> tree_perso = new TreeMap<>(new Comparateur());
        //stockage des objets dans un treeMap
        tree_perso.put("Paysan", paysan);
        tree_perso.put("Guerrier", guerrier);
        tree_perso.get("Paysan").setLevelSceptre(10);
        ArmeUtilise arme_principale = new ArmeUtilise(new Epee(), 50);
        
        System.out.println(menu_general);
        menu_general = new MenuPlaine();
        System.out.println(menu_general);
        menu_general = new MenuForet();
        System.out.println(menu_general);
        menu_general = new MenuLac();
        System.out.println(menu_general);
        menu_general = new MenuCampement();
        System.out.println(menu_general);
        menu_general = new MenuCite();
        System.out.println(menu_general);
        //prsng.setVie(2);
        List liste_menu = new ArrayList();
        System.out.println("Arme principale :\n"+ arme_principale.getNomArme() + "\n" + arme_principale.getValeurArme());
        liste_menu = menu_general.redirectionChoix((TreeMap<String, Personnage>) tree_perso,perso_principal,arme_principale);
        arme_principale = (ArmeUtilise) liste_menu.get(2);
        perso_principal = (String) liste_menu.get(1);
        setLieuToMenu((Lieu) liste_menu.get(0));
        //System.out.println(menu_general.choix);
        System.out.println(menu_general);
        
        Set <String> clés2 = tree_perso.keySet();
        
        for(String i : clés2){
            System.out.println("Pour la clé "+i+" on a :");
            System.out.println(tree_perso.get(i));
        }
        
        System.out.println("Perso :\n"+perso_principal);
        System.out.println(tree_perso.get(perso_principal));
        System.out.println("Level scpetre : "+tree_perso.get("Paysan").getLevelSceptre());
        System.out.println("or : "+tree_perso.get("Guerrier").getArgent());
        tree_perso.get("Guerrier").setArgent(10);
        System.out.println("or : "+tree_perso.get("Paysan").getArgent());
        System.out.println("Arme principale :\n"+ arme_principale.getNomArme() + "\n" + arme_principale.getValeurArme());
        /*
        System.out.println("\nUn test :\n");
        
        Combat cb = new Combat();
        cb.levelUp((TreeMap<String, Personnage>)tree_perso, perso_principal);*/
        
        
    }
    
    
    /**
     * <p>Cette méthode sert à changer la variable de menu en celui du lieu
     * passé en paramètre</p>
     * @param lieu : Lieu : un lieu à passer en menu correspondant
     * @author Jérémy Duval
     * @version 1.0
     */
    public static void setLieuToMenu(Lieu lieu){
        switch(lieu.getLieu()){
            case "c : Cité\n" :
                menu_general = new MenuCite();
                break;
            case "p : Plaines\n" :
                menu_general = new MenuPlaine();
                break;
            case "f : Forêt\n" :
                menu_general = new MenuForet();
                break;
            case "l : Lac\n" :
                menu_general = new MenuLac();
                break;
            case "k : Campement\n" :
                menu_general = new MenuCampement();
                break;
            default :
                menu_general = new MenuCite();
                break;
        }
    }
    
}
