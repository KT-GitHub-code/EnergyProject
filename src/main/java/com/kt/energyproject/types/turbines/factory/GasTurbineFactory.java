package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.common.TurbineBase;
import com.kt.energyproject.types.turbines.GasTurbine;

public class GasTurbineFactory extends TurbineFactory {

    @Override
    public TurbineBase createTurbine() {
        return new GasTurbine();
    }

}
