package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class NuclearPowerPlant extends PowerPlantBase {

    private static final Logger logger = LoggerFactory.getLogger(NuclearPowerPlant.class);

    public void start() {
        super.start();
        logger.info("Starting NuclearPowerPlant");
    }

}
