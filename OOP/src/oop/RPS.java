/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;
import java.util.Scanner; 
import java.util.Random;
/**
 *
 * @author Lim KJ
 */
public class RPS {

    public static void rps() {
                System.out.println("Welcome to Rock, Paper, Scissors!");
                Repeat();   
                
    }
    static void Repeat (){
                char choice;		
                Scanner console = new Scanner(System.in);     
                do{
                    Game10();
                System.out.println("\nIf you want to play again, please input Y or y.");
                choice = console.next().charAt(0);
                }while((choice == 'Y')||(choice == 'y'));
    }
    static void Game10(){
                String[] Move;
                String[] Oppo;
                String[] Result;
                Move = new String[10];
                Oppo = new String[10];
                Result = new String[10];
                int tie = 0;
                int won = 0;
                int lost = 0;
                String result;
                Scanner in = new Scanner(System.in);
                String userMove;

        for(int i = 1; i < 11; i++) {
                String choice;
                int myMove;
                //Get the user's move through user input
                while (true) {
                try {
                System.out.println("\n"+ i + " round");
                //Check if the user's move is valid (rock, paper, or scissors)
                System.out.println("What is your move?\n 0 = scissors \n 1 = rock \n 2 = paper\n\nYour Choice:");
                    choice = in.next();
                    myMove = Integer.parseInt(choice);
                } catch(Exception e) {
                    System.out.println("Your move isn't valid!\n");
                    continue;
                }

                if((myMove != 0) && (myMove != 1) && (myMove != 2)) {
                        System.out.println("Your move isn't valid!\n");			
                }
                else {
                    break;
                }
                }
                if(myMove == 0){
                    userMove = "scissors";
                }else if(myMove == 1){
                    userMove = "rock";
                }else{
                    userMove = "paper";
                }
                Move [i-1] = userMove;
                        
                //Get a random number in between 0 and 3 and convert it to an integer so that the possibilities are 0, 1, or 2
                Random random = new Random(); //instance of random class
                int upperbound = 3;
                int rand = random.nextInt(upperbound);
                String opponentMove;
                if(rand == 0) {
                        opponentMove = "scissors";
                } else if(rand == 1) {
                        opponentMove = "rock";
                } else {
                        opponentMove = "paper";
                }
                Oppo [i-1] = opponentMove;
                System.out.println("Opponent move: " + opponentMove);	
                //Print the results of the game: tie, lose, win
                if(myMove == rand) {
                        System.out.println("It's a tie!");
                        tie = tie + 1;
                        result = "tie";
                } else if(((myMove==1) && (rand==0)) || ((myMove==0) && (rand==2)) || ((myMove==2) && (rand==1))) {
                        System.out.println("You won!");
                        won = won + 1;
                        result = "won";
                } else {
                        System.out.println("You lost!");
                        lost = lost + 1; 
                        result = "lost";
                }
                Result [i-1] = result;
                
            System.out.print(("\nwin = ")+won+" ");
            System.out.print(("lost = ")+lost+" ");
            System.out.print(("tie = ")+tie+" \n");  
            }

        System.out.printf("%-15s%-20s%-5s", "You move", "Opponent move", "Result"+"\n");
        for (int n = 0; n < Move.length; n++) {
        System.out.printf("%-15s%-20s%-4s", Move [n], Oppo[n], Result[n]+"\n");
        }
    }
}
        

