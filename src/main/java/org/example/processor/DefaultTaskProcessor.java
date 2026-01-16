package org.example.processor;

import org.example.model.Task;
import org.example.observer.Subject;
import org.example.observer.TaskEvent;

public class DefaultTaskProcessor extends TaskProcessor {

    public DefaultTaskProcessor(Subject subject) {
        super(subject);
    }

    @Override
    public void process(Task task) {
        subject.notifyObservers(new TaskEvent(task, "Rozpoczynam przetwarzanie zadania OTHER"));
        task.getExecutionStrategy().execute(task);
        subject.notifyObservers(new TaskEvent(task, "Zakończono przetwarzanie zadania OTHER"));
    }
}