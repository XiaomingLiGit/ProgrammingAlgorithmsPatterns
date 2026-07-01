package ca.qc.vc.week1.lesson3;

/**
 * This demo shows an example of template design pattern
 */
abstract class DataProcessor {
    public final void process() { // Template method
        readData();
        processData();
        saveData();
    }
    abstract void readData();     // Subclasses override
    abstract void processData();  // Subclasses override
    public void saveData() {
        System.out.println("Saving data...");
    }
}

class CSVDataProcessor extends DataProcessor {
    @Override
    void readData() {
        System.out.println("Reading CSV data");
    }
    @Override
    void processData() {
        System.out.println("Processing CSV data");
    }
}

class XMLDataProcessor extends DataProcessor {
    @Override
    void readData() {
        System.out.println("Reading XML data");
    }
    @Override
    void processData() {
        System.out.println("Processing XML data");
    }
}

public class DataProcessTest {
    public static void main(String[] args) {
        DataProcessor processor = new CSVDataProcessor(); // Polymorphism
        processor.process(); // Calls CSV-specific versions

        processor = new XMLDataProcessor(); // Polymorphism again
        processor.process(); // Calls XML-specific versions
    }
}
