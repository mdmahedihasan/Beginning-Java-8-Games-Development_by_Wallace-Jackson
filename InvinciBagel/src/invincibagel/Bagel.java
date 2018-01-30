/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invincibagel;

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean collide(Actor object) {
        return false;
    }
}
