package com.kt.energyproject.common;


public abstract class PowerPlantBase {

    private boolean running = false;
    private Thread operationThread;

    public boolean isRunning() {
        return running;
    }

    public void start(){
        System.out.println("Starting power plant");
        running = true;
        operateContinuously();
    }

    public void stop(){
        System.out.println("Stopping power plant");
        running = false;
        if (operationThread != null) {
            operationThread.interrupt();
        }
    }

    private void operateContinuously() {
        operationThread = new Thread(() -> {
            while (running) {
                reportStatus();
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
        System.out.println("Power plant is operating");
    }

}
