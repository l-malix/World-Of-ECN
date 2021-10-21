package org.centrale.projet.objet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Classe de chargement des parties
 * @author lmalix
 */
public class ChargementPartie {
    /**
     * Nom du fichier à charger
     */
    private String filePath;
    /**
     * Liste de dimensions
     */
    private ArrayList<String> typesDimensions = new ArrayList(List.of("Hauteur", "Largeur"));
    /**
     * Liste de personnages
     */
    private ArrayList<String> typesPersonnages = new ArrayList(List.of("Archer", "Paysan", "Mage", "Voleur", "Guerrier"));
    /**
     * Liste de monstres
     */
    private ArrayList<String> typesMonstres = new ArrayList(List.of("Loup", "Lapin"));
    /**
     * Liste de objets
     */
    private ArrayList<String> typesObjets = new ArrayList(List.of("Soin", "Mana", "NuageToxique"));
    /**
     * Liste de joueurs
     */
    private ArrayList<String> typesJoueurs = new ArrayList(List.of("Joueur"));
    /**
     * Liste de nourritures
     */
    private ArrayList<String> typesNourritures = new ArrayList(List.of("Nourriture"));
    /**
     * Le lecteur des fichiers
     */
    private BufferedReader reader;
    
    /**
     * Constructeur de chargement d'une partie à partir d'un fichier
     * @param filePath le fichier à charger
     */
    public ChargementPartie(String filePath) {
        try {
            this.filePath = filePath;
            this.reader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException ex) {
            System.out.println("file not found!");
        }
    }
    
    /**
     * Initier un monde à partir d'un fichier
     * @param world le monde à reprendre
     */
    public void chargerPartie(World world) {
        try {
            // deffinir la ligne à lire
            String ligne = this.reader.readLine();
            // definir un delimitteur
            String espace = " ";
            // Le type de ligne
            String typeDeLigne;
            
            /**
             * Passage sur toute les lignes séquentiellement
             */
            while (ligne != null) {
                System.out.println(ligne);
                StringTokenizer tokens = new StringTokenizer(ligne, espace);
                
                // extraire le type de ligne comme étant le premier mot
                typeDeLigne = tokens.nextToken();
                
                // Vérifier si la ligne correspond à une dimension
                if (typesDimensions.contains(typeDeLigne)) {
                    if (typeDeLigne.equals("Largeur")) {
                        world.largeur = Integer.parseInt(tokens.nextToken());
                    }
                    if (typeDeLigne.equals("Hauteur")) {
                        world.hauteur = Integer.parseInt(tokens.nextToken()); 
                    }
                }
                
                Joueur joueur = null;
                // Vérifier si la ligne correspond à un joueur
                if (typesJoueurs.contains(typeDeLigne)) {
                    joueur = new Joueur();
                    // passage au type de personnage qui correspond au joueur
                    typeDeLigne = tokens.nextToken();
                }
                
                // Vérifier si la ligne correspond à un personnage
                if (typesPersonnages.contains(typeDeLigne)) {
                    // extraire les caractéristiques du personnage
                    String nom = tokens.nextToken();
                    int ptVie = Integer.parseInt(tokens.nextToken());
                    int ptMana = Integer.parseInt(tokens.nextToken());
                    int pourcentageAtt = Integer.parseInt(tokens.nextToken());
                    int pourcentagePar = Integer.parseInt(tokens.nextToken());
                    int pourcentageMag = Integer.parseInt(tokens.nextToken());
                    int pourcentageResisMag = Integer.parseInt(tokens.nextToken());
                    int degAtt = Integer.parseInt(tokens.nextToken());
                    int degMag = Integer.parseInt(tokens.nextToken());
                    int distAttMax = Integer.parseInt(tokens.nextToken());
                    int ptParade = Integer.parseInt(tokens.nextToken());
                    Point2D pos = new Point2D(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
                    Personnage personnage = null;
                    
                    // Création du personnage selon le type
                    if (typeDeLigne.equals("Archer")) {
                        personnage = new Archer(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResisMag, degAtt, degMag, distAttMax, ptParade, pos, 10);
                    }
                    
                    if (typeDeLigne.equals("Guerrier")) {
                        personnage = new Guerrier(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResisMag, degAtt, degMag, distAttMax, ptParade, pos);
                    }
                    
                    if (typeDeLigne.equals("Mage")) {
                        personnage = new Mage(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResisMag, degAtt, degMag, distAttMax, ptParade, pos);
                    }
                    
                    if (typeDeLigne.equals("Paysan")) {
                        personnage = new Paysan(nom, ptVie, ptMana, pourcentageAtt, pourcentagePar, pourcentageMag, pourcentageResisMag, degAtt, degMag, distAttMax, ptParade, pos);
                    }
                    
                    // Si le personnage correspond à un joueur
                    if (personnage != null && joueur != null) {
                        joueur.personnage = personnage;
                        world.joueur.personnage = personnage;
                    }
                    // Si le personnage est aléatoirement controlé
                    else if (personnage != null && joueur == null) {
                       world.listCreature.add(personnage);
                       world.positionsCreatures.add(personnage.getPos());
                    }
                }
                
                // Vérifier si la ligne corresponfd à un monstre
                if (typesMonstres.contains(typeDeLigne)) {
                    int ptVie = Integer.parseInt(tokens.nextToken());
                    int pourcentageAtt = Integer.parseInt(tokens.nextToken());
                    int pourcentagePar = Integer.parseInt(tokens.nextToken());
                    int degAtt = Integer.parseInt(tokens.nextToken());
                    int ptParade = Integer.parseInt(tokens.nextToken());
                    Point2D pos = new Point2D(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
                    
                    // Création du monstre selon le type
                    if (typeDeLigne.equals("Loup")) {
                        Loup loup = new Loup(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptParade, pos);
                        world.listCreature.add(loup);
                        world.positionsCreatures.add(loup.getPos());
                    }
                    
                    if (typeDeLigne.equals("Lapin")) {
                        Lapin lapin = new Lapin(ptVie, pourcentageAtt, pourcentagePar, degAtt, ptParade, pos);
                        world.listCreature.add(lapin);
                        world.positionsCreatures.add(lapin.getPos());
                    }
                }
                
                // Si la ligne correspond à un objet
                if (typesObjets.contains(typeDeLigne)) {
                    int points = Integer.parseInt(tokens.nextToken());
                    Point2D pos = new Point2D(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
                    
                    // Création de l'objet selon le type
                    if (typeDeLigne.equals("Soin")) {
                        Soin soin = new Soin(pos, points);
                        world.listPotions.add(soin);
                        world.positionsPotions.add(soin.getPos());
                    }
                    
                    if (typeDeLigne.equals("Mana")) {
                        Mana mana = new Mana(pos, points);
                        world.listPotions.add(mana);
                        world.positionsPotions.add(mana.getPos());
                    }
                    
                    if (typeDeLigne.equals("NuageToxique")) {
                        NuageToxique nt = new NuageToxique(pos, points);
                        world.listNuageToxiques.add(nt);
                        world.positionsNuageToxiques.add(nt.getPos());
                    }
                }
                
                // Nourriture
                if (typesNourritures.contains(typeDeLigne)) {
                    int bonusMalus = Integer.parseInt(tokens.nextToken());
                    int persistTime = Integer.parseInt(tokens.nextToken());
                    Point2D pos = new Point2D(Integer.parseInt(tokens.nextToken()), Integer.parseInt(tokens.nextToken()));
                    
                    if (typeDeLigne.equals("Nourriture")) {
                        Nourriture nourriture = new Nourriture(bonusMalus, persistTime, pos);
                        world.listNourritures.add(nourriture);
                        world.positionsNourritures.add(nourriture.getPos());
                    }
                    
                }
                
                // Passage à la ligne suivante
                ligne = this.reader.readLine();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
}
