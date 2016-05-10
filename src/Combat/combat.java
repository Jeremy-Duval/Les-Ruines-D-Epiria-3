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
import armes.ArmeUtilise;
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
public class combat {
    
    //**************************************************************************
    //constructeurs
    //**************************************************************************
    /**
    *<p><Strong>Ce constructeur ne fait rien.</Strong></p>
    *@author Jérémy Duval
    *@since 1.0
    */
    public combat(){};
    
    //**************************************************************************
    //fonctions
    //**************************************************************************
    public void menuCombat(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme, Lieu lieu){
        Random aleat = new Random();
        Monstres mob;
        boolean debut_combat = true;
        List liste = new ArrayList();
        
        if(Math.abs(aleat.nextInt(9))<=8){
            mob = determineMonstre(lieu);
            while((mob.getVie()>0)||(treePerso.get(perso).getVieAcutelle()>0)){//tant que le perso ou le monstre a de la vie
                if((debut_combat==false)||((debut_combat)&&(mob.getAgilite()<treePerso.get(perso).getAgilite()))){//si l'agilité du monstre est > à celle du perso et que l'on est au premier tour, on saute le tour du perso (monstre commence)
                    debut_combat = false;
                    liste = combatPerso(treePerso, perso, arme, mob);
                    treePerso = (TreeMap<String, Personnage>) liste.get(0);
                    mob = (Monstres) liste.get(1);
                    
                }else{
                    if(mob.getVie()>0){//si le monstre est vaincu, on saute son tour afin de terminer le while
                        debut_combat = false;
                        liste = combatMob(treePerso, perso, arme, mob);
                        treePerso = (TreeMap<String, Personnage>) liste.get(0);
                        mob = (Monstres) liste.get(1);
                    } 
                }
            }
            //Reste à gérer si perso vaincu
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
    * personnage durant le combat.</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @param arme : arme utilisée par le perso
     * @param mob : monstre contre lequel se bas le perso
     * @return List : <ul><li>treePerso : TreeMap (String,Personnage)</li>
    *                     <li>mob : Monstres </li></ul>
    * @since 1.0
    */
    public List combatPerso(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme, Monstres mob){
        List liste = new ArrayList();
        //a faire
        
        liste.add(0, treePerso);
        liste.add(1, mob);
        return liste;
    }
    
    /**
    *<p>Cette fonction représente le tour du monstre pendant le combat.</p>
    * @author Jérémy Duval
     * @param treePerso : TreeMap (String,Personnage) : tout les objets personnages
     * @param perso : String : classe du personnage
     * @param arme : arme utilisée par le perso
     * @param mob : monstre contre lequel se bas le perso
     * @return List : <ul><li>treePerso : TreeMap (String,Personnage)</li>
    *                     <li>mob : Monstres </li></ul>
    * @since 1.0
    */
    public List combatMob(TreeMap<String,Personnage> treePerso, String perso, ArmeUtilise arme, Monstres mob){
        List liste = new ArrayList();
        //a faire
        
        liste.add(0, treePerso);
        liste.add(1, mob);
        return liste;
    }
}
