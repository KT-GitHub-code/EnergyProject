package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.common.TurbineBase;
import com.kt.energyproject.types.turbines.GasTurbine;
import org.springframework.stereotype.Component;

@Component
public class GasTurbineFactory extends TurbineFactory {

    @Override
    public TurbineBase createTurbine() {
        return new GasTurbine();
    }

}
