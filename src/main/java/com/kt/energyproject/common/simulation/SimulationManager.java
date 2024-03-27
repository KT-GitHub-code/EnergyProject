package com.kt.energyproject.common.simulation;

import com.kt.energyproject.common.SpeedService;
import com.kt.energyproject.environment.SunIntensity;
import com.kt.energyproject.environment.SunIntensityLevel;
import com.kt.energyproject.environment.WindIntensity;
import com.kt.energyproject.environment.WindIntensityLevel;
import com.kt.energyproject.types.generators.Generator;
import com.kt.energyproject.types.powerplants.SolarPowerTower;
import com.kt.energyproject.types.powerplants.StandardWindPowerPlant;
import com.kt.energyproject.types.turbines.WindTurbineType;
import com.kt.energyproject.types.turbines.factory.SteamTurbineFactory;
import com.kt.energyproject.types.turbines.factory.WindTurbineFactoryProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SimulationManager {

    private static final Logger logger = LoggerFactory.getLogger(SimulationManager.class);

    private final WindTurbineFactoryProvider turbineFactoryProvider;
    private final SpeedService speedService;

    @Autowired
    public SimulationManager(WindTurbineFactoryProvider turbineFactoryProvider, SpeedService speedService) {
        this.turbineFactoryProvider = turbineFactoryProvider;
        this.speedService = speedService;
    }

    public void startSimulation() {
//        simulateSolarPowerTower();
//        simulateStandardWindPowerPlant();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void simulateSolarPowerTower() {

        logger.warn("Starting Solar Power Tower simulation");

        SolarPowerTower powerPlant = new SolarPowerTower(
                new SteamTurbineFactory(),
                new Generator(),
                SunIntensity.getInstance(),
                speedService);

        powerPlant.start();

        sleep(5000);

        SunIntensity.getInstance().setIntensity(SunIntensityLevel.LOW);

        sleep(5000);

        SunIntensity.getInstance().setIntensity(SunIntensityLevel.ZERO);

        sleep(2500);

        powerPlant.stop();
        logger.warn("Solar Power Tower simulation ended");
    }

    private void simulateStandardWindPowerPlant() {

        logger.warn("Starting Standard Wind Power Plant simulation");

        StandardWindPowerPlant powerPlant = new StandardWindPowerPlant(
                turbineFactoryProvider,
                WindTurbineType.MODERN_HAWT,
                new Generator(),
                WindIntensity.getInstance(),
                speedService);

        powerPlant.start();

        sleep(5000);

        WindIntensity.getInstance().setIntensity(WindIntensityLevel.LOW);

        sleep(5000);

        WindIntensity.getInstance().setIntensity(WindIntensityLevel.ZERO);

        sleep(2500);

        powerPlant.stop();
        logger.warn("Standard Wind Power Plant simulation ended");
    }
}
