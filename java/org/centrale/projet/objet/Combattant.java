/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Interface de combattant
 * @author lmalix
 */
public interface Combattant {
    
    /**
     * Permet de combattre un defendeur
     * @param defendeur la créature défendeur
     */
    public abstract void combattre(Creature defendeur);
}
