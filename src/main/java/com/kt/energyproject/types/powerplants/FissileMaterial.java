package com.kt.energyproject.types.powerplants;

import java.util.Set;

public interface FissileMaterial {

    private Set<FissionProduct> undergoFission(Neutron neutron){
        throw new UnsupportedOperationException("Fission process must be implemented by the subclasses");
    };

}
