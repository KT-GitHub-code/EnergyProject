package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.common.TurbineBase;
import com.kt.energyproject.types.turbines.SteamTurbine;
import org.springframework.stereotype.Component;

@Component
public class SteamTurbineFactory extends TurbineFactory {

    @Override
    public TurbineBase createTurbine() {
        return new SteamTurbine();
    }

}
