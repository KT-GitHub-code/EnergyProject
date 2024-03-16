package com.kt.energyproject.types.turbines;

import org.springframework.stereotype.Component;

@Component
public class DarrieusVAWT extends WindTurbine {

    @Override
    public void turn() {
        System.out.println("DarrieusVAWT is turning");
    }

}
