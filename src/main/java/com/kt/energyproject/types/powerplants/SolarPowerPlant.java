package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import com.kt.energyproject.environment.SunIntensityObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SolarPowerPlant extends PowerPlantBase implements SunIntensityObserver {

    private static final Logger logger = LoggerFactory.getLogger(SolarPowerPlant.class);

    public void start() {
        super.start();
        logger.info("Starting SolarPowerPlant");
    }

}
