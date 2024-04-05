package com.kt.energyproject.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GeneratorBase implements ElectricalComponent {

    private static final Logger logger = LoggerFactory.getLogger(GeneratorBase.class);
    private SpinSpeedLevel spinSpeed;
    private final VoltageLevel voltageLevel = VoltageLevel.GENERATOR;
    private Transformer transformer;

    public SpinSpeedLevel getSpinSpeed() {
        return spinSpeed;
    }

    public void setSpinSpeed(SpinSpeedLevel spinSpeed) {
        this.spinSpeed = spinSpeed;
    }

    public void generateElectricity(){
        logger.info("Generating electricity...");
    }

    public Transformer getTransformer() {
        return transformer;
    }

    public void setTransformer(Transformer transformer) {
        this.transformer = transformer;
    }

    public void turn(SpinSpeedLevel spinSpeed){
        setSpinSpeed(spinSpeed);
        if(spinSpeed == SpinSpeedLevel.ZERO){
            logger.info(this.getClass().getSimpleName() + " is standing still.");
        } else {
            logger.info(this.getClass().getSimpleName() + " is turning at speed: " + spinSpeed);
            generateElectricity();
        }
    }

    public VoltageLevel getVoltageLevel() {
        return voltageLevel;
    }

}
