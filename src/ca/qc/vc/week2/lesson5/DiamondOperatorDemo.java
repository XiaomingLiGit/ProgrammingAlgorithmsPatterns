package ca.qc.vc.week2.lesson5;

import java.util.ArrayList;
import java.util.HashMap;

public class DiamondOperatorDemo {
    public static void main(String[] args) {

        // Old style: repeat the generic type on both sides
        ArrayList<String> names1 = new ArrayList<String>();

        // Preferred modern style: use diamond operator <>
        ArrayList<String> names2 = new ArrayList<>();

        names2.add("Alice");
        names2.add("Bob");
        names2.add("Charlie");

        System.out.println(names2);

        // Example with two generic types
        HashMap<String, Integer> scores = new HashMap<>();

        scores.put("Alice", 95);
        scores.put("Bob", 88);
        scores.put("Charlie", 92);

        System.out.println(scores);

        // The left-hand side still needs full generic type information
        // ArrayList<> names3 = new ArrayList<String>();  // invalid

        // Raw type: legal but not recommended
        ArrayList rawList = new ArrayList();
        rawList.add("Hello");
        rawList.add(123);   // allowed, but unsafe

        // Generic type: type-safe
        ArrayList<String> safeList = new ArrayList<>();
        safeList.add("Hello");
        // safeList.add(123);   // compile-time error
    }
}