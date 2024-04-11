package com.kt.energyproject.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElectricConsumer implements ElectricalComponent, PowerObserver {

    private static final Logger logger = LoggerFactory.getLogger(ElectricConsumer.class);

    private final VoltageLevel voltageLevel;

    private boolean powerAvailable;

    private Thread operationThread;

    private final WattageLevel wattageLevel;

    public ElectricConsumer(VoltageLevel voltageLevel, WattageLevel wattageLevel) {
        this.voltageLevel = voltageLevel;
        this.wattageLevel = wattageLevel;
    }

    public boolean isPowerAvailable() {
        return powerAvailable;
    }

    public WattageLevel getWattageLevel() {
        return wattageLevel;
    }

    @Override
    public VoltageLevel getVoltageLevel() {
        return voltageLevel;
    }

    private void consumeElectricity() {
        logger.info("Consuming a " + wattageLevel + " amount of electricity...");
    }

    public void start(){
        logger.info("Starting consumer: " + this);
        tryToConsumeElectricity();
    }

    public void stop(){
        logger.info("Stopping consumer: " + this);
        if (operationThread != null) {
            operationThread.interrupt();
        }
    }

    @Override
    public void onPowerAvailabilityChange(boolean powerAvailable) {
        logger.info("Power Availability Changed: "+powerAvailable);
        this.powerAvailable = powerAvailable;
    }

    public void tryToConsumeElectricity() {
        operationThread = new Thread(() -> {
            while (powerAvailable) {
                consumeElectricity();
                try {
                    // 1 tick per second
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        operationThread.start();
    }

}
