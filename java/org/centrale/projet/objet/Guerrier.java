package org.centrale.projet.objet;

import java.util.Random;

/**
 * <b> Guerrier est la classe représentatnt un personnage Guerrier dans le
 * jeu</b>
 * <p>
 * Un Guerrier est caractérisé par les attributs d'un personnage
 * <ul>
 * <li>Le nom du paysan</li>
 * <li>Les caractéristiques d'attaque et de vie</li>
 * <li>La position</li>
 * </ul>
 *
 * @author lmalix
 */
public class Guerrier extends Personnage implements Combattant {

    /**
     * Constructeur Guerrier Initialisation par la super classe
     *
     * @see Personnage#Personnage()
     */
    public Guerrier() {
        super();
        setNom("Guerrier");
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
     * Constructeur Guerrier Initialisation par la super classe
     *
     * @param nom Le nom du guerrier
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
     *
     */
    public Guerrier(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResisMag, int degAtt, int degMag, int distAttMax,int ptParade, Point2D pos) {
        super(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResisMag, degAtt, degMag, distAttMax, ptParade, pos);
    }

    /**
     * Constructeur Guerrier Initialisation par la super classe
     *
     * @param guerrier un guerrier
     */
    public Guerrier(Guerrier guerrier) {
        super(guerrier);
    }
    
    /**
     * Affichage d'un Guerrier
     */
    @Override
    public void affiche() {
        super.affiche();
    }

    /**
     * permet du Guerrier de lancer une attaque sur une autre créature
     *
     * @param defendeur La créature attaquée
     */
    @Override
    public void combattre(Creature defendeur) {

        float distance = this.getPos().distance(defendeur.getPos());

        /*
        Attaque corps à corps
         */
        if (distance == 1) {

            Random jet = new Random();
            int Rand = jet.nextInt(100);

            if (Rand > this.getPourcentageAtt()) {
                System.out.println("--  Attaque ratée ****************************\n");
            } else {
                System.out.println("--  Attaque corps à corps **********************\n");
                int ptVieBefore = defendeur.getPtVie();
                if (Rand > defendeur.getPourcentagePar()) {
                    defendeur.setPtVie(defendeur.getPtVie() - this.getDegAtt());
                    System.out.println(this.getNom() + " Attacked " + defendeur.getNom());
                    System.out.println(defendeur.getNom() + ": Pt Vie :" + ptVieBefore + " --> " + defendeur.getPtVie() + "\n");
                } else {
                    defendeur.setPtVie(defendeur.getPtVie() - this.getDegAtt() + defendeur.getPourcentagePar());
                    System.out.println(this.getNom() + " Attacked " + defendeur.getNom());
                    System.out.println(defendeur.getNom() + ": Pt Vie :" + ptVieBefore + " --> " + defendeur.getPtVie() + "\n");
                }
            }

        } else {
            System.out.println("-- Trop loin ****************************\n");
        }
    }
    
    /**
     *  générer le texte de sauvegarde
     * @return texte de sauvegarde
     */
    @Override
    public String getTexteSauvegarde() {
        String texte = "Guerrier " + getNom() + " " + getPtVie() + " " + getPtMana() + " " + 
                " " + getPourcentageAtt() + " " + getPourcentagePar() + " " + getPourcentageMag() +
                " " + getPourcentageResisMag() + " " + getDegAtt() + " " + getDegMag() +
                " " + getDistAttMax() + " " + getPtParade() + " " + getPos().getX() + " "+ getPos().getY();
        return texte;
    }

}
