# My_JAVA_FS-project

A collection of three small Java projects built while learning Java.

| Project | What it is | Build tool |
|---------|------------|------------|
| `Inventory Management System/` | Console inventory app: products, categories, stock management, low-stock report. Data is saved to `products.dat`. | plain `javac` |
| `MultiThreadedFileProcessor/` | Reads several CSV sales files in parallel threads and writes a combined report (`report.txt`). Has its own [README](MultiThreadedFileProcessor/README.md). | plain `javac` / `run.bat` |
| `calculator-executable-jar/` | Swing calculator packaged as an executable JAR. | Maven |

## Getting started

Prerequisite: a JDK (all three were compiled and checked with JDK 17).

### Inventory Management System

```bash
cd "Inventory Management System"
javac *.java
java Main
```

### MultiThreadedFileProcessor

```bash
cd MultiThreadedFileProcessor
javac -d out src/Main.java src/model/SalesRecord.java src/config/ProcessorConfig.java src/processor/CsvFileProcessor.java src/report/ReportAggregator.java
java -cp out Main
```

On Windows you can run `run.bat` instead.

### calculator-executable-jar

```bash
cd calculator-executable-jar
mvn -DskipTests package
java -jar target/calculator-executable-jar-1.0-SNAPSHOT.jar
```

## Project structure

```
Inventory Management System/   Main, Product, Category, InventoryManager, FileManager
MultiThreadedFileProcessor/    src/, data/*.csv, run.bat
calculator-executable-jar/     pom.xml, src/main, src/test
```

## Roadmap / known limitations

- `mvn package` (with tests) currently fails because the project depends on JUnit 3.8.1, which current Maven no longer supports. Use `-DskipTests` until the test dependency is upgraded.
- Only compilation and (for the CSV processor) a run were verified; the Swing calculator was built but not launched.

## Author

Mrittunjay Dubey, GitHub [@JayD108](https://github.com/JayD108)

## License

No license file is included yet, so all rights are reserved by default.