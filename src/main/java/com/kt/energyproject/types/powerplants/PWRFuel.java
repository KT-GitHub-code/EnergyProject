package com.kt.energyproject.types.powerplants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class PWRFuel extends NuclearFuel {

    private static final Logger logger = LoggerFactory.getLogger(PWRFuel.class);

    private final Set<Atom> atoms;

    private PressurizedWaterReactorCore reactorCore;

    public PWRFuel() {

        this.atoms = new HashSet<>();

        for (int i=1; i<=5; i++) {
            this.atoms.add(new Uranium235());
        }

        for (int i=1; i<=95; i++) {
            this.atoms.add(new Uranium238());
        }

    }

    public void setNuclearReactorCore(PressurizedWaterReactorCore reactorCore) {
        this.reactorCore = reactorCore;
    }

    public void shootNeutron(Neutron neutron) {
        logger.info("Shooting neutron");
        if(neutronGetsAbsorbedByControlRods(neutron)) {
            logger.info("Neutron gets absorbed by control rods");
            return;
        }

        if(neutronGetsAbsorbedByModerator(neutron)) {
            logger.info("Neutron gets absorbed by moderator");
            return;
        }

        Atom atom = getRandomAtom();
        logger.info("random atom: {}", atom);

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

        if(fissionFragments.size() == 2) {
            reactorCore.temperatureRising();
            atoms.remove(atom);
            for (FissionFragment fissionFragment : fissionFragments) {
                atoms.add( (Atom) fissionFragment);
            }
        }

        Iterator<Neutron> iterator = neutrons.iterator();
        while(iterator.hasNext()) {
            Neutron n = iterator.next();
            reactorCore.getModerator().moderateNeutronSpeed(n);
            shootNeutron(n);
            iterator.remove();
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

    private boolean neutronGetsAbsorbedByControlRods(Neutron neutron) {
        ControlRods controlRods = reactorCore.getControlRods();
        int positionPercentage = controlRods.getPosition();

        Random random = new Random();
        int randomNumber = random.nextInt(101);

        return randomNumber < positionPercentage;
    }

    private boolean neutronGetsAbsorbedByModerator(Neutron neutron) {
        Moderator moderator = reactorCore.getModerator();
        int chanceOfNeutronAbsorptionByModerator = moderator.getChanceOfNeutronAbsorption();

        Random random = new Random();
        int randomNumber = random.nextInt(101);

        return randomNumber < chanceOfNeutronAbsorptionByModerator;
    }

}
