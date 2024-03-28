package com.kt.energyproject.environment;

import java.util.ArrayList;
import java.util.List;

public class WaterflowIntensity {

    private static final WaterflowIntensity INSTANCE = new WaterflowIntensity();
    private List<WaterflowIntensityObserver> observers = new ArrayList<>();
    private WaterflowIntensityLevel intensity = WaterflowIntensityLevel.MEDIUM;

    private WaterflowIntensity() {
    }

    public static WaterflowIntensity getInstance() {
        return INSTANCE;
    }

    public WaterflowIntensityLevel getIntensity() {
        return intensity;
    }

    public void setIntensity(WaterflowIntensityLevel intensity) {
        this.intensity = intensity;
        notifyObservers();
    }

    public void registerObserver(WaterflowIntensityObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WaterflowIntensityObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WaterflowIntensityObserver observer : observers) {
            observer.updateWaterflowIntensity(intensity);
        }
    }

}
