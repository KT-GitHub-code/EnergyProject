package com.kt.energyproject.common;

public abstract class TurbineBase {

    private SpinSpeedLevel spinSpeed;

    public SpinSpeedLevel getSpinSpeed() {
        return spinSpeed;
    }

    public void setSpinSpeed(SpinSpeedLevel spinSpeed) {
        this.spinSpeed = spinSpeed;
    }

    public void turn(){
        turn(spinSpeed);
    }

    private void turn(SpinSpeedLevel spinSpeed){
        System.out.println(this.getClass().getSimpleName() + " is turning at speed: " + spinSpeed);
    }

}
