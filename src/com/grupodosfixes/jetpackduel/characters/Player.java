package com.grupodosfixes.jetpackduel.characters;

public class Player extends Character {

    //need to store position Y as a float
    private float posY;
    private float velocityY = 0;
    private boolean goingUp = false; //bool for storing if player is going up or down

    private final float FLY_POWER = -0.8f; //negative for how fast player accelerates UPWARDS
    private final float GRAVITY =  0.8f; //positive for how fast player accelerates DOWNWARDS
    private final float MAX_UP_SPEED = -7f; //negative for max speed going UP
    private final float MAX_DOWN_SPEED = 7f; //positive for max speed going DOWN

    //TEMPORARY VARIABLES FOR COLLISION WITH CANVAS TOP AND BOTTOM
    private int CEILING = 0;
    private int FLOOR   = 700;

    public Player(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
        this.posY = y;
    }

    //method for going up or down
    public void setGoingUp(boolean goingUp) {
        this.goingUp = goingUp;
    }

    //method for updating how much the player is going UP or DOWN
    @Override
    public void update() {
        velocityY += goingUp ? FLY_POWER : GRAVITY; //check if player is going up or down, apply fly power or gravity force respectively
        velocityY = Math.max(MAX_UP_SPEED, Math.min(MAX_DOWN_SPEED, velocityY)); //make sure the speed does not exceed max velocity
        posY += velocityY;

        //TEMPORARY COLLISION WITH CANVAS
        if (posY < CEILING) { posY = CEILING; velocityY = 0; }
        else if (posY > FLOOR) { posY = FLOOR; velocityY = 0; }

        y = Math.round(posY); //apply posY(float) to y(int)
    }
}
