package com.grupodosfixes.jetpackduel;

import com.grupodosfixes.jetpackduel.characters.Opponent;
import com.grupodosfixes.jetpackduel.characters.Player;
import com.grupodosfixes.jetpackduel.input.GameKeyboard;
import com.grupodosfixes.jetpackduel.types.GameState;
import com.grupodosfixes.jetpackduel.ui.Arena;
import com.grupodosfixes.jetpackduel.ui.HUD;

public class Game {
    private Arena arena;
    private HUD hud;
    private GameState state;
    private Player player;
    private Opponent opponent;
    private GameKeyboard keyboard;
    private int ticks;
    private static final int PLAYER_X = 100;
    private static final int PLAYER_WIDTH = 109;
    private static final int PLAYER_HEIGHT = 100;
    private static final int PLAYER_SPEED = 0;

    public void init() {
        this.arena = new Arena();
        this.hud = new HUD();
        this.player = new Player(PLAYER_X, arena.getHeight()/2 - PLAYER_HEIGHT/2, PLAYER_WIDTH, PLAYER_HEIGHT, PLAYER_SPEED);
        this.keyboard = new GameKeyboard();
        keyboard.init();
        state = GameState.PLAYING;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void start() {
        while(state == GameState.PLAYING) {
            update();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        ticks++;
        player.setGoingUp(keyboard.isSpaceHeld());
        player.update();
    }

    public void gameOver(String winner) {
        state = GameState.GAME_OVER;
        System.out.println("Game over! Winner: " +  winner);
    }
}
