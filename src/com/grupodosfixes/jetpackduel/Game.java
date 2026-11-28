package com.grupodosfixes.jetpackduel;

import com.grupodosfixes.jetpackduel.types.GameState;
import com.grupodosfixes.jetpackduel.ui.Arena;

public class Game {
    private Arena arena;
    private GameState state;
    private int ticks;

    public void init() {
        this.arena = new Arena();
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
        System.out.println("tick " + ticks);
        if (ticks == 100) {
            gameOver("teste");
        }
    }

    public void gameOver(String winner) {
        state = GameState.GAME_OVER;
        System.out.println("Game over! Winner: " +  winner);
    }
}
