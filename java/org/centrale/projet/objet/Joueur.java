/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Classe représentant un joueur humain
 * 
 * @author lmalix
 */
public class Joueur {
    
    /**
     * Personnage correspondant au joueur
     */
    public Personnage personnage;
    
    /**
     * Le constructeur de jouaur
     */
    public Joueur() {
        personnage = null;
    }
    
    /**
     * Choisir le type de personnage et son nom
     */
    public void creeJoueur() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Set<String> personnages = Set.of("Archer", "Guerrier", "Paysan", "Mage");
        System.out.println("Choisir parmi les personnages : " + personnages);
        String typeDePersonnage = scanner.nextLine();

        while (true) {
            if (personnages.contains(typeDePersonnage)) {
                break;
            }
            System.out.println("Choisir parmi les personnages existants");
            typeDePersonnage = scanner.nextLine();
        }

        if (typeDePersonnage.equals("Archer")) {
            personnage = new Archer();
            System.out.println("Tapez votre surnom :");
            personnage.setNom(scanner.nextLine());
        } else if (typeDePersonnage.equals("Guerrier")) {
            personnage = new Guerrier();
            System.out.println("Tapez votre surnom :");
            personnage.setNom(scanner.nextLine());
        }
        if (typeDePersonnage.equals("Mage")) {
            personnage = new Mage();
            System.out.println("Tapez votre surnom :");
            personnage.setNom(scanner.nextLine());
        }
        if (typeDePersonnage.equals("Paysan")) {
            personnage = new Paysan();
            System.out.println("Tapez votre surnom :");
            personnage.setNom(scanner.nextLine());
        }

    }
    
    /**
     * Texte de déplacement
     */
    
    public final String CONTROLLER =  "         Q\n" +
                                "       _____\n" +
                                "   W  |     | A\n" +
                                "   ___| /|  |___ \n" +
                                "  |      |      |\n" +
                                "S | <---   ---> | Z\n" +
                                "  |___   |   ___|\n" +
                                "      |  |/ |\n" +
                                "   X  |_____| E\n" +
                                "         D";
    
    /**
     * Permettre de choisir un mouvement par une lettre
     * @return le mouvement choisi
     */
    public int[] move() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choisir un déplacement");
        System.out.println(CONTROLLER);
        String move = scanner.nextLine();
        int[] mv = {0, 0};
        switch (move) {
            case "Z" ->
                mv = Point2D.FORWARD;
            case "A" ->
                mv = Point2D.FORLEFT;
            case "Q" ->
                mv = Point2D.LEFT;
            case "W" ->
                mv = Point2D.BACKLEFT;
            case "S" ->
                mv = Point2D.BACKWARD;
            case "X" ->
                mv = Point2D.BACKRIGHT;
            case "D" ->
                mv = Point2D.RIGHT;
            case "E" ->
                mv = Point2D.FORRIGHT;
            default ->
                System.out.println("Incompatible commande");
        }
        return mv;
    }
    
    
    
    /**
     * Permettre le joueur à attaquer une créature
     * @param creature une créature à attaquer
     */
    public void attaquer(Creature creature) {
        if (this.personnage instanceof Archer) {
            Archer archer = new Archer((Archer) personnage);
            archer.combattre(creature);
        } else if (this.personnage instanceof Guerrier) {
            Guerrier guerrier = new Guerrier((Guerrier) personnage);
            guerrier.combattre(creature);
        } else if (this.personnage instanceof Mage) {
            Mage mage = new Mage((Mage) personnage);
            mage.combattre(creature);
        } else {
            System.out.println("I can't attack, I'm just a citizen");
        }
    }
}
