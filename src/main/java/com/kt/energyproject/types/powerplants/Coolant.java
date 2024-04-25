package com.kt.energyproject.types.powerplants;

public class Coolant {

    private final CoolantMaterial material;
    private NuclearReactorCore nuclearReactorCore;
    private HeatExchanger heatExchanger;
    private CoolantPump coolantPump;

    public Coolant(CoolantMaterial material) {
        this.material = material;
        this.coolantPump = new CoolantPump();
        this.coolantPump.setCoolant(this);
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

    public CoolantPump getCoolantPump() {
        return coolantPump;
    }

    public void setCoolantPump(CoolantPump coolantPump) {
        this.coolantPump = coolantPump;
    }

    public void absorbHeatFromReactor() {
        nuclearReactorCore.temperatureFalling();
        heatExchanger.absorbHeatFromCoolant();

    }


}
