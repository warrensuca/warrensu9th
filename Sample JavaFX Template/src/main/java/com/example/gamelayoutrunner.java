package com.example;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.stage.Stage;
public class gamelayoutrunner extends Application{
    @Override 
    public void start(Stage stage) throws FileNotFoundException, InterruptedException { 

        //String player1 = PlayerNames.player1Name;
        //String player2 = PlayerNames.player2Name;
        GameLayout.setPlayerNames("w", "s");

        GameLayout.setBackgroundImageName("/background drawing.png");
        GameLayout.setSongName("/casin.mp3");
        GameLayout.setSongStopTime(48.1);

        
        int[] playerMoves = {0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1};
        GameLayout.setPlayerMoves(playerMoves);
        
        char[] tempCommands = {'l','r','l','r','l','r','l','r', 'u','d','u', 'd', 'u','d','u', 'd', 'l','u','d','r', 'l','u','d','r', 'd', 'd', 'u', 'd', 'd', 'r','d', 'd', 'u', 'd', 'd', 'r'};
        
        
        GameLayout.setCommands(tempCommands);



        //double[] endTimes = {10.26, 11.4365, 12.6130, 13.8895, 14.93, 16.1065, 17.28300, 18.4595, 19.86, 21.0365, 22.2130, 23.3895, 24.7, 25.8765, 27.05300, 28.2295, 29.86, 31.0365, 32.2130, 33.3895, 34.65, 35.8265, 37.00300, 38.1795, 39.15600, 39.80600, 40.45600, 41.7795, 42.4295, 43.0795, 43.98600, 44.63600, 45.28600, 46.6095, 47.2595, 47.9095};
        
        double[] endTimes = {11.16, 12.3365, 13.513, 14.7895, 15.83, 17.0065, 18.183, 19.3595, 20.76, 21.9365, 23.113, 24.2895, 25.6, 26.7765, 27.953, 29.1295, 30.76, 31.9365, 33.113, 34.2895, 35.55, 36.7265, 37.903, 39.0795, 40.056, 40.706, 41.356, 42.6795, 43.3295, 43.9795, 44.786, 45.436, 46.086, 47.4095, 48.0595, 48.7095};
        double[] casinEndTimes = {6.30, 6.65, 7.40, 7.65, 7.90, 8.40, 8.90, 9.48, 9.82, 10.35, 10.55, 10.75, 10.95, 11.15, 11.35, 11.55, 11.75, 12.15, 12.40, 12.65, 12.90, 13.35, 13.55, 13.75, 13.95, 14.15, 14.35, 14.55, 14.75, 14.95, 15.32, 15.48, 15.65, 15.82, 16.15, 16.35, 16.55, 16.75, 16.95, 17.15, 17.35, 17.55, 17.75, 17.95, 18.15, 18.35, 18.55, 18.75, 18.95, 19.32, 19.48, 19.65, 19.82, 20.15, 20.48, 20.82, 21.05, 21.24};

        double [] casinAppearTimes = new double[casinEndTimes.length];
        for (int i = 0; i < casinEndTimes.length; i++){
            casinAppearTimes[i] = casinEndTimes[i] - 2.3;
        }
        GameLayout.setMoveSpeed(2.3);


        double[] tempAppearTimes = new double[endTimes.length];
        GameLayout.setEndTimes(casinEndTimes);

        for (int i = 0; i < endTimes.length; i++){
            tempAppearTimes[i] = endTimes[i] - 2.7;
        }

        //double[] tempAppearTimes = {8.46,9.6365,10.8130,12.0895,18.06,19.2365,20.4130,21.5895,28.06,29.2365,30.4130,31.5895};
        GameLayout.setAppearTimes(casinAppearTimes);
        //GameLayout.setEndTimes(casinEndTimes);
        //GameLayout.setAppearTimes(casinAppearTimes);
        try {
            new GameLayout().start(stage); // Use current stage
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    public static void main(String[] args) {
        launch(args);
    }
}