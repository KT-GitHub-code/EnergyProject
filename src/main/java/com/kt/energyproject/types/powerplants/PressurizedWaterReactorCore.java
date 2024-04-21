package com.kt.energyproject.types.powerplants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PressurizedWaterReactorCore extends NuclearReactorCore {

    private static final Logger logger = LoggerFactory.getLogger(PressurizedWaterReactorCore.class);

    private PWRFuel fuel = null;
    private final ControlRods controlRods;
    private final Moderator moderator;
    private final Coolant coolant;

    public PressurizedWaterReactorCore() {
        this.controlRods = new ControlRods(ControlRodMaterial.BORON);
        this.moderator = new Moderator(ModeratorMaterial.WATER);
        this.coolant = new Coolant(CoolantMaterial.WATER);
    }

    public PWRFuel getFuel() {
        return fuel;
    }

    public ControlRods getControlRods() {
        return controlRods;
    }

    public Moderator getModerator() {
        return moderator;
    }

    public Coolant getCoolant() {
        return coolant;
    }

    public void insertFuelIntoReactor(PWRFuel fuel) {
        this.fuel = fuel;
        this.fuel.setNuclearReactorCore(this);
    }

    @Override
    public void start() {
        if (fuel == null) {
            throw new IllegalStateException("No fuel in the reactor");
        }
        logger.info("Starting Reactor");
    }

    @Override
    public void stop() {
        logger.info("Stopping Reactor");
    }

    @Override
    protected void performContinuousOperationTasks() {

    }
}
