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

public class Final_Project extends Application {
    private MediaPlayer soundPlayer;
    private MediaPlayer mediaPlayer;

    @Override 
    public void start(Stage stage) throws FileNotFoundException {
        soundPlayer = new MediaPlayer(new Media(getClass().getResource("/ButtonPress.mp3").toString()));

        Image backgroundIm = new Image(getClass().getResource("/Start.png").toString());

        Pane pane = new Pane();

        ImageView backgroundView = new ImageView(backgroundIm);
        backgroundView.setFitWidth(backgroundIm.getWidth());
        backgroundView.setFitHeight(backgroundIm.getHeight());
        pane.getChildren().add(backgroundView);

        // Black overlay for fade-to-black
        Rectangle blackOverlay = new Rectangle(backgroundIm.getWidth(), backgroundIm.getHeight());
        blackOverlay.setFill(Color.BLACK);
        blackOverlay.setOpacity(0);
        pane.getChildren().add(blackOverlay);

        // Text fields for names
        TextField player1Field = new TextField();
        player1Field.setPromptText("Enter Player 1 Name");

        TextField player2Field = new TextField();
        player2Field.setPromptText("Enter Player 2 Name");

        Label instruction = new Label("Enter both player names and press ENTER to start");
        instruction.setTextFill(Color.WHITE);

        VBox inputBox = new VBox(10, instruction, player1Field, player2Field);
        inputBox.setAlignment(Pos.CENTER);
        inputBox.setLayoutX(backgroundIm.getWidth() / 2 - 700);
        inputBox.setLayoutY(backgroundIm.getHeight() - 400);
        pane.getChildren().add(inputBox);

        FadeTransition fadeToBlack = new FadeTransition(Duration.seconds(2), blackOverlay);
        fadeToBlack.setFromValue(0.0);
        fadeToBlack.setToValue(1.0);

        Scene scene = new Scene(pane, backgroundIm.getWidth(), backgroundIm.getHeight());

        // Key press: only trigger fade if both names entered
        scene.setOnKeyPressed(event -> {
            //String p1 = player1Field.getText().trim();
            //String p2 = player2Field.getText().trim();
            if (!player1Field.getText().trim().isEmpty() && !player2Field.getText().trim().isEmpty()) {
                mediaPlayer.stop();
                soundPlayer.play();
                

                fadeToBlack.play();
            } else {
                instruction.setText("Please enter both names before starting.");
            }
        });

        fadeToBlack.setOnFinished(e -> {
            try {
                SelectScreen.setPlayerNames(player1Field.getText().trim(), player2Field.getText().trim());
                new SelectScreen().start(stage); 
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
    });

        // Background music
        String musicFile = getClass().getResource("/LobbyMusic.mp3").toString(); 
        Media media = new Media(musicFile);
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(1);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        

        stage.setScene(scene);
        stage.setTitle("Thursday Night Funk'n");
        stage.show(); 
        pane.requestFocus();
    }

    public static void main(String[] args) { 
        launch(args); 
    } 
}
