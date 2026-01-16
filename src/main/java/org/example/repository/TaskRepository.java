package org.example.repository;

import org.example.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRepository {

    private static TaskRepository instance;

    private final Map<Integer, Task> tasks = new HashMap<>();

    private TaskRepository() {}

    public static TaskRepository getInstance() {
        if (instance == null) {
            instance = new TaskRepository();
        }
        return instance;
    }

    public void add(Task task) {
        tasks.put(task.getId(), task);
    }

    public Task getById(int id) {
        return tasks.get(id);
    }

    public List<Task> getAll() {
        return new ArrayList<>(tasks.values());
    }

    public void remove(int id) {
        tasks.remove(id);
    }
}