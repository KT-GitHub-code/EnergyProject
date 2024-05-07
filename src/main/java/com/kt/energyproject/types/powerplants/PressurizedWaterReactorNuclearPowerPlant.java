package com.kt.energyproject.types.powerplants;

import com.kt.energyproject.types.generators.Generator;
import com.kt.energyproject.types.turbines.SteamTurbine;
import com.kt.energyproject.types.turbines.factory.SteamTurbineFactory;
import com.kt.energyproject.types.turbines.factory.TurbineFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PressurizedWaterReactorNuclearPowerPlant extends NuclearPowerPlant {

    private static final Logger logger = LoggerFactory.getLogger(PressurizedWaterReactorNuclearPowerPlant.class);


    private final PressurizedWaterReactorCore reactorCore;
    private final TurbineFactory turbineFactory;
    private final SteamTurbine turbine;
    private final Generator generator;
    private final HeatExchanger heatExchanger;

    public PressurizedWaterReactorNuclearPowerPlant(
            SteamTurbineFactory steamTurbineFactory,
            Generator generator,
            HeatExchanger heatExchanger) {
        this.reactorCore = new PressurizedWaterReactorCore();
        this.turbineFactory = steamTurbineFactory;
        this.turbine = (SteamTurbine) this.turbineFactory.createTurbine();
        this.generator = generator;
        turbine.setGenerator(generator);
        this.heatExchanger = heatExchanger;
        heatExchanger.setTurbine(turbine);
        reactorCore.getCoolant().setHeatExchanger(heatExchanger);
        PWRFuel fuel = new PWRFuel();
        reactorCore.insertFuelIntoReactor(fuel);
    }

    public void start() {
        super.start();
        reactorCore.getControlRods().setPosition(0);
        reactorCore.start();
    }

    @Override
    protected void performContinuousOperationTasks() {
        reactorCore.getCoolant().getCoolantPump().circulate();
    }



}
