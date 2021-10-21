/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * <b> Creature est la classe représentatnt un créature dans le jeu, les
 * créatures dans le jeux seront de deux types : Personnage et Archer
 * </b>
 * <p>
 * Une créature est caractérisé par les attributs suivantes
 * <ul>
 * <li>Le nom de créature</li>
 * <li>Les caractéristiques d'attaque et de vie</li>
 * <li>La position</li>
 * </ul>
 *
 * @author lmalix
 */
public abstract class Creature extends ElementDeJeu implements Deplacable, Sauvegardable{

    /**
     * nom
     */
    private String nom;
    /**
     * points de vie
     */
    private int ptVie;
    /**
     * pourcentage d'attaque
     */
    private int pourcentageAtt;

    /**
     * pourcentage de parade
     */
    private int pourcentagePar;

    /**
     * degats d'attaque
     */
    private int degAtt;
    
    /**
     * Points de parade
     */
    private int ptParade;

    /**
     * position
     */
    private Point2D pos;

    /**
     * Constructeur Creature initialiser une créature avec des 0
     */
    public Creature() {
        this.nom = "Créature";
        this.ptVie = 0;
        this.pourcentageAtt = 0;
        this.pourcentagePar = 0;
        this.degAtt = 0;
        this.ptParade = 0;
        this.pos = new Point2D();
    }

    /**
     * Conctructeur Creature Initialiser une créature avec des valeurs initiales
     *
     * @param nom nom
     * @param ptVie points de vie
     * @param pourcentageAtt pourcentage d'attaque
     * @param pourcentagePar pourcentage de parade
     * @param degAtt pourcentage d'attaque
     * @param ptParade points de parade
     * @param pos la position
     */
    public Creature(String nom, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptParade, Point2D pos) {
        this.nom = nom;
        this.ptVie = ptVie;
        this.pourcentageAtt = pourcentageAtt;
        this.pourcentagePar = pourcentagePar;
        this.degAtt = degAtt;
        this.ptParade = ptParade;
        this.pos = pos;
    }

    /**
     * Conctructeur Creature Initialiser une créature avec les valeurs d'une
     * autre céature
     *
     * @param creature une créature
     */
    public Creature(Creature creature) {
        this.nom = creature.nom;
        this.ptVie = creature.ptVie;
        this.pourcentageAtt = creature.pourcentageAtt;
        this.pourcentagePar = creature.pourcentagePar;
        this.degAtt = creature.degAtt;
        this.ptParade = creature.ptParade;
        this.pos = creature.pos;
    }
    
    /**
     * getter pour le nom
     * @return le nom
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * geter des points de vie
     * @return les points de vie
     */
    public int getPtVie() {
        return ptVie;
    }
    
    /**
     * getter de % d'attaque
     * @return % d'attaque
     */
    public int getPourcentageAtt() {
        return pourcentageAtt;
    }
    
    /**
     * getter de % de parade
     * @return % de parade
     */
    public int getPourcentagePar() {
        return pourcentagePar;
    }
    
    /**
     * getter de degats d'attaque
     * @return degats d'attaque
     */
    public int getDegAtt() {
        return degAtt;
    }
    
    /**
     * getter de position
     * @return position
     */
    public Point2D getPos() {
        return pos;
    }
    
    /**
     * setter du nom
     * @param nom le nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * setter de points de vie
     * @param ptVie points de vie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }
    
    /**
     * setter de % d'attaque
     * @param pourcentageAtt % d'attaque
     */
    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }
    
    /**
     * setter de % d'attaque
     * @param pourcentagePar % d'attaque
     */
    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }
    
    /**
     * setter de degats d'attaque
     * @param degAtt degats d'attaque
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
    
    /**
     * setter de position
     * @param pos la position
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * getter de points de parade
     * @return points de parade
     */
    public int getPtParade() {
        return ptParade;
    }
    
    /**
     * setter de points de parade
     * @param ptParade points de parade
     */
    public void setPtParade(int ptParade) {
        this.ptParade = ptParade;
    }
    
    
    /**
     * Déplacer la creature avec un pas
     *
     * @param move Le pas de déplacement
     */
    @Override
    public void deplace(int[] move) {
        this.pos.translate(move[0], move[1]);
    }
    
    /**
     * créer le texte d'affichage
     * @return le texte d'affichage
     */
    @Override
    public String toString() {
        return "Nom : " + getNom() + "\n"
                + "Position : " + pos.toString();
    }

    /**
     * L'affichage de la créature
     */
    public void affiche() {
        System.out.println(this);
    }

}
