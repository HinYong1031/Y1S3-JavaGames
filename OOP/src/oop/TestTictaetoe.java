/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.InputMismatchException;
import java.util.Scanner;
import static oop.Tictaetoe.board;
import static oop.Tictaetoe.checkWinner;
import static oop.Tictaetoe.printBoard;
import static oop.Tictaetoe.turn;

/**
 *
 * @author User
 */
public class TestTictaetoe {
    public static void main() {    
        Scanner in = new Scanner(System.in);
        turn = "X";
        board = new String[9];
  
        // initialize all positions with numbers
        for (int a = 0; a < 9; a++) {
            board[a] = String.valueOf(a + 1);
        }
  
        // welcome message
        System.out.println("Welcome to Tic Tac Toe.");
        // Prompt for name of two players
        Scanner inputName = new Scanner(System.in);
        System.out.println("Player 1, what is your name?");
        String p1 = inputName.nextLine();
        System.out.println("Player 2, what is your name?");
        String p2 = inputName.nextLine();
        System.out.println(p1 + ", you will represent as X.\n" + p2 + ", you will represent as O.");
        
        // loop the game
        Boolean gameEnd = false;
        while(!gameEnd) {
            String winner = null;
            turn = "X";
            // print the board
            printBoard();
            System.out.println(turn + " ,it is your turn first. Please enter a number to place X :");
            while (winner == null) {
                int numInput;
                // Exception handling.
                // numInput will be taken from user from 1 to 9.
                // If it is not in range from 1 to 9.
                // then it will show an error message
                try {
                    numInput = in.nextInt();
                    
                    if (!(numInput > 0 && numInput <= 9)) {
                        System.out.println("Invalid input, please enter slot number again: ");
                        continue;
                    }
                    
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input, please enter slot number again: ");
                    in.nextLine();
                    continue;
                }

                // decide the turn(x or O)
                if (board[numInput - 1].equals(String.valueOf(numInput))){
                    board[numInput - 1] = turn;
                    if (turn.equals("X"))
                        turn = "O";
                    else 
                        turn = "X";
                    printBoard();
                    winner = checkWinner();
                }
                else {
                    System.out.println("Slot is already taken, please enter another slot number:");
                }
            }

            // No one has three identical X or O then declare a "draw".
            if (winner.equalsIgnoreCase("draw")){
                System.out.println("It's a draw! Thanks for playing.");
                Scanner playAgain = new Scanner(System.in);
                System.out.println("Would you like to play again?\n1. Yes\n2. No");
                int contiune = playAgain.nextInt();
                if (contiune == 1){
                    gameEnd = false;
                    // restart the board and winner
                    // initialize again all positions with numbers
                    board = new String[9];
                    for (int a = 0; a < 9; a++) {
                        board[a] = String.valueOf(a + 1);
                    }
                    winner = null;
                }
                else {
                    // end the game and display thank you message
                    gameEnd = true;
                    System.out.println("Thanks for playing!");
                }
            }

            // display Congratulations message to the winner.
            else {
                System.out.println("Congratulations! " + winner + "'s have won!");
                Scanner playAgain = new Scanner(System.in);
                System.out.println("Would you like to play again?\n1. Yes\n2. No");
                int contiune = playAgain.nextInt();
                if (contiune == 1){
                    gameEnd = false;
                    // restart the board and winner
                    // initialize again all positions with numbers
                    board = new String[9];
                    for (int a = 0; a < 9; a++) {
                        board[a] = String.valueOf(a + 1);
                    }
                    winner = null;
                }
                else {
                    // end the game and display thank you message
                    gameEnd = true;
                    System.out.println("Thanks for playing!");
                }
            }
        }
    }
}
