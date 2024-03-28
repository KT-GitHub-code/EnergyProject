package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.types.turbines.WaterTurbineType;
import org.springframework.stereotype.Service;

@Service
public class WaterTurbineFactoryProvider {

    public TurbineFactory getTurbineFactory(WaterTurbineType turbineType) {
        return switch (turbineType) {
            case FRANCIS_TURBINE -> new FrancisTurbineFactory();
            case KAPLAN_TURBINE -> new KaplanTurbineFactory();
        };
    }

}
