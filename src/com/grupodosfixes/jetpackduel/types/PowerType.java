package com.grupodosfixes.jetpackduel.types;

public enum PowerType {

    FLAME(10, 0, 0, EffectType.ON_FIRE, 5),
    ARMOR(0, 0, 10, EffectType.SHIELDED, 10),
    LIGHTNING_STRIKE(10, 0, 0, EffectType.EMPOWERED, 5),
    HEART(0, 20, 0, null, 0);

    private final int damage;
    private final int heal;
    private final int armor;
    private final EffectType effect;
    private final int effectSeconds;

    PowerType(int damage, int heal, int armor, EffectType effect, int effectSeconds) {
        this.damage = damage;
        this.heal = heal;
        this.armor = armor;
        this.effect = effect;
        this.effectSeconds = effectSeconds;
    }

    public int getEffectSeconds() {
        return effectSeconds;
    }

    public int getDamage() {
        return damage;
    }

    public int getHeal() {
        return heal;
    }

    public int getArmor() {
        return armor;
    }

    public EffectType getEffect() {
        return effect;
    }

    public static PowerType randomPower() {
        PowerType[] powers = PowerType.values();
        int randomIndex = (int) (Math.random() * powers.length);
        return powers[randomIndex];
    }
}
