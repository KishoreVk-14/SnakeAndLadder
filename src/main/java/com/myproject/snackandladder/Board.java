package com.myproject.snackandladder;

import javafx.util.Pair;

import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>> positionCoordinates;
    ArrayList<Integer>snakeAndLadder;

    public Board(){
        positionCoordinates =new ArrayList<>();
        populate();
        populteSnakeAndLadder();
    }
    private void populate(){
        positionCoordinates.add(new Pair<>(0,0));
        for (int i = 0; i <SnakeAndLadder.height ; i++) {
            for (int j = 0; j < SnakeAndLadder.width; j++) {
                int xcord=0;
                if(i%2==0){
                    xcord=j*SnakeAndLadder.tileSize+SnakeAndLadder.tileSize/2;
                }else{
                    xcord=SnakeAndLadder.tileSize*SnakeAndLadder.height-(j*SnakeAndLadder.tileSize)-(SnakeAndLadder.tileSize/2);
                }
                int ycord=SnakeAndLadder.tileSize*SnakeAndLadder.height-(i*SnakeAndLadder.tileSize)-(SnakeAndLadder.tileSize/2);
                positionCoordinates.add(new Pair<>(xcord,ycord));
            }
        }
    }

    int getNewPosition(int currentPosition){
        if(currentPosition>0 && currentPosition<=100){
            return snakeAndLadder.get(currentPosition);
        }
        return -1;
    }
    int getXCoordinate(int position){
        if(position>=1 && position<=100)
            return positionCoordinates.get(position).getKey();
        return -1;
    }

    int getYCoordinate(int position){
        if(position>=1 && position<=100)
            return positionCoordinates.get(position).getValue();
        return -1;
    }

    private void populteSnakeAndLadder(){
         snakeAndLadder=new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeAndLadder.add(i);
        }
        snakeAndLadder.set(2,23);
        snakeAndLadder.set(6,45);
        snakeAndLadder.set(20,59);
        snakeAndLadder.set(43,17);
        snakeAndLadder.set(50,5);
        snakeAndLadder.set(52,72);
        snakeAndLadder.set(57,96);
        snakeAndLadder.set(71,92);
        snakeAndLadder.set(73,15);
        snakeAndLadder.set(84,58);
        snakeAndLadder.set(87,49);
        snakeAndLadder.set(98,40);


    }
}
