package com.kt.energyproject.types.turbines;

import com.kt.energyproject.common.TurbineBase;

public class GasTurbine extends TurbineBase {

    @Override
    public void turn() {
        System.out.println("Gas turbine is turning");
    }

}
