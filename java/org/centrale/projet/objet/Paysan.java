package org.centrale.projet.objet;

/**
 * <b> Paysan est la classe représentatnt un personnage Paysan dans le jeu</b>
 * <p>
 * Un Paysan est caractérisé par les attributs d'un personnage
 * <ul>
 * <li>Le nom du paysan</li>
 * <li>Les caractéristiques d'attaque et de vie</li>
 * <li>La position</li>
 * </ul>
 *
 * @author lmalix
 */
public class Paysan extends Personnage {

    /**
     * Constructeur Paysan Initialisation par la super classe
     *
     * pourcentageAtt, int pourcentagePar, int pourcentageMag, int
     * pourcentageResisMag, int degAtt, int degMag, int distAttMax, Point2D pos)
     * @param nom Le nom de Paysan
     * @param ptVie Les points de vie
     * @param ptMana les points de Mana
     * @param pourcentageAtt le pourcentage d'attaque
     * @param pourcentagePar le pourcentage de parade
     * @param pourcentageMag le pourcentage de magie
     * @param pourcentageResisMag le pourcentage de resistance de magie
     * @param degAtt degats d'attaque
     * @param degMag degats de magie
     * @param distAttMax distance maximale d'attaque
     * @param ptParade pts de parade
     * @param pos la position
     */
    public Paysan(String nom, int ptVie, int ptMana, int pourcentageAtt, int pourcentagePar, int pourcentageMag, int pourcentageResisMag, int degAtt, int degMag, int distAttMax, int ptParade, Point2D pos) {
        super(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResisMag, degAtt, degMag, distAttMax, ptParade, pos);
    }

    /**
     * Constructeur Paysan Initialisation par la super classe
     *
     * @param paysan un paysan
     */
    public Paysan(Paysan paysan) {
        super(paysan);
    }

    /**
     * Constructeur Paysan Initialisation par la super classe
     *
     */
    public Paysan() {
        super();
        this.setNom("Paysan");
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
     * affichage de paysan
     */
    @Override
    public void affiche() {
        super.affiche();
    }
    
    /**
     * générer le texte de sauvegarde
     * @return le texte de sauvegarde
     */
    @Override
    public String getTexteSauvegarde() {
        String texte = "Paysan " + getNom() + " " + getPtVie() + " " + getPtMana() + " " + 
                " " + getPourcentageAtt() + " " + getPourcentagePar() + " " + getPourcentageMag() +
                " " + getPourcentageResisMag() + " " + getDegAtt() + " " + getDegMag() + " " +
                " " + getDistAttMax() + " " + getPtParade() + " " + getPos().getX() + " "+ getPos().getY();
        return texte;
    }

}
