package org.example.observer;

public class EmailObserver implements Observer {

    @Override
    public void update(TaskEvent event) {
        System.out.println("[EMAIL] Wysyłam email o zdarzeniu: " + event.getMessage());
    }
}