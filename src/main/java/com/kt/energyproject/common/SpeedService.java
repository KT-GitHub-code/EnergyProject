package com.kt.energyproject.common;

import com.kt.energyproject.environment.SunIntensityLevel;
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

}
