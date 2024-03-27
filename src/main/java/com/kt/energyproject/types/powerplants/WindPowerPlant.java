package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import com.kt.energyproject.environment.WindIntensityObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WindPowerPlant extends PowerPlantBase implements WindIntensityObserver {

    private static final Logger logger = LoggerFactory.getLogger(WindPowerPlant.class);

    public void start() {
        super.start();
        logger.info("Starting WindPowerPlant");
    }

}
