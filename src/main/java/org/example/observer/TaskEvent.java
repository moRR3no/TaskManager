package org.example.observer;

import org.example.model.Task;

public class TaskEvent {
    private final Task task;
    private final String message;

    public TaskEvent(Task task, String message) {
        this.task = task;
        this.message = message;
    }

    public Task getTask() {
        return task;
    }

    public String getMessage() {
        return message;
    }
}