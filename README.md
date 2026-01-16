# 🚀 Task Management System

### Projekt akademicki - Implementacja Wzorców Projektowych w Javie

## 📌 O projekcie
System służy do zarządzania i automatyzacji procesowania zadań (np. import, eksport, wysyłka e-mail). Projekt został zaprojektowany tak, aby zademonstrować użycie 5 wzorców projektowych, zapewniając elastyczność i łatwość rozbudowy systemu o nowe typy zadań i sposoby ich powiadamiania.

---

## 🛠️ Analiza wykorzystania wzorców projektowych

Poniższa tabela szczegółowo opisuje zastosowanie wzorców zgodnie z wymaganiami projektu:

| Wzorzec | Miejsce w kodzie | Rozwiązywany problem (Uzasadnienie) |
| :--- | :--- | :--- |
| **Builder** | Klasa `TaskBuilder` | **Problem:** Tworzenie obiektów `Task` z wieloma polami przez konstruktor jest nieczytelne i sprzyja błędom. <br>**Rozwiązanie:** Pozwala na krokowe i czytelne konfigurowanie zadania (np. id, nazwa, strategia). |
| **Strategy** | Pakiet `strategy` (interfejs `ExecutionStrategy`) | **Problem:** Sztywne zaszycie logiki wykonania (if-else/switch) wewnątrz klasy zadania utrudnia dodawanie nowych wariantów i łamie zasadę Single Responsibility. <br>**Rozwiązanie:** Wykorzystanie polimorfizmu do odseparowania algorytmu od danych. Dzięki temu klasa `Task` jest otwarta na rozbudowę, ale zamknięta na modyfikacje (OCP) – możemy dodać nową strategię bez dotykania istniejącego kodu. |
| **Factory Method** | Klasa `TaskProcessorFactory` | **Problem:** Klasa główna nie powinna wiedzieć, jak tworzyć skomplikowane obiekty procesorów i jakie mają one zależności.<br>**Rozwiązanie:** Hermetyzuje proces tworzenia procesorów. Klient podaje typ (`TaskType`), a fabryka zwraca gotowy, skonfigurowany obiekt. |
| **Observer** | Pakiet `observer` (klasy `Subject`, `Observer`) | **Problem:** Silne powiązanie między logiką przetwarzania a systemami powiadomień (logi, maile).<br>**Rozwiązanie:** Wprowadza luźne powiązanie. Procesor zgłasza zdarzenie do `Subject`, a ten powiadamia dowolną liczbę subskrybentów bez wiedzy procesora o ich typie. |
| **Singleton** | Klasa `TaskRepository` | **Problem:** Ryzyko istnienia wielu niezależnych list zadań, co prowadziłoby do niespójności danych.<br>**Rozwiązanie:** Gwarantuje istnienie tylko jednej instancji magazynu danych w całej aplikacji i zapewnia do niej jeden globalny punkt dostępu. |

---

## 💻 Scenariusz testowy (Main.java)
Główny przepływ aplikacji prezentuje współpracę wszystkich wzorców:
1. **Inicjalizacja:** Rejestracja trzech obserwatorów (`Logger`, `Email`, `Metrics`) w obiekcie `Subject`.
2. **Konfiguracja:** Stworzenie fabryki procesorów, do której wstrzykiwany jest system powiadomień.
3. **Kreacja:** Budowa zadań przy użyciu **Buildera** i dynamiczne przypisanie im różnych **Strategii** wykonania.
4. **Magazynowanie:** Dodanie zadań do centralnego rejestru **Singleton**.
5. **Egzekucja:** Pobranie zadań z repozytorium, dopasowanie procesorów przez **Fabrykę** i ich uruchomienie wraz z automatycznym powiadomieniem wszystkich obserwatorów.

## 🚀 Instrukcja uruchomienia
1. Wymagane JDK 17 lub nowsze.
2. Skompiluj projekt:
   ```bash
   javac org/example/app/Main.java
   ```
3. Uruchom aplikację:
   ```bash
   java org.example.app.Main
   ```
