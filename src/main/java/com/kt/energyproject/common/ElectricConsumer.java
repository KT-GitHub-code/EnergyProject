package com.kt.energyproject.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElectricConsumer implements ElectricalComponent {

    private static final Logger logger = LoggerFactory.getLogger(ElectricConsumer.class);

    private final VoltageLevel voltageLevel;

    public ElectricConsumer(VoltageLevel voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    @Override
    public VoltageLevel getVoltageLevel() {
        return voltageLevel;
    }

    public void consumeElectricity() {
        logger.info("Consuming electricity...");
    }

}
