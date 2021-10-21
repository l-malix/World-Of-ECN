package org.centrale.projet.objet;

import java.util.Random;

/**
 * <b> Mage est la classe représentatnt un personnage Mage dans le jeu</b>
 * <p>
 * Un Mage est caractérisé par les attributs d'un personnage
 * <ul>
 * <li>Le nom du paysan</li>
 * <li>Les caractéristiques d'attaque et de vie</li>
 * <li>La position</li>
 * </ul>
 *
 * @author lmalix
 */
public class Mage extends Personnage implements Combattant {


    /**
     * Constructeur Mage Initialisation par la super classe
     *
     * @see Personnage#Personnage()
     */
    public Mage() {
        super();
        setNom("Mage");
        this.setPtVie(120);
        this.setPtMana(5);
        this.setPourcentageAtt(50);
        this.setPourcentagePar(10);
        this.setPourcentageMag(50);
        this.setPourcentageResisMag(50);
        this.setDegAtt(33);
        this.setDegMag(20);
        this.setDistAttMax(4);
        this.setPos(new Point2D());
    }

    /**
     * Constructeur Mage Initialisation par la super classe
     *
     * @param ptParade points de parade
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
     * @param pos la position
     */
    public Mage(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResisMag, int degAtt, int degMag, int distAttMax, int ptParade, Point2D pos) {
        super(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResisMag, degAtt, degMag, distAttMax, ptParade, pos);
    }

    /**
     * Constructeur Mage Initialisation par la super classe
     *
     * @param mage une mage
     */
    public Mage(Mage mage) {
        super(mage);
    }

    
    /**
     * Affichage des information
     */
    @Override
    public void affiche() {
        super.affiche();
    }

    /**
     * permet à Mage de lancer une attaque sur une autre créature
     *
     * @param defendeur La créature attaquée
     */
    @Override
    public void combattre(Creature defendeur) {

        float distance = this.getPos().distance(defendeur.getPos());

        /*
        Attaque magique
         */
        if (distance >= 1 && distance < this.getDistAttMax()) {

            Random jet = new Random();
            int Rand = jet.nextInt(100);

            if (Rand > this.getPourcentageMag()) {
                System.out.println("************************** Attaque ratée ****************************");
            } else {
                System.out.println("************************** Attaque magique ****************************\n");
                defendeur.setPtVie(defendeur.getPtVie() - this.getDegMag());

            }

        } else {
            System.out.println("*************************  Trop loin ****************************\n");
        }
    }
    
    /**
     * Générer le texte de sauvegarde
     * @return le texte de sauvegarde
     */
    @Override
    public String getTexteSauvegarde() {
        String texte = "Mage " + getNom() + " " + getPtVie() + " " + getPtMana() + " " + 
                " " + getPourcentageAtt() + " " + getPourcentagePar() + " " + getPourcentageMag() +
                " " + getPourcentageResisMag() + " " + getDegAtt() + " " + getDegMag() + " " +
                " " + getDistAttMax() + " " + getPtParade() + " " + getPos().getX() + " "+ getPos().getY();
        return texte;
    }

}
