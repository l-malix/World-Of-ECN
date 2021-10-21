/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe representant un monde de jeu
 * @author lmalix
 */
public class World {

    /**
     * La distance minimale entre 2 protagonistes lors de la création
     */
    public static final int INIT_MIN_DIST = 3;
    
    /**
     * joueur humain
     */
    public Joueur joueur;
    
    /**
     * largeur du monde
     */
    public int largeur;
    /**
     * hauteur du monde
     */
    public int hauteur;
    /**
     * Liste des créatures
     */
    public ArrayList<Creature> listCreature;
    /**
     * Liste des potions
     */
    public ArrayList<Potion> listPotions;
    /**
     * Liste des des nuages toxiques
     */
    public ArrayList<NuageToxique> listNuageToxiques;
    /**
     * Liste des positions des créatures
     */
    public ArrayList<Point2D> positionsCreatures;
    /**
     * Liste des positions des potions
     */
    public ArrayList<Point2D> positionsPotions;
    /**
     * Liste des positions des nuages toxiques
     */
    public ArrayList<Point2D> positionsNuageToxiques;
    /**
     * Liste des Nourritures
     */
    ArrayList<Nourriture> listNourritures;
    /**
     * Liste des positions des nourritures
     */
    ArrayList<Point2D> positionsNourritures;
    /**
     * Nombre d'archers dans le monde
     */
    int numArcher;
    /**
     * Nombre de paysans dans le monde
     */
    int numPaysan;
    /**
     * Nombre de mages dans le monde
     */
    int numMage;
    /**
     * Nombre de guerriers dans le monde
     */
    int numGuerrier;
    /**
     * Nombre de loups dans le monde
     */
    int numLoup;
    /**
     * Nombre de lapins dans le monde
     */
    int numLapin;
    /**
     * Nombre de Soins dans le monde
     */
    int numSoin;
    /**
     * Nombre de Mana dans le monde
     */
    int numMana;
    /**
     * Nombre de Nuages Toxiques dans le monde
     */
    int numNT;

    /**
     * Nombre de Nourritures dans le monde
     */
    int numNou;

    /**
     * Constructeur World Initialisation de la liste des protagonistes
     * @param world_dim dimension du monde
     */
    public World(int world_dim) {
        this.hauteur = world_dim;
        this.largeur = world_dim;
        listCreature = new ArrayList<>();
        listPotions = new ArrayList<>();
        listNuageToxiques = new ArrayList<>();

        positionsCreatures = new ArrayList<>();
        positionsPotions = new ArrayList<>();
        positionsNuageToxiques = new ArrayList<>();

        listNourritures = new ArrayList<>();
        positionsNourritures = new ArrayList<>();

        joueur = new Joueur();
    }

    /**
     * Generation des créatures aléatoirement
     */
    public void genererCreatures() {
        int minVal = 1;
        int maxVal = 5 - minVal;

        Random rand = new Random();

        numArcher = minVal + rand.nextInt(maxVal);
        for (int i = 0; i < numArcher; i++) {
            listCreature.add(new Archer());
        }
        System.out.println(numArcher + " Archers sont créés");

        numPaysan = minVal + rand.nextInt(maxVal);
        for (int i = 0; i < numPaysan; i++) {
            listCreature.add(new Paysan());
        }
        System.out.println(numPaysan + " Paysans sont créés");

        numGuerrier = minVal + rand.nextInt(maxVal);
        for (int i = 0; i < numGuerrier; i++) {
            listCreature.add(new Guerrier());
        }
        System.out.println(numGuerrier + " Guerriers sont créés");

        numMage = minVal + rand.nextInt(maxVal);
        for (int i = 0; i < numMage; i++) {
            listCreature.add(new Mage());
        }
        System.out.println(numMage + " Mages sont créés");

        numLapin = minVal + rand.nextInt(maxVal);
        for (int i = 0; i < numLapin; i++) {
            listCreature.add(new Lapin());
        }
        System.out.println(numLapin + " Lapins sont créés");

        numLoup = minVal + rand.nextInt(maxVal);
        for (int i = 0; i < numLoup; i++) {
            listCreature.add(new Loup());
        }

        /**
         * Placement des créatures On génère premierement un point au hasard Ce
         * point ne doit pas être pris par un autre protagoniste Ce point ne
         * doit pas être à l'exterieur du monde Le point le plus proche à notre
         * point doit être distancié par 3 unités
         */
        for (Creature c : listCreature) {
            int randX = rand.nextInt(hauteur);
            int randY = rand.nextInt(largeur);
            Point2D randPoint = new Point2D(randX, randY);

            if (listCreature.isEmpty()) {
                positionsCreatures.add(randPoint);
                c.setPos(randPoint);
            } else {
                c.setPos(randPoint);
                int idxCC = lePlusProche(c); // index of the most closest creature

                while (true) {
                    if ((!positionsCreatures.contains(randPoint)) && (listCreature.get(idxCC).getPos().distance(randPoint) > 3)) {
                        positionsCreatures.add(randPoint);
                        c.setPos(randPoint);
                        break;
                    } else {
                        randX = rand.nextInt(hauteur - INIT_MIN_DIST);
                        randY = rand.nextInt(largeur - INIT_MIN_DIST);
                        randPoint = new Point2D(randX, randY);
                        c.setPos(randPoint);
                        idxCC = lePlusProche(c);
                    }
                }
            }
        }
    }

    /**
     * Generer des potions d'une manière aléatoire
     */
    public void genererPotions() {
        int minVal = 1;
        int maxVal = 5 - minVal;

        Random rand = new Random();

        numSoin = minVal + rand.nextInt(maxVal);
        for (int i = 0; i < numSoin; i++) {
            listPotions.add(new Soin());
        }
        System.out.println(numSoin + " Soins sont créés");

        numMana = minVal + rand.nextInt(maxVal);
        for (int i = 0; i < numMana; i++) {
            listPotions.add(new Mana());
        }
        System.out.println(numMana + " Manas sont créés");

        /**
         * Placement des potions sur les positions non prises
         */
        for (Potion o : listPotions) {
            int randX = rand.nextInt(hauteur - INIT_MIN_DIST);
            int randY = rand.nextInt(largeur - INIT_MIN_DIST);
            Point2D randPoint = new Point2D(randX, randY);
            o.setPos(randPoint);
            while (true) {
                if (!positionsCreatures.contains(o.getPos()) && !positionsPotions.contains(o.getPos())) {
                    positionsPotions.add(randPoint);
                    o.setPos(randPoint);
                    break;
                } else {
                    randX = rand.nextInt(hauteur - INIT_MIN_DIST);
                    randY = rand.nextInt(largeur - INIT_MIN_DIST);
                    randPoint = new Point2D(randX, randY);
                    o.setPos(randPoint);
                }
            }
        }

    }

    /**
     * Generer des nuages toxiques aléatoirement
     */
    public void genererNuagesToxiques() {
        int minVal = 1;
        int maxVal = 5 - minVal;

        Random rand = new Random();
        numNT = 3;
        //numNT = minVal+rand.nextInt(maxVal);
        for (int i = 0; i < numNT; i++) {
            listNuageToxiques.add(new NuageToxique());
        }
        System.out.println(numNT + " Nuages Toxiques sont créés");

        /**
         * Placement des Nuages toxiques dans le monde
         */
        for (NuageToxique nt : listNuageToxiques) {
            int randX = rand.nextInt(hauteur - INIT_MIN_DIST);
            int randY = rand.nextInt(largeur - INIT_MIN_DIST);
            Point2D randPoint = new Point2D(randX, randY);
            nt.setPos(randPoint);
            while (true) {
                if (!positionsCreatures.contains(nt.getPos())
                        && !positionsPotions.contains(nt.getPos())
                        && !positionsNuageToxiques.contains(nt.getPos())) {

                    positionsNuageToxiques.add(randPoint);
                    nt.setPos(randPoint);
                    break;

                } else {
                    randX = rand.nextInt(hauteur - INIT_MIN_DIST);
                    randY = rand.nextInt(largeur - INIT_MIN_DIST);
                    randPoint = new Point2D(randX, randY);
                    nt.setPos(randPoint);
                }
            }
        }
    }

    /**
     * Generer des nourritures d'une manière aléatoire
     */
    public void genererNourritures() {
        Random rand = new Random();
        numNou = 3;
        //numNT = minVal+rand.nextInt(maxVal);
        for (int i = 0; i < numNou; i++) {
            listNourritures.add(new Nourriture());
        }
        System.out.println(numNou + " Nourritures sont créés");

        /**
         * Placement des Nourritures dans le monde
         */
        for (Nourriture nourriture : listNourritures) {
            int randX = rand.nextInt(hauteur - INIT_MIN_DIST);
            int randY = rand.nextInt(largeur - INIT_MIN_DIST);
            Point2D randPoint = new Point2D(randX, randY);
            nourriture.setPos(randPoint);
            while (true) {
                if (!positionsCreatures.contains(nourriture.getPos())
                        && !positionsPotions.contains(nourriture.getPos())
                        && !positionsNuageToxiques.contains(nourriture.getPos())
                        && !positionsNourritures.contains(nourriture.getPos())) {

                    positionsNourritures.add(randPoint);
                    nourriture.setPos(randPoint);
                    break;

                } else {
                    randX = rand.nextInt(hauteur - INIT_MIN_DIST);
                    randY = rand.nextInt(largeur - INIT_MIN_DIST);
                    randPoint = new Point2D(randX, randY);
                    nourriture.setPos(randPoint);
                }
            }
        }
    }

    /**
     * Création d'un monde avec des emplacements aléatoires selon deux
     * contraintes
     * Deux protagonistes ne peuvent pas se positioner en même point
     * La distance maximale entre deux protagonistes lors de la création est 3
     */
    public void creeMondeAlea() {

        genererCreatures();
        genererPotions();
        genererNuagesToxiques();
        genererNourritures();
        creationJoueur();
    }

    /**
     * vérifier si l'emplacement voulu est pris par un autre protagoniste.
     *
     * @param position La position ou le point 2D rechérché.
     * @return True si la position est prise, et False sinon.
     */
    public boolean taken(Point2D position) {
        return positionsCreatures.contains(position);
    }

    /**
     * Vérifiere si la case contient un objet de potion
     *
     * @param position position à vérifier
     * @return indice de la position de potions
     */
    public int containPotion(Point2D position) {
        if (positionsPotions.contains(position)) {
            return positionsPotions.indexOf(position);
        }
        return -1;
    }

    /**
     * Vérifiere si la case contient un Nuage toxique
     *
     * @param position position à vérifier
     * @return l'indice du nuage
     */
    public int containNuage(Point2D position) {
        if (positionsNuageToxiques.contains(position)) {
            return positionsNuageToxiques.indexOf(position);
        }
        return -1;
    }

    /**
     * Vérifiere si la case contient une nourriture
     *
     * @param position position à vérifier
     * @return indice de nourriture
     */
    public int containNourriture(Point2D position) {
        if (positionsNourritures.contains(position)) {
            return positionsNourritures.indexOf(position);
        }
        return -1;
    }

    /**
     * Permet de déplacer un personnage dans le monde en respéctant la
     * contrainte.
     *
     * @param personnage personnage à déplacer.
     * @param move Le mouvement souhaité.
     */
    public void deplacerPersonnage(Personnage personnage, int[] move) {
        // Check if the wanted position is not taken
        Point2D wantedPos = new Point2D(personnage.getPos());
        wantedPos.translate(move);
        if (!taken(wantedPos)                                    && 
            !wantedPos.equals(joueur.personnage.getPos())        &&
             wantedPos.getX() < hauteur && wantedPos.getX() >= 0 &&
             wantedPos.getY() < largeur && wantedPos.getY() >= 0   ) {
            // Vérifier Si la position contient une potion
            int idx = containPotion(wantedPos);
            if (idx != -1) {
                listPotions.get(idx).applyEffect(personnage);
                listPotions.remove(idx);
                positionsPotions.remove(idx);
            }
            // Vérifier si la position contient un nuage toxique
            int idxNT = containNuage(wantedPos);
            if (idxNT != -1) {
                listNuageToxiques.get(idxNT).applyEffect(personnage);
                listNuageToxiques.remove(idxNT);
                positionsNuageToxiques.remove(idxNT);
            }
            // Vérifier si la position contient une nourriture
            int idxNO = containNourriture(wantedPos);
            if (idxNO != -1) {
                Nourriture nourriture = listNourritures.get(idxNO);
                personnage.takeNourriture(nourriture);
                listNourritures.remove(idxNO);
                positionsNourritures.remove(idxNO);
            }
            positionsCreatures.set(positionsCreatures.indexOf(personnage.getPos()), wantedPos);
            personnage.deplace(move);

        } else {
            System.out.println(personnage.getNom() + " can't move");
        }
    }

    /**
     * Déplacer un nuage toxique et appliquer la logique
     *
     * @param nt nuage toxique à déplacer
     * @param move le mouvement prévue
     */
    public void deplaceNt(NuageToxique nt, int[] move) {
        Point2D wantedPos = new Point2D(nt.getPos());
        wantedPos.translate(move);

        positionsNuageToxiques.set(positionsNuageToxiques.indexOf(nt.getPos()), wantedPos);
        nt.deplace(move);
        if (joueur.personnage.getPos().equals(nt.getPos())) {
            nt.applyEffect(joueur.personnage);
            positionsNuageToxiques.remove(positionsNuageToxiques.indexOf(nt.getPos()));
            listNuageToxiques.remove(listNuageToxiques.indexOf(nt));
        }

        for (Creature c : listCreature) {
            if (c.getPos().equals(nt.getPos())) {
                nt.applyEffect((Personnage) c);
                positionsNuageToxiques.remove(positionsNuageToxiques.indexOf(nt.getPos()));
                listNuageToxiques.remove(listNuageToxiques.indexOf(nt));
            }
        }

    }

    /**
     * retourne l'indice de la créature la plus proche à une créature donée
     *
     * @param creature La créature actuelle
     * @return L'indice de la créature la plus proche au creature passée
     */
    public int lePlusProche(Creature creature) {
        float min_dist = 100;
        int indexPlusProche = 0;
        for (int i = 0; i < listCreature.size(); i++) {
            float distance = creature.getPos().distance(listCreature.get(i).getPos());
            if (0 < distance && distance < min_dist) {
                min_dist = distance;
                indexPlusProche = i;
            }
        }
        return indexPlusProche;
    }

    /**
     * Créer un joueur dans le monde avec les entrées manuelles
     */
    public void creationJoueur() {
        joueur.creeJoueur();
        Random random = new Random();
        int randX = random.nextInt(hauteur);
        int randY = random.nextInt(largeur);

        Point2D position = new Point2D(randX, randY);

        while (true) {
            if (!positionsCreatures.contains(position) && !positionsPotions.contains(position)) {
                joueur.personnage.setPos(position);
                break;
            } else {
                randX = random.nextInt(hauteur);
                randY = random.nextInt(largeur);
                position = new Point2D(randX, randY);
            }
        }

    }

    /**
     * Déplacer le joueur dans le monde et appliquer la logique
     */
    public void deplacementJoueur() {
        // Déplacement du joueur
        int[] move = joueur.move();
        Point2D wantedPos = new Point2D(joueur.personnage.getPos());
        wantedPos.translate(move);
        // Vérifier si la positions est libre
        if (!taken(wantedPos) && 
             wantedPos.getX() < hauteur && wantedPos.getX() >= 0 &&
             wantedPos.getY() < largeur && wantedPos.getY() >= 0) {
            joueur.personnage.setPos(wantedPos);
            // Vérifier s'il y a une potions dans wantedPos
            int idx = containPotion(wantedPos);
            if (idx != -1) {
                listPotions.get(idx).applyEffect(joueur.personnage);
                listPotions.remove(idx);
                positionsPotions.remove(idx);
            }
            // Vérifier s'il y a un nuage toxique
            int idxNT = containNuage(wantedPos);
            if (idxNT != -1) {
                listNuageToxiques.get(idxNT).applyEffect(joueur.personnage);
                listNuageToxiques.remove(idxNT);
                positionsNuageToxiques.remove(idxNT);
            }
            // Vérifier si la position contient une nourriture
            int idxNO = containNourriture(wantedPos);
            if (idxNO != -1) {
                Nourriture nourriture = listNourritures.get(idxNO);
                joueur.personnage.takeNourriture(nourriture);
                listNourritures.remove(idxNO);
                positionsNourritures.remove(idxNO);
            }
        } else {
            System.out.println("You can't go there");
        }
    }
    
    /**
     * Permettre de choisir un mouvement par hasard
     * @return le mouvement choisi
     */
    public int[] randMove() {
        Random rand = new Random();
        
        int move = rand.nextInt(8);
        int[] mv = {0, 0};
        switch (move) {
            case 0 ->
                mv = Point2D.FORWARD;
            case 1 ->
                mv = Point2D.FORLEFT;
            case 2 ->
                mv = Point2D.LEFT;
            case 3 ->
                mv = Point2D.BACKLEFT;
            case 4 ->
                mv = Point2D.BACKWARD;
            case 5 ->
                mv = Point2D.BACKRIGHT;
            case 6 ->
                mv = Point2D.RIGHT;
            case 7 ->
                mv = Point2D.FORRIGHT;
            default ->
                System.out.println("Incompatible commande");
        }
        return mv;
    }
    
    /**
     * Permettre le joueur à attaquer une créature
     * @param personnage attaqueur
     * @param creature défendeur
     */
    public void attaquer(Personnage personnage, Creature creature) {
        if (personnage instanceof Archer) {
            Archer archer = new Archer((Archer) personnage);
            archer.combattre(creature);
        } else if (personnage instanceof Guerrier) {
            Guerrier guerrier = new Guerrier((Guerrier) personnage);
            guerrier.combattre(creature);
        } else if (personnage instanceof Mage) {
            Mage mage = new Mage((Mage) personnage);
            mage.combattre(creature);
        } else {
            System.out.println("I can't attack, I'm just a citizen");
        }
    }
    
    /**
     * un tour de jeu aléatoire pour les personnages
     */
    public void jeuAlea() {
        for (Creature c : listCreature) {
            
            Random rand = new Random();
            int deplaceOrAttaque = rand.nextInt(1);
            
            if (c instanceof Personnage) {
                if (deplaceOrAttaque == 0) {
                    deplacerPersonnage((Personnage) c, randMove());
                }
                if (deplaceOrAttaque == 1) {
                    int idxPP = lePlusProche(joueur.personnage);
                    attaquer((Personnage) c, listCreature.get(idxPP));
                }
            }
        }
    }
    
    /**
     * Permet de lancer une attaque sur la créature la plus proche, selon les
     * régles du jeu
     */
    public void tourDeJeu() {
        Scanner scanner = new Scanner(System.in);
        String operation;
        while (true) {
            afficheWorld();
            joueur.personnage.affiche();
            System.out.println("-N : next round, -M : Quit, P : Save");
            operation = scanner.nextLine();
            // Next Round of the game
            if (operation.equals("N")) {
                System.out.println("-V deplacement / -B attque");
                operation = scanner.nextLine();
                // Deplace
                if (operation.equals("V")) {
                    deplacementJoueur();
                    // Attack
                } else if (operation.equals("B")) {
                    int idxPP = lePlusProche(joueur.personnage);
                    joueur.attaquer(listCreature.get(idxPP));
                } //Bad Command
                else {
                    System.out.println("commande incompatible");
                }
                
                joueur.personnage.updateNourritureList();
                jeuAlea();

                // Quitting the game    
            } else if (operation.equals("M")) {
                break;
            } else if (operation.equals("P")) {
                System.out.println("File Name : ");
                operation = scanner.next();
                SauvegardePartie save = new SauvegardePartie(operation +".txt");
                save.sauvegarderPartie(this);
            }
            // Bad command
            else {
                System.out.println("commande incompatible");
            }
            joueur.personnage.updateNourritureList();
            
            
        }
    }

    /**
     * Permet génerer une représentation textuelle au Wold
     *
     * @return le texte à afficher
     */
    @Override
    public String toString() {
        String affichage = "";
        for (int i = 0; i < listCreature.size(); i++) {
            affichage = affichage + listCreature.get(i).toString();
        }
        return affichage;
    }

    /**
     * Fonction d'affichage
     */
    public void afficheWorld() {
        ArrayList<ArrayList<String>> a = new ArrayList<>();

        for (int i = 0; i < hauteur; i++) {
            ArrayList<String> x = new ArrayList<>();
            for (int j = 0; j < largeur; j++) {
                x.add("    ");
            }
            a.add(x);
        }

        // Affect values to the matrix
        
        /**
         * ajouter les créatures
         */
        for (int i = 0; i < positionsCreatures.size(); i++) {
            int x = positionsCreatures.get(i).getX();
            int y = positionsCreatures.get(i).getY();
            String abr = "    ";
            if (listCreature.get(i) instanceof Archer) {
                abr = " AR ";
            } else if (listCreature.get(i) instanceof Guerrier) {
                abr = " GU ";
            } else if (listCreature.get(i) instanceof Paysan) {
                abr = " PA ";
            } else if (listCreature.get(i) instanceof Mage) {
                abr = " MA ";
            } else if (listCreature.get(i) instanceof Lapin) {
                abr = " LA ";
            } else if (listCreature.get(i) instanceof Loup) {
                abr = " LO ";
            }

            a.get(x).set(y, abr);
        }
        
        /**
         * ajouter les potions
         */
        for (int i = 0; i < positionsPotions.size(); i++) {
            int x = positionsPotions.get(i).getX();
            int y = positionsPotions.get(i).getY();
            String abr = "    ";
            if (listPotions.get(i) instanceof Soin) {
                abr = " SO ";
            } else if (listPotions.get(i) instanceof Mana) {
                abr = " MN ";
            }

            a.get(x).set(y, abr);
        }
        
        /**
         * ajouter les nuages toxiques
         */
        for (int i = 0; i < positionsNuageToxiques.size(); i++) {
            int x = positionsNuageToxiques.get(i).getX();
            int y = positionsNuageToxiques.get(i).getY();
            String abr = "    ";
            if (listNuageToxiques.get(i) instanceof NuageToxique) {
                abr = " XX ";
            }

            a.get(x).set(y, abr);
        }
        
        /**
         * ajouter les nourritures
         */
        for (int i = 0; i < positionsNourritures.size(); i++) {
            int x = positionsNourritures.get(i).getX();
            int y = positionsNourritures.get(i).getY();
            String abr = "    ";
            if (listNourritures.get(i) instanceof Nourriture) {
                abr = " $$ ";
            }

            a.get(x).set(y, abr);
        }
        
        /**
         * ajouter le joueur
         */
        int jouX = joueur.personnage.getPos().getX();
        int jouY = joueur.personnage.getPos().getY();
        a.get(jouX).set(jouY, "*JO*");

        // Afficher la matrice
        for (int i = 0; i < hauteur; i++) {
            System.out.println(a.get(i));
        }

    }

}
