package org.example.observer;

public class MetricsObserver implements Observer {

    private int eventsCount = 0;

    @Override
    public void update(TaskEvent event) {
        eventsCount++;
        System.out.println("[METRICS] Event count: " + eventsCount);
    }
}