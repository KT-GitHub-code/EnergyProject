package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.common.SpinSpeedLevel;
import com.kt.energyproject.types.turbines.SteamTurbine;

public class HeatExchanger {

    private SteamTurbine turbine;

    public SteamTurbine getTurbine() {
        return turbine;
    }

    public void setTurbine(SteamTurbine turbine) {
        this.turbine = turbine;
    }

    public void absorbHeatFromCoolant() {
        generateSteam();
    }

    private void generateSteam() {
        turbine.setSpinSpeed(SpinSpeedLevel.HIGH);
        turbine.turn();
    }

}
