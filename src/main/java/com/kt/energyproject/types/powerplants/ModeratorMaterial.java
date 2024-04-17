package com.kt.energyproject.types.powerplants;

public enum ModeratorMaterial {

    WATER("Water"),
    HEAVY_WATER("HeavyWater"),
    GRAPHITE("Graphite");

    private final String category;

    private ModeratorMaterial(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
