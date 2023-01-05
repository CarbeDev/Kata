package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CommandLine cli = new CommandLine(true);
        Scanner input = new Scanner(System.in);

        while (true){
            cli.printMap();

            System.out.println("z pour avancer, q pour tourner a gauche,d pour tourner a droite");
            String command = input.nextLine();

            switch (command) {
                case "z" -> cli.getRover().moveForward();
                case "q" -> cli.getRover().turnLeft();
                case "d" -> cli.getRover().turnRight();
                default -> System.out.println("Erreur");
            }
        }
    }
}