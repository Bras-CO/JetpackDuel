package com.grupodosfixes.jetpackduel.types;

public enum ProjectileType {

    FLAME(10, 3, EffectType.ON_FIRE, 5),       // Flame has regular speed and regular damage;
    BOULDER(15, 1, EffectType.IMMOBILIZED, 2),     // Boulder is slower, but does more damage;
    LIGHTNING(7, 5, EffectType.SHOCKED, 5),     // Lightning is the fastest, but deals less damage;
    ICE_BALL(10, 3, EffectType.SLOWED, 5);    // Ice Ball has regular speed and regular damage;

    private final int damage;
    private final int speed;
    private final EffectType effect;
    private final int effectSeconds;

    ProjectileType(int damage, int speed, EffectType effect, int effectSeconds) {
        this.damage = damage;
        this.speed = speed;
        this.effect = effect;
        this.effectSeconds = effectSeconds;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getEffectSeconds() {
        return effectSeconds;
    }

    public EffectType getEffect() {
        return effect;
    }

    public static ProjectileType randomProjectile() {
        ProjectileType[] projectile = ProjectileType.values();
        int randomIndex = (int) (Math.random() * projectile.length);
        return projectile[randomIndex];
    }
}
