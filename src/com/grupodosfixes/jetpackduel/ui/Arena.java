package com.grupodosfixes.jetpackduel.ui;

import com.codeforall.online.simplegraphics.graphics.Color;
import com.codeforall.online.simplegraphics.graphics.Rectangle;


public class Arena {

    private Rectangle background;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public Arena() {
        background = new Rectangle(10,10,WIDTH, HEIGHT);
        background.setColor(Color.BLACK);
        background.fill();
    }

    public int getHeight() {
        return HEIGHT;
    }

    public int getWidth() {
        return WIDTH;
    }

    public boolean isOutOfBounds(int x, int y) {
        return x < 0 || x > WIDTH || y < 0 || y > HEIGHT;
    }

}
