package com.kt.energyproject.types.turbines.factory;

import com.kt.energyproject.common.TurbineBase;
import com.kt.energyproject.types.turbines.SteamTurbine;

public class SteamTurbineFactory extends TurbineFactory {

    @Override
    public TurbineBase createTurbine() {
        return new SteamTurbine();
    }

}
