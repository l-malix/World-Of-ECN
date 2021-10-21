/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Interface deplacable
 * 
 * @author lmalix
 */
public interface Deplacable {
    
    /**
     * deplacer un élément par un mouvement
     * @param move le mouvement
     */
    public abstract void deplace(int[] move);
}
