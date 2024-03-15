package com.kt.energyproject.types.turbines;

import com.kt.energyproject.common.TurbineBase;

public class SteamTurbine extends TurbineBase {

    @Override
    public void turn() {
        System.out.println("SteamTurbine is turning");
    }

}
