package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import com.kt.energyproject.types.turbines.factory.SteamTurbineFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class NuclearPowerPlant extends PowerPlantBase {

    private static final Logger logger = LoggerFactory.getLogger(NuclearPowerPlant.class);

    private final SteamTurbineFactory turbineFactory;

    protected NuclearPowerPlant(SteamTurbineFactory turbineFactory) {
        this.turbineFactory = turbineFactory;
    }

    public void start() {
        super.start();
        logger.info("Starting NuclearPowerPlant");
    }

}
