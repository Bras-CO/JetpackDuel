package com.grupodosfixes.jetpackduel.characters;

public class Player extends Character {

    //need to store position Y as a float
    private float posY;
    private float velocityY = 0;

    private final float GRAVITY = 0.5f;  // constant pull down
    private final float UP_VELOCITY  = -8f;   // instant upward speed when going up
    private final float MAX_DOWN_SPEED = 10f;   // max fall speed

    //TEMPORARY VARIABLES FOR COLLISION WITH CANVAS TOP AND BOTTOM
    private int canvasHeight = 400;
    private int ceiling = 0;
    private int floor;

    public Player(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
        this.posY = y;
        this.floor = canvasHeight - height;
    }

    //method for going up
    public void goUp() {
        velocityY = UP_VELOCITY;
    }

    //method for updating how much the player is going UP or DOWN
    @Override
    public void update() {
        velocityY += GRAVITY;
        velocityY = Math.min(velocityY, MAX_DOWN_SPEED); //return the smallest between the 2 values, so the player does not accelerate above MAX SPEED
        posY += velocityY;

        //TEMPORARY COLLISION WITH CANVAS
        if (posY < ceiling) {
            posY = ceiling;
            velocityY = 0;
        } else if (posY > floor) {
            posY = floor;
            velocityY = 0;
        }

        y = Math.round(posY); //apply posY(float) to y(int)
    }
}
