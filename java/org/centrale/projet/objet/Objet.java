package org.centrale.projet.objet;

/**
 * Classe objet
 * @author lmalix
 */
public class Objet extends ElementDeJeu implements Sauvegardable{
    
    /**
     * La position
     */
    Point2D pos;
    
    /**
     * Constructeur d'objet
     */
    public Objet() {
        pos = new Point2D();
    }
    
    /**
     * Constructeur d'objet
     * @param pos position d'objet
     */
    public Objet(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * getter de la position
     * @return la position
     */
    public Point2D getPos() {
        return pos;
    }
    
    /**
     * setter de la position
     * @param pos la position
     */
    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    /**
     * applique l'effet d'objet sur un personnage
     * @param personnage le personnage
     */
    public void applyEffect(Personnage personnage) {
    }
    
    /**
     * générer le texte de sauvegarde
     * @return le texte de sauvegarde
     */
    @Override
    public String getTexteSauvegarde() {
       return "";
    }
}
