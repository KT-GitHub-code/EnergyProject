package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.types.turbines.WindTurbine;

public abstract class WindTurbineFactory extends TurbineFactory {

    @Override
    public abstract WindTurbine createTurbine();

}
