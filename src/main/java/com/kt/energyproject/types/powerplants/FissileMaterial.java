package com.kt.energyproject.types.powerplants;

import java.util.Set;

public interface FissileMaterial {

    Set<FissionProduct> undergoFission(Neutron neutron);

}
