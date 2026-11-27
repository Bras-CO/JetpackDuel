package com.grupodosfixes.jetpackduel.testfolder;

import com.grupodosfixes.jetpackduel.objects.CollisionDetector;

public class TestMain {

    public static void main(String[] args) {

        FakeRectangles a = new FakeRectangles(10, 10, 25, 30);
        FakeRectangles b = new FakeRectangles(15, 30, 40, 30);
        FakeRectangles c = new FakeRectangles(45, 30, 20, 30);
        FakeRectangles d = new FakeRectangles(35, 30, 40, 30);

        System.out.println(CollisionDetector.collides(a, b));//expected true
        System.out.println(CollisionDetector.collides(c, b));// expected true
        System.out.println(CollisionDetector.collides(a, c));//expected false
        System.out.println(CollisionDetector.collides(d, a));//expected true

        //COLLISION WORKS!


    }
}
