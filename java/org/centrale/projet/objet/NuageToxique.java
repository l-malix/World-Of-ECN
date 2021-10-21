/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe de nuage toxique
 * @author lmalix
 */
public class NuageToxique extends Objet implements Deplacable, Combattant {
    
    /**
     * dégats d'attaque
     */
    private int degAtt;
    
    /**
     * Constructeur de NT
     */
    public NuageToxique() {
        super();
        degAtt = 10;
    }
    
    /**
     * Constructeur de NT
     * @param pos position
     * @param degAtt degats d'attaque
     */
    public NuageToxique(Point2D pos,int degAtt) {
        super(pos);
        this.degAtt = degAtt;
    }
    
    /**
     * getter des degats d'attaque
     * @return degats d'attaque
     */
    public int getDegAtt() {
        return degAtt;
    }
    
    /**
     * Setter des degats d'attaque
     * @param degAtt degats d'attaque
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }
    
    /**
     * méthode de déplacement avec un mouvement
     * @param move le mouvement
     */
    @Override
    public void deplace(int[] move) {
        Point2D wantedPos = new Point2D(this.getPos());
        wantedPos.translate(move);
        this.setPos(wantedPos);
    }
    
    /**
     * permettre de combattre une créature défendeur
     * @param defendeur la créature défendeur
     */
    @Override
    public void combattre(Creature defendeur) {
        float distance = this.getPos().distance(defendeur.getPos());
        if (distance == 1) {
            System.out.println(defendeur.getNom() + " poisoned by toxic cloud");
            defendeur.setPtVie(defendeur.getPtVie() - this.degAtt);
        } else {
            System.out.println("Trés loin");
        }
    }
    
    /**
     * Poisoner un personnage et disparaitre
     * @param personnage le personnage à poisoner
     */
    @Override
    public void applyEffect(Personnage personnage) {
        personnage.setPtVie(personnage.getPtVie() - this.degAtt);
        System.out.println(personnage.getNom() + " poisoned by toxic cloud");
    }
    
    /**
     * générer un texte de sauvegarde
     * @return texte de sauvegarde
     */
    @Override
    public String getTexteSauvegarde() {
        String texte = "NuageToxique " + getDegAtt() + " "+ getPos().getX() + " "+ getPos().getY();
        return texte;
    }

}
