package com.kt.energyproject.types.turbines;

import org.springframework.stereotype.Component;

@Component
public class SavoniusVAWT extends WindTurbine {

    @Override
    public void turn() {
        System.out.println("SavoniusVAWT is turning");
    }

}
