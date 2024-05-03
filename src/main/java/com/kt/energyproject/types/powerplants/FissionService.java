package com.kt.energyproject.types.powerplants;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class FissionService {

    private static FissionService instance;

    private FissionService() {
    }

    public static synchronized FissionService getInstance() {
        if (instance == null) {
            instance = new FissionService();
        }
        return instance;
    }

    public Set<FissionProduct> calculateFissionProducts(Atom atom, Neutron neutron) {

        FissionFragmentPair randomFissionFragmentPair = randomizeFissionFragmentPair();

        Set<FissionProduct> fissionProducts = new HashSet<>();
        fissionProducts.addAll(calculateFissionProducts(atom, randomFissionFragmentPair));

        return fissionProducts;
    }

    private FissionFragmentPair randomizeFissionFragmentPair() {
        FissionFragmentPair[] values = FissionFragmentPair.values();

        Random random = new Random();
        int index = random.nextInt(values.length);

        FissionFragmentPair randomFissionFragmentPair = values[index];
        return randomFissionFragmentPair;
    }

    private Set<FissionProduct> calculateFissionProducts(Atom atom, FissionFragmentPair fissionFragmentPair) {
        if(atom instanceof Uranium235) {
            return calculateFissionProductsForUranium235(fissionFragmentPair);
        } else if(atom instanceof Plutonium239) {
            return calculateFissionProductsForPlutonium239(fissionFragmentPair);
        }
        else
            return Set.of();
    }

    private Set<FissionProduct> calculateFissionProductsForUranium235(FissionFragmentPair fissionFragmentPair) {
        Set<FissionProduct> fissionProducts = new HashSet<>();

        switch (fissionFragmentPair) {
            case KRYPTON_BARIUM:
                fissionProducts.add(new Krypton(92));
                fissionProducts.add(new Barium(141));
                for (int i = 1; i <= 3; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case STRONTIUM_ZIRCONIUM:
                fissionProducts.add(new Strontium(90));
                fissionProducts.add(new Zirconium(144));
                for (int i = 1; i <= 2; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case CESIUM_XENON:
                fissionProducts.add(new Cesium(141));
                fissionProducts.add(new Xenon(92));
                for (int i = 1; i <= 3; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case IODINE_RUBIDIUM:
                fissionProducts.add(new Iodine(139));
                fissionProducts.add(new Rubidium(94));
                for (int i = 1; i <= 3; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case XENON_MOLYBDENUM:
                fissionProducts.add(new Xenon(140));
                fissionProducts.add(new Molybdenum(94));
                for (int i = 1; i <= 2; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case IODINE_STRONTIUM:
                fissionProducts.add(new Iodine(139));
                fissionProducts.add(new Strontium(95));
                for (int i = 1; i <= 2; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case XENON_ZIRCONIUM:
                fissionProducts.add(new Xenon(138));
                fissionProducts.add(new Zirconium(95));
                for (int i = 1; i <= 3; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
        }
        return fissionProducts;
    }

    private Set<FissionProduct> calculateFissionProductsForPlutonium239(FissionFragmentPair fissionFragmentPair) {
        Set<FissionProduct> fissionProducts = new HashSet<>();

        switch (fissionFragmentPair) {
            case KRYPTON_BARIUM:
                fissionProducts.add(new Krypton(100));
                fissionProducts.add(new Barium(138));
                for (int i = 1; i <= 2; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case STRONTIUM_ZIRCONIUM:
                fissionProducts.add(new Strontium(94));
                fissionProducts.add(new Zirconium(144));
                for (int i = 1; i <= 2; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case CESIUM_XENON:
                fissionProducts.add(new Cesium(137));
                fissionProducts.add(new Xenon(100));
                for (int i = 1; i <= 3; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case IODINE_RUBIDIUM:
                fissionProducts.add(new Iodine(140));
                fissionProducts.add(new Rubidium(98));
                for (int i = 1; i <= 2; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case XENON_MOLYBDENUM:
                fissionProducts.add(new Xenon(134));
                fissionProducts.add(new Molybdenum(104));
                for (int i = 1; i <= 2; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case IODINE_STRONTIUM:
                fissionProducts.add(new Iodine(132));
                fissionProducts.add(new Strontium(105));
                for (int i = 1; i <= 3; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
            case XENON_ZIRCONIUM:
                fissionProducts.add(new Xenon(139));
                fissionProducts.add(new Zirconium(99));
                for (int i = 1; i <= 2; i++) {
                    fissionProducts.add(new Neutron(NeutronSpeed.FAST));
                }
        }
        return fissionProducts;
    }

}

