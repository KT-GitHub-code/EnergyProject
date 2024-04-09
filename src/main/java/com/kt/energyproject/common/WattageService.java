package com.kt.energyproject.common;

import org.springframework.stereotype.Service;

@Service
public class WattageService {

    public int calculateLoadPercentageAfterAddingConsumer(WattageLevel wattageLevel,
                                       Transformer transformer){

        int currentLoad = transformer.getCurrentLoad();

        return switch (wattageLevel) {
            case LOW -> currentLoad + 1;
            case MEDIUM -> currentLoad + 10;
            case HIGH -> currentLoad + 100;
        };

    }

    public int calculateLoadPercentageAfterRemovingConsumer(WattageLevel wattageLevel,
                                                          Transformer transformer){

        int currentLoad = transformer.getCurrentLoad();

        return switch (wattageLevel) {
            case LOW -> Math.min(currentLoad - 1, 0);
            case MEDIUM -> Math.min(currentLoad - 10, 0);
            case HIGH -> Math.min(currentLoad - 100, 0);
        };

    }

}
