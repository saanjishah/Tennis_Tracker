package com.example.tennistrackerappsaanji;

public class Player {
    private String name;
    private int gamesWon, gamesLost, setsWon, setsLost;
    public Player(String nameParam){
        name = nameParam;
    }
    public String getName(){
        return name;
    }
    public void addGame(boolean won){
        if(won){
            gamesWon++;
            if(gamesWon>=6){
                if(gamesWon >= gamesLost+2){
                    gamesWon = 0;
                    gamesLost = 0;
                    setsWon++;
                }
            }
        }else{
            gamesLost++;
            if(gamesLost>=6){
                if(gamesLost >= gamesWon+2){
                    gamesWon = 0;
                    gamesLost = 0;
                    setsLost++;
                }
            }
        }
    }
    public int getGamesWon(){
        return gamesWon;
    }
    public int getGamesLost(){
        return gamesLost;
    }
    public int getSetsWon(){
        return setsWon;
    }
    public int getSetsLost(){
        return setsLost;
    }
}
