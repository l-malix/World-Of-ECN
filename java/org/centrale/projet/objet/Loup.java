package org.centrale.projet.objet;

import java.util.Random;

/**
 * <b> Loup est la classe représentatnt un monstre Loup dans le jeu</b>
 * <p>
 * Un Loup est caractérisé par les attributs d'un monstre
 * <ul>
 * <li>Le nom du lapin</li>
 * <li>Les caractéristiques d'attaque et de vie</li>
 * <li>La position</li>
 * </ul>
 *
 * @author lmalix
 */
public class Loup extends Monstre implements Combattant {

    /**
     * Constructeur Loup Initialisation par la super classe
     *
     */
    public Loup() {
        super();
        setNom("Loup");
        this.setPtVie(120);
        this.setPourcentageAtt(5);
        this.setPourcentagePar(10);
        this.setDegAtt(20);
        this.setPos(new Point2D());
    }

    /**
     * Constructeur Loup Initialisation d'un lapin par la super classe
     * 
     * @param ptVie points de vie
     * @param pourcentageAtt % attaque
     * @param pourcentagePar % parade
     * @param degAtt degats d'attaque
     * @param ptParade pts de parade
     * @param pos position
     */
    public Loup(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptParade ,Point2D pos) {
        super("loup", ptVie, pourcentageAtt, pourcentagePar, degAtt, ptParade, pos);
    }

    /**
     * Constructeur Loup Initialisation d'un lapin par la superclasse
     *
     * @see Monstre#Monstre(Monstre monstre)
     * @param loup un loup
     */
    public Loup(Loup loup) {
        super(loup);
    }
    
    /**
     * Combattre un défendeur
     * @param defendeur le defendeur à combattre
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
     * Générer le texte de sauvegarde
     * @return le texte de sauvegarde
     */
    @Override
    public String getTexteSauvegarde() {
        String texte = "Loup " + getPtVie() +  " " + 
                " " + getPourcentageAtt() + " " + getPourcentagePar() +
                " " + getDegAtt() + " " +
                " " + getPtParade() + " " + getPos().getX() + " "+ getPos().getY();
        return texte;
    }

}
