package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import com.kt.energyproject.types.turbines.factory.SteamTurbineFactory;

public abstract class NuclearPowerPlant extends PowerPlantBase {

    private final SteamTurbineFactory turbineFactory;

    protected NuclearPowerPlant(SteamTurbineFactory turbineFactory) {
        this.turbineFactory = turbineFactory;
    }

    public void start() {
        super.start();
        System.out.println("Starting NuclearPowerPlant");
    }

}
