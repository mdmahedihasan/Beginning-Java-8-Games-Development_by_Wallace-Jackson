/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author mahedi
 */
public class GamePiece {

    private static final String FLOVOR_OF_BAGEL = "Pumpernickle";
    private static final String SIZE_OF_BAGEL = "Mini Size";

    public int invinciBagelX = 0;
    public int invinciBagelY = 0;
    public String bagelOrientation = "side";
    public int lifeIndex = 1000;
    public int hitsIndex = 0;
    public String directionFacing = "E";
    public String movementType = "idle";
    public boolean currentlyMoving = false;

    public void moveInvinciBagel(int x, int y) {
        currentlyMoving = true;
        invinciBagelX = x;
        invinciBagelY = y;
    }

    public String getInvinciBagleOrientation() {
        return bagelOrientation;
    }

    public void setInvinciBagelOrientation(String orientation) {
        bagelOrientation = orientation;
    }

    public int getInvinciBagelLifeIndex() {
        return lifeIndex;
    }

    public void setInvinciBagelLifeIndex(int lifeSpan) {
        lifeIndex = lifeSpan;
    }

    public void setInvinciBagelDirection(String direction) {
        directionFacing = direction;
    }

    public String getInvinciBagelDirection() {
        return directionFacing;
    }

    public int getInvinciBagelHitsIndex() {
        return hitsIndex;
    }

    public void setInvinciBagelHitsIndex(int damage) {
        hitsIndex = damage;
    }

    public String getInvinciBagelMovingType() {
        return movementType;
    }

    public void setInvinciBagelMovingType(String movement) {
        movementType = movement;
    }
}
