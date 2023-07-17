package oop;

// @author 21WMR02982

import java.util.Scanner;

public class OOP {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int choice;
        System.out.println("\t\t\tWelcome to Java Games!");
        do{
            System.out.println("========================================"
                    + "================================");
            System.out.println("Select a game to play (1-5):");
            System.out.println("1: Hangman" + "\n2: Scissor-Rock-Paper"
            + "\n3: Tic-Tac-Toe" + "\n4: Flip and Match" + "\n5: Five dice"
            + "\n0: Exit");
            System.out.println("\nPlay: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    Hangman gamerun = new Hangman();
                    gamerun.GameRun();
                    break;
                case 2:
                    RPS.rps();
                    break;
                case 3:
                    TestTictaetoe.main();
                    break;
                case 4:
                    FlipMatch.FlipMatch();
                    break;
                case 5:
                    Dice.main();
                    break;
                case 0:
                    System.out.println("Thanks for playing (●'◡'●)");
                    System.out.println("See you next time!");
                    break;
                default:
                   System.out.println("Choice must be a value between 1 to 5 or 0");
            }
        }while(choice != 0);
    }
}

