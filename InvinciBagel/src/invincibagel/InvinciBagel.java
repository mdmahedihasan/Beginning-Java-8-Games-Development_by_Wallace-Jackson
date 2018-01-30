/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invincibagel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author mahedi
 */
public class InvinciBagel extends Application {

    static final double WIDTH = 640, HEIGHT = 400;
    boolean up, down, right, left;
    Scene scene;
    StackPane root;
    Image splashScreen, instructionLayer, legalLayer, scoresLayer;
    ImageView splashScreenBackplate, splashScreenTextArea;
    Button gameButton, helpButton, scoreButton, legalButton;
    HBox buttonContainer;
    Insets buttonContainerPadding;
    GamePlayLoop gamePlayLoop;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("InvinciBagel");
        primaryStage.setScene(scene);
        primaryStage.show();

        gameButton.setOnAction((ActionEvent event) -> {
            splashScreenBackplate.setVisible(false);
            splashScreenTextArea.setVisible(false);
        });
        helpButton.setOnAction((ActionEvent event) -> {
            splashScreenBackplate.setVisible(true);
            splashScreenTextArea.setVisible(true);
            splashScreenTextArea.setImage(instructionLayer);
        });
        scoreButton.setOnAction((ActionEvent event) -> {
            splashScreenBackplate.setVisible(true);
            splashScreenTextArea.setVisible(true);
            splashScreenTextArea.setImage(scoresLayer);
        });
        legalButton.setOnAction((ActionEvent event) -> {
            splashScreenTextArea.setImage(legalLayer);
        });

        gamePlayLoop = new GamePlayLoop();
        gamePlayLoop.start();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void createSplashScreenNodes() {
        root = new StackPane();
        scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:
                    up = true;
                    break;
                case DOWN:
                    down = true;
                    break;
                case LEFT:
                    left = true;
                    break;
                case RIGHT:
                    right = true;
                    break;
                case W:
                    up = true;
                    break;
                case S:
                    down = true;
                    break;
                case A:
                    left = true;
                    break;
                case D:
                    right = true;
                    break;
            }
        });
        scene.setOnKeyReleased((KeyEvent event) -> {
            switch (event.getCode()) {
                case UP:
                    up = false;
                    break;
                case DOWN:
                    down = false;
                    break;
                case LEFT:
                    left = false;
                    break;
                case RIGHT:
                    right = false;
                    break;
                case W:
                    up = false;
                    break;
                case S:
                    down = false;
                    break;
                case A:
                    left = false;
                    break;
                case D:
                    right = false;
                    break;
            }
        });

        buttonContainer = new HBox(12);
        buttonContainer.setAlignment(Pos.BOTTOM_LEFT);
        buttonContainerPadding = new Insets(0, 0, 10, 16);
        buttonContainer.setPadding(buttonContainerPadding);

        gameButton = new Button();
        gameButton.setText("PLAY GAME");
        //gameButton.setLayoutX(0);
        helpButton = new Button();
        helpButton.setText("INSTRUCTIONS");
        scoreButton = new Button();
        scoreButton.setText("HIGH SCORES");
        legalButton = new Button();
        legalButton.setText("LEGAL & CREDITS");

        buttonContainer.getChildren().addAll(gameButton, helpButton,
                scoreButton, legalButton);

        splashScreen = new Image("/ok.jpg", 640, 400, true, false, true);
        splashScreenBackplate = new ImageView();
        splashScreenBackplate.setImage(splashScreen);

        instructionLayer = new Image("/Mahedi.png", 640, 400, true, false, true);
        splashScreenTextArea = new ImageView();
        splashScreenTextArea.setImage(instructionLayer);

        legalLayer = new Image("", 640, 400, true, false, true);
        scoresLayer = new Image("", 640, 400, true, false, true);
    }

    private void addNodesToStackPane() {
        root.getChildren().add(splashScreenBackplate);
        root.getChildren().add(splashScreenTextArea);
        root.getChildren().add(buttonContainer);
    }

}
