/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invincibagel;

import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;

/**
 *
 * @author mahedi
 */
public class GamePlayLoop extends AnimationTimer {
    Pos location;

    @Override
    public void handle(long now) {
        location = InvinciBagel.buttonContainer.getAlignment();
        if (location == Pos.BOTTOM_LEFT) {
            InvinciBagel.buttonContainer.setAlignment(Pos.BOTTOM_RIGHT);
        } else if (location == Pos.BOTTOM_RIGHT) {
            InvinciBagel.buttonContainer.setAlignment(Pos.TOP_RIGHT);
        } else if (location == Pos.TOP_RIGHT) {
            InvinciBagel.buttonContainer.setAlignment(Pos.TOP_LEFT);
        } else if (location == Pos.TOP_LEFT) {
            InvinciBagel.buttonContainer.setAlignment(Pos.BOTTOM_LEFT);
        }
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

}
