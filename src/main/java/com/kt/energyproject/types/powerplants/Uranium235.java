package com.kt.energyproject.types.powerplants;

import java.util.Set;

public class Uranium235 extends Atom implements FissileMaterial {

    private final FissionService fissionService = FissionService.getInstance();

    public Uranium235() {
        super(92, 235);
    }

    private Set<FissionProduct> undergoFission(Neutron neutron) {
        return fissionService.calculateFissionProducts(this, neutron);
    }


    @Override
    public Set<FissionProduct> absorbNeutron(Neutron neutron) {
        return undergoFission(neutron);
    }
}
