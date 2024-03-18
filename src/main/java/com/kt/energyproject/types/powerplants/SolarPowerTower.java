package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.environment.SunIntensity;
import com.kt.energyproject.environment.SunIntensityLevel;
import com.kt.energyproject.types.generators.Generator;
import com.kt.energyproject.types.turbines.SteamTurbine;
import com.kt.energyproject.types.turbines.factory.SteamTurbineFactory;
import org.springframework.stereotype.Component;

@Component
public class SolarPowerTower extends SolarPowerPlant implements ConcentratedSolarPower {

    private final SteamTurbineFactory turbineFactory;
    private final Generator generator;

    public SolarPowerTower(SteamTurbineFactory turbineFactory,
                           Generator generator,
                           SunIntensity sunIntensity) {
        this.turbineFactory = turbineFactory;
        this.generator = generator;
        sunIntensity.registerObserver(this);
    }

    public void start() {
        System.out.println("Sun intensity: " + SunIntensity.getInstance().getIntensity());
        super.start();
        SteamTurbine turbine = (SteamTurbine)turbineFactory.createTurbine();
        turbine.turn();
        generator.generateElectricity();
    }

    @Override
    public void updateSunIntensity(SunIntensityLevel intensity) {
        System.out.println("Updating sun intensity: " + intensity);
        if (intensity == SunIntensityLevel.ZERO) {
            stop();
        }
    }

}
