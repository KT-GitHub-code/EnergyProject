package com.kt.energyproject.types.powerplants;

public class ControlRods {

    private final ControlRodMaterial material;
    private int position;

    public ControlRods(ControlRodMaterial material) {
        this.material = material;
        this.position = 100;
    }

    public ControlRodMaterial getMaterial() {
        return material;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
