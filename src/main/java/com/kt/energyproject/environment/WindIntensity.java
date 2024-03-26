package com.kt.energyproject.environment;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WindIntensity {

    private static final WindIntensity INSTANCE = new WindIntensity();
    private List<WindIntensityObserver> observers = new ArrayList<>();
    private WindIntensityLevel intensity = WindIntensityLevel.MEDIUM;

    private WindIntensity() {
    }

    public static WindIntensity getInstance() {
        return INSTANCE;
    }

    public WindIntensityLevel getIntensity() {
        return intensity;
    }

    public void setIntensity(WindIntensityLevel intensity) {
        this.intensity = intensity;
        notifyObservers();
    }

    public void registerObserver(WindIntensityObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WindIntensityObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (WindIntensityObserver observer : observers) {
            observer.updateWindIntensity(intensity);
        }
    }

}
