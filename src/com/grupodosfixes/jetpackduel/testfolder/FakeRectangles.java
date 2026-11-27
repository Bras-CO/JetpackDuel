package com.grupodosfixes.jetpackduel.testfolder;

import com.grupodosfixes.jetpackduel.objects.Collidable;

public class FakeRectangles implements Collidable {

    private int x;
    private int y;
    private int width;
    private int height;

    public FakeRectangles(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

}
