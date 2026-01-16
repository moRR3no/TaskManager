package org.example.model;

import org.example.strategy.ExecutionStrategy;

public class Task {

    private final int id;
    private final String name;
    private final String description;
    private final int priority;
    private final TaskType type;
    private ExecutionStrategy executionStrategy;

    public Task(int id, String name, String description, int priority, TaskType type, ExecutionStrategy strategy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.type = type;
        this.executionStrategy = strategy;
    }

    public int getId() {
        return id;
    }

    public TaskType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public ExecutionStrategy getExecutionStrategy() {
        return executionStrategy;
    }

    public void setExecutionStrategy(ExecutionStrategy executionStrategy) {
        this.executionStrategy = executionStrategy;
    }

    @Override
    public String toString() {
        return "Task{id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", priority=" + priority +
                '}';
    }
}