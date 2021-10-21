/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de potion
 * @author lmalix
 */
public class Potion extends Objet {
    
    /**
     * le nom de potion
     */
    public String nom;
    
    /**
     * constructeur de Potion
     */
    public Potion() {
        this.nom = "Potion";
        this.pos = new Point2D();
    }
    
    /**
     * Constructeur de potion
     * @param nom nom 
     * @param pos position
     */
    public Potion(String nom, Point2D pos) {
        super(pos);
        this.nom = nom;
    }
    
    /**
     * getter du nom
     * @return me nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * setter du nom
     * @param nom le nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * applique l'effet de la potion sur un personnage
     * @param personnage le personnage
     */
    @Override
    public void applyEffect(Personnage personnage) {
    }

}
