/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe de nourriture
 * @author lmalix
 */
public class Nourriture extends Objet {
    
    /**
     * Les points de bonus ou malus sur le degAtt
     */
    private int bonusMalus;
    
    /**
     * Temps de persistance
     */
    private int persistTime;
    
    /**
     * Constructeur de nourriture
     */
    public Nourriture() {
        Random rand = new Random();
        int chance = rand.nextInt(100);
        if (chance < 50) {
            bonusMalus = 10;
        } else {
            bonusMalus = -10;
        }

        persistTime = 3;
    }
    
    /**
     * Constructeur de nourriture
     * @param bonusMalus les points 
     * @param persistTime le temps
     * @param pos la position
     */
    public Nourriture(int bonusMalus, int persistTime, Point2D pos) {
        this.bonusMalus = bonusMalus;
        this.persistTime = persistTime;
        this.pos = pos;
    }
    
    /**
     * getter de temps de persistence
     * @return temps de persistence
     */
    public int getPersistTime() {
        return persistTime;
    }
    
    /**
     * setter de temps de persistence
     * @param persistTime temps de pers
     */
    public void setPersistTime(int persistTime) {
        this.persistTime = persistTime;
    }
    
    /**
     * getter des points
     * @return les points
     */
    public int getBonusMalus() {
        return bonusMalus;
    }
    
    /**
     * setter des points
     * @param bonusMalus les points
     */
    public void setBonusMalus(int bonusMalus) {
        this.bonusMalus = bonusMalus;
    }
    
    /**
     * Représentation textuelle
     * @return texte
     */
    @Override
    public String toString() {
        return "giving : " + getBonusMalus() + " for : " + getPersistTime() + " rounds";
    }
    
    /**
     * Texte de sauvegarde
     * @return le texte de sauvegarde
     */
    @Override
    public String getTexteSauvegarde() {
        String texte = "Nourriture " + getBonusMalus() + " " + getPersistTime() + " "+ getPos().getX() + " "+ getPos().getY();
        return texte;
    }

}
