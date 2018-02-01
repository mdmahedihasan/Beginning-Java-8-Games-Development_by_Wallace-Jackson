/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invincibagel;

import static invincibagel.InvinciBagel.down;
import static invincibagel.InvinciBagel.left;
import static invincibagel.InvinciBagel.right;
import static invincibagel.InvinciBagel.up;
import javafx.scene.image.Image;

/**
 *
 * @author mahedi
 */
public class Bagel extends Hero {

    public Bagel(String SVGdata, double xLocation, double yLocation,
            Image... spriteCels) {
        super(SVGdata, xLocation, yLocation, spriteCels);
    }

    @Override
    public void update() {
        if (right) {
            iX += vX;
        }
        if (left) {
            iX -= vX;
        }
        if (down) {
            iY += vX;
        }
        if (up) {
            iY -= vY;
        }
        spriteFrame.setTranslateX(iX);
        spriteFrame.setTranslateY(iY);
    }

    @Override
    public boolean collide(Actor object) {
        return false;
    }
}
