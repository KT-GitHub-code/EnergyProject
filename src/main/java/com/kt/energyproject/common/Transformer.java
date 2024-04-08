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

    private boolean powerAvailable = false;

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

    public boolean isPowerAvailable() {
        return powerAvailable;
    }

    public void setPowerAvailable(boolean powerAvailable) {
        this.powerAvailable = powerAvailable;
        System.out.println("Transformer - onPowerAvailabilityChange :"+powerAvailable);
        notifyConsumersAboutPowerChange();
    }

    @Override
    public VoltageLevel getVoltageLevel() {
        return getPrimaryVoltage();
    }

    @Override
    public void onConsumerAdded(ElectricConsumer consumer) {
        logger.info("Load increased by adding: " + consumer);
    }

    @Override
    public void onConsumerRemoved(ElectricConsumer consumer) {
        logger.info("Load decreased by removing: " + consumer);
    }

    private void notifyConsumersAboutPowerChange() {
        System.out.println(consumerRegistry.getConsumers());
        for (ElectricConsumer consumer : consumerRegistry.getConsumers()) {
            consumer.onPowerAvailabilityChange(powerAvailable);
        }
    }
}
