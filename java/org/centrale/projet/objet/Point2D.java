package org.centrale.projet.objet;

import java.lang.Math;

/**
 * <b> Point2D est la classe représentatnt un point en 2 dimenstions</b>
 * <p>
 * Un point 2D est caractérisé par les deux coordonnées x et y
 *
 * @author lmalix
 */
public class Point2D {

    /**
     *  FORWARD : translater le caractère par ( 0, 1)
     */
    public static final int[] FORWARD = {0, 1};
    /**
     *  BACKWARD : translater le caractère par ( 0, -1)
     */
    public static final int[] BACKWARD = {0, -1};
    /**
     *  RIGHT : translater le caractère par ( 1, 0)
     */
    public static final int[] RIGHT = {1, 0};
    /**
     *  LEFT : translater le caractère par (-1, 0)
     */
    public static final int[] LEFT = {-1, 0};
    /**
     *  FORRIGHT : translater le caractère par ( 1, 1)
     */
    public static final int[] FORRIGHT = {1, 1};
    /**
     *  FORLEFT : translater le caractère par (-1, 1)
     */
    public static final int[] FORLEFT = {-1, 1};
    /**
     *  BACKRIGHT : translater le caractère par ( 1, -1)
     */
    public static final int[] BACKRIGHT = {1, -1};
    /**
     *  BACKLEFT : translater le caractère par (-1, -1)
     */
    public static final int[] BACKLEFT = {-1, -1};

    /**
     * x : L'ordonnée du point y : L'abscisse du point
     */
    private int x;
    private int y;

    /**
     * Constructeur Point2D.
     * <p>
     * Construction d'un point 2D avec les coordonées (0, 0)
     * </p>
     */
    public Point2D() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Constructeur Point2D.
     * <p>
     * Construction d'un point 2D avec des coordonées
     * </p>
     *
     * @param _x L'ordonnée du point 2D.
     * @param _y L'abscisse du point 2D.
     */
    public Point2D(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }

    /**
     * Constructeur Point2D.
     * <p>
     * Construction d'un point 2D avec les coordonées d'un autre point 2D
     * </p>
     *
     * @param p un point 2D choisi
     */
    public Point2D(Point2D p) {
        this.x = p.getX();
        this.y = p.getY();
    }
    
    /**
     * setter de x
     * @param _x x
     */
    public void setX(int _x) {
        this.x = _x;
    }
    
    /**
     * getter de x
     * @return x
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * setter de y
     * @param _y y
     */
    public void setY(int _y) {
        this.y = _y;
    }
    
    /**
     * getter de y
     * @return y
     */
    public int getY() {
        return this.y;
    }

    /**
     * Changer les coordonées du point 2D
     *
     * @param _x L'ordonnée
     * @param _y L'abscisse
     */
    public void setPosition(int _x, int _y) {
        this.x = _x;
        this.y = _y;
    }

    /**
     * Translater le point 2D suivant 2 axes
     *
     * @param dx Distance de translation suivant l'axe des ordonnées
     * @param dy Distance de translation suivant l'axe des abscisses
     */
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Translater un point 2D par un mouvement
     *
     * @param move Tuple de distances (dx, dy)
     */
    public void translate(int[] move) {
        this.x += move[0];
        this.y += move[1];
    }

    /**
     * Affichage des deux coordonées du point 2D
     */
    public void affiche() {
        System.out.println(this);
    }
    
    /**
     * égalité booléenne
     * @param object un objet
     * @return égalitée
     */
    @Override
    public boolean equals(Object object) {

        boolean sameSame = false;

        if (object != null && object instanceof Point2D) {
            sameSame = this.x == ((Point2D) object).getX()
                    && this.y == ((Point2D) object).getY();
        }

        return sameSame;
    }
    
    /**
     * affichage textuel
     * @return texte
     */
    @Override
    public String toString() {
        return "( " + this.x + ", " + this.y + " )";
    }
    
    /**
     * calculer la distance avec un point
     * @param p un point
     * @return la distance
     */
    public float distance(Point2D p) {
        return (float) Math.sqrt(Math.pow(p.getX() - this.x, 2) + Math.pow(p.getY() - this.y, 2));
    }
}
