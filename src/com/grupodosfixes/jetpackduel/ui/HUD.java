package com.grupodosfixes.jetpackduel.ui;

import com.codeforall.online.simplegraphics.graphics.Color;
import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.pictures.Picture;

public class HUD {

    private static final int PORTRAIT_SIZE = 80;
    private static final int GAP = 10;
    private static final int HP_BAR_HEIGHT = 100;

    private static final int FILL_OFFSET_X = 23;
    private static final int FILL_OFFSET_Y = 38;
    private static final int FILL_SIZE_WIDTH = 254;
    private static final int FILL_SIZE_HEIGHT = 36;


    private static final int PORTRAIT_POSITION_X = 20;
    private static final int PORTRAIT_POSITION_Y = 20;
    private static final int HP_BAR_X = PORTRAIT_POSITION_X + PORTRAIT_SIZE + GAP;
    private static final int HP_BAR_Y = PORTRAIT_POSITION_Y + (PORTRAIT_SIZE - HP_BAR_HEIGHT) / 2;



    private Picture portrait;
    private Picture hpBar;
    private Rectangle hpBarFill;

    public HUD() {
        portrait = new Picture(PORTRAIT_POSITION_X, PORTRAIT_POSITION_Y, "images/hud/player_portrait.png");
        portrait.draw();

        hpBarFill = new Rectangle(HP_BAR_X + FILL_OFFSET_X, HP_BAR_Y + FILL_OFFSET_Y, FILL_SIZE_WIDTH, FILL_SIZE_HEIGHT);
        hpBarFill.setColor(Color.GREEN);
        hpBarFill.fill();

        hpBar = new Picture(HP_BAR_X, HP_BAR_Y, "images/hud/hp_bar.png");
        hpBar.draw();

    }
}
