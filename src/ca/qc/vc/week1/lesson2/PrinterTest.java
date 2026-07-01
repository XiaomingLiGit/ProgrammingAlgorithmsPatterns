package ca.qc.vc.week1.lesson2;

class PrintSpooler {

    private static final PrintSpooler INSTANCE = new PrintSpooler();

    private PrintSpooler() {}

    public static PrintSpooler getInstance() {
        return INSTANCE;
    }

    public void print(String document) {
        System.out.println("Printing: " + document);
    }
}

public class PrinterTest {
}
