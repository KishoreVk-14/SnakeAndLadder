package com.myproject.snackandladder;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

public class Player {

    private Circle coin;

    private int position;

    private String name;

    private static Board gameBoard=new Board();

    public Circle getCoin() {
        return coin;
    }

    public void setCoin(Circle coin) {
        this.coin = coin;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(int tileSize, Color coinColor, String playerName){
        coin=new Circle(tileSize/2);
        coin.setFill(coinColor);
        position=0;
        movePlayer(1);
        name=playerName;


    }

    public void movePlayer(int diceValue){
        if(position+diceValue<=100){
            position+=diceValue;
            TranslateTransition firstMove=translateAnimation(diceValue),secondMove=null;
            translateAnimation(diceValue);
            int newPosition= gameBoard.getNewPosition(position);
             if(newPosition!=position && newPosition!=-1){
                 position=newPosition;
                 secondMove=translateAnimation(6);
             }
             if (secondMove==null){
                 firstMove.play();
             }else{
                 SequentialTransition sequentialTransition=new SequentialTransition(firstMove,new PauseTransition(Duration.millis(1000)),secondMove);
                 sequentialTransition.play();
             }
        }
//        int x= gameBoard.getXCoordinate(position);
//        int y= gameBoard.getYCoordinate(position);
//        coin.setTranslateX(x);
//        coin.setTranslateY(y);

    }

    boolean isWinner(){
        if(position==100){
            return true;
        }
        return false;
    }
    public void startingPosition(){
        position=0;
        movePlayer(1);
    }

    private TranslateTransition translateAnimation(int diceValue){
        TranslateTransition animate=new TranslateTransition(Duration.millis(200*diceValue),coin);
        animate.setToX(gameBoard.getXCoordinate(position));
        animate.setToY(gameBoard.getYCoordinate(position));
        animate.setAutoReverse(false);
        return animate;

    }
}
