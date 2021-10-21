package org.centrale.projet.objet;

import java.util.Random;

/**
 * <b> Archer est la classe représentatnt un personnage Archer dans le jeu</b>
 * <p>
 * Un Archer est caractérisé par les attributs d'un personnage
 * <ul>
 * <li>Le nom du paysan</li>
 * <li>Les caractéristiques d'attaque et de vie</li>
 * <li>La position</li>
 * </ul>
 *
 * @author lmalix
 */
public class Archer extends Personnage implements Combattant {

    /**
     * Le nombre des fleches possédées
     */
    private int nbFleches;

    /**
     * Constructeur Archer Initialisation par la super classe
     *
     * @see Personnage#Personnage()
     */
    public Archer() {
        super();
        this.setNom("Archer");
        this.setPtVie(120);
        this.setPtMana(5);
        this.setPourcentageAtt(100);
        this.setPourcentagePar(10);
        this.setPourcentageMag(50);
        this.setPourcentageResisMag(50);
        this.setDegAtt(33);
        this.setDegMag(20);
        this.setDistAttMax(4);
        this.setPos(new Point2D());
        this.nbFleches = 10;
    }

    /**
     * Constructeur Archer Initialisation par la super classe
     * @param nom Le nom de l'archer
     * @param ptVie Les points de vie
     * @param ptMana les points de Mana
     * @param pourcentageAtt le pourcentage d'attaque
     * @param pourcentagePar le pourcentage de parade
     * @param pourcentageMag le pourcentage de magie
     * @param pourcentageResisMag le pourcentage de resistance de magie
     * @param degAtt degats d'attaque
     * @param degMag degats de magie
     * @param distAttMax distance maximale d'attaque
     * @param ptParade points de parade
     * @param pos la position
     * @param nbFleches le nombre de fleches
     */
    public Archer(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResisMag, int degAtt, int degMag, int distAttMax, int ptParade, Point2D pos, int nbFleches) {
        super(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResisMag, degAtt, degMag, distAttMax, ptParade, pos);
        this.nbFleches = nbFleches;
    }

    /**
     * Constructeur Archer Initialisation par la super classe
     *
     * @see Personnage#Personnage(Personnage personnage)
     * @param archer un archer
     */
    public Archer(Archer archer) {
        super(archer);
        setNom("Archer");
        this.nbFleches = archer.nbFleches;
    }

    /**
     * tirer le nomre de projetiles possédés
     *
     * @return le nombre de projectiles
     */
    public int getProjectiles() {
        return nbFleches;
    }

    /**
     * changer le nombre de projectiles
     *
     * @param nbFleches nombre de projectiles
     */
    public void setProjectiles(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     * Affichage des information de l'archer
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.println("nbFleches :" + getProjectiles());
    }

    /**
     * permet de l'Archer de lancer une attaque sur une autre créature
     *
     * @param defendeur La créature attaquée
     */
    @Override
    public void combattre(Creature defendeur) {

        float distance = this.getPos().distance(defendeur.getPos());

        /*
        Attaque à distance
         */
        if (distance > 1 && distance < this.getDistAttMax()) {
            setProjectiles(nbFleches-1);
            Random jet = new Random();
            int Rand = jet.nextInt(100);

            if (Rand > this.getPourcentageAtt()) {
                this.setProjectiles(nbFleches - 1);
                System.out.println("-- Attaque ratée ****************************\n");

            } else {
                this.setProjectiles(nbFleches - 1);
                System.out.println("-- Attaque à distance ************************");
                int ptVieBefore = defendeur.getPtVie();
                defendeur.setPtVie(defendeur.getPtVie() - this.getDegAtt());
                System.out.println(this.getNom() + " Attacked " + defendeur.getNom());
                System.out.println(defendeur.getNom() + ": Pt Vie :" + ptVieBefore + " --> " + defendeur.getPtVie() + "\n");

            }
        } else {
            System.out.println("-- problème de distance **************************** \n");
        }
    }
    
    @Override
    public String getTexteSauvegarde() {
        String texte = "Archer " + getNom() + " " + getPtVie() + " " + getPtMana() + " " + 
                " " + getPourcentageAtt() + " " + getPourcentagePar() + " " + getPourcentageMag() +
                " " + getPourcentageResisMag() + " " + getDegAtt() + " " + getDegMag() + 
                " " + getDistAttMax() + " " + getPtParade() + " " + getPos().getX() + " "+ getPos().getY();
        return texte;
    }
}
