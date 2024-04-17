package com.kt.energyproject.types.powerplants;

public enum CoolantMaterial {

    WATER("Water"),
    HEAVY_WATER("HeavyWater"),
    CARBON_DIOXIDE("Gas"),
    HELIUM("Gas"),
    SODIUM("LiquidMetal"),
    LEAD("LiquidMetal"),
    MIXTURE_OF_SALTS("MoltenSalts");

    private final String category;

    private CoolantMaterial(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
