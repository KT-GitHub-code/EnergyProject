package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import com.kt.energyproject.types.turbines.factory.SteamTurbineFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class FossilFuelPowerPlant extends PowerPlantBase {

    private static final Logger logger = LoggerFactory.getLogger(HydroPowerPlant.class);

    private final SteamTurbineFactory turbineFactory;

    protected FossilFuelPowerPlant(SteamTurbineFactory turbineFactory) {
        this.turbineFactory = turbineFactory;
    }

    public void start() {
        super.start();
        logger.info("Starting FossilFuelPowerPlant");
    }

}
