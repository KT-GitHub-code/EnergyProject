package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.SpinSpeedLevel;
import com.kt.energyproject.common.SpeedService;
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
    private final SpeedService speedService;

    public SolarPowerTower(SteamTurbineFactory turbineFactory,
                           Generator generator,
                           SunIntensity sunIntensity,
                           SpeedService speedService) {
        this.turbineFactory = turbineFactory;
        this.generator = generator;
        this.speedService = speedService;
        sunIntensity.registerObserver(this);
    }

    public void start() {
        final SunIntensityLevel sunIntensity = SunIntensity.getInstance().getIntensity();
        System.out.println("Sun intensity: " + sunIntensity);
        super.start();

        SteamTurbine turbine = (SteamTurbine)turbineFactory.createTurbine();
        setTurbine(turbine);
        SpinSpeedLevel turbineSpinSpeedLevel = speedService.calculateTurbineSpinSpeedLevel(sunIntensity);
        turbine.setSpinSpeed(turbineSpinSpeedLevel);

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
