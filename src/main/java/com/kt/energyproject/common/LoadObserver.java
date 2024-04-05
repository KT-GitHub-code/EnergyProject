package com.kt.energyproject.common;

public interface LoadObserver {
    void onConsumerAdded(ElectricConsumer consumer);
    void onConsumerRemoved(ElectricConsumer consumer);
}
