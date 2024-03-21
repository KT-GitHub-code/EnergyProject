package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.environment.SunIntensityLevel;
import org.springframework.stereotype.Component;

@Component
public class SolarPark extends SolarPowerPlant implements Photovoltaic {

    @Override
    public void updateSunIntensity(SunIntensityLevel intensity) {
        if (intensity == SunIntensityLevel.ZERO) {
            stop();
        }
    }

    protected void performContinuousOperationTasks() {

    }

}
