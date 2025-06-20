package com.example;

import java.io.FileNotFoundException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class hp extends Application {

    @Override 
    public void start(Stage stage) throws FileNotFoundException {

        //init images
        Image healthBar = new Image(getClass().getResource("/Start.png").toString());
        Image miniBF = new Image(getClass().getResource("/bf.png").toString());
        Image miniHuggy = new Image(getClass().getResource("/huggers.png").toString());
        Image deadBF = new Image(getClass().getResource("/yay.png").toString());
        Image deadHuggy = new Image(getClass().getResource("/huggydeath.png").toString());
        Pane pane = new Pane();

        ImageView healthView = new ImageView(healthBar);
        healthView.setFitWidth(healthBar.getWidth());
        healthView.setFitHeight(healthBar.getHeight());
        healthView.setLayoutX(100);
        healthView.setLayoutY(100);
        pane.getChildren().add(healthView);

        // color in the health bar
        Rectangle leftHP = new Rectangle(1, healthBar.getHeight());
        leftHP.setFill(Color.BLUE);
        leftHp.setLayoutX(100);
        leftHp.setLayoutY(100);
        pane.getChildren().add(leftHP);
        
        Rectangle rightHP = new Rectangle(1, healthBar.getHeight());
        rightHP.setFill(Color.GREENYELLOW);
        rightHp.setLayoutX(100);
        rightHp.setLayoutY(100);
        pane.getChildren().add(rightHP);

        //add heads
        miniBF.setFitWidth(healthBar.getWidth() / 8);
        miniBF.setFitHeight(healthBar.getHeight * 2.5);
        healthView.setLayoutX(100);
        healthView.setLayoutY(100);

        miniHuggy.setFitWidth(healthBar.getWidth / 8);
        miniHuggy.setFitHeight(healthBar.getHeight * 2.5);
        healthView.setLayoutX(100);
        healthView.setLayoutY(100);

        Label scoreDisplay1 = new Label("Score:");
        scoreDisplay1.setTextFill(Color.BLACK);

        Label scoreDisplay2 = new Label("Score:");
        scoreDisplay2.setTextFill(Color.BLACK);
        

        Scene scene = new Scene(pane, healthBar.getWidth(), healthBar.getHeight());

        stage.setScene(scene);
        stage.setTitle("Thursday Night Funk'n");
        stage.show(); 
        pane.requestFocus();
    }

    public double updateScore(double score1, double score2) {
        double total = score1 + score2;
        leftHp.setFitWidth(healthBar.getWidth() / (total / score1));
        rightHp.setLayoutX(healthBar.getWidth() / (total / score1));
        rightHp.setFitWidth(healthBar.getWidth() / (total / score2));

    }

    public static void main(String[] args) { 
        launch(args); 
    } 
}
