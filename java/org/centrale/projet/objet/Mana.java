/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de Mana
 * @author lmalix
 */
public class Mana extends Potion {
    
    /**
     * Les pointd de mlana à ajouter
     */
    public int ptMana;
    
    /**
     * Constructeur de mana
     */
    public Mana() {
        super();
        this.ptMana = 10;
    }
    
    /**
     * Constructeur de mana
     * @param pos position de mana
     * @param ptMana points de mana à ajouter
     */
    public Mana(Point2D pos, int ptMana) {
        super("mana", pos);
        this.ptMana = ptMana;
    }
    
    /**
     * getter des points de mana
     * @return les points de mana
     */
    public int getPtMana() {
        return ptMana;
    }
    
    /**
     * setter des points de mana
     * @param ptMana points de mana
     */
    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }
    
    /**
     * Appliquer l'effet de mana sur un personnage
     * @param personnage le personnage concerné
     */
    @Override
    public void applyEffect(Personnage personnage) {
        personnage.setPtMana(personnage.getPtMana() + this.ptMana);
        System.out.println(personnage.getNom() + " took Mana");
    }
    
    /**
     * Générer le texte de sauvegarde
     * @return le texte de sauvegarde
     */
    @Override
    public String getTexteSauvegarde() {
        String texte = "Mana " + getPtMana() + " "+ getPos().getX() + " "+ getPos().getY();
        return texte;
    }
    

}
