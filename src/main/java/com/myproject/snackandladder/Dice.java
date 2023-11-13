package com.myproject.snackandladder;

public class Dice {

    public int getRolledDice(){
        return (int) (Math.random() * 6) + 1;
    }
}
