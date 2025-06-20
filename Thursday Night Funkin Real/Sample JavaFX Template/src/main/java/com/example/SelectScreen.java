package com.example;

import java.io.FileNotFoundException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SelectScreen extends Application {
    private MediaPlayer soundPlayer;
    private MediaPlayer mediaPlayer;

    private static String playerName1; private static String playerName2;


    public static void setPlayerNames(String p1, String p2){
        playerName1 = p1;
        playerName2 = p2;
    }
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        // Load audio
        soundPlayer = new MediaPlayer(new Media(getClass().getResource("/ButtonPress.mp3").toString()));
        String musicFile = getClass().getResource("/Selectmusic.mp3").toString(); 
        mediaPlayer = new MediaPlayer(new Media(musicFile));
        mediaPlayer.setVolume(0.6);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); 
        mediaPlayer.play();

        // Load background image
        Image backgroundIm = new Image(getClass().getResource("/All.png").toString());
        ImageView backgroundView = new ImageView(backgroundIm);
        backgroundView.setFitWidth(backgroundIm.getWidth()+10);
        backgroundView.setFitHeight(backgroundIm.getHeight()+10);

        Rectangle blackOverlay = new Rectangle(20000, 10000);
        blackOverlay.setFill(Color.BLACK);
        blackOverlay.setOpacity(0);

        Pane pane = new Pane();
        pane.getChildren().addAll(backgroundView, blackOverlay); 


        FadeTransition fadeToBlack = new FadeTransition(Duration.seconds(2), blackOverlay);
        fadeToBlack.setFromValue(0.0);
        fadeToBlack.setToValue(1.0);


        Scene scene = new Scene(pane, backgroundIm.getWidth(), backgroundIm.getHeight());

        scene.setOnKeyPressed(event -> {
            String key = event.getText();
            if (key.equals("1") || key.equals("2") || key.equals("3")) {
                soundPlayer.stop(); 
                soundPlayer.play();
                System.out.println("User pressed: " + key);
                GameLayout.setPlayerNames(playerName1, playerName2);
                if (key.equals("1")) {
                    mediaPlayer.stop(); 
                    fadeToBlack.play();
        
                    fadeToBlack.setOnFinished(e -> {
                        
                        try {

                            GameLayout.setBackgroundImageName("/background drawing.png");
                            GameLayout.setSongName("/tutorial.mp3");
                            GameLayout.setSongStopTime(48.1);
                            GameLayout.setMoveSpeed(2.7);

                            int[] playerMoves = {0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1};
                            GameLayout.setPlayerMoves(playerMoves);

                            char[] tempCommands = {'l','r','l','r','l','r','l','r', 'u','d','u', 'd', 'u','d','u', 'd', 'l','u','d','r', 'l','u','d','r', 'd', 'd', 'u', 'd', 'd', 'r','d', 'd', 'u', 'd', 'd', 'r'};
                            GameLayout.setCommands(tempCommands);
                            
                            double[] endTimes = {11.16, 12.3365, 13.513, 14.7895, 15.83, 17.0065, 18.183, 19.3595, 20.76, 21.9365, 23.113, 24.2895, 25.6, 26.7765, 27.953, 29.1295, 30.76, 31.9365, 33.113, 34.2895, 35.55, 36.7265, 37.903, 39.0795, 40.056, 40.706, 41.356, 42.6795, 43.3295, 43.9795, 44.386, 45.036, 45.686, 47.0095, 47.6595, 48.2095};

                            double[] tempAppearTimes = new double[endTimes.length];
                            GameLayout.setEndTimes(endTimes);

                            for (int i = 0; i < endTimes.length; i++){
                                tempAppearTimes[i] = endTimes[i] - 2.7;
                            }

                            //double[] tempAppearTimes = {8.46,9.6365,10.8130,12.0895,18.06,19.2365,20.4130,21.5895,28.06,29.2365,30.4130,31.5895};
                            GameLayout.setAppearTimes(tempAppearTimes);
                            
                            new GameLayout().start(stage); // Use current stage
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    });
                }
                else if (key.equals("2")) {
                    mediaPlayer.stop(); 
                    fadeToBlack.play();
                    fadeToBlack.setOnFinished(e -> {
                        try {

                            GameLayout.setBackgroundImageName("/casinbg.png");
                            GameLayout.setSongName("/casin.mp3");
                            GameLayout.setSongStopTime(22);
                            GameLayout.setMoveSpeed(2.3);

                            int[] playerMoves = {0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1};
                            GameLayout.setPlayerMoves(playerMoves);

                            char[] tempCommands = {'l','r','l','r','l','r','l','r', 'u','d','u', 'd', 'u','d','u', 'd', 'l','u','d','r', 'l','u','d','r', 'd', 'd', 'u', 'd', 'd', 'r','d', 'd', 'u', 'd', 'd', 'r'};
                            GameLayout.setCommands(tempCommands);
                            
                            double[] casinEndTimes = {5.15, 5.50, 6.25, 6.50, 6.75, 7.25, 7.75, 8.33, 8.67, 9.20, 9.40, 9.60, 9.80, 10.00, 10.20, 10.40, 10.60, 11.00, 11.25, 11.50, 11.75, 12.20, 12.40, 12.60, 12.80, 13.00, 13.20, 13.40, 13.60, 13.80, 14.17, 14.33, 14.50, 14.67, 15.00, 15.20, 15.40, 15.60, 15.80, 16.00, 16.20, 16.40, 16.60, 16.80, 17.00, 17.20, 17.40, 17.60, 17.80, 18.17, 18.33, 18.50, 18.67, 19.00, 19.33, 19.67, 19.90, 20.09};
                            
                            GameLayout.setEndTimes(casinEndTimes);

                            double [] casinAppearTimes = new double[casinEndTimes.length];
                            for (int i = 0; i < casinEndTimes.length; i++){
                                casinAppearTimes[i] = casinEndTimes[i] - 2.1;
                            }

                            //double[] tempAppearTimes = {8.46,9.6365,10.8130,12.0895,18.06,19.2365,20.4130,21.5895,28.06,29.2365,30.4130,31.5895};
                            GameLayout.setAppearTimes(casinAppearTimes);

                            new GameLayout().start(stage); // Use current stage
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        
                        }
                    });
                }
            }
        });

        stage.setScene(scene);
        stage.setTitle("Thursday Night Funk'n - Select Screen");
        stage.show(); 
        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args); 
    }
}
