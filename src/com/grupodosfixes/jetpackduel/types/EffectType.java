package com.grupodosfixes.jetpackduel.types;

public enum EffectType {

    ON_FIRE(true),
    SHOCKED(true),
    SHIELDED(false),
    IMMOBILIZED(true),
    SLOWED(true),
    EMPOWERED(false);

    private final boolean negative;

    EffectType(boolean negative) {
        this.negative = negative;
    }

    public boolean isNegative() {
        return negative;
    }
}
