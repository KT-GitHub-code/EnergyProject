package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.SpinSpeedLevel;
import com.kt.energyproject.common.SpeedService;
import com.kt.energyproject.environment.SunIntensity;
import com.kt.energyproject.environment.SunIntensityLevel;
import com.kt.energyproject.types.generators.Generator;
import com.kt.energyproject.types.turbines.SteamTurbine;
import com.kt.energyproject.types.turbines.factory.SteamTurbineFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SolarPowerTower extends SolarPowerPlant implements ConcentratedSolarPower {

    private static final Logger logger = LoggerFactory.getLogger(SolarPowerTower.class);
    private final SteamTurbineFactory turbineFactory;
    private final SteamTurbine turbine;
    private final Generator generator;
    private final SpeedService speedService;

    public SolarPowerTower(SteamTurbineFactory turbineFactory,
                           Generator generator,
                           SunIntensity sunIntensity,
                           SpeedService speedService) {
        this.turbineFactory = turbineFactory;
        this.turbine = (SteamTurbine)this.turbineFactory.createTurbine();
        this.generator = generator;
        this.speedService = speedService;
        sunIntensity.registerObserver(this);
    }

    public void start() {
        final SunIntensityLevel sunIntensity = SunIntensity.getInstance().getIntensity();
        logger.info("Sun intensity: " + sunIntensity);
        super.start();

        SpinSpeedLevel turbineSpinSpeedLevel = speedService.calculateTurbineSpinSpeedLevel(sunIntensity);
        turbine.setSpinSpeed(turbineSpinSpeedLevel);
        turbine.setGenerator(generator);

        performContinuousOperationTasks();

    }

    @Override
    public void updateSunIntensity(SunIntensityLevel intensity) {
        logger.info("Updating sun intensity: " + intensity);
        turbine.setSpinSpeed(speedService.calculateTurbineSpinSpeedLevel(intensity));
    }

    protected void performContinuousOperationTasks() {
        turbine.turn();
    }

}
