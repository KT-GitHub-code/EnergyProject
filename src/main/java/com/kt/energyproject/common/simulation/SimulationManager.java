package com.kt.energyproject.common.simulation;

import com.kt.energyproject.common.*;
import com.kt.energyproject.environment.*;
import com.kt.energyproject.types.generators.Generator;
import com.kt.energyproject.types.powerplants.SolarPowerTower;
import com.kt.energyproject.types.powerplants.StandardHydroPowerPlant;
import com.kt.energyproject.types.powerplants.StandardWindPowerPlant;
import com.kt.energyproject.types.turbines.WaterTurbineType;
import com.kt.energyproject.types.turbines.WindTurbineType;
import com.kt.energyproject.types.turbines.factory.SteamTurbineFactory;
import com.kt.energyproject.types.turbines.factory.WaterTurbineFactoryProvider;
import com.kt.energyproject.types.turbines.factory.WindTurbineFactoryProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SimulationManager {

    private static final Logger logger = LoggerFactory.getLogger(SimulationManager.class);

    private final WindTurbineFactoryProvider windTurbineFactoryProvider;
    private final WaterTurbineFactoryProvider waterTurbineFactoryProvider;
    private final SpeedService speedService;

    @Autowired
    public SimulationManager(WindTurbineFactoryProvider windTurbineFactoryProvider,
                             WaterTurbineFactoryProvider waterTurbineFactoryProvider,
                             SpeedService speedService) {
        this.windTurbineFactoryProvider = windTurbineFactoryProvider;
        this.waterTurbineFactoryProvider = waterTurbineFactoryProvider;
        this.speedService = speedService;
    }

    public void startSimulation() {
//        simulateSolarPowerTower();
//        simulateStandardWindPowerPlant();
//        simulateStandardHydroPowerPlant();
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

        Generator generator = new Generator();

        SolarPowerTower powerPlant = new SolarPowerTower(
                new SteamTurbineFactory(),
                generator,
                SunIntensity.getInstance(),
                speedService);

        Transformer transformer = new Transformer(
                generator,
                new ElectricalLine(VoltageLevel.HOUSEHOLD),
                new ConsumerRegistry());

        generator.setTransformer(transformer);

        ElectricConsumer consumer = new ElectricConsumer(VoltageLevel.HOUSEHOLD, WattageLevel.LOW);

        transformer.getConsumerRegistry().addConsumer(consumer);

        powerPlant.start();
        consumer.start();

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

        Generator generator = new Generator();

        StandardWindPowerPlant powerPlant = new StandardWindPowerPlant(
                windTurbineFactoryProvider,
                WindTurbineType.MODERN_HAWT,
                generator,
                WindIntensity.getInstance(),
                speedService);

        Transformer transformer = new Transformer(
                generator,
                new ElectricalLine(VoltageLevel.HOUSEHOLD),
                new ConsumerRegistry());

        generator.setTransformer(transformer);

        ElectricConsumer consumer = new ElectricConsumer(VoltageLevel.HOUSEHOLD, WattageLevel.LOW);

        transformer.getConsumerRegistry().addConsumer(consumer);

        powerPlant.start();
        consumer.start();

        sleep(5000);

        WindIntensity.getInstance().setIntensity(WindIntensityLevel.LOW);

        sleep(5000);

        WindIntensity.getInstance().setIntensity(WindIntensityLevel.ZERO);

        sleep(2500);

        powerPlant.stop();
        logger.warn("Standard Wind Power Plant simulation ended");
    }

    private void simulateStandardHydroPowerPlant() {

        logger.warn("Starting Standard Hydro Power Plant simulation");

        Generator generator = new Generator();

        StandardHydroPowerPlant powerPlant = new StandardHydroPowerPlant(
                waterTurbineFactoryProvider,
                WaterTurbineType.KAPLAN_TURBINE,
                new Generator(),
                WaterflowIntensity.getInstance(),
                speedService);

        Transformer transformer = new Transformer(
                generator,
                new ElectricalLine(VoltageLevel.HOUSEHOLD),
                new ConsumerRegistry());

        generator.setTransformer(transformer);

        ElectricConsumer consumer = new ElectricConsumer(VoltageLevel.HOUSEHOLD, WattageLevel.LOW);

        transformer.getConsumerRegistry().addConsumer(consumer);

        powerPlant.start();
        consumer.start();

        sleep(5000);

        WaterflowIntensity.getInstance().setIntensity(WaterflowIntensityLevel.LOW);

        sleep(5000);

        WaterflowIntensity.getInstance().setIntensity(WaterflowIntensityLevel.ZERO);

        sleep(2500);

        powerPlant.stop();
        logger.warn("Standard Hydro Power Plant simulation ended");
    }

}
