package com.kt.energyproject.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TurbineBase {

    private static final Logger logger = LoggerFactory.getLogger(TurbineBase.class);
    private GeneratorBase generator;

    private SpinSpeedLevel spinSpeed;

    public SpinSpeedLevel getSpinSpeed() {
        return spinSpeed;
    }

    public void setSpinSpeed(SpinSpeedLevel spinSpeed) {
        this.spinSpeed = spinSpeed;
    }

    public GeneratorBase getGenerator() {
        return generator;
    }

    public void setGenerator(GeneratorBase generator) {
        this.generator = generator;
    }

    public void turn(){
        turn(spinSpeed);
    }

    private void turn(SpinSpeedLevel spinSpeed){
        if(spinSpeed == SpinSpeedLevel.ZERO){
            logger.info(this.getClass().getSimpleName() + " is standing still.");

        } else {
            logger.info(this.getClass().getSimpleName() + " is turning at speed: " + spinSpeed);
        }
        generator.turn(spinSpeed);
    }

}
