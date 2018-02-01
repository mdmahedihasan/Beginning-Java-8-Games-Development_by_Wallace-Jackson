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
    static Bagel iBagel;
    Image splashScreen, instructionLayer, legalLayer, scoresLayer;
    Image iB0, iB1, iB2, iB3, iB4, iB5, iB6, iB7, iB8;
    ImageView splashScreenBackplate, splashScreenTextArea;
    Button gameButton, helpButton, scoreButton, legalButton;
    HBox buttonContainer;
    Insets buttonContainerPadding;
    GamePlayLoop gamePlayLoop;
    CastingDirector castDirector;
    String cBagel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("InvinciBagel");
        root = new StackPane();
        scene = new Scene(root, WIDTH, HEIGHT, Color.WHITE);
        primaryStage.setScene(scene);
        primaryStage.show();

        gamePlayLoop = new GamePlayLoop();
        gamePlayLoop.start();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private void createSceneEventHandling() {
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
    }

    private void loadImageAssets() {
        splashScreen = new Image("/invincibagelsplash.png", 640, 400, true, false, true);
        instructionLayer = new Image("/invincibagelinstruct.png", 640, 400, true, false, true);
        legalLayer = new Image("/invincibagelcreds.png", 640, 400, true, false, true);
        scoresLayer = new Image("/invincibagelscores.png", 640, 400, true, false, true);
        iB0 = new Image("/sprite0.png", 81, 81, true, false, true);
        iB1 = new Image("/sprite1.png", 81, 81, true, false, true);
        iB2 = new Image("/sprite2.png", 81, 81, true, false, true);
        iB3 = new Image("/sprite3.png", 81, 81, true, false, true);
        iB4 = new Image("/sprite4.png", 81, 81, true, false, true);
        iB5 = new Image("/sprite5.png", 81, 81, true, false, true);
        iB6 = new Image("/sprite6.png", 81, 81, true, false, true);
        iB7 = new Image("/sprite7.png", 81, 81, true, false, true);
        iB8 = new Image("/sprite8.png", 81, 81, true, false, true);
    }

    private void createActorCollisionData() {
        cBagel = "M150 0 L75 500 L225 200 Z";
    }

    private void createGameActors() {
        iBagel = new Bagel(cBagel, 0, 0, iB0, iB1, iB2, iB3, iB4, iB5, iB6,
                iB7, iB8);
    }

    private void addGameActorNodes() {
        root.getChildren().add(iBagel.spriteFrame);
    }

    private void createCastingDirection() {
        castDirector = new CastingDirector();
        castDirector.addCurrentCast(iBagel);
    }

    private void createSplashScreenNodes() {

        buttonContainer = new HBox(12);
        buttonContainer.setAlignment(Pos.BOTTOM_LEFT);
        buttonContainerPadding = new Insets(0, 0, 10, 16);
        buttonContainer.setPadding(buttonContainerPadding);

        gameButton = new Button();
        gameButton.setText("PLAY GAME");
        gameButton.setOnAction((ActionEvent event) -> {
            splashScreenBackplate.setVisible(false);
            splashScreenTextArea.setVisible(false);
        });

        helpButton = new Button();
        helpButton.setText("INSTRUCTIONS");
        helpButton.setOnAction((ActionEvent event) -> {
            splashScreenBackplate.setVisible(true);
            splashScreenTextArea.setVisible(true);
            splashScreenTextArea.setImage(instructionLayer);
        });

        scoreButton = new Button();
        scoreButton.setText("HIGH SCORES");
        scoreButton.setOnAction((ActionEvent event) -> {
            splashScreenBackplate.setVisible(true);
            splashScreenTextArea.setVisible(true);
            splashScreenTextArea.setImage(scoresLayer);
        });

        legalButton = new Button();
        legalButton.setText("LEGAL & CREDITS");
        legalButton.setOnAction((ActionEvent event) -> {
            splashScreenBackplate.setVisible(true);
            splashScreenTextArea.setVisible(true);
            splashScreenTextArea.setImage(legalLayer);
        });

        buttonContainer.getChildren().addAll(gameButton, helpButton,
                scoreButton, legalButton);

        splashScreenBackplate = new ImageView();
        splashScreenBackplate.setImage(splashScreen);
        splashScreenTextArea = new ImageView();
        splashScreenTextArea.setImage(instructionLayer);
    }

    private void addNodesToStackPane() {
        root.getChildren().add(splashScreenBackplate);
        root.getChildren().add(splashScreenTextArea);
        root.getChildren().add(buttonContainer);
    }

    private void createStartGameLoop() {
        gamePlayLoop = new GamePlayLoop();
        gamePlayLoop.start();
    }

}
