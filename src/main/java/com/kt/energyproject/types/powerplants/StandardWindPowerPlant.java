package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.SpeedService;
import com.kt.energyproject.common.SpinSpeedLevel;
import com.kt.energyproject.environment.WindIntensity;
import com.kt.energyproject.environment.WindIntensityLevel;
import com.kt.energyproject.types.generators.Generator;
import com.kt.energyproject.types.turbines.WindTurbine;
import com.kt.energyproject.types.turbines.WindTurbineType;
import com.kt.energyproject.types.turbines.factory.TurbineFactory;
import com.kt.energyproject.types.turbines.factory.WindTurbineFactoryProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardWindPowerPlant extends WindPowerPlant {

    private static final Logger logger = LoggerFactory.getLogger(StandardWindPowerPlant.class);

    private final WindTurbineFactoryProvider windTurbineFactoryProvider;
    private final TurbineFactory turbineFactory;
    private final WindTurbine turbine;
    private final Generator generator;
    private final SpeedService speedService;


    public StandardWindPowerPlant(WindTurbineFactoryProvider windTurbineFactoryProvider,
                                  WindTurbineType turbineType,
                                  Generator generator,
                                  WindIntensity windIntensity,
                                  SpeedService speedService) {
        this.windTurbineFactoryProvider = windTurbineFactoryProvider;
        this.turbineFactory = this.windTurbineFactoryProvider.getTurbineFactory(turbineType);
        this.turbine = (WindTurbine)this.turbineFactory.createTurbine();
        this.generator = generator;
        this.speedService = speedService;
        windIntensity.registerObserver(this);
    }

    public void start() {
        final WindIntensityLevel windIntensity = WindIntensity.getInstance().getIntensity();
        logger.info("Wind intensity: " + windIntensity);
        super.start();

        SpinSpeedLevel turbineSpinSpeedLevel = speedService.calculateTurbineSpinSpeedLevel(windIntensity);
        turbine.setSpinSpeed(turbineSpinSpeedLevel);
        turbine.setGenerator(generator);

        performContinuousOperationTasks();

    }

    @Override
    protected void performContinuousOperationTasks() {
        turbine.turn();
    }

    @Override
    public void updateWindIntensity(WindIntensityLevel intensity) {
        logger.info("Updating wind intensity: " + intensity);
        turbine.setSpinSpeed(speedService.calculateTurbineSpinSpeedLevel(intensity));
    }
}
