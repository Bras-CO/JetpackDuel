package com.grupodosfixes.jetpackduel.input;

import com.codeforall.online.simplegraphics.mouse.Mouse;
import com.codeforall.online.simplegraphics.mouse.MouseEvent;
import com.codeforall.online.simplegraphics.mouse.MouseEventType;
import com.codeforall.online.simplegraphics.mouse.MouseHandler;

public class GameMouse implements MouseHandler {

    private Mouse mouse;
    
    public void init() {
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }


    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("Shoot!");
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
