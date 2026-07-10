package ca.qc.vc.week2.lesson6;

interface Printable {
    void print();
}

interface Savable {
    void save();
}

class Report implements Printable, Savable {
    @Override
    public void print() {
        System.out.println("Printing report");
    }

    @Override
    public void save() {
        System.out.println("Saving report");
    }
}

public class MultipleBoundsDemo3 {

    public static <T extends Printable & Savable> void process(T item) {
        item.print();
        item.save();
    }

    public static void main(String[] args) {
        Report report = new Report();
        process(report);
    }
}