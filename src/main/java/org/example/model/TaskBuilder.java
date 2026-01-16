package org.example.model;

import org.example.strategy.ExecutionStrategy;
import org.example.strategy.NormalExecutionStrategy;

public class TaskBuilder {

    private int id;
    private String name;
    private String description;
    private int priority = 1;
    private TaskType type = TaskType.OTHER;
    private ExecutionStrategy strategy = new NormalExecutionStrategy(); // domyślna

    public TaskBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public TaskBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public TaskBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public TaskBuilder withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    public TaskBuilder withType(TaskType type) {
        this.type = type;
        return this;
    }

    public TaskBuilder withStrategy(ExecutionStrategy strategy) {
        this.strategy = strategy;
        return this;
    }

    public Task build() {
        return new Task(id, name, description, priority, type, strategy);
    }
}