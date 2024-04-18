package com.kt.energyproject.types.powerplants;

import java.util.HashSet;
import java.util.Set;

public abstract class Atom {

    private final int atomicNumber;
    private final int massNumber;

    private final Set<Neutron> neutrons;
    private final Set<Proton> protons;
    private final Set<Electron> electrons;

    public Atom(int atomicNumber, int massNumber) {

        this.atomicNumber = atomicNumber;
        this.massNumber = massNumber;

        Set<Neutron> neutrons = new HashSet<>();
        Set<Proton> protons = new HashSet<>();
        Set<Electron> electrons = new HashSet<>();

        for(int i=1; i<massNumber; i++) {
            neutrons.add(new Neutron());
        }

        for(int i=1; i<=atomicNumber; i++) {
            protons.add(new Proton());
            electrons.add(new Electron());
        }

        this.neutrons = neutrons;
        this.protons = protons;
        this.electrons = electrons;
    }
}
