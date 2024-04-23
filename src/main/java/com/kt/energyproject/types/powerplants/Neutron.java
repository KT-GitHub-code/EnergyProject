package com.kt.energyproject.types.powerplants;

public class Neutron implements SubatomicParticle, FissionProduct{

    private NeutronSpeed speed;

    public Neutron(NeutronSpeed speed) {
        this.speed = speed;
    }

    public NeutronSpeed getSpeed() {
        return speed;
    }

    public void setSpeed(NeutronSpeed speed) {
        this.speed = speed;
    }
}
