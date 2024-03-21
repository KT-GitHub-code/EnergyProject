package com.kt.energyproject.common;

public abstract class TurbineBase {

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
        System.out.println(this.getClass().getSimpleName() + " is turning at speed: " + spinSpeed);
        generator.turn(spinSpeed);
    }

}
