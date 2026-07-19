package ca.qc.vc.week3.lesson8;

import java.util.Enumeration;
import java.util.Vector;

public class VectorEnumerationExample {

    public static void main(String[] args) {

        Vector<String> names = new Vector<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Enumeration<String> enumeration = names.elements();

        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            System.out.println(name);
        }
    }
}