package org.centrale.projet.objet;

import java.util.ArrayList;

/**
 * <b> Pesonnage est la classe représentatnt un personnage dans le jeu</b>
 * <p>
 * Un Personnage est caractérisé par les attributs suivantes
 * <ul>
 * <li>Le nom du personnage</li>
 * <li>Les caractéristiques d'attaque et de vie</li>
 * <li>La position</li>
 * </ul>
 *
 * @author lmalix
 */
public abstract class Personnage extends Creature {
    /**
     * points de mana
     */
    private int ptMana;
    /**
     * % de magie
     */
    private int pourcentageMag;
    /**
     * % de resistance de magie
     */
    private int pourcentageResisMag;
    /**
     * degats de magie
     */
    private int degMag;
    /**
     * distance maximale d'attaque
     */
    private int distAttMax;
    /**
     * liste des nourritures ramassées
     */
    public ArrayList<Nourriture> listNourritures;

    /**
     * Constructeur Personnage
     * <b> Construction d'un personnage avec toutes les caractéristiques à 0</b>
     */
    public Personnage() {
        super();
        super.setNom("Personnage");
        listNourritures = new ArrayList<>();
    }

    /**
     * Constructeur Personnage
     * <b> Construction d'un personnage avec les paramétres suivantes:</b>
     *
     * @param nom Le nom
     * @param ptVie Les points de vie
     * @param ptMana les points de Mana
     * @param pourcentageAtt le pourcentage d'attaque
     * @param pourcentagePar le pourcentage de parade
     * @param pourcentageMag le pourcentage de magie
     * @param pourcentageResisMag le pourcentage de resistance de magie
     * @param degAtt degats d'attaque
     * @param degMag degats de magie
     * @param distAttMax distance maximale d'attaque
     * @param ptParade ptParade
     * @param pos la position
     */
    public Personnage(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResisMag, int degAtt, int degMag, int distAttMax, int ptParade, Point2D pos) {
        super(nom, ptVie, pourcentageAtt, pourcentagePar, degAtt, ptParade ,pos);
        this.ptMana = ptMana;
        this.pourcentageMag = pourcentageMag;
        this.pourcentageResisMag = pourcentageResisMag;
        this.degMag = degMag;
        this.distAttMax = distAttMax;
        listNourritures = new ArrayList<>();
    }

    /**
     * Constructeur Personnage Construction d'un personnage avec les
     * caractéristiques d'un autre personnage
     *
     * @param personnage un Personnage
     */
    public Personnage(Personnage personnage) {
        super(personnage);
        this.ptMana = personnage.ptMana;
        this.pourcentageMag = personnage.pourcentageMag;
        this.pourcentageResisMag = personnage.pourcentageResisMag;
        this.degMag = personnage.degMag;
        this.distAttMax = personnage.distAttMax;
        listNourritures = new ArrayList<>();
    }
    
    /**
     * getter des points de mana
     * @return points de mana
     */
    public int getPtMana() {
        return ptMana;
    }
    
    /**
     * getter de % de magie
     * @return pourcentageMag
     */
    public int getPourcentageMag() {
        return pourcentageMag;
    }
    
    /**
     * getter de % de resistance à la magie
     * @return pourcentageResisMag
     */
    public int getPourcentageResisMag() {
        return pourcentageResisMag;
    }
    
    /**
     * getter de degats de magie
     * @return degats de magie
     */
    public int getDegMag() {
        return degMag;
    }
    
    /**
     * getter de la distance maximale
     * @return distance d'attaque max
     */
    public int getDistAttMax() {
        return distAttMax;
    }
    
    /**
     * setter de points de mana
     * @param ptMana points de mana 
     */
    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }
    
    /**
     * setter de % de magie
     * @param pourcentageMag % de magie
     */
    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }
    
    /**
     * setter de % de resistance de magie
     * @param pourcentageResisMag % de resistance de magie
     */
    public void setPourcentageResisMag(int pourcentageResisMag) {
        this.pourcentageResisMag = pourcentageResisMag;
    }
    
    /**
     * setter de degats de magie
     * @param degMag degats de magie
     */
    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }
    
    /**
     * setter de distance d'attaque maximale
     * @param distAttMax distance d'attaque maximale
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }
    
    /**
     * Permet de rammasser une nourriture
     * @param nourriture la nourriture à ramasser
     */
    void takeNourriture(Nourriture nourriture) {
        listNourritures.add(nourriture);
        this.setDegAtt(this.getDegAtt() + nourriture.getBonusMalus());
        System.out.println(getNom() + " got " + nourriture.getBonusMalus() + " degAtt points");
    }
    
    /**
     * mise à jour de la liste de nourritures
     */
    void updateNourritureList() {
        ArrayList<Nourriture> updatedList = new ArrayList<>();
        for (Nourriture nt : listNourritures) {
            nt.setPersistTime(nt.getPersistTime() - 1);
            if (nt.getPersistTime() >= 0) {
                updatedList.add(nt);
            } else {
                setDegAtt(getDegAtt() - nt.getBonusMalus());
            }
        }
        listNourritures = new ArrayList<>(updatedList);
    }
    
    /**
     * Version textuelle
     * @return texte de description
     */
    @Override
    public String toString() {
        return  "-----------------------------------------------------\n"
                + "Nom                 : " + getNom() + "\n"
                + "ptVie               : " + getPtVie() + "\n"
                + "ptMana              : " + getPtMana() + "\n"
                + "pourcentageAtt      : " + getPourcentageAtt() + "\n"
                + "pourcentagePar      : " + getPourcentagePar() + "\n"
                + "pourcentageMag      : " + getPourcentageMag() + "\n"
                + "pourcentageResisMag : " + getPourcentageResisMag() + "\n"
                + "degAtt              : " + getDegAtt() + "\n"
                + "degMag              : " + getDegMag() + "\n"
                + "distAttMax          : " + getDistAttMax() + "\n"
                + "ptParade            : " + getPtParade() + "\n"
                + "Position            : " + getPos().toString() + "\n"
                + "Liste de NT         : " + listNourritures;

    }

}
