package com.kt.energyproject.common;

public class ElectricalLine implements ElectricalComponent {

    private final VoltageLevel voltageLevel;

    public ElectricalLine(VoltageLevel voltageLevel) {
        this.voltageLevel = voltageLevel;
    }

    @Override
    public VoltageLevel getVoltageLevel() {
        return voltageLevel;
    }

}
