package org.example.factory;

import org.example.model.Task;
import org.example.model.TaskType;
import org.example.observer.Subject;
import org.example.processor.*;

public class TaskProcessorFactory {

    private final Subject subject;

    public TaskProcessorFactory(Subject subject) {
        this.subject = subject;
    }

    public TaskProcessor getProcessor(Task task) {
        TaskType type = task.getType();

        return switch (type) {
            case IMPORT -> new ImportTaskProcessor(subject);
            case EXPORT -> new ExportTaskProcessor(subject);
            case EMAIL -> new EmailTaskProcessor(subject);
            case OTHER -> new DefaultTaskProcessor(subject);
        };
    }
}