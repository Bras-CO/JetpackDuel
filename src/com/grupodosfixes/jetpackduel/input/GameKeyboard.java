package com.grupodosfixes.jetpackduel.input;


import com.codeforall.online.simplegraphics.keyboard.Keyboard;
import com.codeforall.online.simplegraphics.keyboard.KeyboardEvent;
import com.codeforall.online.simplegraphics.keyboard.KeyboardEventType;
import com.codeforall.online.simplegraphics.keyboard.KeyboardHandler;

public class GameKeyboard implements KeyboardHandler {

    private Keyboard keyboard;

    public void init() {
        //keyboard needs reference to the keyboard handler
        keyboard = new Keyboard(this);

        //set up the events
        //input from the user is called an event
        KeyboardEvent goUp = new KeyboardEvent();

        //set the keys
        goUp.setKey(KeyboardEvent.KEY_SPACE);

        //set which sort of event the key should handle
        goUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        //keyboard should listen to events
        keyboard.addEventListener(goUp);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            System.out.println("Go Up!");
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


}
