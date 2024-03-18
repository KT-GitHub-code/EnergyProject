package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import com.kt.energyproject.environment.SunIntensityObserver;

public abstract class SolarPowerPlant extends PowerPlantBase implements SunIntensityObserver {

    public void start() {
        super.start();
        System.out.println("Starting SolarPowerPlant");
    }

}
