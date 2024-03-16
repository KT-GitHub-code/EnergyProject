package com.kt.energyproject.types.turbines;

import com.kt.energyproject.common.TurbineBase;
import org.springframework.stereotype.Component;

@Component
public class GasTurbine extends TurbineBase {

    @Override
    public void turn() {
        System.out.println("Gas turbine is turning");
    }

}
