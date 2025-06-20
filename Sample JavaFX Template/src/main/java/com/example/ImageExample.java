package com.example;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;  
import javafx.stage.Stage;
import javafx.util.Duration;  

import javafx.scene.layout.*;

public class ImageExample extends Application {  
   @Override 
   public void start(Stage stage) throws FileNotFoundException {         
      //Creating an image  
      Image image = new Image(getClass().getResource("/Arrows/Adobe Express - file.png").toString());
      Image grayDown = new Image(getClass().getResource("/Arrows 2/graydown.png").toString());
      Image grayLeft = new Image(getClass().getResource("/Arrows 2/grayleft.png").toString());
      Image grayRight = new Image(getClass().getResource("/Arrows 2/grayright.png").toString());
      Image grayUp = new Image(getClass().getResource("/Arrows 2/grayup.png").toString());  
      Image colorLeft = new Image(getClass().getResource("/Arrows 2/left.png").toString());  
      Image colorRight = new Image(getClass().getResource("/Arrows 2/right.png").toString());
      Image colorUp = new Image(getClass().getResource("/Arrows 2/up.png").toString());
      Image colorDown = new Image(getClass().getResource("/Arrows 2/down.png").toString());
      
      //Setting the image view 
       
      HBox hbox = new HBox();
      
      
      double last_time = 10.2;
      
      double[] p1tutorial = {11.07, 12.12, 13.16, 19.11, 20.18, 21.26, 23.03, 29.06, 30.07, 31.11, 32.13, 38.17, 39.07, 39.24, 41.02, 41.22, 42.09, 48.07, 48.2, 49.01, 49.11};


      ImageView imageView = new ImageView(image); 
      ImageView imageView2 = new ImageView(image);
      //Setting the position of the image 
      imageView.setX(0); 
      imageView.setY(800); 
      

      imageView2.setX(800); 
      imageView2.setY(800); 
      //setting the fit height and width of the image view 
      imageView.setFitHeight(200); 
      imageView.setFitWidth(200); 

      imageView2.setFitHeight(200);
      imageView2.setFitWidth(200);
      
      //Setting the preserve ratio of the image view 
      imageView.setPreserveRatio(true); 
      imageView2.setPreserveRatio(true);
      TranslateTransition translate_move = new TranslateTransition();
      FadeTransition translate_invis = new FadeTransition(Duration.seconds(2));
      TranslateTransition translate2 = new TranslateTransition();
      //translate.setNode(imageView);
      translate_move.setDuration(Duration.millis((15.32-11.07) * 1000));
      
      translate_move.setByY(-800);

      translate_invis.setToValue(0.0);

      translate2.setNode(imageView2);
      translate2.setDuration(Duration.millis((13.16-12.12) * 1000));
      translate2.setByY(-800);

      TranslateTransition translate_move_down = new TranslateTransition();
      FadeTransition translate_vis = new FadeTransition(Duration.seconds(2));
      //translate.setNode(imageView);
      translate_move_down.setDuration(Duration.millis((15.32-11.07) * 10));
      
      translate_move_down.setByY(800);

      translate_vis.setToValue(1.0);


      SequentialTransition sequentialTransition = new SequentialTransition(imageView, translate_move,translate_invis,translate_move_down,translate_vis);

      sequentialTransition.play();
      
      hbox.getChildren().addAll(imageView,imageView2);
      //translate.play();
      translate2.play();

      ImageView leftCutOut = new ImageView(grayLeft);
      ImageView rightCutOut = new ImageView(grayRight);
      ImageView upCutOut = new ImageView(grayUp);
      ImageView downCutOut = new ImageView(grayDown);

      
      //Creating a Group object  
      Group root = new Group(leftCutOut,rightCutOut, upCutOut, downCutOut,imageView,imageView2);  
      
      //Creating a scene object 
      Scene scene = new Scene(hbox, 1000, 1000);  
      
      //Setting title to the Stage 
      stage.setTitle("Loading an image");  
      
      //Adding scene to the stage 
      stage.setScene(scene);
      stage.setTitle("JavaFX AnimationTimer Example");
      //Displaying the contents of the stage 
      stage.show(); 


   }  
   public static void main(String args[]) { 
        launch(args); 
   } 
}