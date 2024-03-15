package com.kt.energyproject.types.turbines;

public class KaplanTurbine extends WaterTurbine {

    @Override
    public void turn() {
        System.out.println("Kaplan turbine is turning");
    }

}
