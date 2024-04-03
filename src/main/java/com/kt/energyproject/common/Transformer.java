package com.kt.energyproject.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transformer implements ElectricalComponent {

    private static final Logger logger = LoggerFactory.getLogger(Transformer.class);

    private final ElectricalComponent primary;
    private final ElectricalComponent secondary;
    private final VoltageLevel primaryVoltage;
    private final VoltageLevel secondaryVoltage;

    public Transformer(ElectricalComponent primary, ElectricalComponent secondary) {
        this.primary = primary;
        this.secondary = secondary;
        this.primaryVoltage = primary.getVoltageLevel();
        this.secondaryVoltage = secondary.getVoltageLevel();
    }

    public ElectricalComponent getPrimary() {
        return primary;
    }

    public ElectricalComponent getSecondary() {
        return secondary;
    }

    public VoltageLevel getPrimaryVoltage() {
        return primaryVoltage;
    }

    public VoltageLevel getSecondaryVoltage() {
        return secondaryVoltage;
    }

    @Override
    public VoltageLevel getVoltageLevel() {
        return getPrimaryVoltage();
    }

}
