package com.grupodosfixes.jetpackduel.ui;

import com.codeforall.online.simplegraphics.pictures.Picture;
import com.grupodosfixes.jetpackduel.objects.Collidable;


public class Arena {

    private final Picture background;

    public Arena() {
        background = new Picture(0, 0, "images/backgrounds/placeholder_background.png");
        background.draw();
    }

    public int getHeight() {
        return background.getHeight();
    }

    public int getWidth() {
        return background.getWidth();
    }

    public boolean isOutOfBounds(Collidable collidable) {
        return collidable.getX() < 0 || collidable.getY() < 0 || collidable.getX() + collidable.getWidth() > background.getWidth() || collidable.getY() + collidable.getHeight() > background.getHeight();
    }

}
