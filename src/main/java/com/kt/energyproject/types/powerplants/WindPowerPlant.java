package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.PowerPlantBase;
import com.kt.energyproject.types.turbines.factory.WindTurbineFactory;

public abstract class WindPowerPlant extends PowerPlantBase {

    private final WindTurbineFactory turbineFactory;

    protected WindPowerPlant(WindTurbineFactory turbineFactory) {
        this.turbineFactory = turbineFactory;
    }

    public void start() {
        super.start();
        System.out.println("Starting WindPowerPlant");
    }

}
