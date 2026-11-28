package com.grupodosfixes.jetpackduel.input;


import com.codeforall.online.simplegraphics.keyboard.Keyboard;
import com.codeforall.online.simplegraphics.keyboard.KeyboardEvent;
import com.codeforall.online.simplegraphics.keyboard.KeyboardEventType;
import com.codeforall.online.simplegraphics.keyboard.KeyboardHandler;
import com.grupodosfixes.jetpackduel.characters.Player;

public class GameKeyboard implements KeyboardHandler {

    private Keyboard keyboard;
    private boolean spaceHeld = false;

    private Player player;
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void init() {
        //keyboard needs reference to the keyboard handler
        keyboard = new Keyboard(this);

        //set up the events
        //input from the user is called an event
        KeyboardEvent spacePressed = new KeyboardEvent();
        KeyboardEvent spaceReleased = new KeyboardEvent();

        //set the keys
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spaceReleased.setKey(KeyboardEvent.KEY_SPACE);

        //set which sort of event the key should handle
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spaceReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        //keyboard should listen to events
        keyboard.addEventListener(spacePressed);
        keyboard.addEventListener(spaceReleased);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            spaceHeld = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            spaceHeld = false;
        }
    }

    public boolean isSpaceHeld() {
        return spaceHeld;
    }


}
