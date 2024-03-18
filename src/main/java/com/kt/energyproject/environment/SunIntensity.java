package com.kt.energyproject.environment;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SunIntensity {

    private static final SunIntensity INSTANCE = new SunIntensity();
    private List<SunIntensityObserver> observers = new ArrayList<>();
    private SunIntensityLevel intensity = SunIntensityLevel.MEDIUM;

    private SunIntensity() {
    }

    public static SunIntensity getInstance() {
        return INSTANCE;
    }

    public SunIntensityLevel getIntensity() {
        return intensity;
    }

    public void setIntensity(SunIntensityLevel intensity) {
        this.intensity = intensity;
        notifyObservers();
    }

    public void registerObserver(SunIntensityObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(SunIntensityObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (SunIntensityObserver observer : observers) {
            observer.updateSunIntensity(intensity);
        }
    }

}
