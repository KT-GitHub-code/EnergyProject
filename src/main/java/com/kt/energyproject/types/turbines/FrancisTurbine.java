package com.kt.energyproject.types.turbines;

import org.springframework.stereotype.Component;

@Component
public class FrancisTurbine extends WaterTurbine {

    @Override
    public void turn() {
        System.out.println("Francis turbine is turning");
    }

}
