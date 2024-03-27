package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.types.turbines.WindTurbineType;
import org.springframework.stereotype.Service;

@Service
public class WindTurbineFactoryProvider {

    public TurbineFactory getTurbineFactory(WindTurbineType turbineType) {
        return switch (turbineType) {
            case MODERN_HAWT -> new ModernHAWTFactory();
            case DARREIUS_VAWT -> new DarrieusVAWTFactory();
            case SAVONIUS_VAWT -> new SavoniusVAWTFactory();
        };
    }

}
