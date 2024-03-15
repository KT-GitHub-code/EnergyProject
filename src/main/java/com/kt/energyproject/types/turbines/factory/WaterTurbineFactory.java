package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.types.turbines.WaterTurbine;

public abstract class WaterTurbineFactory extends TurbineFactory {

    @Override
    public abstract WaterTurbine createTurbine();

}
