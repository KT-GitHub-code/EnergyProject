package com.kt.energyproject.types.powerplants;

public class ControlRods {

    private final ControlRodMaterial material;
    private int position; // 0: fully withdrawn, 100: fully inserted

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
        if (position<0 || position>100) {
            throw new IllegalArgumentException("Position must be between 0 and 100");
        }
        this.position = position;
    }
}
