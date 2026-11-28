package com.grupodosfixes.jetpackduel;

import com.grupodosfixes.jetpackduel.ui.Arena;
import com.grupodosfixes.jetpackduel.ui.HUD;

public class Main {

    public static void main(String[] args) {

        Arena arena = new Arena();
        HUD hud = new HUD();
        hud.updatePlayerHP(50);

    }
}
