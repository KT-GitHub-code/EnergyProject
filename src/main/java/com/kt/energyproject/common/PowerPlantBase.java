package com.kt.energyproject.common;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PowerPlantBase {

    private static final Logger logger = LoggerFactory.getLogger(PowerPlantBase.class);
    private boolean running = false;
    private Thread operationThread;

    public boolean isRunning() {
        return running;
    }

    public void start(){
        logger.info("Starting power plant");
        running = true;
        operateContinuously();
    }

    public void stop(){
        logger.info("Stopping power plant");
        running = false;
        if (operationThread != null) {
            operationThread.interrupt();
        }
    }

    private void operateContinuously() {
        operationThread = new Thread(() -> {
            while (running) {
                reportStatus();
                performContinuousOperationTasks();
                try {
                    // 1 tick per second
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        operationThread.start();
    }

    private void reportStatus() {
        logger.info("Power plant is operating");
    }

    protected abstract void performContinuousOperationTasks();

}
