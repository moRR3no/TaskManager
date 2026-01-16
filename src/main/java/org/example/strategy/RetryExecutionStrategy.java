package org.example.strategy;

import org.example.model.Task;

public class RetryExecutionStrategy implements ExecutionStrategy {

    @Override
    public void execute(Task task) {
        System.out.println("[RetryExecution] Wykonuję task z ponawianiem: " + task.getName());
        int attempts = 0;
        boolean success = false;
        while (!success && attempts < 3) {
            attempts++;
            System.out.println("Próba #" + attempts);
            // symulacja przetwarzania
            try { Thread.sleep(300); success = true; } catch (Exception e) {}
        }
        System.out.println("[RetryExecution] Task wykonany po " + attempts + " próbach.");
    }
}