package com.grupodosfixes.jetpackduel.characters;

import com.codeforall.online.simplegraphics.pictures.Picture;
import com.grupodosfixes.jetpackduel.effects.StatusEffect;
import com.grupodosfixes.jetpackduel.objects.Collidable;
import com.grupodosfixes.jetpackduel.types.EffectType;

import java.util.LinkedList;

public abstract class Character implements Collidable {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int hp;
    protected static final int MAX_HP = 100;
    protected int speed;
    private Picture sprite;
    private LinkedList<StatusEffect> effects = new LinkedList<>();

    public Character(int x, int y, int width, int height, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.hp = MAX_HP;
    }

    public void takeDamage(int amount) {}

    public void heal(int amount) {}

    public boolean isDead() {
        return false;
    }

    public void applyEffect(StatusEffect effect) {}

    public void updateEffects() {}

    public void clearNegativeEffects() {}

    public boolean hasEffect(EffectType type) {
        return false;
    }

    public abstract void update();

    public int getHp() {
        return hp;
    }


    public int getSpeed() {
        return speed;
    }

    public Picture getSprite() {
        return sprite;
    }

    public LinkedList<StatusEffect> getEffects() {
        return effects;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
