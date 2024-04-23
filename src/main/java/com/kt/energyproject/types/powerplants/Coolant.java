package com.kt.energyproject.types.powerplants;

public class Coolant {

    private final CoolantMaterial material;
    private NuclearReactorCore nuclearReactorCore;
    private HeatExchanger heatExchanger;

    public Coolant(CoolantMaterial material) {
        this.material = material;
    }

    public void setNuclearReactorCore(NuclearReactorCore nuclearReactorCore) {
        this.nuclearReactorCore = nuclearReactorCore;
    }

    public HeatExchanger getHeatExchanger() {
        return heatExchanger;
    }

    public void setHeatExchanger(HeatExchanger heatExchanger) {
        this.heatExchanger = heatExchanger;
    }

    public void absorbHeatFromReactor() {
        nuclearReactorCore.temperatureFalling();
        heatExchanger.absorbHeatFromCoolant();

    }


}
