package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.types.turbines.DarrieusVAWT;
import com.kt.energyproject.types.turbines.WindTurbine;

public class DarrieusVAWTFactory extends WindTurbineFactory {

    @Override
    public WindTurbine createTurbine() {
        return new DarrieusVAWT();
    }

}
