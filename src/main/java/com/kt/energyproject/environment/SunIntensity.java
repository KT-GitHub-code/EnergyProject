package com.kt.energyproject.environment;

import org.springframework.stereotype.Component;

@Component
public class SunIntensity {

    private static final SunIntensity INSTANCE = new SunIntensity();

    private SunIntensity() {
    }

    public static SunIntensity getInstance() {
        return INSTANCE;
    }

    public SunIntensityLevel getIntensity() {
        return SunIntensityLevel.MEDIUM;
    }

}
