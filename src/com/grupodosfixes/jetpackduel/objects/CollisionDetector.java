package com.grupodosfixes.jetpackduel.objects;

public class CollisionDetector {

    public static boolean collides(Collidable a, Collidable b) {
        return a.getX() + a.getWidth() >= b.getX() &&
               a.getY() + a.getHeight() >= b.getY() &&
               b.getX() + b.getWidth() >= a.getX() &&
               b.getY() + b.getHeight() >= a.getY();

    }
}
