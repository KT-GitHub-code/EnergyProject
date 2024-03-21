package com.kt.energyproject.common;

public abstract class GeneratorBase {

    private SpinSpeedLevel spinSpeed;

    public SpinSpeedLevel getSpinSpeed() {
        return spinSpeed;
    }

    public void setSpinSpeed(SpinSpeedLevel spinSpeed) {
        this.spinSpeed = spinSpeed;
    }

    public void generateElectricity(){
        System.out.println("Generating electricity...");
    }


    public void turn(SpinSpeedLevel spinSpeed){
        setSpinSpeed(spinSpeed);
        System.out.println(this.getClass().getSimpleName() + " is turning at speed: " + spinSpeed);
        generateElectricity();
    }

}
