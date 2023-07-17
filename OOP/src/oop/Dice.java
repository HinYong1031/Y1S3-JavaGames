/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oop;
import java.util.*;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author yuton
 */
public class Dice {

public static int checkInt(){
     String choice;
  int answer;
while (true) {
    try {
        System.out.println("1.Play ");
        System.out.println("2.Exit to menu");
       System.out.println("Enter your choice: ");
        Scanner scan = new Scanner(System.in);
        choice = scan.next();
        answer = Integer.parseInt(choice);
    } catch(Exception e) {
        System.out.println("Invalid input! Please select '1' or '2':");
        continue;
    }

    if (answer != 1 && answer != 2) {
        System.out.println("Invalid input! Please select '1' or '2':");
    }
    else {
        break;
    }
}
return answer;
}
public static String checkChar(){
     
      String input;
      char answerr;
   while (true) {
    try {
        System.out.println("Do you want to continue?(Y/N): ");
         Scanner sc = new Scanner(System.in);
        input=sc.next(); 
        answerr = input.charAt(0);
    } catch(Exception e) {
        System.out.println("Invalid input! Please enter 'Y' or 'N':");
        continue;
    }

    if (answerr != 'Y' && answerr != 'N' && answerr != 'y' && answerr != 'n') {
        System.out.println("Invalid input! Please enter 'Y' or 'N':");
    }
    else {
        break;
    }

}
return input;
}

    public static void main() {
        boolean play = false;
 do{
System.out.print("Welcome to Five Dice Game! \n");    
Dice inputMenu = new Dice();
int valid = inputMenu.checkInt();
 
//Game
if(valid == 1){ 
        String input;//input of continued    
         do{         
       int userWin = 0,cpuWin = 0,Draw = 0;
       System.out.println("--------------------------------------------------");
       System.out.print(" Round |");
       System.out.print("    User");
        System.out.print("     |");
        System.out.print("   Computer \n");
        System.out.println("--------------------------------------------------");
        
for(int x = 0; x<10;x++){
        Random ranNum = new Random();

        int[] U=new int[5];
        int[] C=new int[5];
        int y=x+1;
        if(y ==10){System.out.print("   "  + y + "  |  ");}
        else {System.out.print("   "  + y + "   |  ");}
        for (int i = 0; i < U.length; i++) {
 
            int user = ranNum.nextInt(6) + 1;   
            U[i]=user;
            System.out.print(user);
            System.out.print(" ");
        }
         System.out.print(" |  ");
         for (int i = 0; i < C.length; i++) {
 
            int cpu  = ranNum.nextInt(6) + 1;
            C[i]=cpu;
            System.out.print(cpu);
            System.out.print(" ");
        }
       
          Map<Integer,Integer> User = new HashMap<>();
      int frequency = 0 ;int pair=0; int maxElement = 0;
      for(int i = 0 ; i < U.length;i++) {
          int element = U[i];
          User.put(element, User.getOrDefault(element, 0) +1);//compare value 
      }//for
//      System.out.println(User); //check value

// Using entrySet() to get the entry's of the map
      Set<Entry<Integer,Integer>> entrySet = User.entrySet();

      for(Entry<Integer,Integer> entry : entrySet) {
          // Using the getKey to get key of the entry element
          // Using the getValue to get value of the entry element
          if(entry.getValue() > frequency) {frequency = entry.getValue();maxElement = entry.getKey();}
          if(entry.getValue() == 2){pair += 1;} //example: {1=1,2=1,3=1,5=2},then it will record one piar.If {1=2,2=1,3=2},it will record two pair.  
      }//for
      
//    System.out.println("max element => " + maxElement);//check value but fail
//    System.out.println("frequency => " + frequency); //check value
//    System.out.println("test => " + pair);//check value
     Map<Integer,Integer> Cpu = new HashMap<>();
      int frequen = 0 ; int pair2=0; int maxElement2 = 0 ;
      for(int i = 0 ; i < C.length;i++) {
          int element2 = C[i];
          Cpu.put(element2, Cpu.getOrDefault(element2, 0) +1);
      }//for
      Set<Entry<Integer,Integer>> entrySet2 = Cpu.entrySet();

      for(Entry<Integer,Integer> entry : entrySet2) {
          if(entry.getValue() > frequen) {frequen = entry.getValue();maxElement2 = entry.getKey();}
          if(entry.getValue() == 2){pair2 += 1;}
      }//for
      
//    System.out.println("max element => " + maxElement2);//check value but fail
//    System.out.println("frequency => " + frequen);//check value
//    System.out.println("test => " + pair2);//check value

    if (frequency == frequen && pair > pair2){
     userWin += 1;
     System.out.println("  User win");
    }
    else if(frequen == frequency && pair2 > pair){
    cpuWin += 1;
    System.out.println("  Computer win");
    }
    else if(frequency > frequen){
     userWin += 1;
     System.out.println("  User win");
    }
    else if(frequen > frequency){
    cpuWin += 1;
    System.out.println("  Computer win");
    }
    else{
   Draw += 1;
   System.out.println("  Draw");
}
    
    System.out.println("--------------------------------------------------");
}
  //result of 10 rounds
   System.out.println("    User win(rounds)=> " + userWin);
   System.out.println("Computer win(rounds)=> " + cpuWin);
   System.out.println("        Draw(rounds)=> " + Draw);
   if(userWin>cpuWin){
   System.out.println("User win!!!(swap up to watch result)");
   }
   else if(userWin<cpuWin){
         System.out.println("Computer win!!!(swap up to watch result)");
         }
   else{
         System.out.println("Draw!!!(swap up to watch result)");
   }
   input = inputMenu.checkChar();//ask user to continue
      
}while(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("Y"));
        System.out.println("Thanks for playing.");
        System.out.println("Exiting the game, back to main menu...");
        play = false;
    }
        else if(valid == 2){
        System.out.println("Thanks for coming.");
        System.out.println("Exiting the game, back to main menu...");
        play = false;
        }
 }while(play);
    }
}

//another way to check input//
//        int choice =0;      
//       do {
//        System.out.println("1.Play ");
//        System.out.println("2.Exit ");
//        System.out.println("Enter your choice: ");
//        Scanner input = new Scanner (System.in);
//        while(!input.hasNextInt()){
//        System.out.println("Input wrong!Plese Enter your choice again."); 
//        System.out.println("1.Play ");
//        System.out.println("2.Exit ");
//        System.out.println("Enter your choice: ");
//        input.nextLine();
//        }
//       choice = input.nextInt();
//        if(choice !=1 || choice !=2){
//            System.out.println("Input wrong!Enter your choice again.");
//        }
//} while (!(choice >= 1 && choice <= 2));