/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import perso.Guerrier;
import perso.Mage;
import perso.Paysan;
import perso.Personnage;
import perso.Pretre;

/**
 *
 * @author jeremy
 */
public class MenuMaitreCompetences {
    
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur ne fait rien.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public MenuMaitreCompetences(){};
    
    
    
    public void menu(TreeMap<String,Personnage> treePerso, Personnage perso) throws IOException{
        BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
        String choix;
        String choix2;
        boolean continuer = false;
        boolean continuer2 = false;
        
        System.out.println("\nBienvenue aventurier !");
        while(!continuer){
            System.out.println("Que désirez-vous ?");
            System.out.println("a : apprendre une nouvelle classe");
            System.out.println("c : changer de classe");
            System.out.println("p : partir");
                choix = buff.readLine();
            switch(choix){
                case "c" :
                    System.out.println("Mais bien sûr !");
                    System.out.println("En quel type de personnage voulez-vous vous changer ?");
                    System.out.println("p : paysan");
                    System.out.println("g : guerrier");
                    System.out.println("m : mage");
                    System.out.println("c : prêtre");
                    System.out.println("r : retour");
                    continuer2 = false;
                    while(!continuer2){
                        choix2 = buff.readLine();
                        switch(choix2){
                            case "p" :
                                continuer2 = true;
                                this.changementDeClasse("Paysan", treePerso, perso);
                                break;
                            case "g" :
                                continuer2 = true;
                                this.changementDeClasse("Guerrier", treePerso, perso);
                                break;
                            case "m" :
                                continuer2 = true;
                                this.changementDeClasse("Mage", treePerso, perso);
                                break;
                            case "c" :
                                continuer2 = true;
                                this.changementDeClasse("Pretre", treePerso, perso);
                                break;
                            case "r" :
                                continuer2 = true;
                                break;
                            default :
                                System.out.println("Parlez plus fort, je n'ai rien compris !");
                                break;
                        }
                    }
                    break;
                case "a" :
                    System.out.println("Mais bien sûr !");
                    System.out.println("Quel type de personnage voulez-vous devenir ?");
                    System.out.println("g : guerrier");
                    System.out.println("m : mage");
                    System.out.println("c : prêtre");
                    System.out.println("r : retour");
                    continuer2 = false;
                    while(!continuer2){
                        choix2 = buff.readLine();
                        switch(choix2){
                            
                            case "g" :
                                continuer2 = true;
                                this.apprendreUneClasse("Guerrier", treePerso, perso);
                                break;
                            case "m" :
                                continuer2 = true;
                                this.apprendreUneClasse("Mage", treePerso, perso);
                                break;
                            case "c" :
                                continuer2 = true;
                                this.apprendreUneClasse("Pretre", treePerso, perso);
                                break;
                            case "r" :
                                continuer2 = true;
                                break;
                            default :
                                System.out.println("Parlez plus fort, je n'ai rien compris !");
                                break;
                        }
                    }
                    break;
                case "p" :
                    continuer = true;
                    break;
                default :
                    System.out.println("Parlez plus fort, je n'ai rien compris !");
                    break;
            }
        }
    }
    
    private void apprendreUneClasse(String classe, TreeMap<String,Personnage> treePerso, Personnage perso){
        
        if(classe.equals("Guerrier")){
            if(treePerso.containsKey("Guerrier")){
                System.out.println("Désolé mais vous avez déjà apris cette classe !");
            } else {
                this.enregistrePersoClasse(treePerso, perso);
                perso = new Guerrier();
                treePerso.put("Guerrier", perso);
                System.out.println("Classe apprise !");
            }
        }
        if(classe.equals("Mage")){
            if(treePerso.containsKey("Mage")){
                System.out.println("Désolé mais vous avez déjà apris cette classe !");
            } else {
                this.enregistrePersoClasse(treePerso, perso);
                perso = new Mage();
                treePerso.put("Mage", perso);
                System.out.println("Classe apprise !");
            }
        }
        if(classe.equals("Pretre")){
            if(treePerso.containsKey("Pretre")){
                System.out.println("Désolé mais vous avez déjà apris cette classe !");
            } else {
                this.enregistrePersoClasse(treePerso, perso);
                perso = new Pretre();
                treePerso.put("Pretre", perso);
                System.out.println("Classe apprise !");
            }
        }
    }
    
    private void changementDeClasse(String classe, TreeMap<String,Personnage> treePerso, Personnage perso){
        
        if(classe.equals("Paysan")){
            if(!treePerso.containsKey("Paysan")){
                System.out.println("Désolé mais vous n'avez pas encore apris cette classe !");
            } else {
                this.enregistrePersoClasse(treePerso, perso);
                perso = treePerso.get("Paysan");
                System.out.println("Classe changée !");
            }
        }
        if(classe.equals("Guerrier")){
            if(!treePerso.containsKey("Guerrier")){
                System.out.println("Désolé mais vous n'avez pas encore apris cette classe !");
            } else {
                this.enregistrePersoClasse(treePerso, perso);
                perso = treePerso.get("Guerrier");
                System.out.println("Classe changée !");
            }
        }
        if(classe.equals("Mage")){
            if(!treePerso.containsKey("Mage")){
                System.out.println("Désolé mais vous n'avez pas encore apris cette classe !");
            } else {
                this.enregistrePersoClasse(treePerso, perso);
                perso = treePerso.get("Mage");
                System.out.println("Classe changée !");
            }
        }
        if(classe.equals("Pretre")){
            if(!treePerso.containsKey("Pretre")){
                System.out.println("Désolé mais vous n'avez pas encore apris cette classe !");
            } else {
                this.enregistrePersoClasse(treePerso, perso);
                perso = treePerso.get("Pretre");
                System.out.println("Classe changée !");
            }
        }
    }
    
    private void enregistrePersoClasse(TreeMap<String,Personnage> treePerso, Personnage perso){
        String classe_perso;
        
        classe_perso = perso.getClassePerso();
        treePerso.remove(classe_perso, treePerso.get(classe_perso));
        treePerso.put(classe_perso, perso);
    }
}
