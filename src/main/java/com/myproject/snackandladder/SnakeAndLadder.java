package com.myproject.snackandladder;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeAndLadder extends Application {

    public static final int tileSize=40,height=12,width=12;

    public static final int buttonLine=tileSize*height+25,infoLine=buttonLine-15;

    private static Dice dice=new Dice();

    private  Player playerOne,playerTwo;

    private boolean gameStarted=false,playerOneTurn=false,playerTwoTurn=false;
    public Pane createContent(){
        Pane root=new Pane();
        root.setPrefSize(width*tileSize,height*tileSize +50);


        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile=new Tile(tileSize);
                tile.setTranslateX(i*tileSize);
                tile.setTranslateY(j*tileSize);
                root.getChildren().add(tile);
            }
        }
        Image img=new Image("C:\\Users\\kisho\\IdeaProjects\\SnackAndLadder\\src\\main\\istockphoto-577332576-1024x1024.jpg");
        ImageView board=new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tileSize);
        board.setFitWidth(width*tileSize);


        Button playerOneButton=new Button("Player One");
        Button playerTwoButton=new Button("Player Two");
        Button startButton=new Button("Start");
        playerOneButton.setTranslateX(20);
        playerOneButton.setTranslateY(buttonLine);
        playerOneButton.setDisable(true);
        playerTwoButton.setTranslateX(380);
        playerTwoButton.setTranslateY(buttonLine);
        playerTwoButton.setDisable(true);
        startButton.setTranslateX(200);
        startButton.setTranslateY(buttonLine);

        Label playerOneLabel=new Label("Your Turn!!");
        Label playerTwoLabel=new Label("Your Turn!!");
        Label startLabel=new Label("Start Game");

        playerOneLabel.setTranslateX(20);
        playerOneLabel.setTranslateY(infoLine);
        playerTwoLabel.setTranslateX(380);
        playerTwoLabel.setTranslateY(infoLine);
        startLabel.setTranslateX(200);
        startLabel.setTranslateY(infoLine);

        playerOne =new Player(tileSize, Color.BLACK,"Kishore");
        playerTwo=new Player(tileSize-5,Color.AQUA,"Keerthi");

        playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(playerOneTurn){
                        int diceValue=dice.getRolledDice();
                        startLabel.setText("Dice Value : "+ diceValue);
                        playerOne.movePlayer(diceValue);
                        if(playerOne.isWinner()){
                            startLabel.setText("Player Won!!!");
                            playerOneTurn=false;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");

                            playerTwoTurn=true;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");
                            startButton.setDisable(false);
                            startButton.setText("Restart Game");
                        }else {
                            playerOneTurn=false;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");

                            playerTwoTurn=true;
                            playerTwoButton.setDisable(false);
                            playerTwoLabel.setText("Your Turn");
                        }

                    }
                }

            }
        });

        playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStarted){
                    if(playerTwoTurn){
                        int diceValue=dice.getRolledDice();
                        startLabel.setText("Dice Value : "+ diceValue);
                        playerTwo.movePlayer(diceValue);
                        if(playerTwo.isWinner()){
                            startLabel.setText("Player Won!!!");
                            playerOneTurn=false;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");

                            playerTwoTurn=true;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");
                            startButton.setDisable(false);
                            startButton.setText("Restart Game");
                        }else{
                            playerOneTurn=true;
                            playerOneButton.setDisable(false);
                            playerOneLabel.setText("Your Turn");

                            playerTwoTurn=false;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");
                        }

                    }
                }

            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted=true;
                startLabel.setText("Game Started");
                startLabel.setDisable(true);
                startButton.setDisable(true);
                playerOneTurn=true;
                playerOneLabel.setText("Your Turn");
                playerOneButton.setDisable(false);
                playerTwoTurn=false;
                playerTwoLabel.setText("");
                playerTwoButton.setDisable(true);
                playerOne.startingPosition();
                playerTwo.startingPosition();

            }

        });


        root.getChildren().addAll(board,playerOneButton,playerTwoButton,startButton,playerOneLabel,playerTwoLabel,startLabel,playerOne.getCoin(),playerTwo.getCoin());


        return root;
    }
    @Override
    public void start(Stage stage) throws IOException {

        Scene scene = new Scene(createContent());
        stage.setTitle("Snake And Ladder!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}