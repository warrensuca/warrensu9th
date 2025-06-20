package com.example;

import java.io.FileInputStream; 
import java.io.FileNotFoundException;
import java.security.Key;
//import java.sql.Time;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


import javafx.scene.text.*;
import javafx.application.Application; 
import javafx.scene.Group; 
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;  

import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.animation.*;
public class GameLayout extends Application{
    
    
    private static String songName;
    private static double[] endTimes;
    private static double songStopTime;
    private static int[] playerMoves;
    private static String backgroundImgName;
    private static char[] commands;
    private static double[] appearTimes;
    private static double moveSpeed;
    private static String playerName1; private static String playerName2;


    private MediaPlayer song;

    
    private Random rand = new Random();
    private Image grayDown;
    private Image grayLeft;
    private Image grayRight;
    private Image grayUp;  
    private Image colorLeft;  
    private Image colorRight;
    private Image colorUp;
    private Image colorDown;
    private int lastIdx;
    private Image backgroundImg;
    private ImageView bfView;
    private ImageView huggyView;

    //private Image backgroundIm = new Image(getClass().getResource("/background drawing.png").toString());

    //Setting the image view 
    

    
    
    private Pane pane;
    
    private Image[] cutouts;
    

    private HashMap<Character, Image> imagesMap;
    private HashMap<Character, Integer> posMap;

    //Image image = new Image(getClass().getResource("/Arrows/Adobe Express - file.png").toString());
    
    
    
    public GameLayout(){

        
    }
    public static void setSongName(String tempSongName){
        songName = tempSongName;
    }

    public static void setEndTimes(double[] tempEndTimes){
        endTimes = tempEndTimes;
    }

    public static void setSongStopTime(double tempSongStopTime){
        songStopTime = tempSongStopTime;
    }
    public static void setPlayerMoves(int[] tempPlayerMoves){
        playerMoves = tempPlayerMoves;
    }
    public static void setBackgroundImageName(String tempBackgroundImageName){
        backgroundImgName = tempBackgroundImageName;
    }

    public static void setCommands(char[] tempCommands){
        commands = tempCommands;
    }

    public static void setAppearTimes(double[] tempAppearTimes){
        appearTimes = tempAppearTimes;
    }

    public static void setMoveSpeed(double tempMoveSpeed){
        moveSpeed = tempMoveSpeed;
    }

    public static void setPlayerNames(String p1, String p2){
        playerName1 = p1;
        playerName2 = p2;
    }

    @Override 
    public void start(Stage stage) throws FileNotFoundException, InterruptedException {  

        song = new MediaPlayer(new Media(getClass().getResource(songName).toString()));
        song.setStopTime(Duration.seconds(songStopTime));
        song.play();
        long startTime = System.currentTimeMillis();


        grayDown = new Image(getClass().getResource("/Arrows 2/graydown.png").toString());
        grayLeft = new Image(getClass().getResource("/Arrows 2/grayleft.png").toString());
        grayRight = new Image(getClass().getResource("/Arrows 2/grayright.png").toString());
        grayUp = new Image(getClass().getResource("/Arrows 2/grayup.png").toString());  
        colorLeft = new Image(getClass().getResource("/Arrows 2/left.png").toString());  
        colorRight = new Image(getClass().getResource("/Arrows 2/right.png").toString());
        colorUp = new Image(getClass().getResource("/Arrows 2/up.png").toString());
        colorDown = new Image(getClass().getResource("/Arrows 2/down.png").toString());
        
        lastIdx = -1;
        pane = new Pane();
        //private Image backgroundIm = new Image(getClass().getResource("/background drawing.png").toString());

        //Setting the image view 
        if (playerName1 == null){
            playerName1 = "Player 1";
            playerName2 = "Player 2";
        }

        
        bfView = new ImageView(new Image(getClass().getResource("/Characters/bfstart.png").toString()));
        bfView.setFitWidth(250); bfView.setFitHeight(250); 
        bfView.setLayoutX(200);
        bfView.setLayoutY(650);
        huggyView = new ImageView(new Image(getClass().getResource("/Characters/huggy.png").toString()));
        huggyView.setFitWidth(250); huggyView.setFitHeight(250);
        huggyView.setLayoutX(1600);
        huggyView.setLayoutY(650);

        pane.getChildren().addAll(bfView, huggyView);
        
        
        
        cutouts = new Image[] {grayLeft, grayDown, grayUp, grayRight};
 
        imagesMap = new HashMap<>();
        posMap = new HashMap<>();
        posMap.put('l',0);
        posMap.put('d', 1);
        posMap.put('u', 2);
        posMap.put('r', 3);

        imagesMap.put('l', colorLeft);
        imagesMap.put('d', colorDown);
        imagesMap.put('u', colorUp);
        imagesMap.put('r', colorRight);
        //char[] tempCommands = {'l', 'r', 'l', 'r', 'u', 'd', 'u', 'd', 'l', 'u', 'd', 'r'};
        //double[] tempAppearTimes = {8.46, 9.6365, 10.8130, 12.0895, 18.06, 19.2365, 20.4130, 21.5895, 28.06, 29.2365, 30.4130, 31.5895};
        backgroundImg = new Image(getClass().getResource(backgroundImgName).toString());
        
        Player playerOne = new Player(playerName1, "boyfriend", 0, "right");
        Player playerTwo = new Player(playerName2, "huggy", 0, "right");

        Text OneScoreText = new Text(500,500, playerName1 + " Score: "+playerOne.getScore());
        Text TwoScoreText = new Text(1000,500, playerName2 + " Score: "+playerTwo.getScore());
        
        OneScoreText.setFont(new Font(30));
        TwoScoreText.setFont(new Font(30));
        Player[] playerList = {playerOne, playerTwo};
        
        pane.getChildren().addAll(OneScoreText,TwoScoreText);


        
        setUpBackground();
        setUpCutouts();
        

        ParallelTransition sequence = arrowsAnimation(appearTimes, commands);
        



        
        
        Scene scene = new Scene(pane, 2000, 1000);  
        
        //Setting title to the Stage 
        


        scene.setOnKeyPressed(event -> {
            long time = System.currentTimeMillis()-startTime;


            double[] endTimesMillis = new double[endTimes.length];
            for (int i = 0; i<endTimesMillis.length; i++){
                endTimesMillis[i] = endTimes[i]*1000;
            }
            double smallestGap = 1000000000;
            int currIdx = 0;
            for (int i = 0; i < endTimesMillis.length; i++){
                if (Math.abs(endTimesMillis[i]-time) < smallestGap){
                //if (endTimesMillis[i] > time){
                    smallestGap = Math.abs(endTimesMillis[i]-time);
                    currIdx = i;
                }
            }
            PlayerInput(time, event.getCode(), playerList, currIdx, endTimesMillis);
            OneScoreText.setText(playerName1 + " Score: " + playerOne.getScore());
            TwoScoreText.setText(playerName2 + " Score: " + playerTwo.getScore());

            characterAnimation(playerMoves[currIdx], playerList[playerMoves[currIdx]].getCharacter(), event.getCode());
            
        });
        stage.setScene(scene);
        stage.setTitle("Thursday Night Funk'n");

        sequence.play();
        stage.show(); 

        pane.requestFocus();
    }

    public void setUpBackground(){

        BackgroundSize size = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage background = new BackgroundImage(backgroundImg, 
        BackgroundRepeat.NO_REPEAT, 
        BackgroundRepeat.NO_REPEAT, 
        BackgroundPosition.CENTER, 
        size);
        pane.setBackground(new Background(background));
    }
    public void setUpCutouts(){
        for (int i = 0; i < 4; i++) {
            ImageView cutout = new ImageView(cutouts[i]);

            cutout.setFitHeight(200);
            cutout.setFitWidth(200);
            cutout.setTranslateX(200 * (i));
            cutout.setTranslateY(0);

            System.out.println("image " + i + " created");

            pane.getChildren().addAll(cutout);
        }

        for (int i = 0; i < 4; i++) {
            ImageView cutout = new ImageView(cutouts[i]);

            cutout.setFitHeight(200);
            cutout.setFitWidth(200);
            cutout.setTranslateX(1000 + 200 * (i));
            cutout.setTranslateY(0);



            pane.getChildren().addAll(cutout);
        }
    }

    public void PlayerInput(long time, KeyCode inp, Player[] pList, int currIdx, double[] endTimesMillis){
        
        double[] accuracyTimes = {2000, 300, 250, 125, 10};
        
        String[] scoresMessages = {"Missed", "Ok!", "Great!", "Perfect!", "Impossible!"};
        int[] scores = {-50,25,50,75,100};
        

        HashMap<KeyCode, Character> keyToCharMap = new HashMap<>();
        keyToCharMap.put(KeyCode.LEFT,'l');
        keyToCharMap.put(KeyCode.DOWN,'d');
        keyToCharMap.put(KeyCode.UP, 'u');
        keyToCharMap.put(KeyCode.RIGHT,'r');

        HashMap<KeyCode, Character> dirToCharMap = new HashMap<>();
        dirToCharMap.put(KeyCode.A,'l');
        dirToCharMap.put(KeyCode.S,'d');
        dirToCharMap.put(KeyCode.W, 'u');
        dirToCharMap.put(KeyCode.D,'r');

    

        
        
        System.out.println(inp);
        
        
        
        if (playerMoves[currIdx] == 0){
            if (dirToCharMap.get(inp) != commands[currIdx]){
                return;
            }
        }

        if (playerMoves[currIdx] == 1){
            if (keyToCharMap.get(inp) != commands[currIdx]){
                return;
            }
        }
        
        double accuracy = time-endTimesMillis[currIdx];
        System.out.println(endTimesMillis[currIdx]);
        System.out.println(accuracy);

        int displayI = accuracyTimes.length-1;
        for (int i = 0; i < accuracyTimes.length; i++){
            if (Math.abs(accuracy)>accuracyTimes[i]){
                displayI = i;
                break;
            }
        }

        System.out.println(scores[displayI]);

        pList[playerMoves[currIdx]].addScore(scores[displayI]);
        
        int[] randomArr = {-20,0,20};
        int x = randomArr[rand.nextInt(3)];
        int y = randomArr[rand.nextInt(3)];
        Text ts = new Text(100+x + (1200*playerMoves[currIdx]), 400+y, scoresMessages[displayI]); 
        ScaleTransition st = new ScaleTransition(Duration.seconds(0.2), ts);
        st.setToX(1.5);
        st.setToY(1.5);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.2), ts);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        SequentialTransition textSequence = new SequentialTransition(st, fadeOut);
        



        ts.setFont(new Font(20));
        pane.getChildren().add(ts);

        
        textSequence.play();
        lastIdx = currIdx;
    }

    public void characterAnimation(int leftOrRight, String character, KeyCode dir){
    
        System.out.println(dir);

        

        if (character.equals( "boyfriend")){

            if (dir.equals(KeyCode.D)) {

                bfView.setImage(new Image(getClass().getResource("/Characters/bfright.png").toString()));
            } else if (dir.equals(KeyCode.A)) {
                bfView.setImage(new Image(getClass().getResource("/Characters/bfleft.png").toString()));
            } else if (dir.equals(KeyCode.W)) {
                bfView.setImage(new Image(getClass().getResource("/Characters/bfup.png").toString()));
            } else if (dir.equals(KeyCode.S)) {
                bfView.setImage(new Image(getClass().getResource("/Characters/bfdown.png").toString()));
            }
        } else if (character.equals("huggy")){
            if (dir.equals(KeyCode.UP)) {
                System.out.println("yes3");
                huggyView.setImage(new Image(getClass().getResource("/Characters/huggersup.png").toString()));
            } else if (dir.equals(KeyCode.LEFT)) {
                System.out.println("yes34");
                huggyView.setImage(new Image(getClass().getResource("/Characters/huggersleft.png").toString()));
            } else if (dir.equals(KeyCode.DOWN)) {
                huggyView.setImage(new Image(getClass().getResource("/Characters/huggersdown.png").toString()));
            } else if (dir.equals(KeyCode.RIGHT)) {
                System.out.println("yes35");
                huggyView.setImage(new Image(getClass().getResource("/Characters/huggyright.png").toString()));
            }
        }

        bfView.setFitWidth(250); bfView.setFitHeight(250); huggyView.setFitWidth(250); huggyView.setFitHeight(250);
       // pane.getChildren().addAll(bfView,huggyView);
    }

    public ParallelTransition arrowsAnimation(double[] appearTimes, char[] commands) {
        //char[] commands = {'l', 'r', 'l', 'r', 'u', 'd', 'u', 'd', 'l', 'u', 'd', 'r'};
    
        //double[] endTimes = {9.22, 11.07, 12.12, 13.16, 19.11, 20.18, 21.26, 23.03, 29.06, 30.07, 31.11, 32.13, 38.17, 39.07, 39.24, 41.02, 41.22, 42.09, 48.07, 48.2, 49.01, 49.11};
        ///double[] appearTimes = {0.4, 1.5765, 2.7530, 4.0295, 10.0, 11.1765, 12.3530, 13.5295, 20.0, 21.1765, 22.3530, 23.5295, 30.0, 31.1765, 32.3530, 33.5295, 40.0, 41.1765, 42.3530, 43.5295, 50.0, 51.1765, 52.3530, 53.5295};


        double prevTime = appearTimes[0];
        ParallelTransition sequence = new ParallelTransition();

        
        for (int i = 0; i < commands.length ; i++) {
            ImageView temp_key = new ImageView(imagesMap.get(commands[i]));

            temp_key.setFitHeight(200);
            temp_key.setFitWidth(200);
            temp_key.setTranslateX((1000 * playerMoves[i]) + 200 * (posMap.get(commands[i])));
            temp_key.setTranslateY(800);
            temp_key.setOpacity(0.0);


            
            PauseTransition pause = new PauseTransition(Duration.seconds(appearTimes[i]));

            FadeTransition transition_appear = new FadeTransition(Duration.millis(1), temp_key);

            transition_appear.setToValue(1.0);

            TranslateTransition transition_move = new TranslateTransition(Duration.seconds(moveSpeed), temp_key);
            transition_move.setInterpolator(Interpolator.LINEAR);
            transition_move.setByY((-1000));



            System.out.println("Arrow " + i + " appears at: " + appearTimes[i]);

            //SequentialTransition animation = new SequentialTransition(temp_key, translate_move, translate_invis);
            pane.getChildren().addAll(temp_key);
            //sequence.getChildren().addAll(animation);
            SequentialTransition subSequence = new SequentialTransition(pause, transition_appear, transition_move);
            sequence.getChildren().addAll(subSequence);

            
    

        }
        return sequence;
    }
    


        
        
    
    public static void main(String args[]) { 
        
        launch(args); 
    } 
} 
//WWWWWWWWWWWWW