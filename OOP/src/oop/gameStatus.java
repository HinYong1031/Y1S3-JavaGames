/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop;

/**
 *
 * @author ZHEN HIN
 */
public class gameStatus {
    char State;
    int Score = 0;
    
    gameStatus(char Continue){
        State = Continue;
    }
    
    void setStatus(char Continue){
        State = Continue;
    }
    
    void addScore(){
        Score++;
    }
    
    char getStatus(){
        return State;
    }
    
    int getScore(){
        return Score;
    }
}
