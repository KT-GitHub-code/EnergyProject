package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.types.turbines.FrancisTurbine;
import com.kt.energyproject.types.turbines.WaterTurbine;
import org.springframework.stereotype.Component;

@Component
public class FrancisTurbineFactory extends WaterTurbineFactory {

    @Override
    public WaterTurbine createTurbine() {
        return new FrancisTurbine();
    }

}
