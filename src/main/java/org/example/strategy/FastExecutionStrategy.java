package org.example.strategy;

import org.example.model.Task;

public class FastExecutionStrategy implements ExecutionStrategy {

    @Override
    public void execute(Task task) {
        System.out.println("[FastExecution] Szybkie wykonanie taska: " + task.getName());
        // symulacja szybkiego przetwarzania
    }
}