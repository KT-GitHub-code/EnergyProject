package com.kt.energyproject.types.turbines;

import com.kt.energyproject.common.TurbineBase;
import org.springframework.stereotype.Component;

@Component
public class SteamTurbine extends TurbineBase {

    @Override
    public void turn() {
        System.out.println("Steam turbine is turning");
    }

}
