package com.example;

public class Player {
    private String name;
    private String character;
    private int score;
    private String side;


    public Player(String n, String ch, int s, String p){
        name = n;
        character = ch;
        score = s;
        side = p;
    }

    public String getSide(){
        return side;
    }

    public int getScore(){
        return score;
    }

    public String getName(){
        return name;
    }

    public String getCharacter(){
        return character;
    }

    public void addScore(int val){
        score += val;
    }

    public void reset(){
        name = "";
        character = "";
        score = 0;
        side = "";
        
    }




    public static void main(String[] args) {
        //launch(args);
    }
}
