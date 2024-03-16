package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import com.kt.energyproject.types.turbines.factory.WaterTurbineFactory;

public abstract class HydroPowerPlant extends PowerPlantBase {

    private final WaterTurbineFactory turbineFactory;

    protected HydroPowerPlant(WaterTurbineFactory turbineFactory) {
        this.turbineFactory = turbineFactory;
    }

    public void start() {
        super.start();
        System.out.println("Starting HydroPowerPlant");
    }

}
