package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import com.kt.energyproject.environment.WaterflowIntensityObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HydroPowerPlant extends PowerPlantBase implements WaterflowIntensityObserver {

    private static final Logger logger = LoggerFactory.getLogger(HydroPowerPlant.class);

    public void start() {
        super.start();
        logger.info("Starting HydroPowerPlant");
    }

}
