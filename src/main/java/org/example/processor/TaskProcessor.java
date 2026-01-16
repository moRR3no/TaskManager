package org.example.processor;

import org.example.model.Task;
import org.example.observer.Subject;

public abstract class TaskProcessor {

    protected final Subject subject;

    public TaskProcessor(Subject subject) {
        this.subject = subject;
    }

    public abstract void process(Task task);
}