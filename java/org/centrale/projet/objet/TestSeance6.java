/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Scanner;

/**
 * Classe de tests pour la séance 6 du TP
 * @author lmalix
 */
public class TestSeance6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Décommenter pour tester le chargement d'une partie à partir de
         * "Sauvegarde-WoE.txt"
         */
//        ChargementPartie partie = new ChargementPartie("Sauvegarde-WoE.txt");
//        World world = new World(20);
//        partie.chargerPartie(world);
//        world.afficheWorld();
        

            String welcome =    " _    _            _     _   _____  __   _____ _____  _   _ \n" +
                                "| |  | |          | |   | | |  _  |/ _| |  ___/  __ \\| \\ | |\n" +
                                "| |  | | ___  _ __| | __| | | | | | |_  | |__ | /  \\/|  \\| |\n" +
                                "| |/\\| |/ _ \\| '__| |/ _` | | | | |  _| |  __|| |    | . ` |\n" +
                                "\\  /\\  / (_) | |  | | (_| | \\ \\_/ / |   | |___| \\__/\\| |\\  |\n" +
                                " \\/  \\/ \\___/|_|  |_|\\__,_|  \\___/|_|   \\____/ \\____/\\_| \\_/\n" +
"                                                            ";
            /**
             * Tout en un
             */
            World world = new World(0);
            Scanner scanner = new Scanner(System.in);
            System.out.println(welcome);
            System.out.println("C : Charger une partie - N : Nouvelle partie");
            String reponse = scanner.nextLine();
            if (reponse.equals("N")) {
                System.out.println("Dimension du monde :");
                world = new World(Integer.parseInt(scanner.nextLine()));
                world.creeMondeAlea();
                world.tourDeJeu();
            } else if (reponse.equals("C")) {
                System.out.println("Entrere le nom du fichier à charger");
                String file = scanner.nextLine() + ".txt";
                ChargementPartie loadGame = new ChargementPartie(file);
                loadGame.chargerPartie(world);
                world.tourDeJeu();
            } else {
                System.out.println("Bye");
            }
            
    }
    
}
