Rugby Analytics System (RAS)

English Version

Project Overview:
Rugby Analytics System (RAS) is a Java SE backend engine designed for rugby coaches and analysts to track match events like scrums, lineouts, and penalties. The system allows for the creation of complex action sequences and exports all data into a structured CSV format for further analysis.

Design Patterns & Justifications
The project implements the following patterns to meet professional architecture standards:

Factory Pattern (EventFactory): Decouples event creation from the main logic, allowing for easy addition of new rugby events without modifying existing code.

Composite Pattern (ActionGroup): Enables grouping multiple sub-events into a single "Action" (e.g., a Scrum followed by a Penalty), treating individual events and groups uniformly.

Iterator Pattern (Match): Implements the Iterable interface in the Match class to provide a clean way to traverse events while protecting the internal data structure (ArrayList).

Exception Shielding: Implemented in Match.java during File I/O operations to prevent sensitive stack traces from reaching the user and ensuring resources are safely closed via try-with-resources.

Advanced Technologies
Reflection API: Used in the CSV export logic to dynamically read fields from different Event subclasses. This allows the system to remain extensible without changing the export engine.

JUnit 5: A test suite (MatchTest, EventFactoryTest) ensures that input sanitization and logic remain stable.

Java Logging API: Replaces standard print statements for professional system monitoring and error tracking.

Setup and Execution
Prerequisites: Ensure you have Java JDK 17 or higher installed.

Compilation: Run javac *.java in your terminal.

Run Simulation: Run java Test to execute the sample match data entry.

Output: A .csv file will be generated with the format HOME/AWAY_Opponent_Season.csv.

Versione Italiana
Panoramica del Progetto
Rugby Analytics System (RAS) è un motore backend in Java SE sviluppato per allenatori e analisti di rugby. Il sistema gestisce il tracciamento di eventi (Mischie, Touche, Calci) e la loro esportazione in formato CSV.

Pattern di Design e Giustificazioni
Per garantire sicurezza e manutenibilità, sono stati implementati i seguenti pattern:

Factory Pattern (EventFactory): Centralizza la creazione degli eventi, separando la logica di esemplificazione di un fenomeno con un caso concreto molto specifico dall'utilizzo pratico.

Composite Pattern (ActionGroup): Permette di raggruppare più eventi (es. Mischia che genera un Fallo) in un'unica entità, trattando eventi singoli e gruppi nello stesso modo.

Iterator Pattern (Match): La classe Match implementa Iterable per scorrere gli eventi senza esporre l'ArrayList interna.

Exception Shielding: Utilizzato nel salvataggio su file per prevenire la fuga di stack trace e gestire correttamente la chiusura delle risorse.

Tecnologie Avanzate
Reflection API: Utilizzata per estrarre dinamicamente i dati dei campi nelle sottoclassi di Event durante la generazione del CSV, rendendo il sistema facilmente estendibile.

JUnit 5: Suite di test per la verifica della sanificazione degli input e della stabilità logica.

Java Logging API: Per una gestione professionale dei log di sistema e degli errori.

Installazione ed Esecuzione
Prerequisiti: Java JDK 17 o superiore.

Compilazione: Eseguire il comando javac *.java.

Esecuzione: Avviare la simulazione con java Test.

Risultato: Il sistema genererà un file .csv nominato in base alla partita (es. HOME_PVR_Rugby_25-26.csv).

## Diagrammi UML

[cite_start]Di seguito sono riportati i diagrammi che illustrano l'architettura e la struttura del sistema, come richiesto dalle specifiche del progetto.

### Architectural Diagram
![Architectural Diagram](Architectural%20Diagram.png)
[cite_start]*Descrizione: Mostra il flusso dei dati dall'input dell'utente fino alla generazione del file CSV tramite il sistema di Reflection[cite: 101].*

### Class Diagram
![Class Diagram](Class%20Diagram.png)
[cite_start]*Descrizione: Illustra la gerarchia delle classi Event e l'implementazione dei pattern Factory, Composite e Iterator[cite: 90].*