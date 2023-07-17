/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

import javax.swing.JOptionPane;

/**
 *
 * @author ZHEN HIN
 */
public class FlipMatch {
    
    public static void FlipMatch(){
        //declaring game rule
        JOptionPane.showMessageDialog(null, "Game Rule: " + 
                "\n1. There are 20 cards is display, player are quired to find match pair by insert 2 number in order"
                + "\n2. If both flipped card are match, cards will remain face-up" + 
                "\n3. If both flipped cards are unmatch, cards will become face-down" 
                + "\n4. Game will be ended after all the cards are face-up" 
                + "\n\n Note: If no input in entered, exit option will be given to player", 
                "Flip & Match", JOptionPane.INFORMATION_MESSAGE);
        
        //declaring all the cards
        char[] cards = {'A', 'A', 'B', 'B', 'C', 'C', 'D', 'D', 'E', 'E', 'F', 
        'F', 'G', 'G', 'H', 'H', 'I', 'I', 'J', 'J'};
        int[] numCards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 
            16, 17, 18, 19, 20};
        char[] displayCards = {'_', '_','_','_','_','_','_','_','_',
            '_','_','_','_','_','_','_','_','_','_','_'};
        
        //shuffle cards in cards[]
        shuffle(cards);
        
        //decclare game status
        gameStatus End = new gameStatus('F');
        
        // showing answer before playing (programmer purpose)
        //displayOutput(numCards, cards);
        
        //crop do while here
        do{
            //print out the cards and start the game
            System.out.println("\nCurrent: ");
            displayOutput(numCards, displayCards);

            //request flip 1st card value
            //try and catch if no value insert, no value choose to exit
            //repeat until there is value
            boolean pass = true;
            int Flip1 = 0;
            int option = JOptionPane.NO_OPTION;

            do{
                try{
                    String Input1 = JOptionPane.showInputDialog
                                    ("Enter 1st cards you wish to flip over");
                    Flip1 = Integer.parseInt(Input1);

                    while(Flip1 < 1 || Flip1 > 20 || displayCards[Flip1 - 1] != '_'){
                        if(Flip1 < 1 || Flip1 > 20){
                            JOptionPane.showMessageDialog(null, 
       "Error detected, insert number not in range. \nOR decimal number is inserted.", 
                                "Error", JOptionPane.INFORMATION_MESSAGE);
                        }else if(displayCards[Flip1 - 1] != '_'){
                            JOptionPane.showMessageDialog(null, 
                                "Error detected, the card selected is flipped over", 
                                "Error", JOptionPane.INFORMATION_MESSAGE);
                        }

                        Input1 = JOptionPane.showInputDialog(
                                "Enter first cards you wish to flip over");
                        Flip1 = Integer.parseInt(Input1);
                    }

                    pass = true;
                }catch(Exception Ex){
                    option = JOptionPane.showConfirmDialog(null, 
                            "No number input detected, Confirm Exit?", "Exit", 
                            JOptionPane.YES_NO_CANCEL_OPTION);

                    if(option == JOptionPane.YES_OPTION){
                                pass = true;
                            }else{
                                pass = false;
                            }
                        }
            }while(pass == false);
            
            //if select comfirm, exit game 
            if(option == JOptionPane.YES_OPTION){
                break;
            }

            //assign number to display array
            int FlipOption;
            FlipOption = Flip1 - 1;
            displayCards[FlipOption] = cards[FlipOption];

            //print out
            System.out.println("\nFlip 1st card: " + Flip1);
            displayOutput(numCards, displayCards);

            //request 2nd card to flip
            int Flip2 = 0;

            do{
                try{
                    String Input2 = JOptionPane.showInputDialog
                                    ("Enter 2nd cards you wish to flip over");
                    Flip2 = Integer.parseInt(Input2);

                    while(Flip2 < 1 || Flip2 > 20 || displayCards[Flip2 - 1] != '_'){
                        if(Flip2 < 1 || Flip2 > 20){
                            JOptionPane.showMessageDialog(null, 
       "Error detected, insert number not in range. \nOR decimal number is inserted.", 
                                "Error", JOptionPane.INFORMATION_MESSAGE);
                        }else if(displayCards[Flip2 - 1] != '_'){
                            JOptionPane.showMessageDialog(null, 
                                "Error detected, the card selected is flipped over", 
                                "Error", JOptionPane.INFORMATION_MESSAGE);
                        }

                        Input2 = JOptionPane.showInputDialog(
                                "Enter 2nd cards you wish to flip over");
                        Flip2 = Integer.parseInt(Input2);
                    }

                    pass = true;
                }catch(Exception Ex){
                    option = JOptionPane.showConfirmDialog(null, 
                            "No input detected, Confirm Exit?", "Exit", 
                            JOptionPane.YES_NO_CANCEL_OPTION);

                    if(option == JOptionPane.YES_OPTION){
                                pass = true;
                            }else{
                                pass = false;
                            }
                        }
            }while(pass == false);
            
            //if select comfirm, exit game
            if(option == JOptionPane.YES_OPTION){
                break;
            }

            //assign 2nd number to display array 
            System.out.println("\nFlip 2nd card: " + Flip2);
            int FlipOption2 = Flip2 - 1;
            displayCards[FlipOption2] = cards[FlipOption2];

            //display Output again
            displayOutput(numCards, displayCards);

            //now find displayed 1st and 2nd card same? if not same assign null to 
            //display array
            if (displayCards[FlipOption] != displayCards[FlipOption2]){
                displayCards[FlipOption] = '_';
                displayCards[FlipOption2] = '_';

                JOptionPane.showMessageDialog(null, 
                        "Sorry, both fliped card are not match" + 
                        "\nCurrent Score: " + End.getScore(), "Notice", 
                        JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Yay, it is both match!" + 
                        "\nCurrent Score: " + End.getScore(), 
                        "Notice", JOptionPane.INFORMATION_MESSAGE);
                End.addScore();
            }

            if(End.getScore() == 10){
                End.setStatus('T');
            }

            System.out.println("End: " + End.getStatus());
        }while(End.getStatus() == 'F');
        
        //the end of the game, annouce score and say bye bye
        JOptionPane.showMessageDialog(null, "That's the end of game! \nYour final score: " 
                + End.getScore() + "\nSee you next time!!", "The end", 
                JOptionPane.INFORMATION_MESSAGE);
       
    }
    
    public static void shuffle(char[] cards){
        char x;
        
        ////using swap method to shuffle the cards
        for(int i=0; i<20; i++){
            int ch = (int) (0 + Math.random() * (19 - 0 + 1));
            int ch1 = (int) (0 + Math.random() * (5 - 0 + 1));
            
            if (cards[ch] != cards[ch1]){
                x = cards[ch];
                cards[ch] = cards[ch1];
                cards[ch1] = x;
            }
        }
    }
    
    public static void displayOutput(int[] numberCards, char[] displayCards){
        int j=0;
            for(int i = 0; i < 5; i++){
                System.out.printf("%15s%3s%15s%3s%15s%3s%15s%3s\n", 
                        numberCards[j] + ": " + displayCards[j], "|", 
                        numberCards[j+1] + ": " + displayCards[j+1], "|", 
                        numberCards[j+2] + ": " + displayCards[j+2], "|", 
                        numberCards[j+3] + ": " + displayCards[j+3], "|");
                
                j+=4;
            }
    }
    
}
