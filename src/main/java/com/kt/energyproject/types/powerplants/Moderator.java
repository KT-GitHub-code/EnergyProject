package com.kt.energyproject.types.powerplants;

public class Moderator {

    private final ModeratorMaterial material;

    private final int chanceOfNeutronAbsorption = 1;

    public Moderator(ModeratorMaterial material) {
        this.material = material;
    }

    public int getChanceOfNeutronAbsorption() {
        return chanceOfNeutronAbsorption;
    }
}
