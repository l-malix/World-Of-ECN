package org.centrale.projet.objet;

/**
 * <b> Lapin est la classe représentatnt un monstre Lapin dans le jeu</b>
 * <p>
 * Un Lapin est caractérisé par les attributs d'un monstre
 * <ul>
 * <li>Le nom du lapin</li>
 * <li>Les caractéristiques d'attaque et de vie</li>
 * <li>La position</li>
 * </ul>
 *
 * @author lmalix
 */
public class Lapin extends Monstre {

    /**
     * Constructeur Lapin Initialisation par la super classe
     *
     */
    public Lapin() {
        super();
        setNom("Lapin");
        this.setPtVie(120);
        this.setPourcentageAtt(5);
        this.setPourcentagePar(10);
        this.setDegAtt(20);
        this.setPos(new Point2D());
    }

    /**
     * Constructeur Lapin Initialisation d'un lapin par la super classe
     *
     * @param ptVie points de vie
     * @param pourcentageAtt % attage
     * @param pourcentagePar % attaque
     * @param degAtt degats d'attaque
     * @param ptParade pts de parade
     * @param pos la position
     */
    public Lapin(int ptVie, int pourcentageAtt, int pourcentagePar, int degAtt, int ptParade, Point2D pos) {
        super("lapin", ptVie, pourcentageAtt, pourcentagePar, degAtt, ptParade, pos);
    }

    /**
     * Constructeur Lapin Initialisation d'un lapin par la superclasse
     *
     * @see Monstre#Monstre(Monstre monstre)
     * @param lapin un lapin
     */
    public Lapin(Lapin lapin) {
        super(lapin);
    }
    
    /**
     * Générer le texte de sauvegarde
     * @return le texte de sauvegarde
     */
    @Override
    public String getTexteSauvegarde() {
        String texte = "Lapin " + getPtVie() +  " " + 
                " " + getPourcentageAtt() + " " + getPourcentagePar() +
                " " + getDegAtt() + " " +
                " " + getPtParade() + " " + getPos().getX() + " "+ getPos().getY();
        return texte;
    }

}
