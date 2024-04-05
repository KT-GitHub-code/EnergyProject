package com.kt.energyproject.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transformer implements ElectricalComponent, LoadObserver {

    private static final Logger logger = LoggerFactory.getLogger(Transformer.class);

    private final ElectricalComponent primary;
    private final ElectricalComponent secondary;
    private final VoltageLevel primaryVoltage;
    private final VoltageLevel secondaryVoltage;

    private ConsumerRegistry consumerRegistry;

    public Transformer(
            ElectricalComponent primary,
            ElectricalComponent secondary,
            ConsumerRegistry consumerRegistry) {
        this.primary = primary;
        this.secondary = secondary;
        this.primaryVoltage = primary.getVoltageLevel();
        this.secondaryVoltage = secondary.getVoltageLevel();
        this.consumerRegistry = consumerRegistry;
        this.consumerRegistry.addObserver(this);
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

    @Override
    public void onConsumerAdded(ElectricConsumer consumer) {
        consumerRegistry.addConsumer(consumer);
    }

    @Override
    public void onConsumerRemoved(ElectricConsumer consumer) {
        consumerRegistry.removeConsumer(consumer);
    }

}
