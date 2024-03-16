package com.kt.energyproject;

import com.kt.energyproject.types.powerplants.SolarPowerTower;
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
        SolarPowerTower powerPlant = context.getBean(SolarPowerTower.class);

        powerPlant.start();
    }

}
