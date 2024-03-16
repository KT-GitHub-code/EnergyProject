package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.types.turbines.SavoniusVAWT;
import com.kt.energyproject.types.turbines.WindTurbine;
import org.springframework.stereotype.Component;

@Component
public class SavoniusVAWTFactory extends WindTurbineFactory {

    @Override
    public WindTurbine createTurbine() {
        return new SavoniusVAWT();
    }

}
