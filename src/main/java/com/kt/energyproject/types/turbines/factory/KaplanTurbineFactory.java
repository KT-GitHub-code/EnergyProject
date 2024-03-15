package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.types.turbines.KaplanTurbine;
import com.kt.energyproject.types.turbines.WaterTurbine;

public class KaplanTurbineFactory extends WaterTurbineFactory {

    @Override
    public WaterTurbine createTurbine() {
        return new KaplanTurbine();
    }

}
