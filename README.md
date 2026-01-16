# 🚀 Task Management System

### Projekt akademicki - Implementacja Wzorców Projektowych w Javie

## 📌 O projekcie
System służy do zarządzania i automatyzacji procesowania zadań (np. import, eksport, wysyłka e-mail). Głównym celem projektu jest demonstracja praktycznego zastosowania 5 wzorców projektowych.


## 🛠️ Zastosowane Wzorce Projektowe

W projekcie zaimplementowano 5 wzorców projektowych, które ściśle ze sobą współpracują:

### 1. Builder
* **Klasa:** `TaskBuilder`
* **Zastosowanie:** Pozwala na krokowe konfigurowanie złożonych obiektów klasy `Task`. Dzięki temu kod w klasie `Main` jest czytelny, a tworzenie zadań z różnymi parametrami nie wymaga tworzenia wielu konstruktorów.
* **Przykład z kodu:**
    ```java
    Task task = new TaskBuilder()
            .withId(1)
            .withName("Import danych")
            .withType(TaskType.IMPORT)
            .withStrategy(new NormalExecutionStrategy())
            .build();
    ```



### 2. Strategy 
* **Interfejs:** `ExecutionStrategy`
* **Implementacje:** `NormalExecutionStrategy`, `FastExecutionStrategy`, `RetryExecutionStrategy`
* **Zastosowanie:** Umożliwia wymianę algorytmu wykonania zadania w czasie rzeczywistym. Zadanie deleguje logikę wykonania do przypisanej strategii, co pozwala np. na łatwe dodanie mechanizmu powtórzeń (Retry) bez zmiany logiki procesora.



### 3. Factory Method
* **Klasa:** `TaskProcessorFactory`
* **Zastosowanie:** Hermetyzuje proces tworzenia konkretnych procesorów. Na podstawie pola `TaskType` (np. EMAIL, IMPORT), fabryka zwraca odpowiednią implementację `TaskProcessor`.



### 4. Observer 
* **Klasy:** `Subject`, `Observer` (Implementacje: `EmailObserver`, `LoggerObserver`, `MetricsObserver`)
* **Zastosowanie:** Mechanizm powiadomień. Klasa `Subject` zarządza listą obserwatorów. Gdy procesor wykonuje zadanie, system automatycznie rozsyła informację do wszystkich subskrybentów (np. loguje zdarzenie i wysyła e-mail jednocześnie).



### 5. Singleton
* **Klasa:** `TaskRepository`
* **Zastosowanie:** Gwarantuje, że w całej aplikacji istnieje tylko jedna instancja magazynu zadań. Zapewnia to spójność danych – niezależnie od miejsca w kodzie, zawsze operujemy na tej samej liście obiektów.
* **Dostęp:** `TaskRepository.getInstance()`
