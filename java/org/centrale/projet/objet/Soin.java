/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de soin
 * @author lmalix
 */
public class Soin extends Potion {
    
    /**
     * Les points de vie à ajouter
     */
    public int ptVie;
    
    /**
     * Constructeur de soin
     */
    public Soin() {
        super();
        this.ptVie = 10;
    }
    
    /**
     * Constructeur de soin
     * @param pos la position
     * @param ptVie les points de vie
     */
    public Soin(Point2D pos, int ptVie) {
        super("soin", pos);
        this.ptVie = ptVie;

    }
    
    /**
     * getter des pts de vie
     * @return pts de vie
     */
    public int getPtVie() {
        return ptVie;
    }
    
    /**
     * setter des pts de vie
     * @param ptVie pts de vie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }
    
    /**
     * appliquer l'effet sur un personnage
     * @param personnage un personnage
     */
    @Override
    public void applyEffect(Personnage personnage) {
        personnage.setPtVie(personnage.getPtVie() + this.ptVie);
        System.out.println(personnage.getNom() + " took Soin");
    }
    
    /**
     * Générer le texte de sauvegarde
     * @return le texte de sauvegarde
     */
    @Override
    public String getTexteSauvegarde() {
        String texte = "Soin " + getPtVie() + " "+ getPos().getX() + " "+ getPos().getY();
        return texte;
    }

}
