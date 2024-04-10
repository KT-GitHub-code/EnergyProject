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

    private final WattageService wattageService;

    private final int totalCapacity = 100;
    private int currentLoad = 0;

    private boolean powerAvailable = false;

    public Transformer(
            ElectricalComponent primary,
            ElectricalComponent secondary) {
        this.primary = primary;
        this.secondary = secondary;
        this.primaryVoltage = primary.getVoltageLevel();
        this.secondaryVoltage = secondary.getVoltageLevel();
        this.consumerRegistry = new ConsumerRegistry();
        this.consumerRegistry.addObserver(this);
        this.wattageService = new WattageService();
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

    public ConsumerRegistry getConsumerRegistry() {
        return consumerRegistry;
    }

    public void setConsumerRegistry(ConsumerRegistry consumerRegistry) {
        this.consumerRegistry = consumerRegistry;
    }

    public boolean isPowerAvailable() {
        return powerAvailable;
    }

    public void setPowerAvailable(boolean powerAvailable) {
        this.powerAvailable = powerAvailable;
        notifyConsumersAboutPowerChange();
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    @Override
    public VoltageLevel getVoltageLevel() {
        return getPrimaryVoltage();
    }

    @Override
    public void onConsumerAdded(ElectricConsumer consumer) {
        logger.info("Load increased by adding: " + consumer);
        currentLoad = wattageService.calculateLoadPercentageAfterAddingConsumer(consumer.getWattageLevel(), this);
        checkOverloadStatus();
    }

    @Override
    public void onConsumerRemoved(ElectricConsumer consumer) {
        logger.info("Load decreased by removing: " + consumer);
        currentLoad = wattageService.calculateLoadPercentageAfterRemovingConsumer(consumer.getWattageLevel(), this);
        checkOverloadStatus();
    }

    private void notifyConsumersAboutPowerChange() {
        for (ElectricConsumer consumer : consumerRegistry.getConsumers()) {
            consumer.onPowerAvailabilityChange(powerAvailable);
        }
    }

    private void checkOverloadStatus() {
        if (currentLoad > totalCapacity) {
            logger.warn("Overload! Current load: " + currentLoad + " %.");
            if (currentLoad >= 120) {
               emergencyShutdown();
            }
        }
    }

    private void emergencyShutdown() {
        logger.warn("Emergency Shutdown initiated!");
        powerAvailable = false;
        notifyConsumersAboutPowerChange();
    }

}
