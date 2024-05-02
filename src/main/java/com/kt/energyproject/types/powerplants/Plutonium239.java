package com.kt.energyproject.types.powerplants;

import java.util.Set;

public class Plutonium239 extends Atom implements FissileMaterial {

    private final FissionService fissionService = FissionService.getInstance();

    public Plutonium239() {
        super(94, 239);
    }

    private Set<FissionProduct> undergoFission(Neutron neutron) {
        return fissionService.calculateFissionProducts(this, neutron);
    }

    @Override
    public Set<FissionProduct> absorbNeutron(Neutron neutron) {
        return undergoFission(neutron);
    }
}
