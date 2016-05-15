/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Combat;

import Menus.Lieu;
import Menus.LieuCite;
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
import static java.lang.Math.ceil;
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
import utilitaire.Comparateur;

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
    public Lieu menuCombat(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme, Lieu lieu) throws IOException{
        Random aleat = new Random();
        Monstres mob;
        boolean debut_combat = true;
        List liste = new ArrayList();
        boolean fuir = false;
        int argent;
        System.out.println("Vous entrez dans un lieu sauvage...");
        if(Math.abs(aleat.nextInt(9))<=8){
            System.out.println("Vous êtes attaqué par un monstre !");
            mob = determineMonstre(lieu);
            while((mob.getVie()>0)&&(treePerso.get(perso).getVieAcutelle()>0)&&(!fuir)){//tant que le perso ou le monstre a de la vie
                System.out.println("*********************************");
                System.out.println("Vie : "+ treePerso.get(perso).getVieAcutelle() + "/" + treePerso.get(perso).getVie() + "\nPm : " + treePerso.get(perso).getPmActuel() + "/" + treePerso.get(perso).getPm());
                System.out.println("*********************************");
                System.out.println("Vie du monstre restante : "+mob.getVie());
                System.out.println("*********************************");
                if((debut_combat==false)||((debut_combat)&&(mob.getAgilite()<treePerso.get(perso).getAgilite()))){//si l'agilité du monstre est > à celle du perso et que l'on est au premier tour, on saute le tour du perso (monstre commence)
                    debut_combat = false;
                    liste = combatPerso(treePerso, perso, arme, mob);
                    fuir = (boolean) liste.get(0);
                    mob = (Monstres) liste.get(1);
                    
                    
                }
                if((debut_combat==false)||((debut_combat)&&(mob.getAgilite()>treePerso.get(perso).getAgilite()))){
                    if((mob.getVie()>0)&&(!fuir)){//si le monstre est vaincu, on saute son tour afin de terminer le while
                        debut_combat = false;
                        mob = combatMob(treePerso, perso, arme, mob);
                    } 
                }
            }
            if(treePerso.get(perso).getVieAcutelle()<0){
                System.out.println("Vous avez perdu !");
                argent = (int)treePerso.get(perso).getArgent()/4;
                treePerso.get(perso).setArgent(argent);//pert les 3/4 de l'or
                treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVie());//soin
                treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVie());//remet pm
                lieu = new LieuCite();//repart dans la ville
            } else{
                if(!fuir){
                    monstreVaincu(treePerso, perso, mob);
                    if(treePerso.get(perso).getXp()>treePerso.get(perso).getXpNecessaire()){//si xp perso > xp nécessaire pour le prochain niveau, on passe niveau
                        System.out.println("Vous montez de niveau !\n");
                        levelUp(treePerso, perso);
                    }
                    fouilles( treePerso, perso);
                } else {
                    //si le perso fuit, on n'appel pas les méthodes de levelUp() et fouilles()
                }
            }
            
        } else { 
            //on a une chance sur 10 de ne pas tomber sur un monstre
            fouilles( treePerso, perso);
        }
        return lieu;
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
        int rang;
        Monstres mob = null;
        
        test_lieu = new LieuPlaine();
        if(test_lieu.getLieu().equals(lieu.getLieu())){
            rang = Math.abs(aleat_rang.nextInt(1));
            if(rang==0){//rang E
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
            rang = Math.abs(aleat_rang.nextInt(1));
            if(rang == 0){//rang C
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
                if(rang == 1){//rang D
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
            rang = Math.abs(aleat_rang.nextInt(1));
            if(rang==0){//rang C
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
    * personnage durant le Combat.</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @param arme : ArmeUtilise : arme utilisée par le perso
     * @param mob : Monstres : monstre contre lequel se bas le perso
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
        int xp_arme;
        
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
                        mob.setVie(mob.getVie()+mob.getDefense()-(treePerso.get(perso).getAttaque()+treePerso.get(perso).getEpee()));//vie monstre = defense monstre - (attaque perso + epee perso)
                        xp_arme = (int) ceil((((treePerso.get(perso).getAttaque()+treePerso.get(perso).getEpee()))-mob.getDefense())/2);//xp arme = dégat/2
                        if(xp_arme>0){
                            treePerso.get(perso).setXpEpee(xp_arme+treePerso.get(perso).getXpEpee());
                            if(treePerso.get(perso).getXpEpee()>treePerso.get(perso).getXpNecessaireEpee()){//on test si xp de l'arme > xp besoin pour passer de level
                                levelUpArme(treePerso, perso, arme);
                            }
                        }
                    }else{
                        mob.setVie(mob.getVie()+mob.getDefense()-(treePerso.get(perso).getAttaque()));//vie monstre = defense monstre - (attaque perso)
                    }
                    if(mob.getVie()>mob.getVieMax()){
                        mob.setVie(mob.getVieMax());
                    }
                    continuer = true;
                    break;
                case "m" :
                    System.out.println("Vous utilisez attaque magique !");
                    arme_test = new Sceptre();
                    if(arme_test.getArmeUtil().equals(arme.getNomArme())){
                        mob.setVie(mob.getVie()+mob.getDefenseMagique()-(treePerso.get(perso).getAttaqueMagique()+treePerso.get(perso).getSceptre()));
                        xp_arme = (int) ceil((((treePerso.get(perso).getAttaque()+treePerso.get(perso).getSceptre()))-mob.getDefense())/2);//xp arme = dégat/2
                        if(xp_arme>0){
                            treePerso.get(perso).setXpSceptre(xp_arme+treePerso.get(perso).getXpSceptre());
                            if(treePerso.get(perso).getXpSceptre()>treePerso.get(perso).getXpNecessaireSceptre()){//on test si xp de l'arme > xp besoin pour passer de level
                                levelUpArme(treePerso, perso, arme);
                            }
                        }
                    }else{
                        arme_test = new Talisman();
                        if(arme_test.getArmeUtil().equals(arme.getNomArme())){
                            mob.setVie(mob.getVie()+mob.getDefenseMagique()-(treePerso.get(perso).getAttaqueMagique()+treePerso.get(perso).getTalisman()));
                            xp_arme = (int) ceil((((treePerso.get(perso).getAttaque()+treePerso.get(perso).getTalisman()))-mob.getDefense())/2);//xp arme = dégat/2
                            if(xp_arme>0){
                                treePerso.get(perso).setXpTalisman(xp_arme+treePerso.get(perso).getXpTalisman());
                                if(treePerso.get(perso).getXpTalisman()>treePerso.get(perso).getXpNecessaireTalisman()){//on test si xp de l'arme > xp besoin pour passer de level
                                    levelUpArme(treePerso, perso, arme);
                                }
                            }
                        }else{
                            mob.setVie(mob.getVie()+mob.getDefenseMagique()-(treePerso.get(perso).getAttaqueMagique()));
                        }
                    }
                    if(mob.getVie()>mob.getVieMax()){
                        mob.setVie(mob.getVieMax());
                    }
                    continuer = true;
                    break;
                case "s" :
                    test_sort = new SortAttaque();
                    if(treePerso.get(perso).getSort().getSort().equals(test_sort.getSort())){
                        if(treePerso.get(perso).getPmActuel()>=5){
                            System.out.println("Vous lancez un sort d'attaque !");
                            treePerso.get(perso).setPmActuel(treePerso.get(perso).getPmActuel()-5);
                            mob.setVie(mob.getVie()-treePerso.get(perso).getIntelligence());//on attaque directement la vie à l'aide de la puissance magique(intellignece)
                        }else{
                            System.out.println("Pas assez de pm !");
                        }
                        
                    }
                    test_sort = new SortSoin();
                    if(treePerso.get(perso).getSort().getSort().equals(test_sort.getSort())){
                        if(treePerso.get(perso).getPmActuel()>=5){
                            System.out.println("Vous lancez un sort de soin !");
                            treePerso.get(perso).setPmActuel(treePerso.get(perso).getPmActuel()-5);
                            treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getSagesse());//on soigne le perso à l'aide de la puissance de soin (sagesse)
                            if(treePerso.get(perso).getVieAcutelle()>treePerso.get(perso).getVie()){//si la vie actu a dépassée la vie max
                            treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVie());
                        }else{
                            System.out.println("Pas assez de pm !");
                        }
                    }
                    }
                    
                    continuer = true;
                    break;
                case "v" :
                    System.out.println("Vous utilisez une potion de vie !");
                    treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVieAcutelle()+treePerso.get(perso).getPotionVie());
                    treePerso.get(perso).setPotionVie(0);
                    if(treePerso.get(perso).getVieAcutelle()>treePerso.get(perso).getVie()){//si la vie actu a dépassée la vie max
                        treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVie());
                    }
                    continuer = true;
                    break;
                case "p" :
                    System.out.println("Vous utilisez une potion de PM !");
                    treePerso.get(perso).setPmActuel(treePerso.get(perso).getPmActuel()+treePerso.get(perso).getPotionPm());
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
                                continuer2 = true;
                                fuir = true;
                            }else{
                                System.out.println("Vous n'arrivez pas à fuir !");
                                continuer2 = true;
                            }
                        }
                        
                    }
                    continuer = true;
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
     * @param arme : ArmeUtilise : arme utilisée par le perso
     * @param mob : Monstres : monstre contre lequel se bas le perso
     * @return mob : Monstres
    * @since 1.0
    */
    public Monstres combatMob(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme, Monstres mob){
        Random aleat = new Random();
        int nb_aleat;
        
        nb_aleat = Math.abs(aleat.nextInt(11));
        if(nb_aleat <= mob.getProbaAtq()){
            System.out.println("Le monstre lance attaque physique !\n");
            treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVieAcutelle()-mob.getAttaque()+(treePerso.get(perso).getDefense()+treePerso.get(perso).getArmure()));
            if(treePerso.get(perso).getVieAcutelle()>treePerso.get(perso).getVie()){
                treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVie());
            }
        }else{
            if((nb_aleat > mob.getProbaAtq())&&(nb_aleat<11)){
                System.out.println("Le monstre lance attaque magique !\n");
                treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVieAcutelle()-mob.getAttaqueMagique()+(treePerso.get(perso).getDefenseMagique()+treePerso.get(perso).getArmureMagique()));
                if(treePerso.get(perso).getVieAcutelle()>treePerso.get(perso).getVie()){
                treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVie());
            }
            }else{
                System.out.println("Le monstre rate son attaque !\n");
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
            System.out.println("Votre épée monte de niveau !");
            treePerso.get(perso).setXpEpee(treePerso.get(perso).getXpEpee()-treePerso.get(perso).getXpNecessaireEpee());//on remplace l'xp par celui restant lors du passage de level
            treePerso.get(perso).setLevelEpee(treePerso.get(perso).getLevelEpee()+1);//on augmente le niveau
        }
        n_arme = new Sceptre();
        if(n_arme.getArmeUtil().equals(arme.getNomArme()))
        {
            System.out.println("Votre sceptre monte de niveau !");
            treePerso.get(perso).setXpSceptre(treePerso.get(perso).getXpSceptre()-treePerso.get(perso).getXpNecessaireSceptre());//on remplace l'xp par celui restant lors du passage de level
            treePerso.get(perso).setLevelSceptre(treePerso.get(perso).getLevelSceptre()+1);//on augmente le niveau
        }
        n_arme = new Talisman();
        if(n_arme.getArmeUtil().equals(arme.getNomArme()))
        {
            System.out.println("Votre talisman monte de niveau !");
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
        int points;
        treePerso.get(perso).setXp(treePerso.get(perso).getXp()-treePerso.get(perso).getXpNecessaire());//on remplace l'xp par celui restant lors du passage de level
        treePerso.get(perso).setLevel(treePerso.get(perso).getLevel()+1);//on augmente le niveau
        //augmentation des stats suivant les classes
        points = (int) treePerso.get(perso).getPointPassageLevel().get("Vie");
        treePerso.get(perso).setVie(treePerso.get(perso).getVie()+points);//on augmente la vie
        points = (int) treePerso.get(perso).getPointPassageLevel().get("Pm");
        treePerso.get(perso).setPm(treePerso.get(perso).getPm()+points);//on augmente les pm
        points = (int) treePerso.get(perso).getPointPassageLevel().get("Attaque");
        treePerso.get(perso).setAttaque(treePerso.get(perso).getAttaque()+points);//on augmente l'attaque
        points = (int) treePerso.get(perso).getPointPassageLevel().get("AttaqueMagique");
        treePerso.get(perso).setAttaqueMagique(treePerso.get(perso).getAttaqueMagique()+points);//on augmente l'attaque magique
        points = (int) treePerso.get(perso).getPointPassageLevel().get("Defense");
        treePerso.get(perso).setDefense(treePerso.get(perso).getDefense()+points);//on augmente la defense
        points = (int) treePerso.get(perso).getPointPassageLevel().get("DefenseMagique");
        treePerso.get(perso).setDefenseMagique(treePerso.get(perso).getDefenseMagique()+points);//on augmente la defense magique
        points = (int) treePerso.get(perso).getPointPassageLevel().get("Agilite");
        treePerso.get(perso).setAgilite(treePerso.get(perso).getAgilite()+points);//on augmente l'agilite
        points = (int) treePerso.get(perso).getPointPassageLevel().get("Intelligence");
        treePerso.get(perso).setIntelligence(treePerso.get(perso).getIntelligence()+points);//on augmente l'intelligence
        points = (int) treePerso.get(perso).getPointPassageLevel().get("Sagesse");
        treePerso.get(perso).setSagesse(treePerso.get(perso).getSagesse()+points);//on augmente la sagesse
        
        pointsCaractéristiques(treePerso, perso);
        
        //remise de la vie au max
        treePerso.get(perso).setVieAcutelle(treePerso.get(perso).getVie());
        
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
        System.out.println("e : defense");
        System.out.println("f : defense magique");
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
                case "e" :
                    System.out.println("Defense augmentée !");
                    treePerso.get(perso).setDefense(treePerso.get(perso).getDefense()+1);
                    nb_points--;
                    break;
                case "f" :
                    System.out.println("Defense magique augmentée !");
                    treePerso.get(perso).setDefenseMagique(treePerso.get(perso).getDefenseMagique()+1);
                    nb_points--;
                    break;
                default :
                    System.out.println("Vous n'avez pas cette caractéristique...");
            }
        }
    }
    
    /**
    *<p>Cette fonction sert à augmenter l'xp et l'argent du perso lorsqu'il
    * a vaincu le monstre.</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @param mob : Monstres : monstre vaincu
    * @since 1.0
    */
    public void monstreVaincu(TreeMap<String,Personnage> treePerso, String perso, Monstres mob){
        treePerso.get(perso).setXp(treePerso.get(perso).getXp()+mob.getXp());//on augmente l'xp du perso avec celui donné par le monstre
        treePerso.get(perso).setArgent(treePerso.get(perso).getArgent()+mob.getOr());//on augmente l'or du perso avec celui donné par le monstre
    }
    
    /**
    *<p>Cette fonction détermine si le perso trouve un item (ainsi que sa valeur)
    * en arrivant dans un endroit.</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @throws java.io.IOException : lecture de buffer
    * @since 1.0
    */
    public void fouilles(TreeMap<String,Personnage> treePerso, String perso) throws IOException{
        BufferedReader buff = new BufferedReader(
                                    new InputStreamReader(System.in));
        Random trouve = new Random();
        Random item = new Random();
        Random alea_val_item = new Random();
        int type_item;
        int val_item;
        String choix;
        boolean continuer = false;
        
        if(Math.abs(trouve.nextInt(1))==0){
            //objet trouvé
            type_item = Math.abs(trouve.nextInt(50));
            if(type_item==0){
                System.out.println("Vous trouvez une potion d'xp !");
                System.out.println("Vous montez de niveau !");
                treePerso.get(perso).setXp(treePerso.get(perso).getXpNecessaire());
                levelUp(treePerso, perso);
            } else {
                type_item = Math.abs(trouve.nextInt(6));
                val_item = Math.abs(alea_val_item.nextInt(treePerso.get(perso).getLevel()*10))%(treePerso.get(perso).getLevel()*5);
                switch(type_item){
                    case 0 :
                        System.out.println("Vous trouvez une épee de puissance "+val_item+" !");
                        System.out.println("Voulez vous la garder ?");
                        System.out.println("o : oui");
                        System.out.println("n : non");
                        while(!continuer){
                            choix = buff.readLine();
                            switch(choix){
                                case "o" :
                                    System.out.println("Vous prenez l'épée.");
                                    treePerso.get(perso).setEpee(val_item);
                                    break;
                                case "n" :
                                    System.out.println("Vous la laissez là...");
                                    break;
                                default :
                                    System.out.println("Arrêtez d'hesiter et choisissez !");
                            }
                            continuer = true;
                        }
                    break;
                    case 1 :
                        System.out.println("Vous trouvez un sceptre de puissance "+val_item+" !");
                        System.out.println("Voulez vous le garder ?");
                        System.out.println("o : oui");
                        System.out.println("n : non");
                        while(!continuer){
                            choix = buff.readLine();
                            switch(choix){
                                case "o" :
                                    System.out.println("Vous prenez le sceptre.");
                                    treePerso.get(perso).setSceptre(val_item);
                                    break;
                                case "n" :
                                    System.out.println("Vous le laissez là...");
                                    break;
                                default :
                                    System.out.println("Arrêtez d'hesiter et choisissez !");
                            }
                            continuer = true;
                        }
                    break;
                    case 2 :
                        System.out.println("Vous trouvez un talisman de puissance "+val_item+" !");
                        System.out.println("Voulez vous le garder ?");
                        System.out.println("o : oui");
                        System.out.println("n : non");
                        while(!continuer){
                            choix = buff.readLine();
                            switch(choix){
                                case "o" :
                                    System.out.println("Vous prenez le talisman.");
                                    treePerso.get(perso).setTalisman(val_item);
                                    break;
                                case "n" :
                                    System.out.println("Vous le laissez là...");
                                    break;
                                default :
                                    System.out.println("Arrêtez d'hesiter et choisissez !");
                            }
                            continuer = true;
                        }
                    break;  
                    case 3 :
                        System.out.println("Vous trouvez une potion de vie de puissance "+val_item+" !");
                        System.out.println("Voulez vous la garder ?");
                        System.out.println("o : oui");
                        System.out.println("n : non");
                        while(!continuer){
                            choix = buff.readLine();
                            switch(choix){
                                case "o" :
                                    System.out.println("Vous prenez la potion de vie.");
                                    treePerso.get(perso).setPotionVie(val_item);
                                    break;
                                case "n" :
                                    System.out.println("Vous la laissez là...");
                                    break;
                                default :
                                    System.out.println("Arrêtez d'hesiter et choisissez !");
                            }
                            continuer = true;
                        }
                    break;
                    case 4 :
                        System.out.println("Vous trouvez une potion de pm de puissance "+val_item+" !");
                        System.out.println("Voulez vous la garder ?");
                        System.out.println("o : oui");
                        System.out.println("n : non");
                        while(!continuer){
                            choix = buff.readLine();
                            switch(choix){
                                case "o" :
                                    System.out.println("Vous prenez la potion de pm.");
                                    treePerso.get(perso).setPotionPM(val_item);
                                    break;
                                case "n" :
                                    System.out.println("Vous la laissez là...");
                                    break;
                                default :
                                    System.out.println("Arrêtez d'hesiter et choisissez !");
                            }
                            continuer = true;
                        }
                    break;
                    case 5 :
                        System.out.println("Vous trouvez une armure de puissance "+val_item+" !");
                        System.out.println("Voulez vous la garder ?");
                        System.out.println("o : oui");
                        System.out.println("n : non");
                        while(!continuer){
                            choix = buff.readLine();
                            switch(choix){
                                case "o" :
                                    System.out.println("Vous prenez l'armure.");
                                    treePerso.get(perso).setArmure(val_item);
                                    break;
                                case "n" :
                                    System.out.println("Vous la laissez là...");
                                    break;
                                default :
                                    System.out.println("Arrêtez d'hesiter et choisissez !");
                            }
                            continuer = true;
                        }
                    break;
                    default :
                        System.out.println("Vous trouvez une armure magique de puissance "+val_item+" !");
                        System.out.println("Voulez vous la garder ?");
                        System.out.println("o : oui");
                        System.out.println("n : non");
                        while(!continuer){
                            choix = buff.readLine();
                            switch(choix){
                                case "o" :
                                    System.out.println("Vous prenez l'armure magique.");
                                    treePerso.get(perso).setArmureMagique(val_item);
                                    break;
                                case "n" :
                                    System.out.println("Vous la laissez là...");
                                    break;
                                default :
                                    System.out.println("Arrêtez d'hesiter et choisissez !");
                            }
                            continuer = true;
                        }
                    break;
                }
            }
        }else{
            System.out.println("Vous n'avez rien trouvé...");
        }
    }
    
    
}