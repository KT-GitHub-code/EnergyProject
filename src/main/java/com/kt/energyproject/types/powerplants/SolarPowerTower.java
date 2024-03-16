package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.types.generators.Generator;
import com.kt.energyproject.types.turbines.SteamTurbine;
import com.kt.energyproject.types.turbines.factory.SteamTurbineFactory;
import org.springframework.stereotype.Component;

@Component
public class SolarPowerTower extends SolarPowerPlant implements ConcentratedSolarPower {

    private final SteamTurbineFactory turbineFactory;
    private final Generator generator;

    public SolarPowerTower(SteamTurbineFactory turbineFactory,
                           Generator generator) {
        this.turbineFactory = turbineFactory;
        this.generator = generator;
    }

    public void start() {
        super.start();
        SteamTurbine turbine = (SteamTurbine)turbineFactory.createTurbine();
        turbine.turn();
        generator.generateElectricity();
    }

}
