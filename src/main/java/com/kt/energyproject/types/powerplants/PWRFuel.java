package com.kt.energyproject.types.powerplants;

import java.util.*;

public class PWRFuel extends NuclearFuel {

    private final Set<Atom> atoms;

    public PWRFuel() {

        this.atoms = new HashSet<>();

        for (int i=1; i<=5; i++) {
            this.atoms.add(new Uranium235());
        }

        for (int i=1; i<=95; i++) {
            this.atoms.add(new Uranium238());
        }

    }

    public void shootNeutron(Neutron neutron) {

        Atom atom = getRandomAtom();

        Set<FissionProduct> fissionProducts = atom.absorbNeutron(neutron);

        Set<FissionFragment> fissionFragments = new HashSet<>();
        Set<Neutron> neutrons = new HashSet<>();

        for (FissionProduct fissionProduct : fissionProducts){
            if(fissionProduct instanceof FissionFragment) {
                fissionFragments.add((FissionFragment) fissionProduct);
            } else if (fissionProduct instanceof Neutron) {
                neutrons.add((Neutron) fissionProduct);
            }
        }

        atoms.remove(atom);
        for (FissionFragment fissionFragment : fissionFragments) {
            atoms.add( (Atom) fissionFragment);
        }

        while(!neutrons.isEmpty()) {
            Neutron n = neutrons.iterator().next();
            shootNeutron(n);
        }

    }

    private Atom getRandomAtom() {
        int randomIndex = new Random().nextInt(atoms.size());
        Iterator<Atom> iterator = atoms.iterator();
        for (int i = 0; i < randomIndex; i++) {
            iterator.next();
        }
        return iterator.next();
    }

}
