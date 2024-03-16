package com.kt.energyproject.types.generators;

import com.kt.energyproject.common.GeneratorBase;
import org.springframework.stereotype.Component;

@Component
public class Generator extends GeneratorBase {

    @Override
    public void generateElectricity() {
        System.out.println("Generating electricity...");
    }

}
