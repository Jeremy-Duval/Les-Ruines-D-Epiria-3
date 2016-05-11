/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Combat;

import Menus.Lieu;
import Menus.LieuForet;
import Menus.LieuLac;
import Menus.LieuPlaine;
import armes.Arme;
import armes.ArmeUtilise;
import armes.Epee;
import armes.Sceptre;
import armes.Talisman;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;
import mobs.Monstres;
import mobs.MonstresCaCC;
import mobs.MonstresCaCD;
import mobs.MonstresCaCE;
import mobs.MonstresMagieC;
import mobs.MonstresMagieD;
import mobs.MonstresMagieE;
import mobs.MonstresPolyC;
import mobs.MonstresPolyD;
import mobs.MonstresPolyE;
import perso.Personnage;

/**
 *<p><strong>Cette classe permet la création du menu de combats.</strong></p>
 * @author Jérémy Duval
 * @since 1.0
 */
public class Combat {
    
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur ne fait rien.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public Combat(){};
    
    //**************************************************************************
    //fonctions
    //**************************************************************************
    public void menuCombat(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme, Lieu lieu) throws IOException{
        Random aleat = new Random();
        Monstres mob;
        boolean debut_combat = true;
        List liste = new ArrayList();
        boolean fuir = false;
        
        if(Math.abs(aleat.nextInt(9))<=8){
            mob = determineMonstre(lieu);
            while((mob.getVie()>0)&&(treePerso.get(perso).getVieAcutelle()>0)&&(!fuir)){//tant que le perso ou le monstre a de la vie
                if((debut_combat==false)||((debut_combat)&&(mob.getAgilite()<treePerso.get(perso).getAgilite()))){//si l'agilité du monstre est > à celle du perso et que l'on est au premier tour, on saute le tour du perso (monstre commence)
                    debut_combat = false;
                    liste = combatPerso(treePerso, perso, arme, mob);
                    fuir = (boolean) liste.get(0);
                    mob = (Monstres) liste.get(1);
                    
                }else{
                    if((mob.getVie()>0)&&(!fuir)){//si le monstre est vaincu, on saute son tour afin de terminer le while
                        debut_combat = false;
                        mob = combatMob(treePerso, perso, arme, mob);
                    } 
                }
            }
            //Reste à gérer si perso vaincu
            //si fuir == false
                //si mob vaincu appeler levelUp (qui appel pointDeCaracteristique)
            //si mob vaincue appeler fouillerLieu
        } else { 
            //on a une chance sur 10 de ne pas tomber sur un monstre
        }
    }
    /**
    *<p>Cette fonction détermine un rang de monstre en fonction du lieu ainsi
    * que son type (aléatoirement entre 3).</p>
    * @param lieu : Lieu
    * @return Monstres : monstre en fonction du lieu.
    * @author Jérémy Duval
    * @since 1.0
    */
    public Monstres determineMonstre(Lieu lieu){
        Lieu test_lieu;
        Random aleat_rang = new Random();
        Random aleat_type = new Random();
        int type;
        Monstres mob = null;
        
        test_lieu = new LieuPlaine();
        if(test_lieu.getLieu().equals(lieu.getLieu())){
            if(Math.abs(aleat_rang.nextInt(1))==0){//rang E
                type = Math.abs(aleat_type.nextInt(2));
                switch(type){
                    case 0:
                        mob = new MonstresCaCE();
                        break;
                    case 1:
                        mob = new MonstresMagieE();
                        break;
                    default :
                        mob = new MonstresPolyE();
                        break;
                }
            }else{//rang D
                type = Math.abs(aleat_type.nextInt(2));
                switch(type){
                    case 0:
                        mob = new MonstresCaCD();
                        break;
                    case 1:
                        mob = new MonstresMagieD();
                        break;
                    default :
                        mob = new MonstresPolyD();
                        break;
                }
            }
        }
        test_lieu = new LieuLac();
        if(test_lieu.getLieu().equals(lieu.getLieu())){
            type = Math.abs(aleat_rang.nextInt(1));
            if(type == 0){//rang C
                type = Math.abs(aleat_type.nextInt(2));
                switch(type){
                    case 0:
                        mob = new MonstresCaCC();
                        break;
                    case 1:
                        mob = new MonstresMagieC();
                        break;
                    default :
                        mob = new MonstresPolyC();
                        break;
                }
            }else{
                if(type == 1){//rang D
                    type = Math.abs(aleat_type.nextInt(2));
                    switch(type){
                        case 0:
                            mob = new MonstresCaCD();
                            break;
                        case 1:
                            mob = new MonstresMagieD();
                            break;
                        default :
                            mob = new MonstresPolyD();
                            break;
                    }
                }else{
                    type = Math.abs(aleat_type.nextInt(2));
                    switch(type){
                        case 0:
                            mob = new MonstresCaCE();
                            break;
                        case 1:
                            mob = new MonstresMagieE();
                            break;
                        default :
                            mob = new MonstresPolyE();
                            break;
                    }
                }
            }
        }
        test_lieu = new LieuForet();
        if(test_lieu.getLieu().equals(lieu.getLieu())){
            if(Math.abs(aleat_rang.nextInt(1))==0){//rang C
                type = Math.abs(aleat_type.nextInt(2));
                switch(type){
                    case 0:
                        mob = new MonstresCaCC();
                        break;
                    case 1:
                        mob = new MonstresMagieC();
                        break;
                    default :
                        mob = new MonstresPolyC();
                        break;
                }
            }else{//rang D
                type = Math.abs(aleat_type.nextInt(2));
                switch(type){
                    case 0:
                        mob = new MonstresCaCD();
                        break;
                    case 1:
                        mob = new MonstresMagieD();
                        break;
                    default :
                        mob = new MonstresPolyD();
                        break;
                }
            }
        }
        return mob;
    }
    /**
    *<p>Cette fonction est le menu représentant les différentes possibilité du
 personnage durant le Combat.</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @param arme : arme utilisée par le perso
     * @param mob : monstre contre lequel se bas le perso
     * @throws java.io.IOException : lecture de buffer
     * @return List : <ul><li>fuir : boolean</li>
    *                     <li>mob : Monstres </li></ul> 
    * @since 1.0
    */
    public List combatPerso(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme, Monstres mob) throws IOException{
        List liste = new ArrayList();
        Sort test_sort;
        boolean continuer = false;
        boolean continuer2 = false;
        BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
        String choix;
        int choix2;
        Arme arme_test;
        Random aleat = new Random();
        int nb_aleat;
        boolean fuir = false;
        
        System.out.println("\nQue faire ?");
        System.out.println("a : attaque");
        System.out.println("m : attaque magique");
        System.out.println("s : sort");
        System.out.println("v : potion de vie");
        System.out.println("p : potion de pm");
        System.out.println("f : fuite");
        while(!continuer){
            choix = buff.readLine();
            switch(choix){
                case "a" :
                    System.out.println("Vous utilisez attaque physique !");
                    arme_test = new Epee();
                    if(arme_test.getArmeUtil().equals(arme.getNomArme())){
                        mob.setVie(mob.getDefense()-(treePerso.get(perso).getAttaque()+treePerso.get(perso).getEpee()));//vie monstre = defense monstre - (attaque perso + epee perso)
                        treePerso.get(perso).setXpEpee((mob.getDefense()-(treePerso.get(perso).getAttaque()+treePerso.get(perso).getEpee()))/2);//xp arme = dégat/2
                        if(treePerso.get(perso).getXpEpee()>treePerso.get(perso).getXpNecessaireEpee()){//on test si xp de l'arme > xp besoin pour passer de level
                            levelUpArme(treePerso, perso, arme);
                        }
                    }else{
                        mob.setVie(mob.getDefense()-(treePerso.get(perso).getAttaque()));//vie monstre = defense monstre - (attaque perso)
                    }
                    continuer = true;
                    break;
                case "m" :
                    System.out.println("Vous utilisez attaque magique !");
                    arme_test = new Sceptre();
                    if(arme_test.getArmeUtil().equals(arme.getNomArme())){
                        mob.setVie(mob.getDefenseMagique()-(treePerso.get(perso).getAttaqueMagique()+treePerso.get(perso).getSceptre()));
                        treePerso.get(perso).setXpSceptre((mob.getDefense()-(treePerso.get(perso).getAttaque()+treePerso.get(perso).getEpee()))/2);//xp arme = dégat/2
                        if(treePerso.get(perso).getXpSceptre()>treePerso.get(perso).getXpNecessaireSceptre()){//on test si xp de l'arme > xp besoin pour passer de level
                            levelUpArme(treePerso, perso, arme);
                        }
                    }else{
                        arme_test = new Talisman();
                        if(arme_test.getArmeUtil().equals(arme.getNomArme())){
                            mob.setVie(mob.getDefenseMagique()-(treePerso.get(perso).getAttaqueMagique()+treePerso.get(perso).getTalisman()));
                            treePerso.get(perso).setXpTalisman((mob.getDefense()-(treePerso.get(perso).getAttaque()+treePerso.get(perso).getEpee()))/2);//xp arme = dégat/2
                            if(treePerso.get(perso).getXpTalisman()>treePerso.get(perso).getXpNecessaireTalisman()){//on test si xp de l'arme > xp besoin pour passer de level
                                levelUpArme(treePerso, perso, arme);
                            }
                        }else{
                            mob.setVie(mob.getDefenseMagique()-(treePerso.get(perso).getAttaqueMagique()));
                        }
                    }
                    continuer = true;
                    break;
                case "s" :
                    test_sort = new SortAttaque();
                    if(treePerso.get(perso).getSort().getSort().equals(test_sort.getSort())){
                        mob.setVie(treePerso.get(perso).getIntelligence());//on attaque directement la vie à l'aide de la puissance magique(intellignece)
                    }
                    test_sort = new SortSoin();
                    if(treePerso.get(perso).getSort().getSort().equals(test_sort.getSort())){
                        treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getSagesse());//on soigne le perso à l'aide de la puissance de soin (sagesse)
                        if(treePerso.get(perso).getVieAcutelle()>treePerso.get(perso).getVie()){//si la vie actu a dépassée la vie max
                        treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVie());
                    }
                    }
                    
                    continuer = true;
                    break;
                case "v" :
                    System.out.println("Vous utilisez une potion de vie !");
                    treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getPotionVie());
                    treePerso.get(perso).setPotionVie(0);
                    if(treePerso.get(perso).getVieAcutelle()>treePerso.get(perso).getVie()){//si la vie actu a dépassée la vie max
                        treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVie());
                    }
                    continuer = true;
                    break;
                case "p" :
                    System.out.println("Vous utilisez une potion de PM !");
                    treePerso.get(perso).setPmActuel(treePerso.get(perso).getPotionPm());
                    treePerso.get(perso).setPotionPM(0);
                    if(treePerso.get(perso).getPmActuel()>treePerso.get(perso).getPm()){//si les pm actu ont dépassés les pm max
                        treePerso.get(perso).setPmActuel(treePerso.get(perso).getPm());
                    }
                    continuer = true;
                    break;
                case "f" :
                    System.out.println("Jetez des pièces pour augmenter vos chances de fuir !");
                    System.out.println("Combien voulez-vous jeter ?");
                    while(!continuer2){
                        choix2 = Integer.parseInt(buff.readLine());
                        if(choix2>treePerso.get(perso).getArgent()){
                            treePerso.get(perso).setArgent(treePerso.get(perso).getArgent()-choix2);
                            nb_aleat = Math.abs(aleat.nextInt(30))%choix2;
                            if(nb_aleat == 30){
                                System.out.println("Vous fuyez !");
                                continuer = true;
                                fuir = true;
                            }else{
                                System.out.println("Vous n'arrivez pas à fuir !");
                                continuer = true;
                            }
                        }
                        
                    }
                    break;
                default :
                    System.out.println("Vous ne connaissez pas cette action...");
            }
        }
        
        liste.add(0, fuir);
        liste.add(1, mob);
        return liste;
    }
    
    /**
    *<p>Cette fonction représente le tour du monstre pendant le Combat.</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @param arme : arme utilisée par le perso
     * @param mob : monstre contre lequel se bas le perso
     * @return mob : Monstres
    * @since 1.0
    */
    public Monstres combatMob(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme, Monstres mob){
        Random aleat = new Random();
        int nb_aleat;
        
        nb_aleat = Math.abs(aleat.nextInt(11));
        if(nb_aleat < 5){
            System.out.println("Le monstre lance attaque physique !");
            treePerso.get(perso).setVieAcutelle(mob.getAttaque()-(treePerso.get(perso).getDefense()+treePerso.get(perso).getArmure()));
        }else{
            if((nb_aleat > 4)&&(nb_aleat<11)){
                System.out.println("Le monstre lance attaque magique !");
                treePerso.get(perso).setVieAcutelle(mob.getAttaqueMagique()-(treePerso.get(perso).getDefenseMagique()+treePerso.get(perso).getArmureMagique()));
            }else{
                System.out.println("Le monstre rate son attaque !");
            }
        }
        return mob;
    }
    
    /**
    *<p>Cette fonction sert à faire passer de niveau de l'arme.</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @param arme : armeUtilise utilisé par le perso
    * @since 1.0
    */
    public void levelUpArme(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme){
        Arme n_arme;
        //arme.setArme(arme.getTypeArme(), treePerso.get(perso).getEpee());//on met à jour l'arme utilise
        n_arme = new Epee();
        if(n_arme.getArmeUtil().equals(arme.getNomArme()))
        {
            treePerso.get(perso).setXpEpee(treePerso.get(perso).getXpEpee()-treePerso.get(perso).getXpNecessaireEpee());//on remplace l'xp par celui restant lors du passage de level
            treePerso.get(perso).setLevelEpee(treePerso.get(perso).getLevelEpee()+1);//on augmente le niveau
        }
        n_arme = new Sceptre();
        if(n_arme.getArmeUtil().equals(arme.getNomArme()))
        {
            treePerso.get(perso).setXpSceptre(treePerso.get(perso).getXpSceptre()-treePerso.get(perso).getXpNecessaireSceptre());//on remplace l'xp par celui restant lors du passage de level
            treePerso.get(perso).setLevelSceptre(treePerso.get(perso).getLevelSceptre()+1);//on augmente le niveau
        }
        n_arme = new Talisman();
        if(n_arme.getArmeUtil().equals(arme.getNomArme()))
        {
            treePerso.get(perso).setXpTalisman(treePerso.get(perso).getXpTalisman()-treePerso.get(perso).getXpNecessaireTalisman());//on remplace l'xp par celui restant lors du passage de level
            treePerso.get(perso).setLevelTalisman(treePerso.get(perso).getLevelTalisman()+1);//on augmente le niveau
        }
    }
    
    /**
    *<p>Cette fonction sert à faire passer de niveau le perso.</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @throws java.io.IOException : lecture de buffer
    * @since 1.0
    */
    public void levelUp(TreeMap<String,Personnage> treePerso, String perso) throws IOException{
        treePerso.get(perso).setXp(treePerso.get(perso).getXp()-treePerso.get(perso).getXpNecessaire());//on remplace l'xp par celui restant lors du passage de level
        treePerso.get(perso).setLevel(treePerso.get(perso).getLevel()+1);//on augmente le niveau
        //augmentation des stats suivant les classes
        //
        
        
        
        pointsCaractéristiques(treePerso, perso);
        
        
        //remet vie et pm au max
        //
    }
    /**
    *<p>Cette fonction sert à faire distribuer des points de caractéristique.</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @throws java.io.IOException : lecture de buffer
    * @since 1.0
    */
    public void pointsCaractéristiques(TreeMap<String,Personnage> treePerso, String perso) throws IOException{
        BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
        String choix;
        int nb_points = 5;
        
        System.out.println("\nVous avez " + nb_points + " de caractéristique à répartir :");
        System.out.println("v : vie");
        System.out.println("p : pm");
        System.out.println("a : attaque");
        System.out.println("m : attaque magique");
        System.out.println("i : intellignece");
        System.out.println("s : sagesse");
        System.out.println("d : agilité");
        
        while(nb_points > 0){
            choix = buff.readLine();
            switch(choix){
                case "a" :
                    System.out.println("Attaque augmentée !");
                    treePerso.get(perso).setAttaque(treePerso.get(perso).getAttaque()+1);
                    nb_points--;
                    break;
                case "m" :
                    System.out.println("Attaque magique augmentée !");
                    treePerso.get(perso).setAttaque(treePerso.get(perso).getAttaque()+1);
                    nb_points--;
                    break;
                case "s" :
                    System.out.println("Sagesse augmentée !");
                    treePerso.get(perso).setSagesse(treePerso.get(perso).getSagesse()+1);
                    nb_points--;
                    break;
                case "i" :
                    System.out.println("Intelligence augmentée !");
                    treePerso.get(perso).setIntelligence(treePerso.get(perso).getIntelligence()+1);
                    nb_points--;
                    break;
                case "v" :
                    System.out.println("Vie augmentée !");
                    treePerso.get(perso).setVie(treePerso.get(perso).getVie()+1);
                    nb_points--;
                    break;
                case "p" :
                    System.out.println("Pm augmentée !");
                    treePerso.get(perso).setPm(treePerso.get(perso).getPm()+1);
                    nb_points--;
                    break;
                case "d" :
                    System.out.println("Agilité augmentée !");
                    treePerso.get(perso).setAgilite(treePerso.get(perso).getAgilite()+1);
                    nb_points--;
                    break;
                default :
                    System.out.println("Vous n'avez pas cette caractéristique...");
            }
        }
    }
}