package com.kt.energyproject.types.powerplants;

import java.util.Set;

public class Uranium238 extends Atom {

    public Uranium238() {
        super(92, 238);
    }

    @Override
    public Set<FissionProduct> absorbNeutron(Neutron neutron) {
        // TODO: implement neutron absorption and beta decay into neptunium-239
        return Set.of();
    }
}
