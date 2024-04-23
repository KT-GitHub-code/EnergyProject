package com.kt.energyproject.types.powerplants;

public abstract class NuclearReactorCore {

    public abstract void start();

    public abstract void stop();

    protected abstract void performContinuousOperationTasks();

    public abstract void temperatureRising();

    public abstract void temperatureFalling();
}
