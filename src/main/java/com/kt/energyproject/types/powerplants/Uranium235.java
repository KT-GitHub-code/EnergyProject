package com.kt.energyproject.types.powerplants;

import java.util.Set;

public class Uranium235 extends Atom implements FissileMaterial {

    public Uranium235() {
        super(92, 235);
    }

    @Override
    public Set<FissionProduct> undergoFission(Neutron neutron) {
        // TODO: implement uranium-235 fission
        return Set.of();
    }


}
