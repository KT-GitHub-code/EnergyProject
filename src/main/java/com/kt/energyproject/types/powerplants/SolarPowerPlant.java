package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;

public abstract class SolarPowerPlant extends PowerPlantBase {

    public void start() {
        super.start();
        System.out.println("Starting SolarPowerPlant");
    }

}
