package com.example;

import java.io.FileNotFoundException;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.time.chrono.*;

public class Characters extends Application{
    
    private static String side;
    private static String character;
    private static Image bgImage;
    @Override 
    public void start(Stage stage/*String character, String side*/) throws FileNotFoundException {  
        int pos;
        if (side == "l"){
            pos = 40;
        }else{
            pos = 200;
        }
        //set character
        Image charIm;

        if (character == "boyfriend"){
            charIm = new Image(getClass().getResource("Adobe Express - file.png").toString());
        } else if (character == "huggy") {
            charIm = new Image(getClass().getResource("Screenshot_2025-05-15_at_1.21.29_PM-removebg-preview.png").toString());
        } else {
            charIm = new Image(getClass().getResource("Adobe Express - file.png").toString());
        }
        Pane pane = new Pane();
         

        ImageView charView = new ImageView(charIm);
        charView.setFitWidth(charIm.getWidth());
        charView.setFitHeight(charIm.getHeight());
        charView.setLayoutX(pos);
        charView.setLayoutY(100);
        pane.getChildren().add(charView); 
        Scene scene = new Scene(pane, charIm.getWidth(), charIm.getHeight());  
        scene.setOnKeyPressed(event ->  {

            @Override
            public record handle(KeyEvent event) { 
                if (character == "boyfriend"){
                    if (event.getCode() == KeyCode.RIGHT) {
                        charIm.setImage(getClass().getResource("Remove background project (7).png").toString());
                    } else if (event.getCode() == KeyCode.LEFT) {
                        charIm.setImage(getClass().getResource("Remove background project (6).png").toString());
                    } else if (event.getCode() == KeyCode.UP) {
                        charIm.setImage(getClass().getResource("Remove background project (5).png").toString());
                    } else if (event.getCode() == KeyCode.DOWN) {
                        charIm.setImage(getClass().getResource("Adobe Express - file (7).png").toString());
                    }
                } else if (character == "huggy"){
                    if (event.getCode() == KeyCode.W) {
                        charIm.setImage(getClass().getResource("Screenshot_2025-05-15_at_1.22.35_PM-removebg-preview.png").toString());
                    } else if (event.getCode() == KeyCode.A) {
                        charIm.setImage(getClass().getResource("Screenshot_2025-05-15_at_1.24.22_PM-removebg-preview.png").toString());
                    } else if (event.getCode() == KeyCode.S) {
                        charIm.setImage(getClass().getResource("Screenshot_2025-05-15_at_1.23.22_PM-removebg-preview.png").toString());
                    } else if (event.getCode() == KeyCode.D) {
                        charIm.setImage(getClass().getResource("huggyright.png").toString());
                    }
                }
            }
        });




        

        stage.setScene(scene);
        //Displaying the contents of the stage 
        
        stage.show(); 
        pane.requestFocus();
        
        
    }

    public static void setBgImage(Image image)
    {
        bgImage = image;
    }
    public static void setCharacter(String character_){
        character = character_;
    }

    public static void setSide(String s) {
        side = s;
    }

    public static void main(String args[]) { 
        
        launch(args); 
    } 
    
}

