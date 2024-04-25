package com.kt.energyproject.types.powerplants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoolantPump {

    private static final Logger logger = LoggerFactory.getLogger(CoolantPump.class);

    private Coolant coolant;

    public Coolant getCoolant() {
        return coolant;
    }

    public void setCoolant(Coolant coolant) {
        this.coolant = coolant;
    }

    public void circulate() {
        logger.info("Circulating coolant through reactor...");
        coolant.absorbHeatFromReactor();
    }

}
