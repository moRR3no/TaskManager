package org.example.observer;

public class LoggerObserver implements Observer {

    @Override
    public void update(TaskEvent event) {
        System.out.println("[LOG] " + event.getMessage() + " | Task: " + event.getTask());
    }
}