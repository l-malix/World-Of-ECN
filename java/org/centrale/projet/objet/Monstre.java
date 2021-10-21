package org.centrale.projet.objet;

/**
 * <b> Monstre est la classe représentatnt un monstre dans le jeu</b>
 * <p>
 * Un Personnage est caractérisé par les attributs suivantes
 * <ul>
 * <li>Le nom du monstre</li>
 * <li>Les caractéristiques d'attaque et de vie</li>
 * <li>La position</li>
 * </ul>
 *
 * @author lmalix
 */
public class Monstre extends Creature {

    /**
     * Constructeur Monstre
     * <b> Construction d'un monstre avec toutes les caractéristiques à 0</b>
     */
    public Monstre() {
        super();
        super.setNom("Monstre");
    }

    /**
     * * Constructeur Monstre
     * <b> Construction d'un monstre avec les paramétres suivantes:</b>
     *
     * @param nom le noò
     * @param ptVie points de vie
     * @param pourcentageAtt pourcentage attaque
     * @param pourcentagePar pourcentage parade
     * @param degAtt degats d'attaque
     * @param ptParade points de parade
     * @param pos position
     */
    public Monstre(String nom, int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptParade, Point2D pos) {
        super(nom, ptVie, pourcentageAtt, pourcentagePar, degAtt, ptParade, pos);
    }

    /**
     * Constructeur Personnage Construction d'un personnage avec les
     * caractéristiques d'un autre Monstre
     *
     * @param monstre un monstre
     */
    public Monstre(Monstre monstre) {
        super(monstre);
    }
    
    /**
     * Représentation textuelle
     * @return le texte
     */
    @Override
    public String toString() {
        return   "------------------------------------------------------" + "\n"
                + "nom              : " + getNom() + "\n"
                + "ptVie            : " + getPtVie() + "\n"
                + "pourcentageAtt   : " + getPourcentageAtt() + "\n"
                + "pourcentagePar   : " + getPourcentagePar() + "\n"
                + "degAtt           : " + getDegAtt() + "\n"
                + "ptParade         : " + getPtParade() + "\n"
                + "Position         : " + getPos().toString();
    }
    
    /**
     * le texte de sauvegarde
     * @return le texte de sauvegarde
     */
    @Override
    public String getTexteSauvegarde() {
        return "";
    }

}
