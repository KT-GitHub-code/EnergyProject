package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.SpeedService;
import com.kt.energyproject.common.SpinSpeedLevel;
import com.kt.energyproject.environment.WaterflowIntensity;
import com.kt.energyproject.environment.WaterflowIntensityLevel;
import com.kt.energyproject.types.generators.Generator;
import com.kt.energyproject.types.turbines.WaterTurbine;
import com.kt.energyproject.types.turbines.WaterTurbineType;
import com.kt.energyproject.types.turbines.factory.TurbineFactory;
import com.kt.energyproject.types.turbines.factory.WaterTurbineFactoryProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardHydroPowerPlant extends HydroPowerPlant{

    private static final Logger logger = LoggerFactory.getLogger(StandardHydroPowerPlant.class);

    private WaterTurbineFactoryProvider waterTurbineFactoryProvider;
    private final TurbineFactory turbineFactory;
    private final WaterTurbine turbine;
    private final Generator generator;
    private final SpeedService speedService;


    public StandardHydroPowerPlant(WaterTurbineFactoryProvider waterTurbineFactoryProvider,
                                   WaterTurbineType turbineType,
                                   Generator generator,
                                   WaterflowIntensity waterflowIntensity,
                                   SpeedService speedService) {
        this.waterTurbineFactoryProvider = waterTurbineFactoryProvider;
        this.turbineFactory = this.waterTurbineFactoryProvider.getTurbineFactory(turbineType);
        this.turbine = (WaterTurbine) this.turbineFactory.createTurbine();
        this.generator = generator;
        this.speedService = speedService;
        waterflowIntensity.registerObserver(this);
    }

    public void start() {
        final WaterflowIntensityLevel waterflowIntensity = WaterflowIntensity.getInstance().getIntensity();
        logger.info("Waterflow intensity: " + waterflowIntensity);
        super.start();

        SpinSpeedLevel turbineSpinSpeedLevel = speedService.calculateTurbineSpinSpeedLevel(waterflowIntensity);
        turbine.setSpinSpeed(turbineSpinSpeedLevel);
        turbine.setGenerator(generator);

        performContinuousOperationTasks();

    }

    @Override
    protected void performContinuousOperationTasks() {
        turbine.turn();
    }

    @Override
    public void updateWaterflowIntensity(WaterflowIntensityLevel intensity) {
        logger.info("Updating waterflow intensity: " + intensity);
        turbine.setSpinSpeed(speedService.calculateTurbineSpinSpeedLevel(intensity));
    }
}
