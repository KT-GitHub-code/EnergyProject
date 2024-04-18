package com.kt.energyproject.types.powerplants;

import java.util.Set;

public class Plutonium239 extends Atom implements FissileMaterial {

    public Plutonium239() {
        super(94, 239);
    }

    @Override
    public Set<FissionProduct> undergoFission(Neutron neutron) {
        // TODO: implement plutonium-239 fission
        return Set.of();
    }
}
