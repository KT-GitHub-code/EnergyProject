package com.kt.energyproject.types.powerplants;

import org.springframework.stereotype.Service;

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

    public void calculateFissionProducts(Atom atom, Neutron neutron) {

    }

}

