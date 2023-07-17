package oop;

import java.util.Random;
import java.util.Scanner;

// @author 21WMR02982
public class Hangman {
    
    Scanner keyboard = new Scanner(System.in);
    String wordsArray[] = {"computer","hangman","Malaysia",
            "Vietnam","Thailand","Kuantan","Sashimi","Ipoh","strawberry",
            "redamancy","hello"};
    Random rand = new Random();
    final static int CHANCES = 10;
    
    public void GameRun(){
        // default boolean给false，unless打yes才变true
        boolean playAgain = false;
        do{
            //every round刷新的数据
            System.out.println("=============================== "
                    + "Hangman ================================");
            String randomWord = wordsArray[rand.nextInt(wordsArray.length)];
            String updateWord = randomWord;
            String[] missArray = new String[10];
            int wordLength = randomWord.length();
            int numGuess = 0, numCorrect = 0;
            boolean inputFalse, letterCorrect;
            
            // print word length for hint
            System.out.print("The word has " + randomWord.length() + " letters.");
            // convert randomWord去**
            for(int i = 0; i < wordLength;i++){
                if(randomWord.charAt(i) != ' '){
                    updateWord = printWordState(i,'*',updateWord);
                }
            }
            for(int j = 0; j < CHANCES; j++){
                // print randomWord in *
                System.out.print("\n---------------------------");
                System.out.println("\nWord: "+ updateWord);
                System.out.println("Attemps: " + "["+(10 - j)+"] attempts left" );
                
                do{
                    inputFalse = true;
                    letterCorrect = false;
                    //验证guess的letter, 加入exception handling
                    try{
                        System.out.println("Enter a letter to guess: ");
                        String guess = keyboard.next();
                        
                        char guessInput = guess.charAt(0);

                        for (int i = 0; i < wordLength; i++) {
                            if(updateWord.toUpperCase().charAt(i) == Character.toUpperCase(guessInput)){
                                throw new InputRepeatFoundException();   
                            }
                            if(guess.length() > 1){
                                throw new LetterFoundMoreThanOne();
                            }
                            if(randomWord.toLowerCase().charAt(i) == Character.toLowerCase(guessInput)){
                                updateWord = printWordState(i,randomWord.charAt(i),updateWord);
                                letterCorrect = true;
                            }
                        }
                        numGuess++;
                        if(letterCorrect == true){
                            numCorrect++;
                            System.out.print("Misses: ");
                            for ( int f = 0; f < missArray.length; f++ ){
                                if(missArray[f] != null){
                                    System.out.print( missArray[f] + " ");
                                }
                            }
                        }
                        if(letterCorrect != true){
                            System.out.print("Misses: ");
                            for ( int k = 0; k < missArray.length; k++ ) {
                                missArray[j] = guess;
                                if(missArray[k] != null){
                                    System.out.print( missArray[k] + " ");
                                }
                            }
                        }
                        inputFalse = false;
                    }catch(InputRepeatFoundException ex){
                        System.out.println(ex.getMessage());
                    }catch(LetterFoundMoreThanOne ex){
                        System.out.println(ex.getMessage());
                    }
                }while(inputFalse);
                if(updateWord.equals(randomWord)){
                    break;
                }
                
            }    
            GameScores(updateWord,randomWord,numGuess,numCorrect);
            System.out.println("========================================"
                    + "================================");
            
            // Prompt user to play again
            System.out.println("Do you want to play again? (Yes/No)");
            String answer = keyboard.next();
            if ("yes".equals(answer.toLowerCase())){
                playAgain = true;
            }else{
                playAgain = false;
            }
        }while(playAgain);
        
        System.out.println("\nExiting the game, Back to main menu...");
    }
    
    // ** IMPORTANT **
    // method for change words to * / change * to update each
    public String printWordState(int index, char replaceChar, String word){
        char[] charArray = word.toCharArray();
        charArray[index] = replaceChar;
        return new String(charArray);
    }
    
    // method for calculate game scores
    public void GameScores(String wordSolved, String answer, double guessNum, double correctNum){
            // Show final result
            System.out.print("\n-------------------");
            System.out.println("\nWord: "+ wordSolved);

            if(!(wordSolved.equals(answer))){            
                System.out.println("\nGame over." + "\nUnfortunately, your attempts is used up. "
                        + "The correct answer was '"+answer+"'.");
                System.out.println("You were close to win. Try it harder next time.");
                System.out.println("Number of correct = " + (int)correctNum);
            }
            else{
                System.out.println("Congratulations! You have entered the correct answer. ");
                System.out.println("Number of misses = " + (int)(guessNum - correctNum));
            }

            // calculate, print accuracy and grade 
            double accuracy = (correctNum / guessNum * 100);
            System.out.printf("Your accuracy score = %.2f%%", accuracy);

            if(accuracy == 100.0){System.out.println(" [PERFECT]");}
            else if(accuracy >= 80.0){System.out.println(" [EXCELLENT]");}
            else if(accuracy >= 60.0){System.out.println(" [GOOD]");}
            else if(accuracy >= 30.0){System.out.println(" [SATISFACTORY]");}
            else {System.out.println(" [UNSATISFACTORY]");}
    }
    
}
