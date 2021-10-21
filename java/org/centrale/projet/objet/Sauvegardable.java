/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Interface pour les types sauvegardables
 * @author lmalix
 */
public interface Sauvegardable {
    
    /**
     * générer le texte dauvegardable
     * @return texte sauvegardable
     */
    public abstract String getTexteSauvegarde();
}
