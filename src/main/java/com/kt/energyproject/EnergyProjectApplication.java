package com.kt.energyproject;

import com.kt.energyproject.common.SpeedService;
import com.kt.energyproject.environment.SunIntensity;
import com.kt.energyproject.environment.SunIntensityLevel;
import com.kt.energyproject.types.generators.Generator;
import com.kt.energyproject.types.powerplants.SolarPowerTower;
import com.kt.energyproject.types.turbines.factory.SteamTurbineFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

// TEMP - exclude the datasource
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EnergyProjectApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(EnergyProjectApplication.class, args);

        startSimulation(context);

    }

    private static void startSimulation(ApplicationContext context) {
        SolarPowerTower powerPlant = new SolarPowerTower(
                context.getBean("steamTurbineFactory", SteamTurbineFactory.class),
                new Generator(),
                SunIntensity.getInstance(),
                context.getBean("speedService", SpeedService.class));

        powerPlant.start();

        try {
            // Runs for 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        SunIntensity.getInstance().setIntensity(SunIntensityLevel.LOW);

        try {
            // Runs for 5 seconds
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        SunIntensity.getInstance().setIntensity(SunIntensityLevel.ZERO);

        try {
            // Runs for 2.5 seconds
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        powerPlant.stop();
        System.out.println("Simulation ended");
    }

}
