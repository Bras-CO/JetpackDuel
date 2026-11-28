package com.grupodosfixes.jetpackduel.testfolder;

import com.codeforall.online.simplegraphics.graphics.Canvas;
import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.grupodosfixes.jetpackduel.characters.Player;
import com.grupodosfixes.jetpackduel.input.GameKeyboard;
import com.grupodosfixes.jetpackduel.objects.CollisionDetector;

public class TestMain {

    public static void main(String[] args) throws InterruptedException{

        FakeRectangles a = new FakeRectangles(10, 10, 25, 30);
        FakeRectangles b = new FakeRectangles(15, 30, 40, 30);
        FakeRectangles c = new FakeRectangles(45, 30, 20, 30);
        FakeRectangles d = new FakeRectangles(35, 30, 40, 30);

        System.out.println(CollisionDetector.collides(a, b));//expected true
        System.out.println(CollisionDetector.collides(c, b));// expected true
        System.out.println(CollisionDetector.collides(a, c));//expected false
        System.out.println(CollisionDetector.collides(d, a));//expected true

        //COLLISION WORKS!


        //====== TESTING PLAYER =====
        Canvas.setMaxX(1280);
        Canvas.setMaxY(720);

        Player player = new Player(100, 200, 40, 40, 5);

        Rectangle rectangle = new Rectangle(player.getX(), player.getY(),
                player.getWidth(), player.getHeight());
        rectangle.fill();

        GameKeyboard keyboard = new GameKeyboard();
        keyboard.init();

        int lastY = player.getY();

        while (true) {
            player.setGoingUp(keyboard.isSpaceHeld());
            player.update();

            // the library moves shapes by an offset, not to an absolute position
            rectangle.translate(0, player.getY() - lastY);
            lastY = player.getY();

            Thread.sleep(16);
        }
    }
}
