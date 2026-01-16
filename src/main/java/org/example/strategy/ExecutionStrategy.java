package org.example.strategy;

import org.example.model.Task;

public interface ExecutionStrategy {
    void execute(Task task);
}