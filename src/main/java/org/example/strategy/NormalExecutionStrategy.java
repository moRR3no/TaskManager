package org.example.strategy;

import org.example.model.Task;

public class NormalExecutionStrategy implements ExecutionStrategy {

    @Override
    public void execute(Task task) {
        System.out.println("[NormalExecution] Wykonuję task: " + task.getName());
        // symulacja przetwarzania
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        System.out.println("[NormalExecution] Task wykonany.");
    }
}