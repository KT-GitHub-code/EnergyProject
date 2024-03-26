package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import com.kt.energyproject.types.turbines.factory.WindTurbineFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class WindPowerPlant extends PowerPlantBase {

    private static final Logger logger = LoggerFactory.getLogger(WindPowerPlant.class);

    private final WindTurbineFactory turbineFactory;

    protected WindPowerPlant(WindTurbineFactory turbineFactory) {
        this.turbineFactory = turbineFactory;
    }

    public void start() {
        super.start();
        logger.info("Starting WindPowerPlant");
    }

}
