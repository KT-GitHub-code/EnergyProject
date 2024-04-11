package com.kt.energyproject.common;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ConsumerRegistry {

    private Set<ElectricConsumer> consumers;
    private Set<LoadObserver> observers;

    public ConsumerRegistry() {
        consumers = new HashSet<>();
        observers = new HashSet<>();
    }

    public void addConsumer(ElectricConsumer consumer) {
        consumers.add(consumer);
        notifyObserversOnConsumerAdded(consumer);
    }

    public void removeConsumer(ElectricConsumer consumer) {
        consumers.remove(consumer);
        notifyObserversOnConsumerRemoved(consumer);
    }

    public Set<ElectricConsumer> getConsumers() {
        return consumers;
    }

    public int getNumberOfConsumers() {
        return consumers.size();
    }

    public void addObserver(LoadObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(LoadObserver observer) {
        observers.remove(observer);
    }

    private void notifyObserversOnConsumerAdded(ElectricConsumer consumer) {
        for (LoadObserver observer : observers) {
            observer.onConsumerAdded(consumer);
        }
    }

    private void notifyObserversOnConsumerRemoved(ElectricConsumer consumer) {
        for (LoadObserver observer : observers) {
            observer.onConsumerRemoved(consumer);
        }
    }

    public List<ElectricConsumer> getConsumersByWattageLevel(WattageLevel wattageLevel) {
        return consumers.stream()
                .filter(consumer -> consumer.getWattageLevel().equals(wattageLevel))
                .collect(Collectors.toList());
    }

    public List<ElectricConsumer> getConsumersByVoltageLevel(VoltageLevel voltageLevel) {
        return consumers.stream()
                .filter(consumer -> consumer.getVoltageLevel().equals(voltageLevel))
                .collect(Collectors.toList());
    }

}
