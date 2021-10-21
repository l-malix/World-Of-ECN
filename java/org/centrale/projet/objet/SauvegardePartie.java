/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe de sauvegarde de la partie
 * @author lmalix
 */
public class SauvegardePartie {
    /**
     * Le nom de fichier
     */
    private String filepath;
    
    /**
     * le BufferedWriter
     */
    private BufferedWriter writer;
    
    /**
     * Constructeur
     * @param filepath le nom de fichier
     */
    public SauvegardePartie(String filepath) {
    try {
        int i = 0;
        File f = new File(filepath);
        while (f.exists()) {
            f = new File(filepath.split(".txt")[0] + (i++) + ".txt");
        }
    this.filepath = f.getAbsolutePath();
    this.writer = new BufferedWriter(new FileWriter(f.getAbsolutePath()));
    } catch (IOException e) {
        System.out.println(e.getMessage());
        }
    }
    
    /**
     * Ecrire une ligne
     * @param ligne la ligne
     */
    public void ecrireLigne(String ligne) {
        try {
        this.writer.write(ligne + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Sauvegarder une partie en cours du monde
     * @param world le monde
     */
    public void sauvegarderPartie(World world) {
        this.ecrireLigne("Largeur " + world.largeur);
        this.ecrireLigne("Hauteur " + world.hauteur);
        this.ecrireLigne("Joueur " + world.joueur.personnage.getTexteSauvegarde());
        for (Creature c : world.listCreature) {
            this.ecrireLigne(c.getTexteSauvegarde());
        }
        for (Potion p : world.listPotions) {
            this.ecrireLigne(p.getTexteSauvegarde());
        }
        for (NuageToxique nt : world.listNuageToxiques) {
            this.ecrireLigne(nt.getTexteSauvegarde());
        }
        for (Nourriture n : world.listNourritures) {
            this.ecrireLigne(n.getTexteSauvegarde());
        }
        try {
            this.writer.flush();
            this.writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
