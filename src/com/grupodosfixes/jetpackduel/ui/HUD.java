package com.grupodosfixes.jetpackduel.ui;

import com.codeforall.online.simplegraphics.graphics.Color;
import com.codeforall.online.simplegraphics.graphics.Rectangle;
import com.codeforall.online.simplegraphics.pictures.Picture;
import com.grupodosfixes.jetpackduel.characters.Character;

public class HUD {

    private static final int PORTRAIT_SIZE = 80;
    private static final int GAP = 10;
    private static final int SCREEN_WIDTH = 1280;
    private static final int HP_BAR_HEIGHT = 100;
    private static final int HP_BAR_WIDTH = 300;

    private static final int FILL_OFFSET_X = 23;
    private static final int FILL_OFFSET_Y = 38;
    private static final int FILL_SIZE_WIDTH = 254;
    private static final int FILL_SIZE_HEIGHT = 36;


    private static final int PORTRAIT_POSITION_X = 20;
    private static final int PORTRAIT_POSITION_Y = 20;
    private static final int OPPONENT_PORTRAIT_POSITION_X = SCREEN_WIDTH - PORTRAIT_POSITION_X - PORTRAIT_SIZE;
    private static final int OPPONENT_HP_BAR_X = OPPONENT_PORTRAIT_POSITION_X - GAP - HP_BAR_WIDTH;
    private static final int HP_BAR_X = PORTRAIT_POSITION_X + PORTRAIT_SIZE + GAP;
    private static final int HP_BAR_Y = PORTRAIT_POSITION_Y + (PORTRAIT_SIZE - HP_BAR_HEIGHT) / 2;



    private Picture portrait;
    private Picture hpBar;
    private Rectangle hpBarFill;
    private Picture opponentPortrait;
    private Picture opponentHpBar;
    private Rectangle opponentHpBarFill;

    public HUD() {
        portrait = new Picture(PORTRAIT_POSITION_X, PORTRAIT_POSITION_Y, "images/hud/player_portrait.png");
        portrait.draw();

        hpBarFill = new Rectangle(HP_BAR_X + FILL_OFFSET_X, HP_BAR_Y + FILL_OFFSET_Y, FILL_SIZE_WIDTH, FILL_SIZE_HEIGHT);
        hpBarFill.setColor(Color.GREEN);
        hpBarFill.fill();

        hpBar = new Picture(HP_BAR_X, HP_BAR_Y, "images/hud/hp_bar.png");
        hpBar.draw();

        opponentPortrait = new Picture(OPPONENT_PORTRAIT_POSITION_X, PORTRAIT_POSITION_Y, "images/hud/opponent_portrait.png");
        opponentPortrait.draw();

        opponentHpBarFill = new Rectangle(OPPONENT_HP_BAR_X + FILL_OFFSET_X, HP_BAR_Y + FILL_OFFSET_Y, FILL_SIZE_WIDTH, FILL_SIZE_HEIGHT);
        opponentHpBarFill.setColor(Color.RED);
        opponentHpBarFill.fill();

        opponentHpBar = new Picture(OPPONENT_HP_BAR_X, HP_BAR_Y, "images/hud/hp_bar.png");
        opponentHpBar.draw();

    }

    public void updatePlayerHP(int hp) {
        hpBarFill.delete();
        int newWidth = FILL_SIZE_WIDTH * hp / Character.MAX_HP;
        hpBarFill = new Rectangle(HP_BAR_X + FILL_OFFSET_X, HP_BAR_Y + FILL_OFFSET_Y, newWidth, FILL_SIZE_HEIGHT);
        hpBarFill.setColor(Color.GREEN);
        hpBarFill.fill();
        hpBar.delete();
        hpBar.draw();
    }
}
