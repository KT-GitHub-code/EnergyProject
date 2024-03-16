package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import com.kt.energyproject.types.turbines.factory.SteamTurbineFactory;

public abstract class FossilFuelPowerPlant extends PowerPlantBase {

    private final SteamTurbineFactory turbineFactory;

    protected FossilFuelPowerPlant(SteamTurbineFactory turbineFactory) {
        this.turbineFactory = turbineFactory;
    }

    public void start() {
        super.start();
        System.out.println("Starting FossilFuelPowerPlant");
    }

}
