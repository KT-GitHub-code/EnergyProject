package com.kt.energyproject.common;

import com.kt.energyproject.environment.SunIntensityLevel;
import com.kt.energyproject.environment.WaterflowIntensityLevel;
import com.kt.energyproject.environment.WindIntensityLevel;
import org.springframework.stereotype.Service;

@Service
public class SpeedService {


    public SpinSpeedLevel calculateTurbineSpinSpeedLevel(SunIntensityLevel sunIntensityLevel) {
        if (sunIntensityLevel == SunIntensityLevel.ZERO) {
            return SpinSpeedLevel.ZERO;
        } else if (sunIntensityLevel == SunIntensityLevel.LOW) {
            return SpinSpeedLevel.LOW;
        } else if (sunIntensityLevel == SunIntensityLevel.MEDIUM) {
            return SpinSpeedLevel.MEDIUM;
        } else {
            return SpinSpeedLevel.HIGH;
        }
    }

    public SpinSpeedLevel calculateTurbineSpinSpeedLevel(WindIntensityLevel windIntensityLevel) {
        if (windIntensityLevel == WindIntensityLevel.ZERO) {
            return SpinSpeedLevel.ZERO;
        } else if (windIntensityLevel == WindIntensityLevel.LOW) {
            return SpinSpeedLevel.LOW;
        } else if (windIntensityLevel == WindIntensityLevel.MEDIUM) {
            return SpinSpeedLevel.MEDIUM;
        } else {
            return SpinSpeedLevel.HIGH;
        }
    }

    public SpinSpeedLevel calculateTurbineSpinSpeedLevel(WaterflowIntensityLevel waterflowIntensityLevel) {
        if (waterflowIntensityLevel == WaterflowIntensityLevel.ZERO) {
            return SpinSpeedLevel.ZERO;
        } else if (waterflowIntensityLevel == WaterflowIntensityLevel.LOW) {
            return SpinSpeedLevel.LOW;
        } else if (waterflowIntensityLevel == WaterflowIntensityLevel.MEDIUM) {
            return SpinSpeedLevel.MEDIUM;
        } else {
            return SpinSpeedLevel.HIGH;
        }
    }

}
