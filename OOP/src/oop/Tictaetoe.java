/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import java.util.Arrays;

/**
 *
 * @author User
 */
public class Tictaetoe {
    static String[] board;
    static String turn;
    
    // CheckWinner method will check whether there is a combination of three 
    // identical symbols in each possibles lines(HORIZONTAL, VERTICAL, DIAGONAL)
    // means checking for winner avaiable.
    static String checkWinner(){
        for (int a = 0; a < 8; a++) {
            // let line be empty for comparison purpose
            String line = null;
  
            switch (a) {
            case 0:
                line = board[0] + board[1] + board[2];
                break;
            case 1:
                line = board[3] + board[4] + board[5];
                break;
            case 2:
                line = board[6] + board[7] + board[8];
                break;
            case 3:
                line = board[0] + board[3] + board[6];
                break;
            case 4:
                line = board[1] + board[4] + board[7];
                break;
            case 5:
                line = board[2] + board[5] + board[8];
                break;
            case 6:
                line = board[0] + board[4] + board[8];
                break;
            case 7:
                line = board[2] + board[4] + board[6];
                break;
            }
            //For X winner
            if (line.equals("XXX")) {
                return "X";
            }
              
            // For O winner
            else if (line.equals("OOO")) {
                return "O";
            }
        }
          
        for (int a = 0; a < 9; a++) {
            if (Arrays.asList(board).contains(
                    String.valueOf(a + 1))) {
                break;
            }
            // if all boxes are filled, declare a draw
            else if (a == 8) {
                return "draw";
            }
        }
  
       // To enter the X Or O at the exact place on board.
        System.out.println(
            turn + "'s turn, please enter a slot number to place "
            + turn + " in:");
        return null;
    }
      
    // To print out the board.
    // sample output
    /*    |   |
        1 | 2 | 3
       ---|---|---
        4 | 5 | 6 
       ---|---|---
        7 | 8 | 9 
          |   |   */
    
    static void printBoard(){
        System.out.println("   |   |    ");
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("---|---|---");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");
        System.out.println("   |   |   ");
    }
}

