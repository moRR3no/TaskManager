package org.example.app;

import org.example.factory.TaskProcessorFactory;
import org.example.model.Task;
import org.example.model.TaskBuilder;
import org.example.model.TaskType;
import org.example.observer.EmailObserver;
import org.example.observer.LoggerObserver;
import org.example.observer.MetricsObserver;
import org.example.observer.Subject;
import org.example.processor.ImportTaskProcessor;
import org.example.processor.TaskProcessor;
import org.example.repository.TaskRepository;
import org.example.strategy.FastExecutionStrategy;
import org.example.strategy.NormalExecutionStrategy;
import org.example.strategy.RetryExecutionStrategy;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== Task Manager Started ===");

        // ===== 1. Tworzymy Subject (Observer) =====
        Subject subject = new Subject();
        subject.registerObserver(new LoggerObserver());
        subject.registerObserver(new EmailObserver());
        subject.registerObserver(new MetricsObserver());

        // ===== 2. Tworzymy TaskProcessorFactory =====
        TaskProcessorFactory factory = new TaskProcessorFactory(subject);

        // ===== 3. Tworzymy Taski (Builder + Strategy) =====
        Task task1 = new TaskBuilder()
                .withId(1)
                .withName("Import danych")
                .withDescription("Zadanie importu danych z pliku CSV")
                .withPriority(5)
                .withType(TaskType.IMPORT)
                .withStrategy(new NormalExecutionStrategy())
                .build();

        Task task2 = new TaskBuilder()
                .withId(2)
                .withName("Eksport danych")
                .withDescription("Zadanie eksportu danych do pliku XLS")
                .withPriority(3)
                .withType(TaskType.EXPORT)
                .withStrategy(new RetryExecutionStrategy())
                .build();

        Task task3 = new TaskBuilder()
                .withId(3)
                .withName("Wysłanie email")
                .withDescription("Wysyłka raportu na email")
                .withPriority(4)
                .withType(TaskType.EMAIL)
                .withStrategy(new FastExecutionStrategy())
                .build();

        // ===== 4. Dodajemy Taski do Repository (Singleton) =====
        TaskRepository repository = TaskRepository.getInstance();
        repository.add(task1);
        repository.add(task2);
        repository.add(task3);

        System.out.println("Taski w repozytorium:");
        repository.getAll().forEach(System.out::println);

        // ===== 5. Przetwarzanie Tasków przez Factory + Strategy + Observer =====
        for (Task task : repository.getAll()) {
            TaskProcessor processor = factory.getProcessor(task);
            processor.process(task);
        }

        System.out.println("=== Task Manager Finished ===");
    }
}