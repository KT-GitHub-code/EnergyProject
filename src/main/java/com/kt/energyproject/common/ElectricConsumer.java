package com.kt.energyproject.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElectricConsumer implements ElectricalComponent, PowerObserver {

    private static final Logger logger = LoggerFactory.getLogger(ElectricConsumer.class);

    private final VoltageLevel voltageLevel;

    private boolean powerAvailable;

    private Thread operationThread;

    public ElectricConsumer(VoltageLevel voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    public boolean isPowerAvailable() {
        return powerAvailable;
    }

    public void setPowerAvailable(boolean powerAvailable) {
        this.powerAvailable = powerAvailable;
    }

    @Override
    public VoltageLevel getVoltageLevel() {
        return voltageLevel;
    }

    public void consumeElectricity() {
        logger.info("Consuming electricity...");
    }

    @Override
    public void onPowerAvailabilityChange(boolean powerAvailable) {
        logger.info("Power Availability Changed: "+powerAvailable);
        this.powerAvailable = powerAvailable;
    }
}
