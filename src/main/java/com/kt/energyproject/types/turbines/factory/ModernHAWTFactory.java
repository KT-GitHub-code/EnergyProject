package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.types.turbines.ModernHAWT;
import com.kt.energyproject.types.turbines.WindTurbine;
import org.springframework.stereotype.Component;

@Component
public class ModernHAWTFactory extends WindTurbineFactory {

    @Override
    public WindTurbine createTurbine() {
        return new ModernHAWT();
    }

}
