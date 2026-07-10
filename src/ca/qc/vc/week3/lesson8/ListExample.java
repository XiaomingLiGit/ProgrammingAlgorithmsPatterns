package ca.qc.vc.week3.lesson8;

import java.util.*;

public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("Names: " + names);                 // [Alice, Bob, Charlie]
        System.out.println("Second name: " + names.get(1));    // Bob

        names.set(1, "Becky");  // Replace Bob with Becky
        System.out.println("After update: " + names);          // [Alice, Becky, Charlie]

        names.remove(0);  // Remove Alice
        System.out.println("Final list: " + names);            // [Becky, Charlie]
    }
}